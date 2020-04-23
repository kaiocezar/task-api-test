package br.com.kaio.test;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ApiTest {

	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "http://localhost:8080/tasks-backend/";
	}

	@Test
	public void deveSalvarTarefa() {
		RestAssured.given().body("{\"task\":\"teste\",\"dueDate\":\"2020-10-10\"}").contentType(ContentType.JSON).when()
				.post("/todo").then().statusCode(201);
	}

	@Test
	public void deveRetornarAsTarefas() {
		RestAssured.given().when().get("/todo").then().statusCode(200);
	}

}
