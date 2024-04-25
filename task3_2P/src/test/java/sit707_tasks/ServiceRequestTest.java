package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

public class ServiceRequestTest {
	
    @Test
    public void testValidRequestSubmission() {
        // Input: Valid URL, valid reason, and supervisor/manager selected
        ServiceRequestPage requestPage = new ServiceRequestPage();
        boolean submissionResult = requestPage.submitRequest("https://colab.research.google.com/", "Research purposes", "John Doe");
        Assert.assertTrue(submissionResult);
    }

    @Test
    public void testEmptyURLField() {
        // Input: Empty URL field, valid reason, and supervisor/manager selected
        ServiceRequestPage requestPage = new ServiceRequestPage();
        boolean submissionResult = requestPage.submitRequest("", "Research purposes", "John Doe");
        Assert.assertFalse(submissionResult);
        // Assert validation error message is displayed for empty URL field
    }

    @Test
    public void testInvalidURLFormat() {
        // Input: Invalid URL format, valid reason, and supervisor/manager selected
        ServiceRequestPage requestPage = new ServiceRequestPage();
        boolean submissionResult = requestPage.submitRequest("example.com", "Research purposes", "John Doe");
        Assert.assertFalse(submissionResult);
        // Assert validation error message is displayed for invalid URL format
    }

    @Test
    public void testEmptyReasonField() {
        // Input: Valid URL, empty reason field, and supervisor/manager selected
        ServiceRequestPage requestPage = new ServiceRequestPage();
        boolean submissionResult = requestPage.submitRequest("https://colab.research.google.com/", "", "John Doe");
        Assert.assertFalse(submissionResult);
        // Assert validation error message is displayed for empty reason field
    }

    @Test
    public void testNoSupervisorSelected() {
        // Input: Valid URL, valid reason, but no supervisor/manager selected
        ServiceRequestPage requestPage = new ServiceRequestPage();
        boolean submissionResult = requestPage.submitRequest("https://colab.research.google.com/", "Research purposes", "");
        Assert.assertFalse(submissionResult);
        // Assert validation error message is displayed for no supervisor selected
    }

    @Test
    public void testInvalidURLScheme() {
        // Input: Invalid URL scheme, valid reason, and supervisor/manager selected
        ServiceRequestPage requestPage = new ServiceRequestPage();
        boolean submissionResult = requestPage.submitRequest("ftp://example.com", "Research purposes", "John Doe");
        Assert.assertFalse(submissionResult);
        // Assert validation error message is displayed for invalid URL scheme
    }

    @Test
    public void testLongReasonText() {
        // Input: Valid URL, long reason text (beyond maximum allowed length), and supervisor/manager selected
        ServiceRequestPage requestPage = new ServiceRequestPage();
        boolean submissionResult = requestPage.submitRequest("https://colab.research.google.com/", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "John Doe");
        Assert.assertFalse(submissionResult);
        // Assert validation error message is displayed for long reason text
    }

    @Test
    public void testValidURLOtherThanHTTP() {
        // Input: Valid URL with scheme other than HTTP/HTTPS, valid reason, and supervisor/manager selected
        ServiceRequestPage requestPage = new ServiceRequestPage();
        boolean submissionResult = requestPage.submitRequest("ftp://example.com", "Research purposes", "John Doe");
        Assert.assertFalse(submissionResult);
        // Assert validation error message is displayed for URL with non-HTTP/HTTPS scheme
    }
}
