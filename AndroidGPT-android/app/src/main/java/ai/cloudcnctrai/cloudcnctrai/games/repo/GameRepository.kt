package ai.cloudcnctrai.cloudcnctrai.games.repo

import ai.cloudcnctrai.cloudcnctrai.games.data.GameService
import ai.cloudcnctrai.cloudcnctrai.games.domain.item.GameItem
import ai.cloudcnctrai.cloudcnctrai.games.domain.item.toGameItem
import javax.inject.Inject


class GameRepository @Inject constructor(private val gameService: GameService) {
   suspend fun getGames(): List<GameItem> {
       return gameService.getGames().map {
           it.toGameItem()
       }
   }
}