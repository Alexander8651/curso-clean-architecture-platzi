package com.platzi.android.rickandmorty.usescases

import com.platzi.rickandmorty.data.CharacterRepository
import com.platzi.rickandmorty.domain.Character
import io.reactivex.Maybe

class UpdateFavoriteCharacterStatusUseCase(
    private val characterRepository: CharacterRepository
) {


    //TODO Paso 5: Crear método "invoke"
    //TODO Paso 5.1: Pasar como parámetro "characterEntity" de tipo CharacterEntity
    //TODO Paso 5.2: Indicar que el método devuelve un valor de tipo Maybe<Boolean>
    //TODO Paso 6: Migrar a este método la implementación del método "onUpdateFavoriteCharacterStatus" en la clase CharacterDetailViewModel
    //TODO Paso 6.1: Migrar el uso de la variable "characterDao"
    //TODO Paso 6.2: Migrar el uso del método "getCharacterById"
    //TODO Paso 6.3: Migrar el uso del método "isEmpty"
    //TODO Paso 6.4: Migrar el uso del método "flatMapMaybe"
    //TODO Paso 6.5: Migrar el uso del método "observeOn"
    //TODO Paso 6.6: Migrar el uso del método "subscribeOn"
    fun invoke(character: Character): Maybe<Boolean> {
        return characterRepository.updateFavoriteStatus(character)
    }
}