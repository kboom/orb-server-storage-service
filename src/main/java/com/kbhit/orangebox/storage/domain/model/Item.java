package com.kbhit.orangebox.storage.domain.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "ITEMS")
public class Item {

    @EmbeddedId
    private ItemId itemId;

    @Column(length = 128)
    private String name;

    @Column(length = 500)
    private String description;



}
