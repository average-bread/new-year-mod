package cursedbread.nym;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;

import java.util.Properties;


public class NYMMain implements ModInitializer, GameStartEntrypoint {
    public static final String MOD_ID = "nym";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	static {
		Properties prop = new Properties();
		prop.setProperty("starting_block_id","2200");
		prop.setProperty("starting_item_id","17890");
		ConfigHandler config = new ConfigHandler(MOD_ID,prop);
		NYMBlocks.blockId = config.getInt("starting_block_id");
		NYMItems.itemId = config.getInt("starting_item_id");
	}

    @Override
    public void onInitialize() {
        LOGGER.info("Naughty programmers get bugs under their skin");
		new NYMBlocks().initilizeBlocks();
		new NYMItems().initilizeItems();
    }

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {

	}
}
