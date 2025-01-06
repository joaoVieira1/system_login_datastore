package br.edu.ifsp.dmo1.login_datastore.data

object User {
    private const val email = "admin@email.com"
    private const val passwd = 123456L

    fun autenticate (email: String, passwd: Long) = this.email == email && this.passwd == passwd
}