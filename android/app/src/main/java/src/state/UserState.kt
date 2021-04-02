package src.state

import mvi.BaseState
import src.model.Usuario

data class UserState    (val otraView: Boolean= false,
val isLoading: Boolean = false,
val errorMessage: String? = null
) : BaseState