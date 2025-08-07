package tests.ResCountriesAPI;

import Common.ContentType;
import Common.RequestBuilder;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Feature("ResCountries API")
@Story("ResCountries Tests")
@Test
public class ResCountriesApiTests {
    @Description("Displaying List of all countries")
    @Severity(SeverityLevel.BLOCKER)
    public void getTotalNumberOfCountriesTest() {
        RequestBuilder.confirmationOfCountries().
                then().
                contentType(ContentType.rescountries_contentType).
                assertThat().
                statusCode(Common.CommonTestData.SUCCESS_STATUS_CODE)
                .body("size()", org.hamcrest.Matchers.equalTo(250));

    }

    @Description("Title: As the Minister of Education, I want to ensure that South African Sign Language (SASL) is\n" +
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
                statusCode(Common.CommonTestData.SUCCESS_STATUS_CODE)
                .body("name", org.hamcrest.Matchers.hasItem("South Africa"))
                .body("languages.name", org.hamcrest.Matchers.hasItem("SASL"));

    }

}
