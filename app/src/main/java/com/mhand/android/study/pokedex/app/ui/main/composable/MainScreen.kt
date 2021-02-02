package com.mhand.android.study.pokedex.app.ui.main.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                PokemonGrid(
                    state = viewModel.pokemonList.observeAsState(),
                    onItemClick = viewModel::onPokemonClick,
                    onReachAtLast = {
                        viewModel.loadPokemonList()
                    }
                )

                LoadingProgress(state = viewModel.isLoading)
            }
        }
    )
}

@Composable
fun LoadingProgress(state: State<Boolean>) {
    if (state.value) {
        CircularProgressIndicator()
    }
}



