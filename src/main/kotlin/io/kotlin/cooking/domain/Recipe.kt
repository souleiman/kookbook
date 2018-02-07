package io.kotlin.cooking.domain

/**
 * Author: Soul
 * Date: 1/26/2018
 */
data class Recipe(var id: Int = -1,
                  val name: String,
                  val description: String?,
                  val ingredients: List<String>,
                  val directions: List<String>,
                  val categories: List<String>,
                  val protein: Double?,
                  val fat: Double?,
                  val calories: Double?,
                  val sodium: Double?)