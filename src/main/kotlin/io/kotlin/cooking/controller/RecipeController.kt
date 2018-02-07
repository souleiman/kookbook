package io.kotlin.cooking.controller

import io.kotlin.cooking.domain.CookBook
import io.kotlin.cooking.domain.Recipe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * Author: Soul
 * Date: 1/26/2018
 */
@RestController
class RecipeController {
    @Autowired
    private lateinit var cookbook: CookBook

    @GetMapping("/")
    fun random(): Recipe? {
        if (cookbook.size == 0) {
            return null
        }

        return cookbook.recipes[(Math.random() * cookbook.size).toInt()]
    }

    @GetMapping("/id/{id}")
    fun findByIndex(@PathVariable(value = "id") id: Int): Recipe? {
        if (id >= cookbook.size) {
            return null
        }

        return cookbook.recipes[id]
    }

    @GetMapping("/recipe/{name}")
    fun findRecipeName(@PathVariable(value = "name") name: String): Recipe? {
        TODO("Search for recipe by name (MAKE SURE TO LOWERCASE WHEN SEARCHING)")
    }

    @GetMapping("/ingredients")
    fun getAllIngredients(): Set<String> {
        TODO("Implement retrieval to all possible recipes")
    }

    @GetMapping("/ingredient/{ingredient}")
    fun findRecipeContainingIngredient(@PathVariable(value = "ingredient") ingredient: String): Recipe? {
        TODO("Implement retrieval to a recipe containing an ingredient")
    }

    @GetMapping("/category/{category}")
    fun findRecipeContainingCategory(@PathVariable(value = "category") category: String): Recipe? {
        TODO("Implement retrieval to a recipe containing a a category")
    }

    @GetMapping("/categories")
    fun getAllCategories(): Set<String> {
        TODO("Implement retrieval to all categories")
    }
}