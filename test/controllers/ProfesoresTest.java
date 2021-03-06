package controllers;

import static play.test.Helpers.GET;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.fakeRequest;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.route;
import static play.test.Helpers.running;
import static org.junit.Assert.*;

import org.junit.Test;

import play.mvc.Http.RequestBuilder;
import play.mvc.Result;

public class ProfesoresTest 
{
	@Test
    public void indexProfesoresJson()
    {
		running(fakeApplication(inMemoryDatabase()), () ->
		{
	    	Result result = route(fakeRequest(GET, "/profesores/0"));
	    		
	    	assertNotNull(result);
	    	assertEquals("application/json", result.contentType());
		});
    }

    @Test
    public void indexProfesoresWithApplicationXml()
    {
		running(fakeApplication(inMemoryDatabase()), () ->
		{
			RequestBuilder request = fakeRequest(GET, "/profesores/0").header("Accept", "application/xml");
	    	Result result = route(request);
	    	assertNotNull(result);
	   		assertEquals("application/xml", result.contentType());
		});
    }

    @Test
    public void indexProfesoresWithTextXml()
    {
		running(fakeApplication(inMemoryDatabase()), () ->
		{
			RequestBuilder request = fakeRequest(GET, "/profesores/0").header("Accept", "text/xml");
	    	Result result = route(request);
	    	assertNotNull(result);
	   		assertEquals("application/xml", result.contentType());
		});
    }

}
