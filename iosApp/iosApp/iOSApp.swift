import SwiftUI
import shared

@main
struct iOSApp: App {
    init() {
        IosKoinHelperKt.doInitKoin()
    }
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
