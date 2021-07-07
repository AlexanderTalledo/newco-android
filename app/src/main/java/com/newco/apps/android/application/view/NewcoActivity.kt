package com.newco.apps.android.application.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.newco.apps.android.signin.view.SignInView
import com.newco.apps.android.ui.theme.NewcoTheme

class NewcoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewcoTheme {
                SignInView()
            }
        }
    }

}