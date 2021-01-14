package cl.desafiolatam.restapidesafio.data

import androidx.lifecycle.MutableLiveData

class Repository {
    val userList = MutableLiveData<List<Users>>()
    suspend fun loadFromApi() {
        val response = RetrofitClient.retrofitCliente().getUsers()

        when (response.isSuccessful) {
            true -> {
                response.body()?.let {
                    userList.value = it
                }
            }

            false -> {
                print("Error")
            }
        }
    }
}