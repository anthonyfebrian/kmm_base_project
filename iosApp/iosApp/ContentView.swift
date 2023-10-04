import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting()
    let greet2 = Greeting2()

	var body: some View {
        Text("\(greet2.say) ....... \(greet.greet())")
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
