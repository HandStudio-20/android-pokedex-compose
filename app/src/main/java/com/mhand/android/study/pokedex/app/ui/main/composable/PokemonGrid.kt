package com.mhand.android.study.pokedex.app.ui.main.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mhand.android.study.pokedex.R
import com.mhand.android.study.pokedex.app.ui.component.loadPicture
import com.mhand.android.study.pokedex.model.PokemonDetail
import com.mhand.android.study.pokedex.utils.PokemonUtils

@ExperimentalFoundationApi
@Composable
fun PokemonGrid(
    state: State<List<PokemonDetail>?>,
    onItemClick: (PokemonDetail) -> Unit
) {
    val pokemonList = state.value ?: emptyList()

    LazyVerticalGrid(
        cells = GridCells.Fixed(count = 2)
    ) {
        items(pokemonList) { pokemon ->
            PokemonGridCard(
                pokemonDetail = pokemon,
                onClick = onItemClick
            )
        }
    }
}

@Composable
fun PokemonGridCard(
    pokemonDetail: PokemonDetail,
    onClick: (PokemonDetail) -> Unit
) {
    Box(modifier = Modifier
        .padding(4.dp)
        .aspectRatio(1f)
        .fillMaxWidth()
    ) {
        Card(
            backgroundColor = PokemonUtils.getPokemonColor(pokemonDetail.types.firstOrNull()?.type?.name),
            shape = RoundedCornerShape(16.dp),
            contentColor = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    onClick.invoke(pokemonDetail)
                }
        ) {
            PokemonGridCardContent(pokemonDetail)
        }
    }
}

@Composable
fun PokemonGridCardContent(pokemonDetail: PokemonDetail) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (pokemonName, pokemonNumber, pokemonImage) = createRefs()

        Text(
            text = pokemonDetail.name,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.constrainAs(pokemonName) {
                top.linkTo(parent.top, margin = 8.dp)
                start.linkTo(parent.start, margin = 8.dp)
            }
        )

        Text(
            text = AmbientContext.current.getString(R.string.pokemon_number, pokemonDetail.pokedexNumber),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White.copy(alpha = 0.7f)
            ),
            modifier = Modifier.constrainAs(pokemonNumber) {
                top.linkTo(pokemonName.bottom, margin = 4.dp)
                start.linkTo(parent.start, margin = 8.dp)
            }
        )

        loadPicture(url = pokemonDetail.imageResource).value?.let {
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = "Pokemon Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier.constrainAs(pokemonImage) {
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                    top.linkTo(pokemonNumber.bottom, margin = 4.dp)
                    start.linkTo(parent.start, margin = 8.dp)
                    end.linkTo(parent.end, margin = 8.dp)
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                }
            )
        }
    }
}
