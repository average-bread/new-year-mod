package cursedbread.nym.BlockLogics;

import cursedbread.nym.NYMBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicSaplingBase;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTreeTaigaBushy;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTreeTaigaTall;

import java.util.Random;

public class BlockLogicSaplingPineSnowy extends BlockLogicSaplingBase {
	public BlockLogicSaplingPineSnowy(Block<?> block) {
		super(block);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (!world.isClientSide) {
			super.updateTick(world, x, y, z, rand);
			int growthRate = 30;
			if (world.getBlockLightValue(x, y + 1, z) >= 9 && rand.nextInt(growthRate) == 0) {
				int l = world.getBlockMetadata(x, y, z);
				if ((l & 8) == 0) {
					world.setBlockMetadataWithNotify(x, y, z, l | 8);
				} else {
					this.growTree(world, x, y, z, rand);
				}
			}

		}
	}

	@Override
	public void growTree(World world, int x, int y, int z, Random random) {
		WorldFeature treeBig = new WorldFeatureTreeTaigaTall(NYMBlocks.snowyPineLeaves.id(), Blocks.LOG_PINE.id());
		WorldFeature treeSmall = new WorldFeatureTreeTaigaBushy(NYMBlocks.snowyPineLeaves.id(), Blocks.LOG_PINE.id());
		world.setBlock(x, y, z, 0);
		if (!((WorldFeature)treeSmall).place(world, random, x, y, z) && !((WorldFeature)treeBig).place(world, random, x, y, z)) {
			world.setBlock(x, y, z, this.id());
		}

	}
}
