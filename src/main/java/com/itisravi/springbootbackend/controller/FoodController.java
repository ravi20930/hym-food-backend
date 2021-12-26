package com.itisravi.springbootbackend.controller;
import com.itisravi.springbootbackend.exception.ResourceNotFoundException;
import com.itisravi.springbootbackend.model.Food;
import com.itisravi.springbootbackend.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

//    get all foods
    @GetMapping("/foods")
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

// create food rest api
    @PostMapping("/foods")
    public Food createFood(@RequestBody Food food) {
        return foodRepository.save(food);
    }

//    get food by id
    @GetMapping("/foods/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
        Food food = foodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("food not found"));
        return ResponseEntity.ok(food);
    }

//    update food rest api
    @PutMapping("/foods/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Long id, @RequestBody Food foodItem) {
        Food food = foodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("food not found"));

        food.setFoodName(foodItem.getFoodName());
        food.setProtein(foodItem.getProtein());
        food.setFats(foodItem.getFats());
        food.setCarbs(foodItem.getCarbs());
        food.setSize(foodItem.getSize());

        Food updatedFood = foodRepository.save(food);
        return ResponseEntity.ok(updatedFood);
    }

//    delete food rest api
    @DeleteMapping("/foods/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteFood(@PathVariable Long id) {
        Food food = foodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("food not found"));

        foodRepository.delete(food);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
