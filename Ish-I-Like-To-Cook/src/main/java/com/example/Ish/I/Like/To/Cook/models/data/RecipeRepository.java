package com.example.Ish.I.Like.To.Cook.models.data;

import com.example.Ish.I.Like.To.Cook.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
