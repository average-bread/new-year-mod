package cursedbread.nym;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelBasket;
import net.minecraft.client.render.block.model.BlockModelCrossedSquares;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.BlockModelLadder;
import net.minecraft.client.render.block.model.BlockModelLeaves;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

@Environment(EnvType.CLIENT)
public class NYMModels implements ModelEntrypoint {

    @Override
    public void initBlockModels(BlockModelDispatcher dispatcher) {
        ModelHelper.setBlockModel(NYMBlocks.snowyPineLeaves, () -> new BlockModelLeaves<>(NYMBlocks.snowyPineLeaves, "nym:block/leaves_pine_snowy"));
        ModelHelper.setBlockModel(NYMBlocks.snowyPineSapling, () -> new BlockModelCrossedSquares<>(NYMBlocks.snowyPineSapling).setAllTextures(0, "nym:block/sapling_pine_snowy"));
        ModelHelper.setBlockModel(NYMBlocks.garlandOne, () -> new BlockModelLadder<>(NYMBlocks.garlandOne).setAllTextures(0, "nym:block/garland"));
        ModelHelper.setBlockModel(NYMBlocks.presentBlack, () -> new BlockModelBasket<>(NYMBlocks.presentBlack));
    }

    @Override
    public void initItemModels(ItemModelDispatcher dispatcher) {
    }

    @Override
    public void initEntityModels(EntityRenderDispatcher dispatcher) {
    }

    @Override
    public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {
    }

    @Override
    public void initBlockColors(BlockColorDispatcher dispatcher) {
    }
    
}
