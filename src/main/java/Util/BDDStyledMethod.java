package Util;

import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

public class BDDStyledMethod {

    public static void SimpleGETPost(int user_id) {
        given().contentType( ContentType.JSON ).
                when().get( String.format( "https://reqres.in/api/users/%s", user_id ) )
                .then()
                .body( "data.first_name", is( "George" ) )
                .body( "data.last_name", is( "Bluth" ) )
                .body( "data.avatar", is( "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg" ) )
                .body( "data.id", is( user_id ) )
                .body( "data.email", is( "george.bluth@reqres.in" ) )
                .assertThat().statusCode( 200 );
    }

    public static void VerifyUserDetailsOnGivenPage(int page, String user_name) {

        String responseString = when().get( String.format( "https://reqres.in/api/users?page=%s", page ) )
                .then()
                .extract()
                .asString();
        Assert.assertFalse( responseString.isEmpty() );

    }

    public static void VerifyPageIsNotEmpty(int page) {
        String responseString = when().get( String.format( "https://reqres.in/api/users?page=%s", page ) )
                .then()
                .extract()
                .asString();
        Assert.assertFalse( responseString.isEmpty() );
    }

    public static void VerifyStatusCodeForGivenRequest(int status_code, int page) {
        when().get( String.format( "https://reqres.in/api/users?page=%s", page ) )
                .then()
                .assertThat().statusCode( status_code );
    }

    public static void VerifyStatusCodeForGivenUserId(int status_code, int user_id) {
        when().get( String.format( "https://reqres.in/api/users/%s", user_id ) )
                .then()
                .assertThat().statusCode( status_code );
    }

    public static void PerformPathParameter(int user) {
        given().contentType( ContentType.JSON ).
                with()
                .pathParams( "users", user )
                .when()
                .get( "https://reqres.in/api/users/{users}" )
                .then()
                .body( "data.first_name", is( "Janet" ) );
    }

    public static void PerformQueryParameter(int user) {
        given().contentType( ContentType.JSON ).
                with()
                .queryParam( "id", user )
                .when()
                .get( "https://reqres.in/api/users/2" )
                .then()
                .assertThat()
                .body( "data.first_name", is( "Janet" ) );
    }

    public static void PerformPOSTwihtBodyParameter(int status_code, int id, String firstName, String lastName) {
        HashMap<String, String> postContent = new HashMap<>();
        postContent.put( "id", String.valueOf( id ) );
        postContent.put( "first_name", firstName );
        postContent.put( "last_name", lastName );

        given()
                .contentType( ContentType.JSON )
                .with()
                .body( postContent )
                .when()
                .post( "https://reqres.in/api/users" )
                .then()
                .assertThat().body( "first_name", is( firstName ) )
                .assertThat().body( "last_name", is( lastName ) )
                .assertThat().statusCode( status_code );
    }

    public static void PerformDeleteOperation(int id) {

        given().contentType( ContentType.JSON ).
                with()
                .pathParams( "users", id )
                .when()
                .delete( "https://reqres.in/api/users/{users}" );
    }

    public static void VerifyResponseCodeIfThereIsNothingToDelete(int status_code, int id) {

        given().contentType( ContentType.JSON ).
                with()
                .pathParams( "users", id )
                .when()
                .delete( "https://reqres.in/api/users/{users}" )
                .then()
                .assertThat().statusCode( status_code );// If record does not exist and there is nothing to delete then it will return status code 204
    }

    public static void PerformGETforUser(String user) {

        given().contentType( ContentType.JSON ).
                with()
                .queryParam( "id", user )
                .when()
                .get( "https://reqres.in/api/users/2" )
                .then()
                .assertThat()
                .body( "data.first_name", is( "Janet" ) );
    }
}
