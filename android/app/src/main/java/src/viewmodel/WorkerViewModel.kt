package src.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import mvi.BaseModel
import src.intent.WorkerIntent
import src.model.WorkerApi
import src.state.WorkerState


class WorkerViewModel(private val workerApi: WorkerApi) : ViewModel(), BaseModel<WorkerIntent, WorkerState> {

    override val intents: Channel<WorkerIntent> = Channel(Channel.UNLIMITED)
    private val _state = MutableLiveData<WorkerState>().apply { value = WorkerState() }
    override val state: LiveData<WorkerState>
    get() = _state
    init    {
        handlerIntent()
    }

    private fun handlerIntent(){
        viewModelScope.launch {
            intents.consumeAsFlow().collect {
                workerIntent -> when(workerIntent){
                    WorkerIntent.RefreshWorkers -> fetchData()
                    WorkerIntent.FetchWorkers -> fetchData()
                }
            }
        }
    }

    private fun fetchData(){
        viewModelScope.launch(Dispatchers.IO) {
            updateState { it.copy(isLoading = true) }
            updateState { it.copy(isLoading = false, workers = workerApi.getWorkers())}

        }
    }

    private suspend fun updateState(handler: suspend (intent : WorkerState) -> WorkerState){
        _state.postValue(handler(state.value!!))
    }
}