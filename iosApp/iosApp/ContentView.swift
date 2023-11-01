import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var vm: ViewModel = ViewModel()

	var body: some View {
        if(self.vm.list.isEmpty) {
            Text("Empty")
        }
        
        List(vm.list, id:\.self) {
            Text($0.missionName)
        }
        
	}
}

extension ContentView {
    class ViewModel: ObservableObject {
        let sampleApi = IosKoinHelper().sampleApi
        @Published var text = "Loading..."
        @Published var list:[RocketLaunch] = []
        init() {
            sampleApi
                .getAllLaunches { list, error in
                    self.list = list ?? []
                }
            Greeting().textOnline { greeting, error in
                DispatchQueue.main.async {
                    if let greeting = greeting {
                        self.text = greeting
                    } else {
                        self.text = error?.localizedDescription ?? "error"
                    }
                }
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
