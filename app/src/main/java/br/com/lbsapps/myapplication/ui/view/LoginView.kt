package br.com.lbsapps.myapplication.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.lbsapps.myapplication.ui.viewmodel.LoginViewModel

@Composable
fun LoginView(
    viewModel: LoginViewModel
) {
    val state = remember { viewModel.loginState }
    Column(
        modifier = Modifier.padding(80.dp)
    ) {
        Text("Type the user")
        TextField(
            value = state.value.user,
            onValueChange = viewModel::onUserChanges,
        )

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Type the password"
        )
        TextField(
            value = state.value.password,
            onValueChange = viewModel::onPasswordChanges,
        )
        Text(
            modifier = Modifier.padding(top = 5.dp),
            text = state.value.formStatusMessage
        )
        Button(
            modifier = Modifier.padding(top = 20.dp),
            onClick = viewModel::validateCredentials
        ) {
            Text("Do Login")
        }
    }
}