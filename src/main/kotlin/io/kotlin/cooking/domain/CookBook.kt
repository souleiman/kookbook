package io.kotlin.cooking.domain

/**
 * Author: Soul
 * Date: 2/6/2018
 */
class CookBook {
    val recipes: MutableList<Recipe> = mutableListOf()
    val names: MutableMap<String, MutableList<Recipe>> = mutableMapOf()
    val ingredients: MutableMap<String, MutableList<Recipe>> = mutableMapOf()
    val categories: MutableMap<String, MutableList<Recipe>> = mutableMapOf()

    val size: Int get() = recipes.size

    operator fun plusAssign(recipe: Recipe) {
        recipes += recipe.apply { id = size }

        names.update(recipe.name.toLowerCase(), recipe)
        recipe.ingredients.forEach { ingredients.update(it.toLowerCase(), recipe) }
        recipe.categories.forEach { categories.update(it.toLowerCase(), recipe) }
    }

    private fun MutableMap<String, MutableList<Recipe>>.update(key: String, recipe: Recipe) {
        val item = this.getOrPut(key) { mutableListOf() }
        item.add(recipe)
    }
}