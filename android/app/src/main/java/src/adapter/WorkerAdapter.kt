package src.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.services_app.databinding.WorkerListBinding
import src.model.Worker
class WorkerAdapter : ListAdapter<Worker, WorkerViewHolder> (WorkerAdapter){
    companion object : DiffUtil.ItemCallback<Worker>(){
        override fun areItemsTheSame(oldItem: Worker, newItem: Worker): Boolean {
            return oldItem === newItem
        }
        override fun areContentsTheSame(oldItem: Worker, newItem: Worker): Boolean {
            return oldItem == newItem
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = WorkerListBinding.inflate(inflater, parent, false)
        return WorkerViewHolder(binding)
    }
    override fun onBindViewHolder(holder: WorkerViewHolder, position: Int) {
        val binding = holder.binding as WorkerListBinding
        val currentWorker = getItem(position)
        binding.run {
            worker = currentWorker
            executePendingBindings()
        }
    }
}
class WorkerViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)