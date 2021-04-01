package mvi

import androidx.lifecycle.LiveData
import kotlinx.coroutines.channels.Channel

interface BaseModel <I: BaseIntent , S: BaseState> {
    val intents: Channel<I>
    val state: LiveData<S>
}
