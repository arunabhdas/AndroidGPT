package ai.cloudcnctrai.cloudcnctrai.games.network.data

import ai.cloudcnctrai.cloudcnctrai.games.common.Constants.Companion.GAMES_ENDPOINT
import ai.cloudcnctrai.cloudcnctrai.games.data.model.GameModel
import retrofit2.Response
import retrofit2.http.GET


interface GameApi {
    @GET(GAMES_ENDPOINT)
    suspend fun getGames(): Response<List<GameModel>>
}