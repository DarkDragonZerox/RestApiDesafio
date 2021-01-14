package cl.desafiolatam.restapidesafio.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.desafiolatam.restapidesafio.data.Repository
import cl.desafiolatam.restapidesafio.data.Users
import kotlinx.coroutines.launch

class RestViewModel: ViewModel() {
    private val repository=Repository()
    private val listaUsuarios=repository.userList

    fun listaUsuarios():LiveData<List<Users>> = listaUsuarios

    init {
        viewModelScope.launch {
            repository.loadFromApi()
        }
    }
}