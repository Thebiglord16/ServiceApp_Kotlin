package src.view

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.services_app.R
import kotlinx.coroutines.launch
import mvi.BaseView
import org.koin.androidx.viewmodel.ext.android.viewModel
import src.intent.WorkerIntent
import src.state.WorkerState
import src.viewmodel.WorkerViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), BaseView<WorkerState>{
    private val mViewModel by viewModel<WorkerViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mViewModel.state.observe(this, Observer {
            render(it)
        })

        lifecycleScope.launch {
            mViewModel.intents.send(WorkerIntent.RefreshWorkers)
        }


        btnRefresh.setOnClickListener {
            lifecycleScope.launch {
                mViewModel.intents.send(WorkerIntent.RefreshWorkers)
            }
        }

    }
    override fun render(state: WorkerState) {
        with(state) {
            progressBar.isVisible = isLoading
            btnRefresh.isEnabled = !isLoading

            if (errorMessage != null) {
                Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}