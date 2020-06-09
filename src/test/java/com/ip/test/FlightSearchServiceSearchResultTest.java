package com.ip.test;

import com.ip.entities.Flight;
import com.ip.entities.SearchRequest;
import com.ip.pluralsight.FlightSearchService;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Set;
import static com.ip.pluralsight.FlightSearchService.flightSearch;
import static com.ip.pluralsight.FlightDateUtils.parseInputDate;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class FlightSearchServiceSearchResultTest {

    private final FlightSearchService searchService = flightSearch();


    private static final String validFromDest = "Boston";
    private static final String validToDest = "New York";
    private static final String date = "15-10-2019";
    private static final String validPassengerNum = "2";

    @Test
    void searchFindsValidFlights() {

        List<Flight> flightsList = searchService.search(
                new SearchRequest(validPassengerNum, date, validFromDest, validToDest ));

        // TestNG way
        Assert.assertEquals(2, flightsList.size());

        // Hamcrest way
        Assert.assertEquals(flightsList.size(), equalTo(2)); // v1 good
        assertThat(flightsList, hasSize(2)); // v2 - better, for collections
    }

    @Test
    void searchFindsValidFlightsWithCorrectDestinations() {

        List<Flight> flights = searchService.search(
                new SearchRequest(validPassengerNum, date, validFromDest, validToDest ));

        // 2 flights, both From Boston
        List<String> destinations = flights.stream().map(Flight::getFromDest).collect(toList());

        // TestNG way
        Assert.assertEquals("Boston", flights.get(0).getFromDest());
        Assert.assertEquals("Boston", flights.get(1).getFromDest());
        // more code if you have 3+ items

        // Hamcrest way
        assertThat(destinations, everyItem(equalTo("Boston")));
    }


  }
