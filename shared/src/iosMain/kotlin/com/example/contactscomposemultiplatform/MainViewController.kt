package com.example.contactscomposemultiplatform

import androidx.compose.ui.interop.LocalUIViewController
import androidx.compose.ui.window.ComposeUIViewController
import com.example.contactscomposemultiplatform.core.presentation.ImagePickerFactory
import com.example.contactscomposemultiplatform.di.AppModule
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

fun MainViewController() = ComposeUIViewController {
    val isDarkTheme =
        UIScreen.mainScreen.traitCollection.userInterfaceStyle ==
                UIUserInterfaceStyle.UIUserInterfaceStyleDark
    App(
        darkTheme = isDarkTheme,
        dynamicColor = false,
        appModule = AppModule(),
        imagePicker = ImagePickerFactory(LocalUIViewController.current).createPicker()
    )
}
