package com.mhand.android.study.pokedex.app.ui.main.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.mhand.android.study.pokedex.app.ui.main.MainViewModel

@ExperimentalFoundationApi
@Composable
fun MainScreen(viewModel: MainViewModel) {
    Scaffold(
        topBar = {
            PokedexTopAppBar(
                onNavigationClick = viewModel::onNavigationClick,
                onActionClick = viewModel::onAppBarActionClick
            )
        },
        bodyContent = {
            PokemonGrid(
                state = viewModel.pokemonList.observeAsState(),
                onItemClick = viewModel::onPokemonClick
            )
        }
    )
}



