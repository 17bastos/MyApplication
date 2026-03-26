package br.com.lbsapps.myapplication.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import br.com.lbsapps.myapplication.domain.CredentialsProvider

class LoginViewModel(
    val credentialsProvider: CredentialsProvider
) : ViewModel() {
    private val _loginState = mutableStateOf(LoginState())
    val loginState = _loginState

    init {
        updateFormStatusMessage()
    }

    fun validateCredentials(user: String, password: String) {
        _loginState.value = _loginState.value.copy(user = user, password = password)
        updateFormStatusMessage()
        _loginState.value = _loginState.value.copy(loading = true)
        val isLoginValid = credentialsProvider.validateCredential(user, password)
        _loginState.value = _loginState.value.copy(loggedIn = isLoginValid)
        if (!isLoginValid) {
            _loginState.value = _loginState.value.copy(error = "Wrong Credentials")
        }
        _loginState.value = _loginState.value.copy(loading = false)
    }

    private fun updateFormStatusMessage() {
        var message = ""

        if (_loginState.value.password.isEmpty()) {
            message += "\nPassword is empty"
        }

        if (_loginState.value.user.isEmpty()) {
            message += "\nUser is empty"
        }

        _loginState.value = _loginState.value.copy(formStatusMessage = message)
    }
}

data class LoginState(
    val error: String? = null,
    val loading: Boolean = false,
    val loggedIn: Boolean = false,
    val password: String = "",
    val user: String = "",
    val formStatusMessage: String = ""
)