package samebutdifferent.ventureonwards.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import samebutdifferent.ventureonwards.block.*;
import samebutdifferent.ventureonwards.VentureOnwards;

import java.util.function.Supplier;

public class VOBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VentureOnwards.MOD_ID);

    public static final RegistryObject<Block> PEBBLES = registerBlock("pebbles", () -> new PebblesBlock(BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion().sound(SoundType.STONE).strength(0.2F)));
    public static final RegistryObject<Block> ROCK = registerBlock("rock", () -> new RockBlock(BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion().sound(SoundType.STONE).strength(0.4F)));
    public static final RegistryObject<Block> CLOVER = registerBlock("clover", () -> new CloverBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> SMOOTH_DIRT = registerBlock("smooth_dirt", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> BROWN_MUSHROOM_SHELF = registerBlock("brown_mushroom_shelf", () -> new MushroomShelfBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_BROWN).noCollission().instabreak().sound(SoundType.GRASS).lightLevel((state) -> 1)));
    public static final RegistryObject<Block> RED_MUSHROOM_SHELF = registerBlock("red_mushroom_shelf", () -> new MushroomShelfBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_RED).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> DAISY = registerBlock("daisy", () -> new DaisyBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> DRIED_MUD = registerBlock("dired_mud", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CLAY)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = VOBlocks.BLOCKS.register(name, block);
        VOItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(VentureOnwards.TAB)));
        return toReturn;
    }
}
