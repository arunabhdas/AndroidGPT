package ai.cloudcnctrai.cloudcnctrai.di

import ai.cloudcnctrai.cloudcnctrai.games.common.Constants
import ai.cloudcnctrai.cloudcnctrai.games.data.GameService
import ai.cloudcnctrai.cloudcnctrai.games.domain.GetGamesUseCase
import ai.cloudcnctrai.cloudcnctrai.games.network.data.GameApi
import ai.cloudcnctrai.cloudcnctrai.games.repo.GameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    @ViewModelScoped
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @ViewModelScoped
    fun provideGameApi(retrofit: Retrofit): GameApi {
        return retrofit.create(GameApi::class.java)
    }

    @Provides
    @ViewModelScoped
    fun provideGameService(gameApi: GameApi): GameService {
        return GameService(gameApi)  // Or however you create an instance of GameService
    }


    @Provides
    @ViewModelScoped
    fun provideGameRepository(gameService: GameService): GameRepository {
        return GameRepository(gameService)  // Or however you create an instance of GameRepository
    }

    @Provides
    @ViewModelScoped
    fun provideGamesUseCase(gameRepository: GameRepository): GetGamesUseCase {
        return GetGamesUseCase(gameRepository)  // Or however you create an instance of GetGamesUseCase
    }
}