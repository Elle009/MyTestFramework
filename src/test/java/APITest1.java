import api.Address1;
import api.BaseApiTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;


public class APITest1 extends BaseApiTest {
    String API_key = "0b96db29f63e534a6ad01512969cd309";
    Map<String, Object> reqBody = new HashMap<>();

    @BeforeEach
    public void setReqBody() {
        reqBody.put("apiKey", API_key);
        reqBody.put("modelName", "Address");
        reqBody.put("calledMethod", "getSettlements");

    }

    @Test
    public void checkThatSuccess() {
        given()
                .spec(requestSpecification)
                .contentType(ContentType.JSON)
                .body(reqBody)
                .when()
                .post()
                .then()
                .spec(responseSpecification)
                .assertThat()
                .body("success", equalTo(true));
    }

    @Test
    public void checkJsonSchema() {
        given()
                .spec(requestSpecification)
                .body(reqBody)
                .contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchema(new File(System.getProperty("user.dir") +
                        "\\src\\main\\resources\\validators\\np_ukraddresses_schema.json")));
    }

    @Test
    public void checkRegions() {
        given()
                .spec(requestSpecification)
                .body(reqBody)
                .contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .assertThat()
                .body("success", equalTo(true))
                .body("data[0].RegionsDescription", equalTo("Полтавський р-н"));
    }

    @Test
    public void checkRegionsWithPojoUsage() {

        List<Address1> addressList = given()
                .spec(requestSpecification)
                .body(reqBody)
                .contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .spec(responseSpecification)
                .extract()
                .body().jsonPath().getList("data[0].Description", Address1.class);

        System.out.println(addressList);
        addressList.forEach(x -> Assertions.assertTrue(x.getDescription().contains("Абазівка")));
    }
}
