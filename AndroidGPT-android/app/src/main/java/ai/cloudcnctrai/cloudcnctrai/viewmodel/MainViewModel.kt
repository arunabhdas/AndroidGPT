package ai.cloudcnctrai.cloudcnctrai.viewmodel

import ai.cloudcnctrai.cloudcnctrai.games.domain.GetGamesUseCase
import ai.cloudcnctrai.cloudcnctrai.games.domain.item.GameItem
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val getGamesUseCase: GetGamesUseCase
): AndroidViewModel(application) {
    private val _games = MutableStateFlow(emptyList<GameItem>())
    val games: StateFlow<List<GameItem>> get() = _games

    init {
        getGames()
    }

    private fun getGames() {
        viewModelScope.launch {
            try {
                val games = getGamesUseCase()
                _games.value = games
            } catch (_: Exception) {

            }
        }
    }

}