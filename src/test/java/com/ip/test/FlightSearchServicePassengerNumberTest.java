package com.ip.test;

import com.ip.entities.SearchRequest;
import com.ip.pluralsight.FlightSearchService;
import static com.ip.pluralsight.FlightSearchService.flightSearch;
import org.testng.Assert;
import org.testng.annotations.Test;


class FlightSearchServicePassengerNumberTest {

    private static final FlightSearchService searchService = flightSearch();
    private static final String validFromDest = "Boston";
    private static final String validToDest = "Washington";
    private static final String date = "15-10-2019";

    @Test
    // no exception means passed test
    void onePassengerIsAllowed() {
        searchService.search(new SearchRequest("1", date, validFromDest, validToDest ));
    }

    @Test
    // no exception means passed test
    void sevenPassengersAreAllowed() {
        searchService.search(new SearchRequest("7", date, validFromDest, validToDest ));
    }

    @Test
    void zeroPassengersNotAllowed() {
    	 Assert.assertThrows(() -> searchService.search(new SearchRequest("0", date, validFromDest, validToDest )));
    }

    @Test
    void eightPassengersNotAllowed() {
        Assert.assertThrows(() -> searchService.search(new SearchRequest("8", date, validFromDest, validToDest )));
    }


}
