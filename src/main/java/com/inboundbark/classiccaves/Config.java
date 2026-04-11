package com.inboundbark.classiccaves;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static boolean higherCaveFrequency = true;
    public static boolean higherMineshaftChance = true;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        higherCaveFrequency = configuration
            .getBoolean("higherCaveFrequency", Configuration.CATEGORY_GENERAL, higherCaveFrequency, "enable pre r1.7 cave frequency?");

        higherMineshaftChance = configuration
            .getBoolean("higherMineshaftChance", Configuration.CATEGORY_GENERAL, higherMineshaftChance, "enable pre r1.7 mineshaft frequency?");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
