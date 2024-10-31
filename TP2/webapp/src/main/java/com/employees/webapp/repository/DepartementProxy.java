package com.employees.webapp.repository;

import com.employees.webapp.CustomProperties;
import com.employees.webapp.model.Departement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class DepartementProxy {

    @Autowired
    private CustomProperties props;

    public  Iterable<Departement> getDepartements(){
        String baseApiUrl = props.getApi2URl();
        String getDepartementsUrl = baseApiUrl+"/departements";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Departement>> response =
                restTemplate.exchange(
                        getDepartementsUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Iterable<Departement>>() {
                        }
                );

        log.debug("Get Departements call " + response.getStatusCode().toString());
        return response.getBody();
    }

    public  Departement getDepartement(final Long id){
        String baseApiUrl = props.getApi2URl();
        String getDepartementUrl = baseApiUrl+"/departements/"+id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Departement> response =
                restTemplate.exchange(
                  getDepartementUrl,
                  HttpMethod.GET,
                  null,
                  Departement.class
                );
        log.debug("Get Departement call " + response.getStatusCode());
        return response.getBody();
    }

    public Departement saveDepartement(Departement departement){
        String baseApiUrl = props.getApi2URl();
        String saveDepartementsUrl = baseApiUrl+"/departements";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Departement> response =
                restTemplate.exchange(
                        saveDepartementsUrl,
                        HttpMethod.POST,
                        new HttpEntity<>(departement),
                        Departement.class

                );
        log.debug("Save Departement call " + response.getStatusCode());
        return  response.getBody();
    }

    public  Departement updateDepartement(Departement departement){
        String baseApiUrl = props.getApi2URl();
        String updateDepartementUrl =baseApiUrl +"/departements";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Departement> response =
                restTemplate.exchange(
                        updateDepartementUrl,
                        HttpMethod.PUT,
                        new HttpEntity<>(departement),
                        Departement.class
                );
        log.debug("Update Departement call " + response.getStatusCode());
        return response.getBody();
    }

    public void deleteDepartement(final Long id ){
        String baseApiUrl=props.getApiUrl();
        String deleteDepartementUrl = baseApiUrl + "/departements/"+id;

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(
                deleteDepartementUrl,
                HttpMethod.DELETE,
                null,
                Void.class
        );
        log.debug("Delete Departement Call");
    }

}
