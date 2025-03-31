package fr.unilasalle.cocktailbackend.repository;

import fr.unilasalle.cocktailbackend.entity.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocktailRepository extends JpaRepository<Cocktail, Long> {
}
