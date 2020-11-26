package org.runite.client;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;

import java.nio.ByteBuffer;


final class WaterShader implements ShaderInterface {

    static int anInt3285 = 128;
    private static boolean aBoolean2191 = false;
    private final float[] aFloatArray2190 = new float[4];
    private int anInt2192 = -1;
    private int anInt2193 = -1;


    public WaterShader() {
        if (HDToolKit.maxTextureUnits >= 2) {
            int[] textures = new int[1];
            byte[] pixels = new byte[8];
            int pixelsPos = 0;
            while (pixelsPos < 8) {
                pixels[pixelsPos] = (byte) (96 + ++pixelsPos * 159 / 8);
            }
//         for(int var3 = 0; var3 < 8; pixels[var3++] = (byte)(96 + var3 * 159 / 8)) {
//         }
            glGenTextures(textures);//1, buffer, 0
            glBindTexture(GL_TEXTURE_1D, textures[0]);//TEXTURE_1D
            //                TEXTURE_1D, level0, ALPHA, width8, border0, ALPHA, UNSIGNED_BYTE, pixels.
            glTexImage1D(GL_TEXTURE_1D, 0, GL_ALPHA, 8, 0, GL_ALPHA, GL_UNSIGNED_BYTE, ByteBuffer.wrap(pixels));
            glTexParameteri(GL_TEXTURE_1D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);//TEXTURE_1D, TEXTURE_MIN_FILTER, LINEAR
            glTexParameteri(GL_TEXTURE_1D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);//TEXTURE_1D, TEXTURE_MAG_FILTER, LINEAR
            glTexParameteri(GL_TEXTURE_1D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);//TEXTURE_1D, TEXTURE_WRAP_S, CLAMP_TO_EDGE
            this.anInt2192 = textures[0];
            aBoolean2191 = HDToolKit.maxTextureUnits > 2 && HDToolKit.allows3DTextureMapping;
            this.method2251();
        }

    }

    static int method2252() {
        return aBoolean2191 ? GL_TEXTURE2 : GL_TEXTURE1;
    }

    static void method2253() {
        glClientActiveTexture(method2252());
        glDisableClientState(GL_TEXTURE_COORD_ARRAY);
        glClientActiveTexture(GL_TEXTURE0);
    }

    static void method2254() {
        glClientActiveTexture(method2252());
        glEnableClientState(GL_TEXTURE_COORD_ARRAY);
        glClientActiveTexture(GL_TEXTURE0);
    }

    private void method2251() {
        this.anInt2193 = glGenLists(2);
        glNewList(this.anInt2193, GL_COMPILE);
        glActiveTexture(GL_TEXTURE1);
        if (aBoolean2191) {
            glBindTexture(GL_TEXTURE_3D, Class88.anInt1228);
            glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_RGB, GL_ADD);
            glTexEnvi(GL_TEXTURE_ENV, GL_OPERAND0_RGB, GL_SRC_COLOR);
            glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_ALPHA, GL_REPLACE);
            glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_ALPHA, GL_PREVIOUS);
            glTexGeni(GL_S, GL_TEXTURE_GEN_MODE, GL_EYE_LINEAR);
            glTexGeni(GL_R, GL_TEXTURE_GEN_MODE, GL_EYE_LINEAR);
            glTexGeni(GL_T, GL_TEXTURE_GEN_MODE, GL_EYE_LINEAR);
            glTexGeni(GL_Q, GL_TEXTURE_GEN_MODE, GL_OBJECT_LINEAR);
            glTexGenfv(GL_Q, GL_OBJECT_PLANE, new float[]{0.0F, 0.0F, 0.0F, 1.0F});//0
            glEnable(GL_TEXTURE_GEN_S);
            glEnable(GL_TEXTURE_GEN_T);
            glEnable(GL_TEXTURE_GEN_R);
            glEnable(GL_TEXTURE_GEN_Q);
            glEnable(GL_TEXTURE_3D);
            glActiveTexture(GL_TEXTURE2);
            glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_COMBINE);
        }

        glBindTexture(GL_TEXTURE_1D, this.anInt2192);
        glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_RGB, GL_INTERPOLATE);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_RGB, GL_CONSTANT);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE2_RGB, GL_TEXTURE);
        glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_ALPHA, GL_REPLACE);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_ALPHA, GL_PREVIOUS);
        glTexGeni(GL_S, GL_TEXTURE_GEN_MODE, GL_EYE_LINEAR);
        glEnable(GL_TEXTURE_1D);
        glEnable(GL_TEXTURE_GEN_S);
        glActiveTexture(GL_TEXTURE0);
        glEndList();
        glNewList(this.anInt2193 + 1, GL_COMPILE);
        glActiveTexture(GL_TEXTURE1);
        if (aBoolean2191) {
            glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_RGB, GL_MODULATE);
            glTexEnvi(GL_TEXTURE_ENV, GL_OPERAND0_RGB, GL_SRC_COLOR);
            glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_ALPHA, GL_MODULATE);
            glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_ALPHA, GL_TEXTURE);
            glDisable(GL_TEXTURE_GEN_S);
            glDisable(GL_TEXTURE_GEN_T);
            glDisable(GL_TEXTURE_GEN_R);
            glDisable(GL_TEXTURE_GEN_Q);
            glDisable(GL_TEXTURE_3D);
            glActiveTexture(GL_TEXTURE2);
            glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);
        }

        glTexEnvfv(GL_TEXTURE_ENV, GL_TEXTURE_ENV_COLOR, new float[]{0.0F, 1.0F, 0.0F, 1.0F});//0
        glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_RGB, GL_MODULATE);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_RGB, GL_TEXTURE);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE2_RGB, GL_CONSTANT);
        glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_ALPHA, GL_MODULATE);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_ALPHA, GL_TEXTURE);
        glDisable(GL_TEXTURE_1D);
        glDisable(GL_TEXTURE_GEN_S);
        glActiveTexture(GL_TEXTURE0);
        glEndList();
    }

    public final void method22() {
        glCallList(this.anInt2193);
    }

    public final int method24() {
        return 0;
    }

    public final void method21() {
        glCallList(this.anInt2193 + 1);
    }

    public final void method23(int var1) {
        glActiveTexture(GL_TEXTURE1);
        if (!aBoolean2191 && var1 < 0) {
            glDisable(GL_TEXTURE_GEN_S);
        } else {
            glPushMatrix();
            glLoadIdentity();
            glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
            glRotatef((float) Class140_Sub7.anInt2938 * 360.0F / 2048.0F, 1.0F, 0.0F, 0.0F);
            glRotatef((float) Class3_Sub13_Sub8.anInt3103 * 360.0F / 2048.0F, 0.0F, 1.0F, 0.0F);
            glTranslatef((float) (-Unsorted.anInt144), (float) (-Unsorted.anInt3695), (float) (-LinkableRSString.anInt2587));
            if (aBoolean2191) {
                this.aFloatArray2190[0] = 0.0010F;
                this.aFloatArray2190[1] = 9.0E-4F;
                this.aFloatArray2190[2] = 0.0F;
                this.aFloatArray2190[3] = 0.0F;
                glTexGenfv(GL_S, GL_EYE_PLANE, this.aFloatArray2190);//0
                this.aFloatArray2190[0] = 0.0F;
                this.aFloatArray2190[1] = 9.0E-4F;
                this.aFloatArray2190[2] = 0.0010F;
                this.aFloatArray2190[3] = 0.0F;
                glTexGenfv(GL_T, GL_EYE_PLANE, this.aFloatArray2190);//0
                this.aFloatArray2190[0] = 0.0F;
                this.aFloatArray2190[1] = 0.0F;
                this.aFloatArray2190[2] = 0.0F;
                this.aFloatArray2190[3] = (float) HDToolKit.anInt1791 * 0.0050F;
                glTexGenfv(GL_R, GL_EYE_PLANE, this.aFloatArray2190);//0
                glActiveTexture(GL_TEXTURE2);
            }

            glTexEnvfv(GL_TEXTURE_ENV, GL_TEXTURE_ENV_COLOR, Class72.method1297());//0
            if (var1 >= 0) {
                this.aFloatArray2190[0] = 0.0F;
                this.aFloatArray2190[1] = 1.0F / (float) anInt3285;
                this.aFloatArray2190[2] = 0.0F;
                this.aFloatArray2190[3] = 1.0F * (float) var1 / (float) anInt3285;
                glTexGenfv(GL_S, GL_EYE_PLANE, this.aFloatArray2190);//0
                glEnable(GL_TEXTURE_GEN_S);
            } else {
                glDisable(GL_TEXTURE_GEN_S);
            }

            glPopMatrix();
        }

        glActiveTexture(GL_TEXTURE0);
    }


}
