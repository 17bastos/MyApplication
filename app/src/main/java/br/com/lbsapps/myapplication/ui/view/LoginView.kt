package br.com.lbsapps.myapplication.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.lbsapps.myapplication.data.CredentialsRepository
import br.com.lbsapps.myapplication.ui.viewmodel.LoginViewModel

@Composable
fun LoginView(
    viewModel: LoginViewModel
) {

    val state = remember { viewModel.loginState }
    val user = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    if (state.value.loggedIn) {
        Column(modifier = Modifier.padding(80.dp)) {
            Text("WELCOME!!!")
        }
    } else {
        Column(
            modifier = Modifier.padding(80.dp)
        ) {
            Text("Type the user")
            TextField(
                value = user.value,
                onValueChange = { value ->
                    user.value = value
                },
            )

            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = "Type the password"
            )
            TextField(
                value = password.value,
                onValueChange = { value ->
                    password.value = value
                },
            )
            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = state.value.formStatusMessage
            )
            Button(
                modifier = Modifier.padding(top = 20.dp),
                onClick = {
                    viewModel.validateCredentials(user.value, password.value)
                }
            ) {
                Text("Do Login")
            }
        }
    }

}