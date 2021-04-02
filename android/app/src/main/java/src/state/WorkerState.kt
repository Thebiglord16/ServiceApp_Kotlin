package src.state

import mvi.BaseState
import src.model.Worker

data class WorkerState(
    val workers: List<Worker> = listOf(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) : BaseState

