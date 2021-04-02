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
import src.intent.UserIntent
import src.state.UserState
import java.lang.Exception

class UserViewModel() : ViewModel(), BaseModel<UserIntent, UserState> {

    override val intents: Channel<UserIntent> = Channel(Channel.UNLIMITED)
    private val _state = MutableLiveData<UserState>().apply { value = UserState() }
    override val state: LiveData<UserState>
        get() = _state
    init    {
        handlerIntent()
    }
    private fun handlerIntent(){
        viewModelScope.launch {
            intents.consumeAsFlow().collect {
                workerIntent -> when(workerIntent){
                UserIntent.ChangeView -> getView()

            }
            }
        }
    }

    private fun getView(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                updateState { it.copy(isLoading = true) }
                updateState { it.copy(isLoading = false, otraView = true)}
            }
            catch (e : Exception){
                e.printStackTrace()
                updateState { it.copy(isLoading = false, errorMessage = e.message) }
            }
        }
    }
    private suspend fun updateState(handler: suspend (intent: UserState) -> UserState){
        _state.postValue(handler(state.value!!))
    }

}