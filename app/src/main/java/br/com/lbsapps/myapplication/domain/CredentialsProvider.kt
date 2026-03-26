package br.com.lbsapps.myapplication.domain

interface CredentialsProvider {
    fun validateCredential(user: String, password: String) : Boolean
}