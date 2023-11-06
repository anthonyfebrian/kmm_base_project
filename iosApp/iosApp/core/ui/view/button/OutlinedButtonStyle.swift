//
//  OutlinedButtonStyle.swift
//  iosApp
//
//  Created by Hayden Lui on 02/11/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct OutlinedButtonStyle: ButtonStyle {
    let color:Color
    let cornerRadius:CGFloat
    
    init(color: Color, cornerRadius: CGFloat = 8) {
        self.color = color
        self.cornerRadius = cornerRadius
    }
    
    func makeBody(configuration: Configuration) -> some View {
        return OutlinedButtonView(
            configuration: configuration,
            color: color, 
            cornerRadius: cornerRadius
        )
    }
}

private extension OutlinedButtonStyle {
   
    struct OutlinedButtonView: View {
        @Environment(\.isEnabled) var isEnabled
        let configuration: GoldButton.Configuration
        
        let color:Color
        let cornerRadius:CGFloat
        
        var body: some View {
            return configuration.label
                .padding()
                .background(Color.white)
                .clipShape(
                    RoundedRectangle(cornerRadius: cornerRadius)
                )
                .foregroundColor(isEnabled ? color : Color.gray)
                .overlay(
                    RoundedRectangle(
                        cornerRadius: cornerRadius
                    )
                    .stroke(
                        isEnabled ? color : Color.gray,
                        lineWidth: 2
                    )
                )
                .scaleEffect(configuration.isPressed ? 1.1 : 1)
                .animation(.easeOut(duration: 0.2), value: configuration.isPressed)
                
        }
    }
}

#Preview {
    VStack {
        Button("Button") {
            
        }.buttonStyle(
            OutlinedButtonStyle(
                color: Color.red,
                cornerRadius: 24
            )
        )
        
        Button("Button") {
            
        }.buttonStyle(OutlinedButtonStyle(color:Color.red))
            .disabled(true)
    }
}
