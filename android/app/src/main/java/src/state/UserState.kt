package src.state

import mvi.BaseState
import src.model.Worker

class UserState    ( val workers: List<Worker> = listOf(),
val isLoading: Boolean = false,
val errorMessage: String? = null
) : BaseState