package net.shirojr.nemuelch.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.shirojr.nemuelch.NeMuelch;
import net.shirojr.nemuelch.init.ConfigInit;
import net.shirojr.nemuelch.item.custom.caneItem.*;
import net.shirojr.nemuelch.item.custom.gloveItem.TraininggloveItem;
import net.shirojr.nemuelch.item.custom.supportItem.BandageItem;
import net.shirojr.nemuelch.item.custom.supportItem.OintmentItem;
import net.shirojr.nemuelch.item.custom.adminToolItem.EntityTransportToolItem;
import net.shirojr.nemuelch.item.custom.adminToolItem.RefillToolItem;
import net.shirojr.nemuelch.item.custom.muelchItem.*;
import net.shirojr.nemuelch.item.custom.supportItem.OnionWandItem;

public class NeMuelchItems {
    //region muelch
    public static final Item GREEN_MUELCH = registerItem("green_muelch",
            new NeMuelchGreenItem(new FabricItemSettings().group(NeMuelchItemGroup.NEMUELCH).food(NeMuelchDrinkComponents.GREEN_MILK).maxCount(1)));

    public static final Item BROWN_MUELCH = registerItem("brown_muelch",
            new NeMuelchBrownItem(new FabricItemSettings().group(NeMuelchItemGroup.NEMUELCH).food(NeMuelchDrinkComponents.BROWN_MILK).maxCount(1)));

    public static final Item BLUE_MUELCH = registerItem("blue_muelch",
            new NeMuelchBlueItem(new FabricItemSettings().group(NeMuelchItemGroup.NEMUELCH).food(NeMuelchDrinkComponents.BLUE_MILK).maxCount(1)));

    public static final Item PINK_MUELCH = registerItem("pink_muelch",
            new NeMuelchPinkItem(new FabricItemSettings().group(NeMuelchItemGroup.NEMUELCH).food(NeMuelchDrinkComponents.PINK_MILK).maxCount(1)));

    public static final Item YELLOW_MUELCH = registerItem("yellow_muelch",
            new NeMuelchYellowItem(new FabricItemSettings().group(NeMuelchItemGroup.NEMUELCH).food(NeMuelchDrinkComponents.YELLOW_MILK).maxCount(1)));

    public static final Item PURPLE_MUELCH = registerItem("purple_muelch",
            new NeMuelchPurpleItem(new FabricItemSettings().group(NeMuelchItemGroup.NEMUELCH).food(NeMuelchDrinkComponents.PURPLE_MILK).maxCount(1)));
    //endregion
    //region canes
    public static final Item PEST_CANE = registerItem("pestcane",
            new PestcaneItem(new FabricItemSettings().group(NeMuelchItemGroup.CANES).maxCount(1)));

    public static final Item ARKADUS_CANE = registerItem("arkaduscane",
            new ArkaduscaneItem(new FabricItemSettings().group(NeMuelchItemGroup.CANES).maxCount(1)));

    public static final Item ARKADUSCANE_ENTITY_PROJECTILE_ITEM = registerItem("arkaduscane_projectile",
            new ArkaduscaneProjectileEntityItem(new FabricItemSettings()));

    public static final Item GLADIUS_CANE = registerItem("gladiuscane",
            new GladiuscaneItem(new FabricItemSettings().group(NeMuelchItemGroup.CANES).maxCount(1)));

    public static final Item GLADIUS_BLADE = registerItem("gladiusblade",
            new GladiusBladeItem(ToolMaterials.IRON, ConfigInit.CONFIG.GladiusBladeAttackDamage, ConfigInit.CONFIG.GladiusBladeAttackSpeed,
                    new FabricItemSettings().group(NeMuelchItemGroup.CANES).maxCount(1)));
    //endregion
    //region admin tools
    public static final Item REFILLER_TOOL = registerItem("refiller_tool",
            new RefillToolItem(new FabricItemSettings().group(NeMuelchItemGroup.HELPERTOOLS).maxCount(1)));

    public static final Item ENTITYTRANSPORT_TOOL = registerItem("entity_transport_tool",
            new EntityTransportToolItem(new FabricItemSettings().group(NeMuelchItemGroup.HELPERTOOLS).maxCount(1)));
    //endregion

    public static final Item GLOVE_ITEM = registerItem("training_glove",
            new TraininggloveItem(new FabricItemSettings().group(NeMuelchItemGroup.GLOVES).maxCount(1)));


    public static final Item BANDAGE_ITEM = registerItem("bandage",
            new BandageItem(new FabricItemSettings().group(NeMuelchItemGroup.SUPPORT).maxCount(8)));

    public static final Item OINTMENT_ITEM = registerItem("ointment",
            new OintmentItem(new FabricItemSettings().group(NeMuelchItemGroup.SUPPORT).maxCount(8)));

    public static final Item ONION_WAND_ITEM = registerItem("onion_wand",
            new OnionWandItem(new FabricItemSettings().group(NeMuelchItemGroup.SUPPORT).maxCount(1)));


    //preparing items for loading
    private static Item registerItem(String name, Item item) {

        return Registry.register(Registry.ITEM, new Identifier(NeMuelch.MOD_ID, name), item);

    }

    public static void registerModItems() {
        NeMuelch.LOGGER.info("Registering " + NeMuelch.MOD_ID + " Mod items");
    }
}
