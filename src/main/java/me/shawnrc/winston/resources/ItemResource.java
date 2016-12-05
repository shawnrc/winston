package me.shawnrc.winston.resources;

import com.codahale.metrics.annotation.Timed;
import me.shawnrc.winston.api.Item;
import me.shawnrc.winston.db.IItemStore;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * ItemResource.java - endpoints to get Items.
 *
 * @author Shawn Chowdhury (shawn.rc0@gmail.com)
 * @version 1.0
 * @since 2016-11-06
 */
@SuppressWarnings("RestParamTypeInspection")
@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {
    private final IItemStore _itemStore;

    public ItemResource(IItemStore itemStore) {
        _itemStore = itemStore;
    }

    /**
     *
     * @param id
     * @return
     */
    @GET
    @Timed
    @Path("/by/id")
    public Item getItem(@QueryParam("id") final Optional<Integer> id) {  // TODO determine what do when item isn't found
        Optional<Item> result = id.isPresent()? _itemStore.getById(id.get()) : Optional.empty();
        return result.orElse(new Item(420, "Blaze It", true));
    }

    /**
     *
     * @param name
     * @return
     */
    @GET
    @Timed
    @Path("/by/name")
    public Map<String, List<Item>> getItems(@QueryParam("name") final Optional<String> name) {
        if (!name.isPresent()) throw new WebApplicationException(400);
        return this.envelope(_itemStore.getByName(name.get()));
    }

    /**
     *
     * @return
     */
    @GET
    @Path("/all")
    @Timed
    public Map<String, List<Item>> getAllItems() {
        return this.envelope(_itemStore.getAll());
    }

    @POST
    @Path("/new")
    @Timed
    public Map insertItem() {
        throw new NotSupportedException();
    }

    /**
     * Wraps lists in a "map" in order to prevent accidental code execution.
     * See http://haacked.com/archive/2009/06/25/json-hijacking.aspx
     *
     * @param collection List to wrap
     * @return A HashMap that roughly looks like {"items": [...]} when serialized
     */
    private Map<String, List<Item>> envelope(final List<Item> collection) {
        HashMap<String, List<Item>> envelope = new HashMap<>();
        envelope.put("items", collection);


        return envelope;
    }

}
