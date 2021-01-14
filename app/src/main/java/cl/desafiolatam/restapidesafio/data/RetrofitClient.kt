package cl.desafiolatam.restapidesafio.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun retrofitCliente () : UserApi {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()).build()

            return retrofit.create(UserApi::class.java)
        }
    }
}