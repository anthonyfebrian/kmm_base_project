//
//  CustomButton.swift
//  iosApp
//
//  Created by Hayden Lui on 01/11/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct GoldButton: ButtonStyle {
    let clipShape = RoundedRectangle(cornerRadius: 8)
    
    func makeBody(configuration: Configuration) -> some View {
        let isPressed = configuration.isPressed
        let gradient = LinearGradient(
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
        
        return configuration.label
            .padding()
            .background(gradient)
            .clipShape(clipShape)
            .overlay(
                clipShape
                .stroke(Color.black, lineWidth: 1))
    }
}

#Preview {
    Button("Press") {
        
    }.buttonStyle(GoldButton())
}
