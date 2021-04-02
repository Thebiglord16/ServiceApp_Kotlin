package src.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.services_app.databinding.WorkerListBinding
import src.model.Worker
class UserAdapter : RecyclerView.Adapter<UserViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = WorkerListBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }


    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val binding = holder.binding as WorkerListBinding
        binding.run {
            executePendingBindings()
        }
    }
}

    class UserViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)