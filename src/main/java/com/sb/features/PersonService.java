package com.sb.features;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class PersonService {
    private final RestClient restClient;

    public PersonService(RestClient restClient) {
        this.restClient = restClient;
    }

    public Person createPerson(Person person) {
        return restClient
                .post()
                .uri("/person")
                .body(person)
                .retrieve()
                .body(Person.class);
    }

    public Person getPerson(String id) {
        return restClient
                .get()
                .uri("/person/{id}", id)
                .retrieve()
                .body(Person.class);
    }

    public void updatePerson(String id, Person person) {
        restClient
                .put()
                .uri("/person/{id}", id)
                .body(person)
                .retrieve()
                .toBodilessEntity();
    }

    public void deletePerson(String id) {
        restClient
                .delete()
                .uri("/person/{id}", id)
                .retrieve()
                .toBodilessEntity();
    }

    public List<Person> listPerson() {
        return restClient
                .get()
                .uri("/person")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
