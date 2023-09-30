package com.nameless.falchion.capabilities;

import com.nameless.falchion.gameasset.FalchionAnimations;
import com.nameless.falchion.gameasset.FalchionSkills;
import net.minecraft.world.item.Item;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.function.Function;

public class FalchionCapability {
    public static final Function<Item, CapabilityItem.Builder> FALCHION = (item) -> {
        WeaponCapability.Builder builder = WeaponCapability.builder()
                .category(CapabilityItem.WeaponCategories.SPEAR)
                .styleProvider((playerpatch) -> CapabilityItem.Styles.TWO_HAND)
                .collider(ColliderPreset.SPEAR)
                .hitSound(EpicFightSounds.BLADE_HIT)
                .canBePlacedOffhand(false)
                .newStyleCombo(CapabilityItem.Styles.TWO_HAND, FalchionAnimations.FALCHION_AUTO1, FalchionAnimations.FALCHION_AUTO2, FalchionAnimations.FALCHION_AUTO3, Animations.SPEAR_DASH, Animations.SPEAR_TWOHAND_AIR_SLASH)
                .newStyleCombo(CapabilityItem.Styles.MOUNT, Animations.SPEAR_MOUNT_ATTACK)
                .innateSkill(CapabilityItem.Styles.TWO_HAND, itemStack -> FalchionSkills.FALCHION_ART)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.IDLE, FalchionAnimations.FALCHION_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.WALK, FalchionAnimations.FALCHION_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.CHASE, Animations.BIPED_HOLD_SPEAR)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.RUN, Animations.BIPED_RUN_SPEAR)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SWIM, Animations.BIPED_HOLD_SPEAR)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.BLOCK, Animations.SPEAR_GUARD);
        return builder;
    };

    public static void register(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put("falchion", FALCHION);
    }
}
