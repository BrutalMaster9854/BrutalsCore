package tk.brutalmaster9854.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public abstract class BrutalCommand implements CommandExecutor, TabCompleter {

    public abstract boolean onCommand(CommandSender sender, Command cmd, String label, String[] args);

    public abstract List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings);

    public boolean isPlayer(CommandSender sender) {
        return (sender instanceof Player);
    }

    public boolean hasPermissions(Player player, String... perms) {
        for(String string : perms) {
            return player.hasPermission(string);
        }
        return false;
    }

    public boolean argsEquals(String arg, String value) {
        return arg.toLowerCase().equalsIgnoreCase(value);
    }
}
