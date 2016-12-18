package tk.brutalmaster9854.core.placeholders;

import org.bukkit.entity.Player;

public interface PlaceHolderHook {

    String[] getIdentifiers();

    String hook(Player player, String string);
}
