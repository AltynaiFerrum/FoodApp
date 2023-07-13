package com.jyldyzferr.foodapp.presentation.main_screen

import androidx.lifecycle.ViewModel
import com.jyldyzferr.foodapp.data.repositories.FoodRepositoryImpl
import com.jyldyzferr.foodapp.data.repositories.UsersRepositoryImpl
import com.jyldyzferr.foodapp.domain.models.FoodCategory
import com.jyldyzferr.foodapp.domain.models.Recipe
import com.jyldyzferr.foodapp.domain.models.RecommendationsEvent
import com.jyldyzferr.foodapp.domain.models.User
import com.jyldyzferr.foodapp.domain.repositories.FoodRepository
import com.jyldyzferr.foodapp.domain.repositories.UsersRepository
import com.jyldyzferr.foodapp.domain.use_cases.FetchAllFoodCategories
import com.jyldyzferr.foodapp.domain.use_cases.FetchAllRecipesUseCases
import com.jyldyzferr.foodapp.domain.use_cases.FetchAllRecommendationsEventUseCase
import com.jyldyzferr.foodapp.domain.use_cases.FetchCurrentUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class MainFragmentUiState(
    val recommendationsEvent: List<RecommendationsEvent> = emptyList(),
    val recipes: List<Recipe> = emptyList(),
    val foodCategories: List<FoodCategory> = emptyList(),
    val currentUser: User = User.unknown()
)

class FragmentMainViewModel : ViewModel() {

    private val foodRepository: FoodRepository = FoodRepositoryImpl()
    private val usersRepository: UsersRepository = UsersRepositoryImpl()

    private val fetchAllRecommendationsEventUseCase = FetchAllRecommendationsEventUseCase(foodRepository)
    private val fetchAllRecipesUseCases = FetchAllRecipesUseCases(foodRepository)
    private val fetchAllFoodCategories = FetchAllFoodCategories(foodRepository)

    private val fetchCurrentUserUseCase = FetchCurrentUserUseCase(usersRepository)

    private val _uiStateFlow = MutableStateFlow(MainFragmentUiState())
    val uiStateFlow = _uiStateFlow.asStateFlow()


    init {
        val recommendationsEvent = fetchAllRecommendationsEventUseCase.invoke()
        val recipes = fetchAllRecipesUseCases.invoke()
        val foodCategories = fetchAllFoodCategories.invoke()
        val currentUser = fetchCurrentUserUseCase.invoke()
        val uiState = MainFragmentUiState(
            recommendationsEvent = recommendationsEvent,
            recipes = recipes,
            foodCategories = foodCategories,
            currentUser = currentUser
        )
        _uiStateFlow.tryEmit(uiState)
    }
}