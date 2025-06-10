package cursedbread.nym;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class NYMCrafts implements RecipeEntrypoint {
	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(NYMMain.MOD_ID);
		RecipeBuilder.getRecipeNamespace(NYMMain.MOD_ID);
	}

	@Override
	public void onRecipesReady() {
		RecipeBuilder.Shaped(NYMMain.MOD_ID)
			.setShape("GGG", "GDG", "GGG")
			.addInput('D', Blocks.SAPLING_PINE)
			.addInput('G', Items.AMMO_SNOWBALL)
			.create("snowypinesapling", new ItemStack(NYMBlocks.snowyPineSapling));
		RecipeBuilder.Shaped(NYMMain.MOD_ID)
			.setShape("GGG", "FDF", "GGG")
			.addInput('D', Blocks.TORCH_REDSTONE_ACTIVE)
			.addInput('F', Items.STRING)
			.addInput('G', Blocks.LAMP_IDLE)
			.create("garland", new ItemStack(NYMBlocks.garlandOne));
	}
}

