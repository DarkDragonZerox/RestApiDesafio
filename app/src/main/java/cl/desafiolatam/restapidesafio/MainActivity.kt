package cl.desafiolatam.restapidesafio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import cl.desafiolatam.restapidesafio.data.UserAdapter
import cl.desafiolatam.restapidesafio.databinding.ActivityMainBinding
import cl.desafiolatam.restapidesafio.model.RestViewModel

/*
1. Ir a la web de jsonplaceholder https://jsonplaceholder.typicode.com, e identificar el método a utilizar para los datos de usuario.
2. Crear un nuevo proyecto kotlin, min sdk 19, blank activity, llamado RestApiDesafio.
3. Implementar las bibliotecas necesarias en el archivo gradle.
4. Modificar el layout por defecto activity_main.xml para incluir una vista tipo RecyclerView.
5. Crear el layout users_list_item.xml con los atributos name, email y phone.
6. Crear el archivo pojo con los atributos id, name, email y phone.
7. Crear la interfaz Api con el método GET de la lista de usuarios del api.
8. Crear la clase cliente de Retrofit.
9. Crear la clase UserAdapter con la implementación de ViewHolder y parametrización de los datos
de usuario name, email y phone.
10. Modificar la clase de Actividad agregando un nuevo método loadApiData() e instanciando la clase
recyclerview y UserAdapter.

 */
class MainActivity : AppCompatActivity() {
    private val viewModel : RestViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val adapter = UserAdapter()
        binding.rvUsers.adapter=adapter
        binding.rvUsers.layoutManager=LinearLayoutManager(this)
        setContentView(binding.root)
        viewModel.listaUsuarios().observe(this,{
            adapter.update(it)

        })



    }
}

