package me.shawnrc.winston.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Item.java - describes a piece of equipment.
 *
 * @author Shawn Chowdhury (shawn.rc0@gmail.com)
 * @version 1.0
 * @since 2016-10-13
 */
public class Item {
    private long id;
    private String name;
    private boolean checkedOut;

    public Item() {
        // I think Jackson has something to do with this
    }

    public Item(final long id, final String name, final boolean checkedOut) {
        this.id = id;
        this.name = name;
        this.checkedOut = checkedOut;  // TODO convert this to a db lookup
    }

    public Item(final String name, final boolean checkedOut) {
        this.name = name;
        this.checkedOut = checkedOut;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public boolean getCheckedOut() {
        return checkedOut;
    }
}
