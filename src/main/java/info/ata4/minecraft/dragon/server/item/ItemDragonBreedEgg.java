/*
** 2016 March 10
**
** The author disclaims copyright to this source code. In place of
** a legal notice, here is a blessing:
**    May you do good and not evil.
**    May you find forgiveness for yourself and forgive others.
**    May you share freely, never taking more than you give.
 */
package info.ata4.minecraft.dragon.server.item;

import info.ata4.minecraft.dragon.server.entity.breeds.EnumDragonBreed;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

/**
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class ItemDragonBreedEgg extends ItemBlock {
    
    public ItemDragonBreedEgg(Block block) {
        super(block);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int metadata) {
        return metadata;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        EnumDragonBreed type = EnumDragonBreed.META_MAPPING.inverse().get(stack.getMetadata());
        String breedName = StatCollector.translateToLocal("entity.DragonMounts.DragonMount." + type.getName() + ".name");
        return StatCollector.translateToLocalFormatted("item.dragonEgg.name", breedName);
    }
}
