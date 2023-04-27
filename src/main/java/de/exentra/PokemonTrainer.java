package de.exentra;

import java.util.List;

public class PokemonTrainer
{
	private String id;
	private List<Badge> badges;
	private String name;

	public PokemonTrainer(String id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public List<Badge> getBadges()
	{
		return badges;
	}

	public void setBadges(List<Badge> badges)
	{
		this.badges = badges;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
