package nl.naimverboom.turtlesurvival;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.meta.BlockDataMeta;

import java.util.List;

public class onChangeBlockEvent implements Listener {

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        EntityType entity = event.getEntityType();

        if(event.getEntityType() == EntityType.CREEPER) {
            List<Block> destroyed = event.blockList();
            event.setCancelled(true);
            for (Block destroyed_s : destroyed) {
                BlockData blockdata = destroyed_s.getBlockData();
                Location location = destroyed_s.getLocation();
                World world = location.getWorld();
                Block newBlock = world.getBlockAt(location);
                newBlock.setType(destroyed_s.getType());
                newBlock.setBlockData(blockdata);
                newBlock.getState().update();
            }

            World eventWorld = event.getEntity().getWorld();
            Location eventLocation = event.getEntity().getLocation();
            eventWorld.playSound(eventLocation, Sound.ENTITY_GENERIC_EXPLODE, SoundCategory.HOSTILE, 1, 1);
            eventWorld.spawnParticle(Particle.EXPLOSION_LARGE, eventLocation, 20, 1, 1, 1);
        }
    }

}
