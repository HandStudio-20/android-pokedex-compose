package com.mhand.android.study.pokedex.app.ui.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

enum class AppBarActionType(
    val icon: ImageVector,
    val description: String
) {
    ACTION_ONE(Icons.Filled.Add, "Action one"),
    ACTION_TWO(Icons.Filled.Info, "Action two")
}