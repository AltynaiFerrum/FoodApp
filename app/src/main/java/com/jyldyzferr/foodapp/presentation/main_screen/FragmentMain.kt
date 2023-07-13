package com.jyldyzferr.foodapp.presentation.main_screen

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.jyldyzferr.foodapp.R
import com.jyldyzferr.foodapp.databinding.FragmentMainBinding
import com.jyldyzferr.foodapp.domain.models.Recipe
import com.jyldyzferr.foodapp.domain.models.User
import com.jyldyzferr.foodapp.presentation.main_screen.recycler_view.food_category.FoodCategoryAdapter
import com.jyldyzferr.foodapp.presentation.main_screen.recycler_view.listeners.RecipeItemOnClickListeners
import com.jyldyzferr.foodapp.presentation.main_screen.recycler_view.recipe.RecipeAdapter
import com.jyldyzferr.foodapp.presentation.main_screen.view_pager.ViewPagerAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class FragmentMain : Fragment(), RecipeItemOnClickListeners {

    private val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    private val viewModel: FragmentMainViewModel by viewModels()


    private val viewPagerAdapter: ViewPagerAdapter by lazy {
        ViewPagerAdapter()
    }

    private val recipeAdapter: RecipeAdapter by lazy {
        RecipeAdapter(this)
    }

    private val categoryAdapter: FoodCategoryAdapter by lazy {
        FoodCategoryAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setupSearchView()
        observeData()
    }

    private fun initViews() = with(binding){
        mainContent.viewPager.adapter = viewPagerAdapter
        mainContent.recyclerView.adapter = recipeAdapter
        mainContent.foodCategoryRecyclerView.adapter= categoryAdapter
    }


    private fun setupSearchView() {
        binding.mainContent.searchView.setupSearchViewParams()
    }


    private fun observeData() {
        viewModel.uiStateFlow.onEach { uiState ->
            viewPagerAdapter.updateData(uiState.recommendationsEvent)
            recipeAdapter.updateData(uiState.recipes)
            categoryAdapter.updateData(uiState.foodCategories)
            showUserInfo(uiState.currentUser)
        }.launchIn(lifecycleScope)
    }

    private fun showUserInfo(user: User){
        Glide.with(requireActivity())
            .load(user.avatarUrl)
            .into(binding.mainTopContent.avatarImageView)
    }

    override fun onRecipeClick(recipe: Recipe) {
        findNavController()
            .navigate(FragmentMainDirections.actionFragmentMainToFragmentRecipeDetails(recipe))

    }
}

fun android.widget.SearchView.setupSearchViewParams() {
    val searchText = this.findViewById<View>(
        this.context.resources.getIdentifier(
            "android:id/search_src_text", null, null
        )
    ) as AutoCompleteTextView
    searchText.setTextSize(
        TypedValue.COMPLEX_UNIT_PX,
        resources.getDimensionPixelSize(R.dimen.textSizeForSmallTexts).toFloat()
    )
    val typeface = ResourcesCompat.getFont(this.context, R.font.inter_light)
    searchText.typeface = typeface
}


