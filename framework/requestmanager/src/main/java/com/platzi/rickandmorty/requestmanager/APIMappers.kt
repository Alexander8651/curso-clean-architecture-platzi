package com.platzi.android.rickandmorty.api

import com.platzi.rickandmorty.domain.Character
import com.platzi.rickandmorty.domain.Episode
import com.platzi.rickandmorty.domain.Location
import com.platzi.rickandmorty.domain.Origin

fun CharacterResponseServer.toCharacterDomainList(): List<Character> = results.map {
    it.run{
        Character(
            id,
            name,
            image,
            gender,
            species,
            status,
            origin.toOriginDomain(),
            location.toLocationDomain(),
            episodeList.map { episode -> "$episode/" }
        )
    }
}

fun OriginServer.toOriginDomain() = Origin(
    name,
    url
)

fun LocationServer.toLocationDomain() = Location(
    name,
    url
)

fun EpisodeServer.toEpisodeDomain() = Episode(
    id,name
)
