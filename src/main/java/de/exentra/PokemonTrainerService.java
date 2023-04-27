package de.exentra;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PokemonTrainerService
{
	public List<PokemonTrainer> getAllTrainers()
	{
		PokemonTrainer helmut = new PokemonTrainer("1", "Helmut");
		PokemonTrainer misty = new PokemonTrainer("2", "Misty");
		PokemonTrainer brock = new PokemonTrainer("3", "Brock");
		return List.of(helmut, misty, brock);
	}
}
