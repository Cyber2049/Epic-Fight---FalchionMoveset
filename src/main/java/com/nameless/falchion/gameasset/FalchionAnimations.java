package com.nameless.falchion.gameasset;

import com.nameless.falchion.main.FalchionMoveset;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.BasicAttackAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.client.animation.property.ClientAnimationProperties;
import yesman.epicfight.api.client.animation.property.TrailInfo;
import yesman.epicfight.api.forgeevent.AnimationRegistryEvent;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.model.armature.HumanoidArmature;
import yesman.epicfight.world.damagesource.SourceTags;
import yesman.epicfight.world.damagesource.StunType;

import java.util.List;
import java.util.Set;

public class FalchionAnimations {
    public static StaticAnimation FALCHION_IDLE;
    public static StaticAnimation FALCHION_AUTO1;
    public static StaticAnimation FALCHION_AUTO2;
    public static StaticAnimation FALCHION_AUTO3;
    public static StaticAnimation FALCHION_FORWARD;
    public static StaticAnimation FALCHION_BACKWARD;
    public static StaticAnimation FALCHION_SIDE;

    public static void registerAnimations(AnimationRegistryEvent event){
        event.getRegistryMap().put(FalchionMoveset.MODID, FalchionAnimations::build);
    }

    public static void build(){
        HumanoidArmature biped = Armatures.BIPED;
        FALCHION_IDLE = new StaticAnimation(true, "biped/falchion/falchion_idle", biped);

        FALCHION_AUTO1 = new BasicAttackAnimation(0.1F, 0.25F, 0.317F, 0.5F, null, biped.toolR, "biped/falchion/falchion_auto1", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F)
                .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR,0.5F);
        FALCHION_AUTO2 = new BasicAttackAnimation(0.05F, 0.167F, 0.233F, 0.5F, null, biped.toolR, "biped/falchion/falchion_auto2", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F)
                .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR,0.5F);
        FALCHION_AUTO3 = new BasicAttackAnimation(0.05F, 0.333F, 0.383F, 0.95F, null, biped.toolR, "biped/falchion/falchion_auto3", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F)
                .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR,0.5F);

        FALCHION_FORWARD = new AttackAnimation(0.05F, "biped/falchion/falchion_forward", biped,
                new AttackAnimation.Phase(0.0F, 0.6F, 0.667F, 0.75F, 0.75F, biped.toolR, null),
                new AttackAnimation.Phase(0.75F, 0.85F, 0.9F, 1.35F, Float.MAX_VALUE, biped.toolR, null)
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(4))
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.25F)))
                .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(SourceTags.WEAPON_INNATE))
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 0.95F)
                .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR,0.5F)
                .addProperty(ClientAnimationProperties.TRAIL_EFFECT, List.of(TrailInfo.builder().time(0.1F,0.3F).joint("Tool_R").itemSkinHand(InteractionHand.MAIN_HAND).create()));;

        FALCHION_BACKWARD = new AttackAnimation(0.05F, "biped/falchion/falchion_backward", biped,
                new AttackAnimation.Phase(0.0F, 0.5F, 0.6F, 1F, 1F, biped.toolR, null)
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER,ValueModifier.setter(5)),
                new AttackAnimation.Phase(1F, 1.63F, 1.7F, 2.33F, Float.MAX_VALUE, biped.toolR, null)
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.25F)))
                .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(SourceTags.WEAPON_INNATE))
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 0.85F)
                .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR,0.5F);

        FALCHION_SIDE = new AttackAnimation(0.1F, 0.25F, 0.58F, 0.667F, 1.0F, null, biped.toolR, "biped/falchion/falchion_side", biped)
                .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(SourceTags.WEAPON_INNATE))
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.75F))
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.0F)
                .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR,0.5F);
    }
}
