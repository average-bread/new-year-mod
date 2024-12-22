package cursedbread.nym;

import cursedbread.nym.BlockLogics.BlockLogicLeavesPineSnowy;
import cursedbread.nym.BlockLogics.BlockLogicSaplingPineSnowy;
import net.minecraft.client.render.block.model.BlockModelCrossedSquares;
import net.minecraft.client.render.block.model.BlockModelLadder;
import net.minecraft.client.render.block.model.BlockModelLeaves;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.core.block.*;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.material.MaterialColor;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.item.block.ItemBlockLadder;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;

import static cursedbread.nym.NYMMain.MOD_ID;

public class NYMBlocks {

	public static int blockId;

	public static BlockBuilder fullBlock = new BlockBuilder(MOD_ID)
		.setBlockModel(BlockModelStandard::new);

	public static BlockBuilder crossedBlock = new BlockBuilder(MOD_ID)
		.setBlockModel(BlockModelCrossedSquares::new);

	public static BlockBuilder flatBlock = new BlockBuilder(MOD_ID)
		.setBlockModel(BlockModelLadder::new);

	public static Block snowyPineLeaves;
	public static Block snowyPineSapling;
	public static Block garlandOne;
	public static Block presentBlack;

	private void initializeBlockDetails() {

	}

	public void initilizeBlocks() {
		snowyPineLeaves = fullBlock
			.setBlockModel(block -> new BlockModelLeaves<>(block, "nym:block/leaves_pine_snowy"))
			.setTextures("nym:block/leaves_pine_snowy")
			.build("pine.leaves.snowy", blockId++, BlockLogicLeavesPineSnowy::new)
			.withSound(BlockSounds.GRASS)
			.withHardness(0.2F)
			.withLightBlock(1)
			.withDisabledNeighborNotifyOnMetadataChange()
			.withTags(new Tag[]{BlockTags.SHEARS_DO_SILK_TOUCH, BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_HOE, BlockTags.MINEABLE_BY_SWORD, BlockTags.MINEABLE_BY_SHEARS});

		snowyPineSapling = crossedBlock
			.setTextures("nym:block/sapling_pine_snowy")
			.build("pine.sapling.snowy", blockId++, BlockLogicSaplingPineSnowy::new)
			.withSound(BlockSounds.GRASS)
			.withHardness(0.0F)
			.withDisabledNeighborNotifyOnMetadataChange()
			.withTags(new Tag[]{BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLANTABLE_IN_JAR});

		garlandOne = flatBlock
			.setTextures("nym:block/garland")
			.setLuminance(15)
			.build("garland", blockId++, BlockLogicLadder::new)
			.setBlockItem(ItemBlockLadder::new)
			.withSound(BlockSounds.GLASS)
			.withHardness(0.5F)
			.withDisabledNeighborNotifyOnMetadataChange()
			.withTags(new Tag[]{BlockTags.BROKEN_BY_FLUIDS});

//		presentBlack = fullBlock
//			.setSideTextures("nym:block/present_black-white_side")
//			.setTopBottomTextures("nym:block/present_black-white_top-bottom")
//			.build("present.black", blockId++, block -> new BlockLogicBasket(block, Material.stone))
//			.withSound(BlockSounds.WOOD)
//			.withHardness(0.2F)
//			.withLightBlock(1)
//			.withDisabledNeighborNotifyOnMetadataChange();

		initializeBlockDetails();
	}
}
