package de.exentra;

import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.lang.Math.max;
import static java.lang.Math.min;

@Path("/trainers")
public class TrainerResource
{
	private static final Logger LOG = LoggerFactory.getLogger(TrainerResource.class);

	@Inject
	PokemonTrainerService pokemonTrainerService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PokemonTrainer> all(@BeanParam Page page)
	{
		List<PokemonTrainer> allTrainers = pokemonTrainerService.getAllTrainers();
		if (page.isDefined())
		{
			LOG.info("Page {} with size {}", page.getPageIndex(), page.getPageSize());
			return Page.getPage(allTrainers, page);
		}
		else
		{
			return allTrainers;
		}
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
