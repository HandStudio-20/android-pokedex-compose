package com.mhand.android.study.pokedex.app.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mhand.android.study.pokedex.api.PokemonApi
import com.mhand.android.study.pokedex.app.ui.main.composable.AppBarActionType
import com.mhand.android.study.pokedex.model.PokemonDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val pokemonApi: PokemonApi
) : ViewModel() {
    private val scope = viewModelScope

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _pokemonList: MutableLiveData<List<PokemonDetail>> = MutableLiveData()
    val pokemonList: LiveData<List<PokemonDetail>> = _pokemonList

    init {
        loadPokemonList()
    }

    private fun loadPokemonList() {
        if (!_isLoading.value) {
            scope.launch {
                _isLoading.value = true

                val newPokemonList = mutableListOf<PokemonDetail>()

                pokemonApi.getAllPokemon(offset = 0).results.forEach {
                    val pokemon = pokemonApi.getPokemonDetail(it.name)
                    newPokemonList.add(pokemon)
                }

                _pokemonList.postValue(newPokemonList)

                _isLoading.value = false
            }
        }
    }

    fun onNavigationClick() {
        // TODO :: Handling event (Ex. Open Drawer..)
    }

    fun onAppBarActionClick(type: AppBarActionType) {
        // TODO :: Handling Event (Ex. Show Dialog..)
    }

    fun onPokemonClick(pokemonDetail: PokemonDetail) {
        // TODO :: Open pokemon detail page
    }
}