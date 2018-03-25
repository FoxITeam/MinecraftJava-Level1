package ru.foxit.grayfox.Lesson3;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
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
        getCommand("info").setExecutor((CommandExecutor) new Commands(this)); // Мы регистрируем команду инфо и
        getCommand("heal").setExecutor(new Heal(this)); //регистрируем команду heal
        // делаем ссылку на класс Commands
    }

    @Override
    public void onDisable(){
        getLogger().info("Выключен");
    }
}
