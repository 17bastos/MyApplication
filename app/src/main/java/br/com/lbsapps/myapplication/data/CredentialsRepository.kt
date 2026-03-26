package br.com.lbsapps.myapplication.data

import br.com.lbsapps.myapplication.domain.CredentialsProvider

class CredentialsRepository : CredentialsProvider {
    override fun validateCredential(user: String, password: String) : Boolean {
        return user == "user1" && password == "123"
    }
}