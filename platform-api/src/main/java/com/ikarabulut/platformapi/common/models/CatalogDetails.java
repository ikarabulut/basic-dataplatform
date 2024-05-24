package com.ikarabulut.platformapi.common.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_registry")
public class CatalogDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String version;
    private String primaryContact;
    private String database;
    private String domain;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(String primaryContact) {
        this.primaryContact = primaryContact;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Long getId() {
        return id;
    }
}
