package de.exentra;

import io.quarkus.runtime.util.StringUtil;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Path("/trainers")
public class TrainerResource
{
	@Inject
	PokemonTrainerService pokemonTrainerService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PokemonTrainer> all()
	{
		return pokemonTrainerService.getAllTrainers();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public PokemonTrainer byId(@PathParam("id") String id)
	{
		if (StringUtils.isBlank(id))
		{
			throw new BadRequestException();
		}

		return pokemonTrainerService.getAllTrainers().stream()
			.filter(t -> t.getId().equals(id))
			.findFirst().orElseThrow(NotFoundException::new);
	}
}
