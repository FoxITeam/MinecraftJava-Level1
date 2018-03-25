package ru.foxit.grayfox.Lesson4;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    private Main plugin;

    public Commands(Main plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!sender.hasPermission("play.info")){
            sender.sendMessage(ChatColor.RED + "У вас нет прав на выполнение данной команды!");
            sender.sendMessage(ChatColor.RED + "Право, которое отсутствует: play.info");
            return true;
        }
        if(args.length == 0){
            sender.sendMessage("Команда прописывается вот так: /info <ник>");
            return false;
        }

        String name = args[0];
        Player p = Bukkit.getPlayer(name);
        if(p == null){
            sender.sendMessage(name + ChatColor.RED + " не в онлайне");
            return true;
        }

        sender.sendMessage(name + ": ");
        sender.sendMessage("IP: " + p.getAddress().getAddress());

        return true;
    }
}
