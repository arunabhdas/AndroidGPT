package ai.cloudcnctrai.cloudcnctrai.games.domain.item

import ai.cloudcnctrai.cloudcnctrai.games.data.model.GameModel

data class GameItem (
    val id: Int,
    val title: String,
    val thumbnail: String,
    val short_description: String
)

fun GameModel.toGameItem() = GameItem(id, title, thumbnail, short_description)

