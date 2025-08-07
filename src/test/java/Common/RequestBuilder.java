package Common;

import io.restassured.response.Response;

import static Common.BasePaths.*;
import static Common.ContentType.*;
import static Common.PayloadBuilder.*;
import static io.restassured.RestAssured.given;

public class RequestBuilder {

    public static Response getListOfAllBreedsResponse(){
        return given().
                when().
                get(DogsAPI_BaseUrl+"/list/all").
                then().
                log().
                all().
                extract().
                response();
    }

    public static Response confirmationOfCountries(){
        return given().
                when().
                get(ResCountriesUrl+"all?fields=name").
                then().
                log().
                all().
                extract().
                response();
    }

    public static Response validationOfSouthAfricanLanguage(){
        return given().
                when().
                get(ResCountriesUrl+"all?fields=name,languages").
                then().
                log().
                all().
                extract().
                response();
    }

    public static Response getListOfAllUsersResponse(){
        return given().
                when().
                get(ReqRes_BaseUrl+"/api/users?page=2").
                then().
                log().
                all().
                extract().
                response();
    }

    public static Response createNewUserResponse(){
        return given().
                when().
                body(createNewUserObject()).
                contentType(reqres_contentType).
                log().
                all().
                post(ReqRes_BaseUrl+"/api/users").
                then().
                log().
                all().
                extract().
                response();
    }

    public static Response updateUserResponse(){
        return given().
                when().
                body(updateUserObject()).
                contentType(reqres_contentType).
                log().
                all().
                put(ReqRes_BaseUrl+"/api/users/2").
                then().
                log().
                all().
                extract().
                response();
    }
}
