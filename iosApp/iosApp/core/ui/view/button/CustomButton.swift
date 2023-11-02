//
//  CustomButton.swift
//  iosApp
//
//  Created by Hayden Lui on 01/11/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct GoldButton: ButtonStyle {
    func makeBody(configuration: Configuration) -> some View {
        GoldButtonView(configuration: configuration)
    }
}

private extension GoldButton {
    struct GoldButtonView: View {
        let color = LinearGradient(
            gradient: Gradient(
                colors: [
                    Color(
                        red: 241 / 255,
                        green: 211 / 255,
                        blue: 172 / 255
                    ),
                    Color(
                        red: 229 / 255,
                        green: 174 / 255,
                        blue: 102 / 255
                    ),
                ]
            ),
            startPoint: .top,
            endPoint: .bottom
        )
        let disableColor = LinearGradient(
            gradient: Gradient(
                colors: [
                    Color(
                        red: 216 / 255,
                        green: 216 / 255,
                        blue: 216 / 255
                    ),
                    Color(
                        red: 182 / 255,
                        green: 182 / 255,
                        blue: 182 / 255
                    ),
                ]
            ),
            startPoint: .top,
            endPoint: .bottom
        )
        
        @Environment(\.isEnabled) var isEnabled
        let configuration: GoldButton.Configuration
        
        var body: some View {
            let clipShape = RoundedRectangle(cornerRadius: 8)
            
            return configuration.label
                .padding()
                .background(isEnabled ? color : disableColor)
                .clipShape(clipShape)
                .overlay(
                    clipShape
                    .stroke(Color.black, lineWidth: 1))
                .scaleEffect(configuration.isPressed ? 1.1 : 1)
                .animation(.easeOut(duration: 0.2), value: configuration.isPressed)
        }
    }
}

#Preview {
    VStack {
        Button("Press") {
            
        }.buttonStyle(GoldButton())
        
        Button("Disable") {
            
        }
        .buttonStyle(GoldButton())
        .disabled(true)
    }
    
}
