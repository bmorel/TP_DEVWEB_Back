package fr.unilasalle.cocktailbackend.service;

import fr.unilasalle.cocktailbackend.entity.Cocktail;
import fr.unilasalle.cocktailbackend.repository.CocktailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CocktailService {

    private final CocktailRepository repository;

    public CocktailService(CocktailRepository repository) {
        this.repository = repository;
    }

    public List<Cocktail> findAll() {
        return repository.findAll();
    }

    public Optional<Cocktail> findById(Long id) {
        return repository.findById(id);
    }

    public Cocktail save(Cocktail cocktail) {
        if (cocktail.getIngredients() != null) {
            cocktail.getIngredients().forEach(ingredient -> ingredient.setCocktail(cocktail));
        }
        return repository.save(cocktail);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }
}
