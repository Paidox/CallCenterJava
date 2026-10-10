package com.example.lr3_java_2.Beans;
import com.example.lr3_java_2.Entity.Client;
import com.example.lr3_java_2.Services.ClientService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("clientBean")
@ViewScoped
public class ClientBean implements Serializable {

  private List<Client> clients;
  private Client client = new Client();
  private String searchQuery;

  @Inject
  private ClientService clientService;

  @PostConstruct
  public void init() {
    this.clients = clientService.findAll();
  }

  public void delete(Client client) {
    clientService.delete(client.getId());
    this.clients.remove(client);
  }

  public void add() {
    clientService.addNewClient(client);
    this.clients = clientService.findAll();
    this.client = new Client();
  }

  public void update() {
    clientService.update(clients);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
  }

  public void search()
  {
    if (searchQuery == null || searchQuery.trim().isEmpty()) {
      this.clients = clientService.findAll();
    } else {
      this.clients = clientService.findClientsByName(searchQuery.trim());
    }
  }

  public String getSearchQuery() {
    return searchQuery;
  }

  public void setSearchQuery(String searchQuery) {
    this.searchQuery = searchQuery;
  }

  public List<Client> getClients() {
    return clients;
  }

  public void setClients(List<Client> clients) {
    this.clients = clients;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}
