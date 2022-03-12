package com.sonu.pokedexapp.repository

import com.sonu.pokedexapp.data.remote.PokeApi
import com.sonu.pokedexapp.data.remote.responses.Pokemon
import com.sonu.pokedexapp.data.remote.responses.PokemonList
import com.sonu.pokedexapp.util.Constants.TRY_AGAIN
import com.sonu.pokedexapp.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton
class PokemonRepository(
    private val pokeApi: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        return try {
            val result = pokeApi.getPokemonList(limit, offset)
            Resource.Success(data = result)
        } catch (e: Exception) {
            Resource.Error(e.message ?: TRY_AGAIN)
        }
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return try {
            val result = pokeApi.getPokemonInfo(pokemonName)
            Resource.Success(data = result)
        } catch (e: Exception) {
            Resource.Error(e.message ?: TRY_AGAIN)
        }
    }
}