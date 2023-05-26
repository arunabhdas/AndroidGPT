package ai.cloudcnctrai.cloudcnctrai.games.domain

import ai.cloudcnctrai.cloudcnctrai.games.domain.item.GameItem
import ai.cloudcnctrai.cloudcnctrai.games.repo.GameRepository
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(private val gameRepository: GameRepository){
    suspend operator fun invoke(): List<GameItem> {
        return gameRepository.getGames()

    }
}