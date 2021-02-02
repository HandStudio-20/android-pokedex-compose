package com.mhand.android.study.pokedex.app.ui.main.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mhand.android.study.pokedex.app.ui.main.MainViewModel

@ExperimentalFoundationApi
@Composable
fun MainScreen(viewModel: MainViewModel) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            PokedexTopAppBar(
                onNavigationClick = {
                    scaffoldState.drawerState.open()
                },
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
        },
        drawerContent = {
            Text(text = "Drawer")
        },
        drawerShape = RoundedCornerShape(topRight = 16.dp)
    )
}

@Composable
fun LoadingProgress(state: State<Boolean>) {
    if (state.value) {
        CircularProgressIndicator()
    }
}



