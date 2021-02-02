package com.mhand.android.study.pokedex.app.ui.main.composable

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AmbientContext
import com.mhand.android.study.pokedex.R
import com.mhand.android.study.pokedex.app.ui.main.AppBarActionType

@Composable
fun PokedexTopAppBar(
    onNavigationClick: () -> Unit,
    onActionClick: (AppBarActionType) -> Unit
) {
    TopAppBar(
        title = {
            Text(text = AmbientContext.current.getString(R.string.app_name))
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        navigationIcon = {
            IconButton(onClick = {
                onNavigationClick.invoke()
            }) {
                Icon(Icons.Filled.Menu, contentDescription = "Navigation Button")
            }
        },
        actions = {
            AppBarActionType.values().map {
                IconButton(onClick = {
                    onActionClick.invoke(it)
                }) {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.description
                    )
                }
            }
        }
    )
}


