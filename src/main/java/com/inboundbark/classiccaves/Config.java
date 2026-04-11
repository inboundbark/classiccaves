package com.inboundbark.classiccaves;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static boolean higherCaveFrequency = true;
    public static boolean higherMineshaftChance = true;
    public static boolean oldRavineShape = true;
    public static boolean lowerDungeonSpawnLimit = true;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        higherCaveFrequency = configuration.getBoolean(
            "higherCaveFrequency",
            Configuration.CATEGORY_GENERAL,
            higherCaveFrequency,
            "Revert to pre-1.7.2 cave frequency.");

        higherMineshaftChance = configuration.getBoolean(
            "higherMineshaftChance",
            Configuration.CATEGORY_GENERAL,
            higherMineshaftChance,
            "Revert mineshaft frequency to how it was between b1.8-pre2 and 1.6.4.");

        oldRavineShape = configuration.getBoolean(
            "lowerRavineSpawnLimit",
            Configuration.CATEGORY_GENERAL,
            oldRavineShape,
            "Revert the shape of ravines so that they spawn exactly as they did in 1.6.4. Does not affect their frequency.");

        lowerDungeonSpawnLimit = configuration.getBoolean(
            "lowerDungeonSpawnLimit",
            Configuration.CATEGORY_GENERAL,
            lowerDungeonSpawnLimit,
            "Revert dungeon to spawn only under y = 128 instead of 256. Dungeons effectively become more common.");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
