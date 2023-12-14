package tests.DogApi;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.SUCCESS_STATUS_CODE;
import static Common.RequestBuilder.getListOfAllBreedsResponse;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

@Feature("Dog Api")
@Story("Dog Tests")
@Test
public class DogsApiTests {
    @Description("Displaying List of all breeds")
    @Severity(SeverityLevel.BLOCKER)
    public void getListOfBreedsTest(){
        getListOfAllBreedsResponse().
                then().
                assertThat().
                statusCode(SUCCESS_STATUS_CODE).
                body(containsString("affenpinscher")).
                body(containsString("african")).body("message.australian", hasItem("shepherd"));
    }
}
