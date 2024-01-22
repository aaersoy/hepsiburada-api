package clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class RestAssuredClient {

  private final RequestSpecification requestSpecification = new RequestSpecBuilder()
      .log(LogDetail.ALL)
      .setContentType(ContentType.JSON)
      .setUrlEncodingEnabled(false)
      .build();

  public RestAssuredClient(String url) {
    requestSpecification.baseUri(url);
  }

  public Response get(String path) {
    return given(requestSpecification).when().get(path);
  }

  public Response post(String path, Object body) {
    return given(requestSpecification).when().body(body).post(path);
  }

  public Response put(String path, Object body) {
    return given(requestSpecification).when().body(body).put(path);
  }

  public Response delete(String path) {
    return given(requestSpecification).when().delete(path);
  }
}
