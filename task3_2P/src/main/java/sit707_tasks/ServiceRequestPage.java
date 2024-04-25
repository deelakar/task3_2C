package sit707_tasks;

import java.net.MalformedURLException;
import java.net.URL;

public class ServiceRequestPage {

    public boolean submitRequest(String url, String reason, String supervisor) {
        if (isValidUrl(url) && isValidReason(reason) && isValidSupervisor(supervisor)) {
            System.out.println("Request submitted successfully!");
            return true;
        } else {
            System.out.println("Failed to submit request. Please check your inputs.");
            return false;
        }
    }

    private boolean isValidUrl(String url) {
        if (url == null || url.isEmpty()) {
            return false;
        }
        try {
            // Check if the URL is well-formed
            new URL(url);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    private boolean isValidReason(String reason) {
        // Validate reason field length or any other specific criteria
        return reason != null && !reason.isEmpty() && reason.length() <= 1000; // Example: Max length of 1000 characters
    }

    private boolean isValidSupervisor(String supervisor) {
        // Validate if a supervisor is selected
        return supervisor != null && !supervisor.isEmpty();
    }
}
