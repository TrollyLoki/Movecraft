package net.countercraft.movecraft.util;

import net.countercraft.movecraft.MovecraftLocation;
import net.countercraft.movecraft.mapUpdater.update.AccessLocationUpdateCommand;
import net.countercraft.movecraft.util.hitboxes.HitBox;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Function;

public class AccessLocationUtils {

    public static @NotNull Optional<AccessLocationUpdateCommand> createUpdateCommand(
            @NotNull HumanEntity entity, @NotNull HitBox oldHitBox, @NotNull World oldWorld, @NotNull World newWorld,
            @NotNull Function<MovecraftLocation, MovecraftLocation> transformation
    ) {
        InventoryView openInventory = entity.getOpenInventory();
        Location inventoryLocation = openInventory.getTopInventory().getLocation();
        if (inventoryLocation == null || inventoryLocation.getWorld() != oldWorld)
            return Optional.empty();

        MovecraftLocation accessLocation = MathUtils.bukkit2MovecraftLoc(inventoryLocation);
        if (!oldHitBox.contains(accessLocation))
            return Optional.empty();

        return Optional.of(new AccessLocationUpdateCommand(openInventory, newWorld, transformation.apply(accessLocation)));
    }

}
