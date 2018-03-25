package ru.foxit.grayfox.Lesson2;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public class Main extends JavaPlugin{

    Logger log = Logger.getLogger("Minecraft"); // Получили логгер маинкрафта

    @Override
    public void onEnable() {
        // При включение сервера в методе onEnable мы будем регистрировать класс Handler
        //this.getServer().getPluginManager().registerEvents(new Handler(), this); //еще один способ зарегать Handler
        //Bukkit.getPluginManager().registerEvents(new Handler(),this); //this так надо, //new Handler(), ссылка на наш класс!
        Bukkit.getPluginManager().registerEvents(new Handler(this),this);
        getLogger().info("Включен");
        getConfig();
    }

    @Override
    public void onDisable(){
        getLogger().info("Выключен");
    }
}
