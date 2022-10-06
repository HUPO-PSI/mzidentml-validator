package psidev.psi.pi.validator;

import java.util.List;
import org.apache.log4j.Logger;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import psidev.psi.pi.validator.objectrules.AObjectRule;

/**
 * Test for encoding an URL for querying the new OLS REST API.
 * @author Gerhard Mayer
 */
public class URLEncodingTest {

    /**
     * Constants.
     */
    private static final Logger LOGGER = Logger.getLogger(URLEncodingTest.class.getName());

    /**
     * Members.
     */
    private static RESTClient restClient;
    
    /**
     * Constructor.
     */
    public URLEncodingTest() {
        super();
    }
    
    /**
     * Time-intensive initializations executed ONCE before the start of all tests.
     */
    @Before
    public void setUpClass() {
        URLEncodingTest.restClient = new RESTClient();
    }
    
    /**
     * Clean-up executed ONCE after all tests have finished.
     */
    @After
    public void tearDownClass() {
        URLEncodingTest.restClient = null;
    }
    
    /**
     * Test for checking the URL encoding.
     */
    @Test
    public void testURLEncoding() {
        String olsAPIStr = AObjectRule.urlEncode("1001143");
        URLEncodingTest.LOGGER.debug("olsAPIStr: " + olsAPIStr);

        /*
        String response = restClient.callGET(olsAPIStr);
        URLEncodingTest.LOGGER.debug(response);
        */
    }
}
