package com.platzi.android.rickandmorty.usescases

import com.platzi.rickandmorty.data.CharacterRepository
import com.platzi.rickandmorty.domain.Character
import io.reactivex.Flowable

class GetAllFavoriteCharactersUseCase(
    private val characterRepository: CharacterRepository
) {

    fun invoke(): Flowable<List<Character>> = characterRepository.getAllFavoriteCharacters()
}