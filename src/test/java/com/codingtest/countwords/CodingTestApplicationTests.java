package com.codingtest.countwords;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CodingTestApplicationTests {

	CodingTestApplication testapp = Mockito.mock(CodingTestApplication.class);
	
	@Value("#{'${words}'.split(',')}")
	private List<String> words;
	
	List<String> emptylist = new ArrayList<>();
//	List<String> properinput = Arrays.asList("Manideep","moon","Mcdonalds","match","Make","monkey");
	List<String> intlist = Arrays.asList("1","2","3","4");
	
	@Test
	void whenContextIsInitialized_thenInjectedListContainsExpectedValues() {
	    assertEquals(Arrays.asList("Manideep","moon","Mcdonalds","match","Make","monkey"), words);
	}
	
	@Test
    public void shouldPassIfListNotContainsData() throws Exception {
        assertEquals(testapp.CountWords(emptylist), emptylist);
    }
	
	@Test
    public void shouldPassIfWrongListPassed() throws Exception {
        assertEquals(testapp.CountWords(intlist), emptylist);
    }
	
	@Test
    public void shouldPassIfListContainsData() throws Exception {
        assertTrue(testapp.CountWords(words).size() > 0 );
    }

}
