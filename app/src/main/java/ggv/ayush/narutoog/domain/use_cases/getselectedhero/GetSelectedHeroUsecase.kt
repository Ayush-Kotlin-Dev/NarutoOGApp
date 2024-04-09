package ggv.ayush.narutoog.domain.use_cases.getselectedhero

import ggv.ayush.narutoog.data.repository.Repository

class GetSelectedHeroUsecase(
    private val repository: Repository
) {
    suspend operator fun invoke(heroId: Int) = repository.getSelectedHero(heroId)
}