package me.shawnrc.winston.db;

import me.shawnrc.winston.api.Item;

import java.util.List;
import java.util.Optional;

/**
 * IItemStore.java - Describes the interface any storage backend classes should have.
 *
 * @author Shawn Chowdhury (shawn.rc0@gmail.com)
 * @version 1.0
 * @since 2016-10-13
 */
public interface IItemStore {

    /**
     * Searches for a piece of equipment using an ID.
     *
     * @param id The numeric ID of the equipment you're looking for.
     *
     * @return An Optional - either an Item instance or null if nothing was found.
     */
    Optional<Item> getById(final long id);

    /**
     * Searches for a piece of equipment by name.
     * Will return the first instance found.
     *
     * @param name The search string to use.
     *
     * @return An Optional - either an Item instance or null if nothing was found.
     */
    Optional<Item> getOneByName(final String name);

    /**
     * Searches for equipment by name.
     *
     * @param name The search string to use.
     *
     * @return A list of results found. The list will be empty if nothing was found.
     */
    List<Item> getByName(final String name);

    /**
     *
     * @return
     */
    List<Item> getAll();

    /**
     *
     * @param item
     */
    void insertItem(Item item);

}
