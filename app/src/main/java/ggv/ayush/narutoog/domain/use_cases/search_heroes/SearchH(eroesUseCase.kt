package ggv.ayush.narutoog.domain.use_cases.search_heroes

import androidx.paging.PagingData
import ggv.ayush.narutoog.data.repository.Repository
import ggv.ayush.narutoog.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class SearchHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(query: String): Flow<PagingData<Hero>> {
        return repository.searchHeroes(query)
    }

}
