package ggv.ayush.narutoog.presentation.common

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberImagePainter
import ggv.ayush.narutoog.R
import ggv.ayush.narutoog.domain.model.Hero
import ggv.ayush.narutoog.navigation.Screen
import ggv.ayush.narutoog.presentation.components.RatingWidget
import ggv.ayush.narutoog.presentation.components.ShimmerEffect
import ggv.ayush.narutoog.ui.theme.HERO_ITEM_HEIGHT
import ggv.ayush.narutoog.ui.theme.LARGE_PADDING
import ggv.ayush.narutoog.ui.theme.MEDIUM_PADDING
import ggv.ayush.narutoog.ui.theme.SMALL_PADDING
import ggv.ayush.narutoog.ui.theme.Shapes
import ggv.ayush.narutoog.util.Constants.BASE_URL

@Composable
fun ListContent(
    heroes : LazyPagingItems<Hero>,
    navController: NavHostController
) {
    val result = handlePagingResult(heroes = heroes)
    if(!result){
        return
    }

    LazyColumn(
        contentPadding = PaddingValues(2.dp),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING),
    ) {
        items(
            items = heroes,
            key = { hero -> hero.id }
        ){ hero ->
            hero?.let {
                HeroItem(
                    hero = it,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun handlePagingResult(
    heroes: LazyPagingItems<Hero>,
) : Boolean{
    heroes.apply {
        val error = when {
            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error
            else -> null
        }
        return when{
            loadState.refresh is LoadState.Loading -> {
                ShimmerEffect()
                false
            }
            error != null -> {
                false
            }
            else -> true // Success
        }
    }

}

@Composable
fun HeroItem(
    hero: Hero,
    navController: NavHostController
) {
    val topBarContentColor = if(isSystemInDarkTheme()) Color.LightGray else Color.White

    val painter = rememberImagePainter(
        data = "$BASE_URL${hero.image}",
        builder = {
            placeholder(R.drawable.placeholder)
            error(R.drawable.placeholder)
        }
    )

    Box(
        modifier = Modifier
            .height(HERO_ITEM_HEIGHT)
            .padding(SMALL_PADDING)
            .clickable {
                navController.navigate(Screen.Details.passHeroId(hero.id))
            },
        contentAlignment = Alignment.BottomStart
    ) {
        Surface(
            shape = RoundedCornerShape(
                bottomStart = LARGE_PADDING,
                bottomEnd = LARGE_PADDING
            )
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentDescription =  "Hero Image",
                contentScale = ContentScale.Crop
            )
        }
        Surface(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            color = Color.Black.copy(alpha = ContentAlpha.medium),
            shape = RoundedCornerShape(
                bottomStart = LARGE_PADDING,
                bottomEnd = LARGE_PADDING
            )
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MEDIUM_PADDING)
            ){
                Text(
                    text = hero.name,
                    color = topBarContentColor,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = hero.about,
                    color = Color.White.copy(alpha = ContentAlpha.medium),
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                Row (
                    modifier = Modifier
                        .padding(top = 1.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    RatingWidget(
                        modifier = Modifier.padding(top = 4.dp , end = SMALL_PADDING),
                        rating = hero.rating
                    )
                    Text(
                        text = "(${hero.rating})",
                        textAlign = TextAlign.Center,
                        color = Color.White.copy(alpha = ContentAlpha.medium)
                    )
                }


            }

        }

    }

}

@Preview
@Composable
fun itemPreview(){
    HeroItem(
        hero = Hero(
            id= 1 ,
            name = "Sasuke",
            image = "",
            about = "Sasuke Uchiha is a fictional character in the Naruto manga and anime franchise created by Masashi Kishimoto. Sasuke belongs to the Uchiha clan, a notorious ninja family, and one of the most powerful, allied with Konohagakure. Most of its members were massacred by Sasuke's older brother, Itachi Uchiha, before the series began, leaving Sasuke one of the few living. Despite becoming empathetic toward his teammates Naruto Uzumaki and Sakura Haruno, Sasuke's feelings of powerlessness force him to abandon his friends and his home in his quest to become stronger, and to find Orochimaru. Sasuke appears in several of the series' animated feature films and related media, including video games, original video animations, and Boruto: Naruto Next Generations, a sequel to the original series.",
            rating = 4.7,
            power = 100 ,
            month = "",
            day = "",
            family = listOf(),
            abilities = listOf(),
            natureTypes = listOf(),



        ),
        navController = rememberNavController()
    )
}