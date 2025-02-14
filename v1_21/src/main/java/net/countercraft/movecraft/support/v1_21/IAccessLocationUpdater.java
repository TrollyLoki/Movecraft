package net.countercraft.movecraft.support.v1_21;

import net.countercraft.movecraft.AccessLocationUpdater;
import net.countercraft.movecraft.MovecraftLocation;
import net.countercraft.movecraft.util.UnsafeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import org.bukkit.World;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.inventory.CraftInventoryView;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

public class IAccessLocationUpdater extends AccessLocationUpdater {
    @Override
    public boolean setAccessLocation(@NotNull InventoryView inventoryView, @NotNull World world, @NotNull MovecraftLocation location) {
        ServerLevel level = ((CraftWorld) world).getHandle();
        BlockPos position = new BlockPos(location.getX(), location.getY(), location.getZ());
        ContainerLevelAccess access = ContainerLevelAccess.create(level, position);

        AbstractContainerMenu menu = ((CraftInventoryView<?,?>) inventoryView).getHandle();
        return UnsafeUtils.trySetFieldOfType(ContainerLevelAccess.class, menu, access);
    }
}
