package edu.itsco.jsonclient.data.repository

import edu.itsco.jsonclient.data.api.RickMortyApi
import edu.itsco.jsonclient.data.api.model.Characters
import javax.inject.Inject

class RickMortyRepository @Inject constructor(
    private val rickMortyApi: RickMortyApi
) {

    suspend fun getCharacters(): Characters {
        return rickMortyApi.getCharacters()
    }
}