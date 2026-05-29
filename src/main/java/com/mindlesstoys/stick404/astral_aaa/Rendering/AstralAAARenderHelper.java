package com.mindlesstoys.stick404.astral_aaa.Rendering;

import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.world.level.material.FogType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.lodestar.lodestone.systems.particle.builder.WorldParticleBuilder;

@OnlyIn(Dist.CLIENT)
public class AstralAAARenderHelper {
    public static void muckAboutWithTheSky(Matrix4f p_254034_, Matrix4f p_324386_, float p_202426_, Camera camera,
                                           boolean p_202428_, Runnable p_202429_, CallbackInfo ci, FogType fogtype,
                                           PoseStack posestack, Vec3 vec3, float f, float f1, float f2, Tesselator tesselator,
                                           ShaderInstance shaderinstance){

        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        posestack.pushPose();

        Matrix4f matrix4f = posestack.last().pose();
        BufferBuilder bufferbuilder = tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);

        posestack.translate(30, 0, 50);
        posestack.scale(0.2f, 1, 0.2f);

        bufferbuilder.addVertex(matrix4f, -100.0F, -100.0F, -100.0F).setUv(0.0F, 0.0F).setColor(0xFFFFFFFF);
        bufferbuilder.addVertex(matrix4f, -100.0F, -100.0F, 100.0F).setUv(0.0F, 16.0F).setColor(0xFFFFFFFF);
        bufferbuilder.addVertex(matrix4f, 100.0F, -100.0F, 100.0F).setUv(16.0F, 16.0F).setColor(0xFFFFFFFF);
        bufferbuilder.addVertex(matrix4f, 100.0F, -100.0F, -100.0F).setUv(16.0F, 0.0F).setColor(0xFFFFFFFF);


        BufferUploader.drawWithShader(bufferbuilder.buildOrThrow());

        posestack.popPose();
    }
}
