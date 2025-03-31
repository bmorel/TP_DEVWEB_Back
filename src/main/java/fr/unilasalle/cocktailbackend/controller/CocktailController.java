package fr.unilasalle.cocktailbackend.controller;

import fr.unilasalle.cocktailbackend.entity.Cocktail;
import fr.unilasalle.cocktailbackend.service.CocktailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cocktails")
public class CocktailController {

    private final CocktailService cocktailService;

    public CocktailController(CocktailService cocktailService) {
        this.cocktailService = cocktailService;
    }

    @GetMapping
    public List<Cocktail> getAll() {
        return cocktailService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cocktail> getById(@PathVariable Long id) {
        return cocktailService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cocktail create(@RequestBody Cocktail cocktail) {
        return cocktailService.save(cocktail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cocktailService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
