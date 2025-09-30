package net.rimaki.emotax;

/*
 * EmotaX Plugin v1.0.0
 * Copyright (c) 2025 Rimaki
 * Licensed under MIT License
 *
 * ⚠️ Content Responsibility Notice:
 * Users are responsible for any animations (emotes) they import.
 * The plugin author assumes no liability for user-generated content.
 */

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.ConfigSection;
import cn.nukkit.utils.TextFormat;

// Plugin Class

import java.io.File;
import java.util.LinkedHashMap;

public class EmotaXPlugin extends PluginBase {
    public static EmotaXPlugin INSTANCE;
    public String plver;
    public String plauthors;
    public String placeholdercmd;

    @Override
    public void onLoad() {
        INSTANCE = this;
        plver = this.getDescription().getVersion();
        plauthors = String.join(", ", this.getDescription().getAuthors());
        // String VERSION = INSTANCE.getDescription().getVersion();
        // Disabled For Now
        // I18N = PluginI18nManager.register(this);

        //Command Stuff
        this.getServer().getCommandMap().register("emotax", new EmotaXCommand());
        // this.getServer().getCommandMap().register("emotelist", new EmotaXCommand());

        this.getLogger().info(TextFormat.WHITE + "EmotaX Initalized Enabling Plugin..");
    }
    @Override
    public void onEnable() {
        Config config = new Config(
                new File(this.getDataFolder(), "config.yml"),
                Config.YAML,
                //Some Basic CFG Stuff
                new ConfigSection(new LinkedHashMap<>() {
                    {
                        put("Placeholder", "[EmotaX]");
                        put("global-emotelist", "false");
                    }
                })
        );
        config.save();
        placeholdercmd = config.getString("Placeholder", "[EmotaX]");
        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);
        this.getLogger().info(TextFormat.DARK_GREEN + "EmotaX Plugin Enabled Successfuly Yay!");
        this.getLogger().info(placeholdercmd + " You're Running EmotaX : " + plver + "\n Made by : " + plauthors);
    }
    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.DARK_RED + "EmotaX Disabled \n (I guess something Failed - Rimaki)");
    }
}
