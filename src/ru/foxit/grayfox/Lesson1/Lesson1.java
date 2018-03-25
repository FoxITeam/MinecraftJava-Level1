package ru.foxit.grayfox.Lesson1;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public class Lesson1 extends JavaPlugin{
//
    Logger log = Logger.getLogger("Minecraft"); // Получили логгер маинкрафта

    @Override
    public void onEnable() {
        getLogger().info("Включен");
        log.info("[Play] Информация" + " и еще какая то информация");
        log.warning("[Play] Внимание внимание");
        log.severe("[Play] Что то не так с плагином Play, ошибка!");
    }

    @Override
    public void onDisable(){
        getLogger().info("Выключен");
        log.info("[Play] Информация" + " и еще какая то информация");
        log.warning("[Play] Внимание внимание");
        log.severe("[Play] Что то не так с плагином Play, ошибка!");
    }
}