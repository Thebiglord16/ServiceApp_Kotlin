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

class UserViewModel() : ViewModel(), BaseModel<UserIntent, UserState> {

    override val intents: Channel<UserIntent> = Channel(Channel.UNLIMITED)
    private val _state = MutableLiveData<UserState>().apply { value = UserState() }
    override val state: LiveData<UserState>
        get() = _state
    init    {

    }


}