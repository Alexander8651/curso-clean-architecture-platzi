package com.platzi.android.rickandmorty.usescases

import com.platzi.rickandmorty.data.CharacterRepository
import com.platzi.rickandmorty.domain.Character
import io.reactivex.Single

class GetAllCharacterUseCase(
    private val characterRepository: CharacterRepository
) {

    fun invoke(currentPage: Int):Single<List<Character>> = characterRepository.getAllCharacters(currentPage)
}