package com.example.service;

import com.example.adaptor.PersonAdaptor;
import com.example.gen.*;
import com.example.model.Person;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * Created by akila on 12/11/16.
 */
public class PersonServiceClient extends WebServiceGatewaySupport {

    public AddPersonResponse addPerson(Person person) {
        AddPersonRequest request = new AddPersonRequest();
        request.setPerson(PersonAdaptor.getGeneratedPerson(person));

        AddPersonResponse response = (AddPersonResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://localhost:8080/ws/person",//soap url
                        request,
                        new SoapActionCallback("http://localhost:8888/person-service"));//targetNamespace

        return response;
    }

    public GetPersonResponse getPerson(int id) {
        GetPersonRequest request = new GetPersonRequest();
        request.setId(id);

        GetPersonResponse response = (GetPersonResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://localhost:8080/ws/person",//soap url
                        request,
                        new SoapActionCallback("http://localhost:8888/person-service"));//targetNamespace

        return response;
    }

    public GetAllPersonResponse getAllPerson() {
        GetAllPersonRequest request = new GetAllPersonRequest();

        GetAllPersonResponse response = (GetAllPersonResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://localhost:8080/ws/person",//soap url
                        request,
                        new SoapActionCallback("http://localhost:8888/person-service"));//targetNamespace

        return response;
    }

    public DeletePersonResponse deletePerson(int id) {
        DeletePersonRequest request = new DeletePersonRequest();
        request.setId(id);

        DeletePersonResponse response = (DeletePersonResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://localhost:8080/ws/person",//soap url
                        request,
                        new SoapActionCallback("http://localhost:8888/person-service"));//targetNamespace

        return response;
    }

}
