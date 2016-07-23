package com.kbhit.orangebox.storage.domain.model;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

@Embeddable
public class ItemId implements Serializable {

    @SequenceGenerator(name="ITEM_ID", sequenceName="SEQ_ITEM_ID")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="ITEM_ID")
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemId itemId = (ItemId) o;

        return id != null ? id.equals(itemId.id) : itemId.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
