package tk.brutalmaster9854.core.entity;

import org.bukkit.entity.Entity;
import org.bukkit.metadata.FixedMetadataValue;
import tk.brutalmaster9854.core.BrutalCore;

public class MetaDataManager {

    public boolean hasData(Entity entity, String data) {
        return entity.hasMetadata(data);
    }
    public void setData(Entity entity, String data) {
        entity.setMetadata(data, new FixedMetadataValue(BrutalCore.get(), Boolean.valueOf(true)));
    }
    public void removeData(Entity entity, String data) {
        entity.removeMetadata(data, BrutalCore.get());
    }
}
