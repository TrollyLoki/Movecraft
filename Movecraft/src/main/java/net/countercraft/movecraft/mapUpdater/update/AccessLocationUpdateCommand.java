package net.countercraft.movecraft.mapUpdater.update;

import net.countercraft.movecraft.Movecraft;
import net.countercraft.movecraft.MovecraftLocation;
import org.bukkit.World;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

public class AccessLocationUpdateCommand extends UpdateCommand {

    private final @NotNull InventoryView inventoryView;
    private final @NotNull World world;
    private final @NotNull MovecraftLocation location;

    public AccessLocationUpdateCommand(@NotNull InventoryView inventoryView, @NotNull World world, @NotNull MovecraftLocation location) {
        this.inventoryView = inventoryView;
        this.world = world;
        this.location = location;
    }

    @Override
    public void doUpdate() {
        Movecraft.getInstance().getAccessLocationUpdater().setAccessLocation(inventoryView, world, location);
    }

}
