package de.exentra;

import jakarta.ws.rs.QueryParam;

import java.util.Collections;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

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

	public boolean isDefined()
	{
		return (pageIndex != null) && (pageSize != null);
	}

	public static <T> List<T> getPage(List<T> list, Page page)
	{
		int from = page.getPageIndex() * page.getPageSize();
		int to = from + page.getPageSize();

		if (from > list.size())
		{
			return Collections.emptyList();
		}
		return list.subList(max(0, from), min(to, list.size()));
	}
}
