package ru.foxit.grayfox.Lesson4;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main extends JavaPlugin{

    Logger log = Logger.getLogger("Minecraft"); // Получили логгер маинкрафта

    @Override
    public void onEnable() {
        // При включение сервера в методе onEnable мы будем регистрировать класс Handler
        //this.getServer().getPluginManager().registerEvents(new Handler(), this); //еще один способ зарегать Handler
        //Bukkit.getPluginManager().registerEvents(new Handler(),this); //this так надо, //new Handler(), ссылка на наш класс!
        Bukkit.getPluginManager().registerEvents(new Ender(),this); // Регистрируем класс ендер
        Bukkit.getPluginManager().registerEvents(new Handler(this),this);
        getLogger().info("Включен");
        getCommand("info").setExecutor((CommandExecutor) new Commands(this)); // Мы регистрируем команду инфо и
        getCommand("heal").setExecutor(new Heal(this)); //регистрируем команду heal
        craft(); // Вызываем пустой тип метода крафт
        // делаем ссылку на класс Commands
    }

    @Override
    public void onDisable(){
        getLogger().info("Выключен");
    }

    private void craft(){
        ItemStack item = new ItemStack(Material.EYE_OF_ENDER); // СОздаем вещь, которую мы хотим скрафтить.
        ItemMeta meta = item.getItemMeta(); //Получаем его метаданную
        meta.setDisplayName(ChatColor.GREEN + "Teleporter");
        List<String> lore = new ArrayList<String>(); // Нам нужно установить описание
        lore.add("Ender-teleport"); //И в наше описание добавляем то, что будет написано.
        meta.setLore(lore); // Устанавливаем наше описание.
        meta.addEnchant(Enchantment.DAMAGE_ALL, 3, true); // Установили данному предмету зачарование на дамаг.
        // 3 уровня.
        item.setItemMeta(meta);// Установить метаданные тому предмету, который мы собираемся крафтить.
        // Теперь вещь готова, надо теперь создать новый рецепт крафта.
// Создаем таблицу крафта
        ShapedRecipe s = new ShapedRecipe(item); // В скобках ту вещь, которую мы собираемся крафтить, то есть итем.
        s.shape(new String[] {"A A", " B ", "A A"}); // Создаем массив
        //A - жемчуг эндера "A"
        //B глаз эндера "B"
        //Пробел - пустая строка, пустой слот, в котором ничего не крафтиться. " "
        s.setIngredient('A', Material.ENDER_PEARL); // Установили под букву А - ендер перл.
        s.setIngredient('B', Material.EYE_OF_ENDER); // Установили под букву B - глаз ендера.
        Bukkit.getServer().addRecipe(s); //Регистрируем наш крафт!
    }
}
