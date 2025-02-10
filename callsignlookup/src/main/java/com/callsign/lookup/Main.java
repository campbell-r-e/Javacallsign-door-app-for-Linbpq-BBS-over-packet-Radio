package com.callsign.lookup;



import com.kevinhooke.hamqthclient.HamQTHClient;
import com.kevinhooke.hamqthclient.callsign.CallsignLookupResponse;
import com.kevinhooke.hamqthclient.callsign.CallsignLookupResult;

public class Main {
    public static void main(String[] args) {
        String username = "your_hamqth_username";
        String password = "your_hamqth_password";
        
        // Initialize HamQTH Client
        HamQTHClient client = new HamQTHClient();
        
        // Authenticate and get session key
        String sessionKey = client.authenticate(username, password);
        if (sessionKey == null) {
            System.out.println("Authentication failed.");
            return;
        }

        System.out.println("Successfully authenticated. Session key: " + sessionKey);

        // Look up a callsign (e.g., "KD9GEK")
        String callsign = "KD9GEK";
        CallsignLookupResponse response = client.lookupCallsign(sessionKey, callsign);

        if (response != null && response.getResult() != null) {
            CallsignLookupResult result = response.getResult();
            System.out.println("Callsign: " + result.getCallsign());
            System.out.println("Name: " + result.getName());
            System.out.println("QTH: " + result.getQth());
            System.out.println("Country: " + result.getCountry());
            System.out.println("Locator: " + result.getLocator());
        } else {
            System.out.println("Callsign lookup failed.");
        }
    
    }
}