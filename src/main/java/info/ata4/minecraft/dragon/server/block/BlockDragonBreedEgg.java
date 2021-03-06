/*
** 2016 March 09
**
** The author disclaims copyright to this source code. In place of
** a legal notice, here is a blessing:
**    May you do good and not evil.
**    May you find forgiveness for yourself and forgive others.
**    May you share freely, never taking more than you give.
 */
package info.ata4.minecraft.dragon.server.block;

import info.ata4.minecraft.dragon.server.entity.breeds.EnumDragonBreed;
import java.util.List;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class BlockDragonBreedEgg extends BlockFalling {
    
    public static final PropertyEnum<EnumDragonBreed> BREED = PropertyEnum.create("breed", EnumDragonBreed.class);
    public static final BlockDragonBreedEgg INSTANCE = new BlockDragonBreedEgg();
    
    private BlockDragonBreedEgg() {
        super(Material.dragonEgg);
        setUnlocalizedName("dragonEgg");
        setHardness(3);
        setResistance(15);
        setStepSound(soundTypePiston);
        setLightLevel(0.125f);
        setDefaultState(blockState.getBaseState().withProperty(BREED, EnumDragonBreed.DEFAULT));
        setCreativeTab(CreativeTabs.tabMisc);
        setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 1.0f, 0.9375f);
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return true;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[]{ BREED });
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(BREED,
            EnumDragonBreed.META_MAPPING.inverse().get(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        EnumDragonBreed type = (EnumDragonBreed) state.getValue(BREED);
        return EnumDragonBreed.META_MAPPING.get(type);
    }
    
    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
        EnumDragonBreed.META_MAPPING.values().forEach(index -> list.add(new ItemStack(itemIn, 1, index)));
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }
}
