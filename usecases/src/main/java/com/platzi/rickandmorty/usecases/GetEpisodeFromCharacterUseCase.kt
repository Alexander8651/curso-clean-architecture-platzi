package com.platzi.android.rickandmorty.usescases

import com.platzi.rickandmorty.data.EpisodeRepository
import com.platzi.rickandmorty.domain.Episode
import io.reactivex.Single

class GetEpisodeFromCharacterUseCase (
    private val episodeReposiroty:EpisodeRepository
) {

    fun invoke(episodeUrlList:List<String>):Single<List<Episode>>{

        return episodeReposiroty.getEpisodeFromCharacter(episodeUrlList)

    }
}