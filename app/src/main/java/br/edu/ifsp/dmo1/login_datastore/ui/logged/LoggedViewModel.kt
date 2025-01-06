package br.edu.ifsp.dmo1.login_datastore.ui.logged

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.edu.ifsp.dmo1.login_datastore.data.DataStoreRepository
import kotlinx.coroutines.launch


class LoggedViewModel(application: Application): AndroidViewModel(application) {

    private val repository = DataStoreRepository(application)

    private val _logout = MutableLiveData<Boolean>()
    val logout: LiveData<Boolean> = _logout

    fun logout(){
        viewModelScope.launch {
            repository.logout()
        }

        _logout.value = true
    }

}