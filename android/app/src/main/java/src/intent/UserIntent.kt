package src.intent

import mvi.BaseIntent

sealed class UserIntent : BaseIntent {
    object ChangeView : UserIntent()
}