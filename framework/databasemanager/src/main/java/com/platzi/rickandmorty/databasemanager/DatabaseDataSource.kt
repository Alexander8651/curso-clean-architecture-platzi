package com.platzi.android.rickandmorty.database

import com.platzi.rickandmorty.data.LocalCharacterDataSource
import com.platzi.rickandmorty.domain.Character
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class  CharacterRoomDataSource(
    database: CharacterDatabase
):LocalCharacterDataSource {

    private val characterDao by lazy{database.characterDao()}

    override fun gelAllFavoriteCharacters(): Flowable<List<Character>> {
        return characterDao
            .getAllFavoriteCharacters()
            .map(List<CharacterEntity>::toCharacterDomainList)
            .onErrorReturn { emptyList() }
            .subscribeOn(Schedulers.io())
    }

    override fun gatFavoriteCharacterStatus(id: Int): Maybe<Boolean> {
        return characterDao.getCharacterById(id)
            .isEmpty
            .flatMapMaybe { isEmpty ->
                Maybe.just(!isEmpty)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun updateFavoriteCharacterStatus(character: Character): Maybe<Boolean> {
        val characterEntity = character.toCharacterEntity()
        return characterDao.getCharacterById(characterEntity.id)
            .isEmpty
            .flatMapMaybe { isEmpty ->
                if (isEmpty) {
                    characterDao.insertCharacter(characterEntity)
                } else {
                    characterDao.deleteCharacter(characterEntity)
                }
                Maybe.just(isEmpty)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}