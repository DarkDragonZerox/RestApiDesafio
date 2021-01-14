package cl.desafiolatam.restapidesafio.data

import retrofit2.Response
import retrofit2.http.GET

interface UserApi  {
 @GET("/users")
suspend fun getUsers(): Response<List<Users>>


}
