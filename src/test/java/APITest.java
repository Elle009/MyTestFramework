import api.Address;
import api.BaseApiTest;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;

public class APITest extends BaseApiTest {
    String API_key = "0b96db29f63e534a6ad01512969cd309";
    Map<String, Object> reqBody = new HashMap<>();

    @BeforeMethod
    public void setReqBody() {
        Map<String, String> methodProperties = new HashMap<>();
        methodProperties.put("CityName", "Київ");
        methodProperties.put("Limit", "5");

        reqBody.put("apiKey", API_key);
        reqBody.put("modelName", "Address");
        reqBody.put("calledMethod", "searchSettlements");
        reqBody.put("methodProperties", methodProperties);
    }

    public void setReqBody1() {
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
                        "\\src\\main\\resources\\validators\\np_address_schema.json")));
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
                .body("data[0].Addresses[0].Present", equalTo("м. Київ, Київська обл."))
                .body("data[0].TotalCount", equalTo(9));
    }

    @Test
    public void checkRegionsWithPojoUsage(){

        List<Address> addressList = given()
                .spec(requestSpecification)
                .body(reqBody)
                .contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .spec(responseSpecification)
                .extract()
                .body().jsonPath().getList("data[0].Addresses", Address.class);

        System.out.println(addressList);
        addressList.forEach(x -> Assert.assertTrue(x.getPresent().contains("Київ")));
    }
}
