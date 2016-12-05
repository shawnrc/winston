package me.shawnrc.winston.db;

import me.shawnrc.winston.api.Item;

import javax.ws.rs.NotSupportedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * DummyStore.java - stores instances of me.
 *
 * @author Shawn Chowdhury (shawn.rc0@gmail.com)
 * @version 1.0
 * @since 2016-11-19
 */
public class DummyStore implements IItemStore {

    private HashMap<Long, Item> dumbStore = new HashMap<>();
    private AtomicLong idCounter;

    /**
     * Please don't use this for anything at all but testing.
     */
    public DummyStore() {
        String[] items = {
            "Oculus Rift DK2",
            "Microsoft Hololens Development Kit",
            "Leap Motion",
            "Microsoft Kinect",
            "Microsoft Xbox One",
            "Samsung Gear Live",
            "Raspberry Pi B+",
            "Arduino Uno-alike",
            "Tobii Eye Tracker",
            "Amazon Echo",
            "Amazon IoT Dash Button",
            "Makerbot Replicator II",
            "3Doodler",
            "3Doodler v2",
            "12V Battery (L)",
            "DeWalt Hammerdrill",
        };

        long i = 0; for (; i < items.length; ++i) {
            dumbStore.put(i, new Item(i, items[(int)i], false));
        }

        dumbStore.put(i, new Item(i, "Apple iPhone 5C 16GB", true));
        idCounter = new AtomicLong(i);
    }

    @Override
    public Optional<Item> getById(final long id) {
        Item result = this.dumbStore.get(id);  // strictly speaking, this should *never* be null and valid at the same time
        return Optional.ofNullable(result);
    }

    @Override
    public Optional<Item> getOneByName(final String name) {
        return null;
    }

    @Override
    public List<Item> getByName(final String name) {
        return this.dumbStore.values()
            .stream()
            .filter(item -> item.getName().contains(name))
            .collect(Collectors.toList());
    }

    @Override
    public List<Item> getAll() {
        return new ArrayList<>(this.dumbStore.values());
    }

    @Override
    public void insertItem(Item item) {
        item.setId(idCounter.incrementAndGet());
        dumbStore.put(idCounter.get(), item);
    }
}
