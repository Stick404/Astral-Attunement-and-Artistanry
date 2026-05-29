package com.mindlesstoys.stick404.astral_aaa.mixins;

import com.mindlesstoys.stick404.astral_aaa.Rendering.AstralAAARenderHelper;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.world.level.material.FogType;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import javax.annotation.Nullable;

@Mixin(value = LevelRenderer.class)
public class LevelRendererMixin {

    @Shadow
    @Nullable
    private ClientLevel level;

    @Inject(
        method = "Lnet/minecraft/client/renderer/LevelRenderer;renderSky(Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;FLnet/minecraft/client/Camera;ZLjava/lang/Runnable;)V",
        at = @At(
                value = "INVOKE",
                target = "Lnet/minecraft/client/renderer/FogRenderer;setupNoFog()V"),
        locals = LocalCapture.CAPTURE_FAILHARD
    )
    private void astral_aaa$StarMixin(Matrix4f p_254034_, Matrix4f p_324386_, float p_202426_, Camera camera,
                                      boolean p_202428_, Runnable p_202429_, CallbackInfo ci, FogType fogtype,
                                      PoseStack posestack, Vec3 vec3, float f, float f1, float f2, Tesselator tesselator,
                                      ShaderInstance shaderinstance){
        AstralAAARenderHelper.muckAboutWithTheSky(p_254034_, p_324386_, p_202426_, camera, p_202428_, p_202429_, ci, fogtype, posestack, vec3, f, f1, f2, tesselator, shaderinstance);
    }
}
