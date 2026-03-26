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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    if (loginViewModel.loginState.value.loggedIn) {
                        Column(modifier = Modifier.padding(80.dp)) {
                            Text("WELCOME!!!")
                        }
                    } else {
                        LoginView(LoginViewModel(CredentialsRepository()))
                    }
                }
            }
        }
    }
}