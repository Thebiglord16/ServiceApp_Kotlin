package mvi

interface BaseView<S: BaseState> {
    fun render(state: S)
}