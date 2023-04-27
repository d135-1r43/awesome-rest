package de.exentra;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@QuarkusTest
@TestHTTPEndpoint(TrainerResource.class)
public class TrainerResourceTests
{
	@Test
	public void shouldReturnAllTrainers()
	{
		when()
			.get()
			.then()
			.assertThat()
			.statusCode(200)
			.and()
			.body("$", hasSize(3))
			.and()
			.body("[0].name", is("Helmut"));
	}

	@Test
	public void shouldReturnASingleTrainer()
	{
		when()
			.get("1")
			.then()
			.assertThat()
			.statusCode(200)
			.and()
			.body("name", is("Helmut"));
	}

	@Test
	public void shouldReturnNotFound()
	{
		when()
			.get("69696969")
			.then()
			.assertThat()
			.statusCode(404);
	}

	@Test
	public void shouldReturnBadRequest()
	{
		when()
			.get("/      /")
			.then()
			.assertThat()
			.statusCode(400);
	}
}
