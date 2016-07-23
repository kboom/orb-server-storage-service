package com.kbhit.orangebox.storage.domain.model;

import javax.persistence.*;

@Entity(name = "ITEM_PHOTOS")
public class ItemPhoto {

    @Id
    @SequenceGenerator(name="ITEM_PHOTO_ID", sequenceName="SEQ_ITEM_PHOTO_ID")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="ITEM_PHOTO_ID")
    private Long id;

    private String name;

    private String uri;

}
