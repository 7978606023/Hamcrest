package com.ip.test;

import com.ip.entities.SearchRequest;
import com.ip.pluralsight.FlightSearchService;
import static com.ip.pluralsight.FlightSearchService.flightSearch;
import org.testng.Assert;
import org.testng.annotations.Test;


class FlightSearchServiceNullAndEmptyStringTest {

    private static final FlightSearchService searchService = flightSearch();
    private static final String validFromDest = "Boston";
    private static final String validToDest = "Washington";
    private static final String date = "15/10/2019";
    private static final String validPassengerNum = "2";

    private static final String ERROR_MSG = "Expected to throw because null or empty string is not allowed, but it didn't";

    @Test
    void invalidDestinationFirstArgNotAllowed() {

        Assert.assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest(validPassengerNum, date, null, validToDest)));

        Assert.assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest(validPassengerNum, date, "", validToDest)));

        Assert.assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest(validPassengerNum, date, " ", validToDest)));
    }

    @Test
    void invalidDestinationSecondArgNotAllowed() {
    	 Assert.assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest(validPassengerNum, date, validFromDest, null)));

    	 Assert.assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest(validPassengerNum, date, validFromDest, "")));

    	 Assert.assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest(validPassengerNum, date, validFromDest, " ")));

    }

    @Test
    void invalidDateNotAllowed() {
    	 Assert.assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest(validPassengerNum, null, validFromDest, validToDest)));

    	 Assert.assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest(validPassengerNum, "", validFromDest, validToDest)));

    	 Assert.assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest(validPassengerNum, "1234", validFromDest, validToDest)));

    }


}
