package com.mhand.android.study.pokedex.app.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mhand.android.study.pokedex.model.Pokemon
import com.mhand.android.study.pokedex.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {
    private val scope = viewModelScope

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _pokemonList: MutableLiveData<List<Pokemon>> = MutableLiveData()
    val pokemonList: LiveData<List<Pokemon>> = _pokemonList

    init {
        loadPokemonList()
    }

    fun loadPokemonList() {
        if (!_isLoading.value) {
            _isLoading.value = true

            scope.launch {
                val updatedPokemonList = _pokemonList.value?.toMutableList() ?: mutableListOf()

                getAllPokemon(
                    offset = updatedPokemonList.lastOrNull()?.id ?: 0
                ).let {
                    updatedPokemonList.addAll(it)
                    _pokemonList.postValue(updatedPokemonList)
                    _isLoading.value = false
                }
            }
        }
    }

    fun onAppBarActionClick(type: AppBarActionType) {
        // TODO :: Handling Event (Ex. Show Dialog..)
    }

    fun onPokemonClick(pokemon: Pokemon) {
        // TODO :: Open pokemon detail page
    }

    private suspend fun getAllPokemon(offset: Int): List<Pokemon> = withContext(Dispatchers.IO) {
        pokemonRepository.getAllPokemon(
            limit = POKEMON_LIST_DEFAULT_LIMIT,
            offset = offset
        ).results.map {
            pokemonRepository.getPokemonDetail(it.name)
        }
    }

    companion object {
        private const val POKEMON_LIST_DEFAULT_LIMIT = 30
    }
}