package de.exentra;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PokemonTrainerService
{
	public List<PokemonTrainer> getAllTrainers()
	{
		PokemonTrainer helmut = new PokemonTrainer("1", "Helmut");
		PokemonTrainer misty = new PokemonTrainer("2", "Misty");
		PokemonTrainer brock = new PokemonTrainer("3", "Brock");
		List<PokemonTrainer> named = List.of(helmut, misty, brock);

		List<PokemonTrainer> all = new ArrayList<>();
		all.addAll(named);


		for (int i=4; i<2000; i++)
		{
			all.add(new PokemonTrainer(Integer.toString(i), "Name " + i));
		}
		return all;
	}
}
