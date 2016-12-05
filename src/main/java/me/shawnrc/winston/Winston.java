package me.shawnrc.winston;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import me.shawnrc.winston.db.DummyStore;
import me.shawnrc.winston.resources.ItemResource;

/**
 * Hello world!
 *
 */
public class Winston extends Application<WinstonConfiguration> {

    public static void main(final String[] args) throws Exception {
        new Winston().run(args);
    }

    @Override
    public String getName() {
        return "Winston";
    }

    public void initialize(final Bootstrap<WinstonConfiguration> bootstrap) {

    }

    public void run(
        final WinstonConfiguration winstonConfiguration,
        final Environment environment
    ) throws Exception {

        environment.jersey().register(new ItemResource(new DummyStore()));

    }
}
