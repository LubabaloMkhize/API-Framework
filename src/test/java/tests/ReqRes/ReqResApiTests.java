package tests.ReqRes;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.*;
import static Common.RequestBuilder.*;
import static org.hamcrest.Matchers.*;

@Feature("Req Res")
@Story("User Tests")
@Test
public class ReqResApiTests {

    @Description("Displaying List of Users")
    @Severity(SeverityLevel.BLOCKER)
    public void getListOfUsersTest(){
        getListOfAllUsersResponse().
                then().
                assertThat().
                statusCode(SUCCESS_STATUS_CODE).
                body(containsString("data")).
                body("data.id[0]",equalTo(7)).
                body("data.first_name", hasItems("Tobias")).
                body("data.last_name",hasItem("Funke"));
    }
  @Description("Creation of new user")
  @Severity(SeverityLevel.MINOR)
    public void createNewUserTest(){
       createNewUserResponse().
               then().
               assertThat().
               statusCode(CREATE_STATUS_CODE).
               body("id",notNullValue()).
               body("name",containsString("Lubabalo")).
               body("job",containsString("Tester")).
               body("createdAt",notNullValue());
    }
    @Description("Updating user info")
    @Severity(SeverityLevel.CRITICAL)
    public void updateUserTest(){
        updateUserResponse().
                then().
                assertThat().
                statusCode(SUCCESS_STATUS_CODE).
                body("name",containsString("Lubabalo")).
                body("job",containsString("Tester")).
                body("updatedAt",notNullValue()).
                body("surname",containsString("Mkhize"));
    }
}
