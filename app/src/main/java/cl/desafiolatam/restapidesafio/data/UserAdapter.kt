package cl.desafiolatam.restapidesafio.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.restapidesafio.databinding.UsersListItemBinding

class UserAdapter: RecyclerView.Adapter<UserVH>() {
   private var users = listOf<Users>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val binding=UsersListItemBinding.inflate(LayoutInflater.from(parent.context))
        return UserVH(binding)
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        val user= users[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
       return users.size
    }

    fun update(list: List<Users>) {
        users = list
        notifyDataSetChanged()
    }
}

class UserVH(val binding: UsersListItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(users: Users){
        binding.tvName.text=users.name
        binding.tvEmail.text=users.email
        binding.tvPhone.text=users.phone
    }


}
