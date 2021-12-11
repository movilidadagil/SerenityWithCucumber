package stepdefinitions;
import api.FavouriteAPI;
import api.VoteAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Steps;
import search.LookForInformation;
import search.WikipediaArticle;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.is;
import static io.restassured.RestAssured.baseURI;

public class ListAllFavouritestStepDefinitions {

    @Steps
    FavouriteAPI favouriteAPI;

    @Steps
    VoteAPI voteAPI;
    public String x_api_key="";

    @When("{actor} makes {string} request")
    public void makesRequest(Actor actor, String endpoint) {
        actor = Actor.named("Tester the automation tester")
                .whoCan(CallAnApi.at(favouriteAPI.invoke_my_webservice()));

        actor.attemptsTo(
                Get.resource(endpoint)
        );

    }

    @Then("{actor} should should see information about dog")
    public void tester_should_see_information_about_dog(Actor actor) {
        actor.should(
                seeThatResponse("all the favourites shoud be returned",
                        response -> response.statusCode(200)
                                .body("created_at",is("2021-11-24T21:52:29.000Z")))
        );
    }

    @When("{actor} makes votes request")
    public void testerMakesVotesRequest(Actor actor) {

        actor = Actor.named("Tester the automation tester")
                .whoCan(CallAnApi.at(voteAPI.invoke_my_webservice()));

        actor.attemptsTo(
                Get.resource("votes")
                        .with(request ->
                                request.header("x-api-key", x_api_key))
        );
    }


    @Given("x-api-key is already acquired.")
    public void xApiKeyIsAlreadyAcquired() {
        x_api_key ="8adf71fc-c27b-40ef-8662-19ab891129e3";
    }

    @Then("{actor} should see votes")
    public void testerShouldSeeVotes(Actor actor) {
        actor.should(
                seeThatResponse("all the votes shoud be returned",
                        response -> response.statusCode(200)
                                .body("id",is(52030)))
        );
    }
}

