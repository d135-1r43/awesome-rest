package de.exentra;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.hamcrest.collection.IsCollectionWithSize;
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
			.body("$", hasSize(3))
			.and()
			.body("[0].name", is("Helmut"));
	}
}
