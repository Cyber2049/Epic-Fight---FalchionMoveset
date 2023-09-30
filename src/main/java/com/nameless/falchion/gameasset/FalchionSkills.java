package com.nameless.falchion.gameasset;

import com.nameless.falchion.main.FalchionMoveset;
import com.nameless.falchion.skill.FalchionArt;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.data.reloader.SkillManager;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;

@Mod.EventBusSubscriber(modid = FalchionMoveset.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FalchionSkills {
    public static Skill FALCHION_ART;
    public static void registerSkills(){
        SkillManager.register(FalchionArt::new, WeaponInnateSkill.createWeaponInnateBuilder().setActivateType(Skill.ActivateType.ONE_SHOT) ,FalchionMoveset.MODID,"falchion_art");
    }

    @SubscribeEvent
    public static void buildSkillEvent(SkillBuildEvent event){
        FALCHION_ART = event.build(FalchionMoveset.MODID,"falchion_art");
    }
}
