package io.kotlin.cooking.app

import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import io.kotlin.cooking.domain.CookBook
import io.kotlin.cooking.domain.Recipe
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan

/**
 * Author: Soul
 * Date: 1/26/2018
 */
@SpringBootApplication
@ComponentScan(basePackages = ["io.kotlin.cooking.controller"])
open class Application {
    @Bean("cookbook")
    open fun recipes(): CookBook {
        val book = CookBook()
        val gson = Gson()

        val stream = javaClass.getResourceAsStream("/recipes.json")
        val bufferedReader = stream.bufferedReader()
        val reader = JsonReader(bufferedReader)

        reader.beginArray()

        while (reader.hasNext()) {
            val recipe = gson.fromJson<Recipe>(reader, Recipe::class.java)
            recipe.name ?: continue // Since Gson is using reflection it bypasses kotlin null-safety

            book += recipe
        }

        reader.close()
        bufferedReader.close()

        return book
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}