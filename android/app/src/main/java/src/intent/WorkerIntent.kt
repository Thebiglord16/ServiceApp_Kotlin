package src.intent

import mvi.BaseIntent

sealed class WorkerIntent : BaseIntent {
    object RefreshWorkers : WorkerIntent()
    object FetchWorkers : WorkerIntent()
}