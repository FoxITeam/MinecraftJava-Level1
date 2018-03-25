package ru.foxit.grayfox.Lesson4;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

//Этот класс зарегистрирован как слушатель событий
public class Handler implements Listener { // Делаем класс Handler слушателем интерфейса Listener
    private int maxNumber = 10;
    ItemStack item = new ItemStack(Material.ANVIL); //Создаем нашу вешь, которую мы положим в инвентарь = Наковальня!

    private Main plugin; // У нас есть переменная плагин, которая имеет тип plugin.

    // конструктор
    public Handler(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void join(PlayerJoinEvent player) throws InterruptedException { // Создаем метод join и передаем в него PlayerJoinEvent с именем player
        Player pFox = player.getPlayer(); // Создаем игрока под именем pFox = получаем игрока.
        for (int number = 1; number <= maxNumber; number++) {
            pFox.sendMessage(ChatColor.YELLOW + "[Play] Во, ты зашел на сервер, а я написал плагин! #" + number); //Передали игроку сообщение
            pFox.getInventory().addItem(item); // getInventory получаем его инвентарь, в него .addItem(item) добавляем итем
        }
        plugin.getConfig();
        //sleep(30000); //Не используй слип, будет спать весь сервер, весь основной поток, дурень! Даже в цикле нельзя!
        //pFox.kickPlayer("А теперь пошел вон отсюдава!"); //Кик игрока
    }

    @EventHandler
    public void blockBreak(BlockBreakEvent breakPlayer) {
        Player pFox = breakPlayer.getPlayer(); // Создаем игрока под именем pFox = получаем игрока.
        Block block = breakPlayer.getBlock(); // Создали блок под именем block = получили блок.

        pFox.sendMessage(ChatColor.YELLOW + "[Play] " + ChatColor.RED + "Блок сломан на координатах: " + block.getX() + " " + block.getY() + " " + block.getZ());
    }

    @EventHandler
    public void blockPlace(BlockPlaceEvent placePlayer) {
        Player pFox = placePlayer.getPlayer(); // Создаем игрока под именем pFox = получаем игрока.
        Block block = placePlayer.getBlock(); // Создали блок под именем block = получили блок.

        pFox.sendMessage(ChatColor.YELLOW + "[Play] " + ChatColor.RED + "Блок поставлен на координатах: " + block.getX() + " " + block.getY() + " " + block.getZ());
    }

    @EventHandler
    public void blockInteract(PlayerInteractEvent interactPlayer) {
        int maxNum = 1;
        int numB = 0;
        int numC = 0;
        Action action = interactPlayer.getAction(); // Создаем/вызываем действия игрока
        Player player = interactPlayer.getPlayer(); // Вызываем плеера
        ItemStack item = player.getItemInHand(); // Для определение, что в руке есть.
//
//        if (action == Action.RIGHT_CLICK_BLOCK) {
//            player.sendMessage("Ты кликнул Правой клавишей мыши по блоку!");
//        }
//        if (action == Action.LEFT_CLICK_BLOCK) {
//            player.sendMessage("Ты кликнул Левой клавишей мыши по блоку!");
//        }

        // Если в руке пусто и кликаю по блоку правой клавишей мыши - сообщение игроку.
        // && - это "и" как в bash ты повторяешь команды apt-get update && apt get upgrade && apt-get install htop
        // Выполнить и обновление и абгрейд и установку htop в одной команде.
        if (item.getType() == Material.AIR && action == Action.RIGHT_CLICK_BLOCK) //Если тип предмета у нас воздух, то
        {
            player.sendMessage(ChatColor.YELLOW + "[Play] " + ChatColor.DARK_AQUA + "Ты кликнул пустой рукой Правой клавишей мыши по блоку!");
        }

        // Если в руке пусто и кликаю по блоку левой клавишей мыши - сообщение игроку.
        if (item.getType() == Material.AIR && action == Action.LEFT_CLICK_BLOCK) //Если тип предмета у нас воздух, то
        {
            player.sendMessage(ChatColor.YELLOW + "[Play] " + ChatColor.DARK_AQUA + "Ты кликнул пустой рукой Левой клавишей мыши по блоку!");
        }

        if (item.getType() == Material.STONE && action == Action.RIGHT_CLICK_BLOCK) //Если тип предмета у нас камень, то
        {
            player.sendMessage(ChatColor.YELLOW + "[Play] " + ChatColor.GREEN + "Ты кликнул (КАМНЕМ) Правой клавишей мыши по блоку!");
        }

        if (item.getType() == Material.STONE && action == Action.LEFT_CLICK_BLOCK) //Если тип предмета у нас камень, то
        {
            player.sendMessage(ChatColor.YELLOW + "[Play] " + ChatColor.GREEN + "Ты кликнул (КАМНЕМ) Левой клавишей мыши по блоку!");
            //interactPlayer.setCancelled(true); //Отмена действия, так можно отменить действие при выполнении или не
            // выполнении условия
        }
    }

    // дз - реализовать метод, который делает следующее:
    // Если у игрока любой предмет в руке и он кликает правой клавишей мыши по сундуку, предмет забирают с инвентаря
    // и он появляется в сундуке.
//    public void events(PlayerInteractEvent event) {
//        Action action = event.getAction(); // Создаем/вызываем действия игрока
//        Player player = event.getPlayer(); // Вызываем плеера
//        ItemStack item = player.getItemInHand(); // Для определение, что в руке есть.
//
//        if (action == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType() == Material.CHEST) {
//            item.setAmount(item.getAmount() - 1);//Уменьшаем его кол-во на один.
//            player.setItemInHand(item);
//            player.sendMessage("Доделай меня");
//        }
//
//    }
}
