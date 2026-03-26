package br.com.lbsapps.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lbsapps.myapplication.data.CredentialsRepository
import br.com.lbsapps.myapplication.ui.theme.MyApplicationTheme
import br.com.lbsapps.myapplication.ui.view.LoginView
import br.com.lbsapps.myapplication.ui.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loginViewModel = LoginViewModel(CredentialsRepository())
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val state = remember { loginViewModel.loginState }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginView(LoginViewModel(CredentialsRepository()))
                }
            }
        }
    }
}