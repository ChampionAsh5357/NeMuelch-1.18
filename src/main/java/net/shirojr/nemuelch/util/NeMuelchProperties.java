package net.shirojr.nemuelch.util;

import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.shirojr.nemuelch.block.custom.IronScaffoldingBlock;
import net.shirojr.nemuelch.util.helper.WateringCanHelper;

public class NeMuelchProperties {
    public static final IntProperty DISTANCE_0_IRON_SCAFFOLDING_MAX;

    public static final BooleanProperty ROPED;
    public static final BooleanProperty ROPE_ANCHOR;
    public static final IntProperty WAND_OF_SOL_STATE;
    public static final BooleanProperty FILLED;
    public static final EnumProperty<WateringCanHelper.ItemMaterial> MATERIAL;

    static {
        DISTANCE_0_IRON_SCAFFOLDING_MAX = IntProperty.of("distance", 0, IronScaffoldingBlock.MAX_DISTANCE);
        ROPED = BooleanProperty.of("roped");
        ROPE_ANCHOR = BooleanProperty.of("rope_anchor");
        WAND_OF_SOL_STATE = IntProperty.of("wandofsol_state", 0, 2);
        FILLED = BooleanProperty.of("filled");
        MATERIAL = EnumProperty.of("material", WateringCanHelper.ItemMaterial.class);
    }
}
