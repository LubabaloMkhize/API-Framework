package tests.ResCountriesAPI;

import Common.ContentType;
import Common.RequestBuilder;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@Feature("ResCountries API")
@Story("ResCountries Tests")
@Test
public class ResCountriesApiTests {

    @Description("Scheme Validation")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void validateCountriesSchema() {
        RequestBuilder.confirmationOfCountries()
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/Countries-Schema.json")));

        System.out.println("✅ Schema validation passed.");
    }


    @Description("Displaying List of all countries")
    @Severity(SeverityLevel.BLOCKER)
    public void getTotalNumberOfCountriesTest() {
        RequestBuilder.confirmationOfCountries().
                then().
                contentType(ContentType.rescountries_contentType).
                assertThat().
                statusCode(Common.CommonTestData.SUCCESS_STATUS_CODE)
                .body("size()", equalTo(195));

    }

    @Description("Title: As the Minister of Education, I want to ensure that South African Zul Language is\n" +
            "included in the list of\n" +
            "South Africa's official\n" +
            "languages so that it is recognized and properly integrated into educational\n" +
            "curricula.")
    @Severity(SeverityLevel.BLOCKER)
    public void validateSASLTest() {
        RequestBuilder.validationOfSouthAfricanLanguage().
                then().
                contentType(ContentType.rescountries_contentType).
                assertThat().
                statusCode(Common.CommonTestData.SUCCESS_STATUS_CODE).
                //body("name.common", equalTo("South Africa")).
                //body("name.nativeName.zul.common", equalTo("Ningizimu Afrika")).
                //body("languages.zul", equalTo("Zulu"));
                body("find { it.name.common == 'South Africa' }.languages.sasl", org.hamcrest.Matchers.equalTo("South African Sign Language"));

    }



}
