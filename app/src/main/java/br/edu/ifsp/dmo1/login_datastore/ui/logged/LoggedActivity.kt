package br.edu.ifsp.dmo1.login_datastore.ui.logged

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import br.edu.ifsp.dmo1.login_datastore.R
import br.edu.ifsp.dmo1.login_datastore.databinding.ActivityLoggedBinding
import br.edu.ifsp.dmo1.login_datastore.ui.main.MainActivity

class LoggedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoggedBinding
    private lateinit var viewModel: LoggedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoggedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(LoggedViewModel::class.java)
        binding.textMessage.setText("Bem-Vindo")

        setupListeners()
        setupObservers()
    }

    private fun setupObservers(){
        viewModel.logout.observe(this, Observer {
            if (it){
                Toast.makeText(this, "Sessão encerrada", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupListeners(){
        binding.buttonLogout.setOnClickListener {
            handleLogout()
        }
    }

    private fun handleLogout(){
        viewModel.logout()
        val mIntent = Intent(this, MainActivity::class.java)
        startActivity(mIntent)
        finish()
    }

}