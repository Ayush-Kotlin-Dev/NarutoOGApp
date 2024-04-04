package ggv.ayush.narutoog.domain.use_cases.readonboarding

import ggv.ayush.narutoog.data.repository.Repository

class ReadOnBoardingUseCase (
     private val repository: Repository
) {
    operator fun invoke() = repository.readOnBoardingState()
}