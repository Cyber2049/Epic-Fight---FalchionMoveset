package com.nameless.falchion.main;

import com.nameless.falchion.capabilities.FalchionCapability;
import com.nameless.falchion.gameasset.FalchionAnimations;
import com.nameless.falchion.gameasset.FalchionSkills;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("falchionmoveset")
public class FalchionMoveset {
    public static final String MODID = "falchionmoveset";

    public FalchionMoveset() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        FalchionSkills.registerSkills();
        bus.addListener(FalchionCapability::register);
        bus.addListener(FalchionAnimations::registerAnimations);
    }
}
