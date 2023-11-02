//
//  MaterialTextField.swift
//  iosApp
//
//  Created by Hayden Lui on 01/11/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct OutlinedTextField : View {
    @Binding var text: String
    var disable:Bool = false
    var label: (() -> Text)? = nil
    var leadingIcon:(() -> Image)? = nil
    var trailingIcon:(() -> Image)? = nil
    var prefix: (() -> Text)? = nil
    var suffix: (() -> Text)? = nil
    var supportingText: (() -> Text)? = nil
    var placeholder: String = ""
    var isSecure: Bool = false
    
    
    var body: some View {
        VStack(alignment: .leading) {
            label?()

            HStack {
                
                ZStack(alignment: .leading) {
                    HStack {
                        leadingIcon?()
                            .padding(.leading, 8)
                        
                        prefix?()
                            .padding(.leading, 8)
                        
                        if text.isEmpty {
                            Text(placeholder)
                                .foregroundColor(.gray)
                                .padding(.horizontal, 8)
                        }
                        
                        if isSecure {
                            SecureField("", text: $text)
                                .padding(.horizontal, 8)
                                .disabled(disable)
                        } else {
                            TextField("", text: $text)
                                .padding(.horizontal, 8)
                                .disabled(disable)
                        }
                        
                        suffix?()
                            .padding(.trailing, 8)
                        
                        trailingIcon?()
                            .padding(.trailing, 8)
                    }
                            
                }
                .frame(height: 48)
                .background(Color.white)
                .cornerRadius(8)
                .shadow(
                    color: Color.black.opacity(0.2), 
                    radius: 5, x: 0, y: 2
                )
                
            }
            
            supportingText?()
        }
        
    }
}


#Preview {
    @State var text = ""
    return OutlinedTextField(
        text:$text,
        label: {
            Text("Lalalaa")
        },
        leadingIcon: {
            Image(systemName: "minus.circle.fill")
        },
        trailingIcon: {
            Image(systemName: "minus.circle.fill")
        },
        prefix: {
            Text("+62")
        },
        suffix: {
            Text("$")
        },
        supportingText: {
            Text("Supporting Text")
        },
        placeholder: "Username",
        isSecure: false
    ).padding()
}
