package me.shawnrc.winston;

import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * WinstonConfiguration.java -
 *
 * @author Shawn Chowdhury (shawn.rc0@gmail.com)
 * @version 1.0
 * @since 2016-10-13
 */
public class WinstonConfiguration extends Configuration {

    //@NotEmpty
    private String backendType;

}
