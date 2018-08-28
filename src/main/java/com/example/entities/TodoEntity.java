package com.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table (name = "todo")
public class TodoEntity {


    @Column(name = "title")
    private String title;

    @Column(name = "descriprtion")
    private String description;


    @Id
    @NotNull
    @GeneratedValue
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
