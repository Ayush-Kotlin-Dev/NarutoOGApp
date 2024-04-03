package ggv.ayush.narutoog.domain.model

import androidx.annotation.DrawableRes
import ggv.ayush.narutoog.R

sealed class onBoardingPage(
    @DrawableRes
    val image : Int,
    val title : String,
    val description : String
){
    object FirstPage : onBoardingPage(
        image = R.drawable.greetings ,
        title = "Greetings",
        description = "NarutoOG is a fan made app for Naruto fans. It provides you with all the information about Naruto and its characters."
    )

    object SecondPage : onBoardingPage(
        image = R.drawable.explore ,
        title = "Explore",
        description = "You can search for any character from Naruto and get all the information about them."
    )

    object ThirdPage : onBoardingPage(
        image = R.drawable.power ,
        title = "Power",
        description = "You can see the power level of each character and compare them with each other."
    )

}