package com.sonu.pokedexapp.ui.pokemondetail

import androidx.lifecycle.ViewModel
import com.sonu.pokedexapp.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {
    suspend fun getPokemonDetail(pokemonName: String) =
        repository.getPokemonInfo(pokemonName)
}