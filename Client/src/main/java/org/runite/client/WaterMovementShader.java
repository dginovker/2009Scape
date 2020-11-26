package org.runite.client;

import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.GL_CLAMP_TO_EDGE;
import static org.lwjgl.opengl.GL13.*;


final class WaterMovementShader implements ShaderInterface {

    private static final float[] color = new float[]{0.1F, 0.1F, 0.15F, 0.1F};
    public static float[] aFloatArray1934 = new float[]{0.073F, 0.169F, 0.24F, 1.0F};
    private final float[] aFloatArray2179 = new float[4];
    private int anInt2177 = -1;
    private int textureId = -1;
    private int anInt2181 = -1;


    public WaterMovementShader() {
        this.method1699();
        this.method1701();
    }

    private void method1699() {
        byte[] var1 = new byte[]{(byte) 0, (byte) -1};
        int[] var3 = new int[1];
        glGenTextures(var3);
        glBindTexture(GL_TEXTURE_1D, var3[0]);
        glTexImage1D(GL_TEXTURE_1D, 0, GL_ALPHA, 2, 0, GL_ALPHA, GL_UNSIGNED_BYTE, ByteBuffer.wrap(var1));
        glTexParameteri(GL_TEXTURE_1D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_1D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_1D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
        this.textureId = var3[0];
    }

    private void method1701() {
        this.anInt2177 = glGenLists(2);
        glNewList(this.anInt2177, GL_COMPILE);
        glTexEnvi(GL_TEXTURE_ENV, GL_OPERAND0_RGB, GL_SRC_COLOR);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE1_RGB, GL_CONSTANT);
        glTexEnvf(GL_TEXTURE_ENV, GL_RGB_SCALE, 2.0F);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE1_ALPHA, GL_CONSTANT);
        glTexGeni(GL_S, GL_TEXTURE_GEN_MODE, GL_OBJECT_LINEAR);
        glTexGeni(GL_T, GL_TEXTURE_GEN_MODE, GL_OBJECT_LINEAR);
        glTexGenfv(GL_S, GL_OBJECT_PLANE, new float[]{9.765625E-4F, 0.0F, 0.0F, 0.0F});
        glTexGenfv(GL_T, GL_OBJECT_PLANE, new float[]{0.0F, 0.0F, 9.765625E-4F, 0.0F});
        glEnable(GL_TEXTURE_GEN_S);
        glEnable(GL_TEXTURE_GEN_T);
        if (Class88.Texture3DEnabled) {
            glBindTexture(GL_TEXTURE_3D, Class88.anInt1228);
            glTexGeni(GL_R, GL_TEXTURE_GEN_MODE, GL_OBJECT_LINEAR);
            glTexGeni(GL_Q, GL_TEXTURE_GEN_MODE, GL_OBJECT_LINEAR);
            glTexGenfv(GL_Q, GL_OBJECT_PLANE, new float[]{0.0F, 0.0F, 0.0F, 1.0F});
            glEnable(GL_TEXTURE_GEN_R);
            glEnable(GL_TEXTURE_GEN_Q);
            glEnable(GL_TEXTURE_3D);
        }

        glActiveTexture(GL_TEXTURE1);
        glEnable(GL_TEXTURE_1D);
        glBindTexture(GL_TEXTURE_1D, this.textureId);
        glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_RGB, GL_INTERPOLATE);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_RGB, GL_CONSTANT);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE2_RGB, GL_TEXTURE);
        glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_ALPHA, GL_INTERPOLATE);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_ALPHA, GL_CONSTANT);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE2_ALPHA, GL_TEXTURE);
        glEnable(GL_TEXTURE_GEN_S);
        glTexGeni(GL_S, GL_TEXTURE_GEN_MODE, GL_EYE_LINEAR);
        glPushMatrix();
        glLoadIdentity();
        glEndList();
        glNewList(this.anInt2177 + 1, GL_COMPILE);
        glActiveTexture(GL_TEXTURE1);
        glDisable(GL_TEXTURE_1D);
        glDisable(GL_TEXTURE_GEN_S);
        glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_RGB, GL_MODULATE);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_RGB, GL_TEXTURE);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE2_RGB, GL_CONSTANT);
        glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_ALPHA, GL_MODULATE);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_ALPHA, GL_TEXTURE);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE2_ALPHA, GL_CONSTANT);
        glActiveTexture(GL_TEXTURE0);
        glTexEnvi(GL_TEXTURE_ENV, GL_OPERAND0_RGB, GL_SRC_COLOR);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE1_RGB, GL_PREVIOUS);
        glTexEnvf(GL_TEXTURE_ENV, GL_RGB_SCALE, 1.0F);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE1_ALPHA, GL_PREVIOUS);
        glDisable(GL_TEXTURE_GEN_S);
        glDisable(GL_TEXTURE_GEN_T);
        if (Class88.Texture3DEnabled) {
            glDisable(GL_TEXTURE_GEN_R);
            glDisable(GL_TEXTURE_GEN_Q);
            glDisable(GL_TEXTURE_3D);
        }

        glEndList();
    }

    public final void method21() {
        glCallList(this.anInt2177 + 1);
    }

    public final void method23(int var1) {
        glActiveTexture(GL_TEXTURE1);
        glTexEnvfv(GL_TEXTURE_ENV, GL_TEXTURE_ENV_COLOR, aFloatArray1934);//0
        glActiveTexture(GL_TEXTURE0);
        if ((var1 & 1) == 1) {
            if (Class88.Texture3DEnabled) {
                if (this.anInt2181 != HDToolKit.anInt1791) {
                    this.aFloatArray2179[0] = 0.0F;
                    this.aFloatArray2179[1] = 0.0F;
                    this.aFloatArray2179[2] = 0.0F;
                    this.aFloatArray2179[3] = (float) HDToolKit.anInt1791 * 0.0050F;//Water moving speed?
                    glTexGenfv(GL_R, GL_OBJECT_PLANE, this.aFloatArray2179);//R, OBJECT_PLANE 0
                    this.anInt2181 = HDToolKit.anInt1791;
                }
            } else {
                HDToolKit.bindTexture2D(Class88.anIntArray1224[HDToolKit.anInt1791 * 64 / 100 % 64]);
            }
        } else if (Class88.Texture3DEnabled) {
            this.aFloatArray2179[0] = 0.0F;
            this.aFloatArray2179[1] = 0.0F;
            this.aFloatArray2179[2] = 0.0F;
            this.aFloatArray2179[3] = 0.0F;
            glTexGenfv(GL_R, GL_OBJECT_PLANE, this.aFloatArray2179);//0
        } else {
            HDToolKit.bindTexture2D(Class88.anIntArray1224[0]);
        }

    }

    public final void method22() {
        HDToolKit.method1856(2);
        HDToolKit.method1847(2);
        HDToolKit.method1823();
        glCallList(this.anInt2177);
        float var2 = 2662.4001F;
        var2 += (float) (Class140_Sub7.anInt2938 - 128) * 0.5F;
        if (var2 >= 3328.0F) {
            var2 = 3327.0F;
        }

        this.aFloatArray2179[0] = 0.0F;
        this.aFloatArray2179[1] = 0.0F;
        this.aFloatArray2179[2] = 1.0F / (var2 - 3328.0F);
        this.aFloatArray2179[3] = var2 / (var2 - 3328.0F);
        glTexGenfv(GL_S, GL_EYE_PLANE, this.aFloatArray2179);//GL_ENABLE_BIT, GL_EYE_PLANE
        glPopMatrix();
        glActiveTexture(GL_TEXTURE0);//GL_TEXTURE0
        glTexEnvfv(GL_TEXTURE_ENV, GL_TEXTURE_ENV_COLOR, color);//GL_TEXTURE_ENV, GL_TEXTURE_ENV_COLOR
    }

    public final int method24() {
        return 15;
    }

}
