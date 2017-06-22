package com.meplato.storedemo;

import com.meplato.store2.ApacheHttpClient;
import com.meplato.store2.Client;
import com.meplato.store2.ServiceException;
import com.meplato.store2.catalogs.Catalog;
import com.meplato.store2.catalogs.SearchResponse;
import com.meplato.store2.catalogs.Service;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        String token = System.getenv("STORE_TOKEN");
        if (args.length > 0) {
            token = args[0];
        }
        if (Objects.equals(token, "")) {
            System.err.println("Usage: storedemo <token>");
            System.exit(1);
        }

        // Client is the HTTP Client to use for making HTTP requests.
        // The package comes with a default implementation (ApacheHttpClient),
        // but feel free to create your own.
        Client client = new ApacheHttpClient();

        // Instantiate the Catalogs service and set your API token.
        Service service = new Service(client);
        service.setUser(token);

        // Create a search, execute it, and iterate through the results.
        try {
            SearchResponse response = service.search().skip(0).take(10).sort("-created,name").execute();
            System.out.format("You have %d catalog(s).\n", response.getTotalItems());
            for (Catalog catalog : response.getItems()) {
                System.out.format("Catalog with ID=%d has name %s.\n", catalog.getId(), catalog.getName());
            }
        } catch (ServiceException e) {
            System.err.format("API call failed with:\n%s\n", e.getMessage());
        }
    }
}
