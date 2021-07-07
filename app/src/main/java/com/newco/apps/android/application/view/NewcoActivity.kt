package com.newco.apps.android.application.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.newco.apps.android.signin.view.SignInView
import com.newco.apps.android.ui.theme.NewcoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewcoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewcoTheme {
                SignInView(hiltViewModel())
            }
        }
    }

}