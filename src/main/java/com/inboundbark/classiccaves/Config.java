package com.inboundbark.classiccaves;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static boolean enabled = true;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        enabled = configuration
            .getBoolean("enableClassicCaves", Configuration.CATEGORY_GENERAL, enabled, "enable pre r1.7 caves?");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
