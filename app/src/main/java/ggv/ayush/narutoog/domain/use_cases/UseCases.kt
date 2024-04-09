package ggv.ayush.narutoog.domain.use_cases

import ggv.ayush.narutoog.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import ggv.ayush.narutoog.domain.use_cases.getselectedhero.GetSelectedHeroUsecase
import ggv.ayush.narutoog.domain.use_cases.readonboarding.ReadOnBoardingUseCase
import ggv.ayush.narutoog.domain.use_cases.save_onboarding.SaveOnBoardingCase
import ggv.ayush.narutoog.domain.use_cases.search_heroes.SearchHeroesUseCase

data class UseCases(
    val saveOnBoardingCase: SaveOnBoardingCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getAllHeroesUseCase: GetAllHeroesUseCase,
    val searchHeroesUseCase : SearchHeroesUseCase,
    val getSelectedHeroUsecase: GetSelectedHeroUsecase
)