package choonster.testmod3.block;

import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.item.ItemStack;

/**
 * A sapling that uses Forge's blockstates format to specify its item models.
 * <p>
 * Test for this thread:
 * http://www.minecraftforge.net/forum/index.php?topic=43598.0
 *
 * @author Choonster
 */
public class BlockSaplingTestMod3 extends BlockSapling {
	/**
	 * A dummy property to allow for separate item models.
	 */
	public static final IProperty<Boolean> ITEM = PropertyBool.create("item");

	public BlockSaplingTestMod3() {
		BlockTestMod3.setBlockName(this, "sapling");
		setHardness(0);
		setSoundType(SoundType.PLANT);
		setDefaultState(getDefaultState().withProperty(ITEM, false));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer.Builder(this).add(TYPE, STAGE, ITEM).build();
	}

	/**
	 * Get the unlocalised name suffix for the specified {@link ItemStack}.
	 *
	 * @param stack The ItemStack
	 * @return The unlocalised name suffix
	 */
	public static String getName(ItemStack stack) {
		final int metadata = stack.getMetadata();

		return BlockPlanks.EnumType.byMetadata(metadata).getUnlocalizedName();
	}
}
