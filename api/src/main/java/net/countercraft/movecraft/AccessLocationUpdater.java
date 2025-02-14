package net.countercraft.movecraft;

import org.bukkit.World;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

public abstract class AccessLocationUpdater {

    /**
     * Sets the location of the block from which an inventory view was accessed.
     * The player will be kicked out of the inventory if the related block is no longer present at this location.
     * Note that for some inventory views, this method will do nothing.
     *
     * @param inventoryView inventory view
     * @param world new world of the access block
     * @param location new position of the access block
     * @return boolean indicating if the access location was updated
     */
    public abstract boolean setAccessLocation(@NotNull InventoryView inventoryView, @NotNull World world, @NotNull MovecraftLocation location);

    public static class IDummy extends AccessLocationUpdater {
        @Override
        public boolean setAccessLocation(@NotNull InventoryView inventoryView, @NotNull World world, @NotNull MovecraftLocation location) {
            return false; // no-op implementation
        }
    }

}
