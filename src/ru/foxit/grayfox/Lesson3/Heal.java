package ru.foxit.grayfox.Lesson3;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    private Main plugin;

    public Heal(Main plugin) {
        this.plugin = plugin;
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) { //Является ли наш отправитель команды хеал игроком?
            sender.sendMessage("Вы выполняете команду не от игрока!");
            return true;
        }
        Player p = (Player) sender; // Создаем объект!
        p.setHealth(20); // Восстанавливаем 10 сердец, 1 сердце - 2 единицы.
        p.sendMessage(ChatColor.GOLD + "Здоровье восстановлено!"); // Сообщение игроку после восстановки.
        return true;
    }
}
