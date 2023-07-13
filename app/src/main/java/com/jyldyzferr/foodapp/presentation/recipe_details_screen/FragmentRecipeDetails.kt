package com.jyldyzferr.foodapp.presentation.recipe_details_screen


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.jyldyzferr.foodapp.databinding.FragmentRecipeDetailsBinding
import com.jyldyzferr.foodapp.domain.models.Recipe
import com.jyldyzferr.foodapp.presentation.recipe_details_screen.ingredients.IngredientsAdapter

class FragmentRecipeDetails : Fragment() {

    private val binding: FragmentRecipeDetailsBinding by lazy {
        FragmentRecipeDetailsBinding.inflate(layoutInflater)
    }

    private val recipe: Recipe by lazy {
        FragmentRecipeDetailsArgs.fromBundle(requireArguments()).recipe
    }

   private val ingredientsAdapter: IngredientsAdapter by lazy {
       IngredientsAdapter()
   }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = with(binding){
      loadImageByUrl(
          imageUrl = recipe.imageUrl,
          imageView = recipeDetailsHeader.recipeImageView,
      )

        loadImageByUrl(
            imageUrl = recipe.cook.avatarUrl,
            imageView = recipeDetailsHeader.cookImageView
        )

        recipeDetailsHeader.cookNameTextView.text = recipe.cook.name
        recipeDetailsHeader.cookLastnameTextView.text = recipe.cook.lastName
        recipeDetailsContent.ingredientsCountTextView.text = recipe.ingredients.count().toString()
        recipeDetailsContent.recipeDescriptionTextView.text = recipe.description
        recipeDetailsContent.recipeTitleTextView.text = recipe.title
        recipeDetailsContent.ingredientRecyclerView.adapter= ingredientsAdapter
        ingredientsAdapter.updateData(recipe.ingredients)

    }

    private fun loadImageByUrl(imageUrl: String, imageView: ImageView) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .into(imageView)
    }

}