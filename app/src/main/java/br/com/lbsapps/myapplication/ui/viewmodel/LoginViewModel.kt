package br.com.lbsapps.myapplication.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import br.com.lbsapps.myapplication.domain.CredentialsProvider

class LoginViewModel(
    val credentialsProvider: CredentialsProvider
) : ViewModel() {
    private val _loginState = mutableStateOf(LoginState(formStatusMessage = "Please fill login and password"))
    val loginState = _loginState

    fun validateCredentials(user: String, password: String) {
        _loginState.value = _loginState.value.copy(user = user, password = password)
        updateFormStatusMessage(user, password)
        _loginState.value = _loginState.value.copy(loading = true)
        val isLoginValid = credentialsProvider.validateCredential(user, password)
        _loginState.value = _loginState.value.copy(loggedIn = isLoginValid)
        if (!isLoginValid) {
            _loginState.value = _loginState.value.copy(formStatusMessage = "Wrong Credentials")
        } else {
            _loginState.value = _loginState.value.copy(loggedIn = true)
        }
        _loginState.value = _loginState.value.copy(loading = false)
    }

    fun updateFormStatusMessage(user: String, password: String) {
        var message = ""

        if (password.isEmpty()) {
            message += "\nPassword is empty"
        }

        if (user.isEmpty()) {
            message += "\nUser is empty"
        }

        _loginState.value = _loginState.value.copy(formStatusMessage = message)
    }
}

data class LoginState(
    val loading: Boolean = false,
    val loggedIn: Boolean = false,
    val password: String = "",
    val user: String = "",
    val formStatusMessage: String = ""
)