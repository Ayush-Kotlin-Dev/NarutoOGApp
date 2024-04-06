package ggv.ayush.narutoog.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import ggv.ayush.narutoog.data.repository.Repository
import ggv.ayush.narutoog.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase (
    private val repository: Repository
)   {
    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }
}