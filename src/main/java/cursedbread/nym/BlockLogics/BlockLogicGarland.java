package cursedbread.nym.BlockLogics;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicLadder;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

public class BlockLogicGarland extends BlockLogicLadder {

    public BlockLogicGarland(Block<?> block) {
        super(block);
    }

    @Override
    public boolean isClimbable(World world, int x, int y, int z) {
        return false;
    }

    @Override
    public boolean canExistAt(World world, int x, int y, int z, int meta) {
      Side side = this.getSideFromMeta(meta).getOpposite();
      x += side.getOffsetX();
      y += side.getOffsetY();
      z += side.getOffsetZ();
      return world.getBlock(x, y, z) != null && world.getBlock(x, y, z).isCubeShaped();
   }
    
}
