package de.exentra;

import jakarta.ws.rs.QueryParam;

public class Page
{
	@QueryParam("pageIndex")
	private Integer pageIndex;
	@QueryParam("pageSize")
	private Integer pageSize;

	public Integer getPageIndex()
	{
		return pageIndex;
	}

	public Integer getPageSize()
	{
		return pageSize;
	}

	public void setPageIndex(Integer pageIndex)
	{
		this.pageIndex = pageIndex;
	}

	public void setPageSize(Integer pageSize)
	{
		this.pageSize = pageSize;
	}
}
