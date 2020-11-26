package org.runite.client;

import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;


final class Class160 implements ShaderInterface {

    private int anInt2187 = -1;
    private boolean aBoolean2188 = false;
    private int[] anIntArray2189 = null;


    public Class160() {
        if (HDToolKit.supportTextureCubeMap && HDToolKit.maxTextureUnits >= 2) {
            this.method2199();
            glBindTexture(GL_TEXTURE_CUBE_MAP, this.anIntArray2189[0]);
            glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
            glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
            glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_WRAP_R, GL_CLAMP_TO_EDGE);
            glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
            glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
            glBindTexture(GL_TEXTURE_CUBE_MAP, this.anIntArray2189[1]);
            glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
            glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
            glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_WRAP_R, GL_CLAMP_TO_EDGE);
            glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
            glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
            glBindTexture(GL_TEXTURE_CUBE_MAP, this.anIntArray2189[2]);
            glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
            glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
            glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_WRAP_R, GL_CLAMP_TO_EDGE);
            glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
            glTexParameteri(GL_TEXTURE_CUBE_MAP, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
            this.aBoolean2188 = HDToolKit.maxTextureUnits < 3;
        }

        this.method2198();
    }

    private void method2198() {
        this.anInt2187 = glGenLists(2);
        glNewList(this.anInt2187, GL_COMPILE);
        if (this.anIntArray2189 == null) {
            glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_ALPHA, GL_PRIMARY_COLOR);
        } else {
            glActiveTexture(GL_TEXTURE1);
            glTexGeni(GL_S, GL_TEXTURE_GEN_MODE, GL_NORMAL_MAP);
            glTexGeni(GL_T, GL_TEXTURE_GEN_MODE, GL_NORMAL_MAP);
            glTexGeni(GL_R, GL_TEXTURE_GEN_MODE, GL_NORMAL_MAP);
            glEnable(GL_TEXTURE_GEN_S);
            glEnable(GL_TEXTURE_GEN_T);
            glEnable(GL_TEXTURE_GEN_R);
            glEnable(GL_TEXTURE_CUBE_MAP);
            glMatrixMode(GL_TEXTURE);
            glLoadIdentity();
            glRotatef(22.5F, 1.0F, 0.0F, 0.0F);
            glMatrixMode(GL_MODELVIEW);
            if (this.aBoolean2188) {
                glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_RGB, GL_ADD);
                glTexEnvi(GL_TEXTURE_ENV, GL_OPERAND0_RGB, GL_SRC_ALPHA);
                glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_ALPHA, GL_REPLACE);
                glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_ALPHA, GL_PRIMARY_COLOR);
            } else {
                glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_RGB, GL_REPLACE);
                glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_RGB, GL_PREVIOUS);
                glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_ALPHA, GL_MODULATE);
                glActiveTexture(GL_TEXTURE2);
                glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_COMBINE);
                glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_RGB, GL_ADD);
                glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_RGB, GL_PREVIOUS);
                glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE1_RGB, GL_PREVIOUS);
                glTexEnvi(GL_TEXTURE_ENV, GL_OPERAND1_RGB, GL_SRC_ALPHA);
                glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_ALPHA, GL_REPLACE);
                glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_ALPHA, GL_PRIMARY_COLOR);
                glBindTexture(GL_TEXTURE_2D, HDToolKit.anInt1810);
                glEnable(GL_TEXTURE_2D);
            }

            glActiveTexture(GL_TEXTURE0);
        }

        glEndList();
        glNewList(this.anInt2187 + 1, GL_COMPILE);
        if (this.anIntArray2189 == null) {
            glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_ALPHA, GL_TEXTURE);
        } else {
            glActiveTexture(GL_TEXTURE1);
            glDisable(GL_TEXTURE_GEN_S);
            glDisable(GL_TEXTURE_GEN_T);
            glDisable(GL_TEXTURE_GEN_R);
            glDisable(GL_TEXTURE_CUBE_MAP);
            glMatrixMode(GL_TEXTURE);
            glLoadIdentity();
            glMatrixMode(GL_MODELVIEW);
            if (this.aBoolean2188) {
                glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_RGB, GL_MODULATE);
                glTexEnvi(GL_TEXTURE_ENV, GL_OPERAND0_RGB, GL_SRC_COLOR);
                glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_ALPHA, GL_MODULATE);
                glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_ALPHA, GL_TEXTURE);
            } else {
                glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_RGB, GL_MODULATE);
                glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_RGB, GL_TEXTURE);
                glActiveTexture(GL_TEXTURE2);
                glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);
                glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_RGB, GL_MODULATE);
                glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_RGB, GL_TEXTURE);
                glTexEnvi(GL_TEXTURE_ENV, GL_OPERAND1_RGB, GL_SRC_COLOR);
                glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_ALPHA, GL_MODULATE);
                glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_ALPHA, GL_TEXTURE);
                glDisable(GL_TEXTURE_2D);
            }

            glActiveTexture(GL_TEXTURE0);
        }

        glEndList();
    }

    public final void method21() {
        if (Class106.aBoolean1441) {
            glCallList(this.anInt2187 + 1);
        } else {
            glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_ALPHA, GL_TEXTURE);
        }

    }

    public final int method24() {
        return 4;
    }

    public final void method22() {
        HDToolKit.method1847(1);
        if (Class106.aBoolean1441) {
            glCallList(this.anInt2187);
        } else {
            glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_ALPHA, GL_PRIMARY_COLOR);
        }

    }

    public final void method23(int var1) {
        if (Class106.aBoolean1441 && this.anIntArray2189 != null) {
            glActiveTexture(GL_TEXTURE1);
            glBindTexture(GL_TEXTURE_CUBE_MAP, this.anIntArray2189[var1 - 1]);
            glActiveTexture(GL_TEXTURE0);
        }

    }

    private void method2199() {
        if (this.anIntArray2189 == null) {
            this.anIntArray2189 = new int[3];
            glGenTextures(this.anIntArray2189);
        }

        short var9 = 4096;
        byte[] var10 = new byte[var9];
        byte[] var11 = new byte[var9];
        byte[] var12 = new byte[var9];

        for (int var13 = 0; var13 < 6; ++var13) {
            int var14 = 0;

            for (int var15 = 0; var15 < 64; ++var15) {
                for (int var16 = 0; var16 < 64; ++var16) {
                    float var5 = 2.0F * (float) var16 / 64.0F - 1.0F;
                    float var6 = 2.0F * (float) var15 / 64.0F - 1.0F;
                    float var7 = (float) (1.0D / Math.sqrt(var5 * var5 + 1.0F + var6 * var6));
                    var5 *= var7;
                    var6 *= var7;
                    float var4;
                    if (var13 == 0) {
                        var4 = -var5;
                    } else if (var13 == 1) {
                        var4 = var5;
                    } else if (var13 == 2) {
                        var4 = var6;
                    } else if (var13 == 3) {
                        var4 = -var6;
                    } else if (var13 == 4) {
                        var4 = var7;
                    } else {
                        var4 = -var7;
                    }

                    int var1;
                    int var2;
                    int var3;
                    if (var4 > 0.0F) {
                        var1 = (int) (Math.pow(var4, 96.0D) * 255.0D);
                        var2 = (int) (Math.pow(var4, 36.0D) * 255.0D);
                        var3 = (int) (Math.pow(var4, 12.0D) * 255.0D);
                    } else {
                        var3 = 0;
                        var2 = 0;
                        var1 = 0;
                    }

                    if (HDToolKit.maxTextureUnits < 3) {
                        var1 /= 5;
                        var2 /= 5;
                        var3 /= 5;
                    } else {
                        var1 /= 2;
                        var2 /= 2;
                        var3 /= 2;
                    }

                    var11[var14] = (byte) var1;
                    var12[var14] = (byte) var2;
                    var10[var14] = (byte) var3;
                    ++var14;
                }
            }

            glBindTexture(GL_TEXTURE_CUBE_MAP, this.anIntArray2189[0]);
            glTexImage2D(GL_TEXTURE_CUBE_MAP_POSITIVE_X + var13, 0, GL_ALPHA, 64, 64, 0, GL_ALPHA, GL_UNSIGNED_BYTE, ByteBuffer.wrap(var11));
            glBindTexture(GL_TEXTURE_CUBE_MAP, this.anIntArray2189[1]);
            glTexImage2D(GL_TEXTURE_CUBE_MAP_POSITIVE_X + var13, 0, GL_ALPHA, 64, 64, 0, GL_ALPHA, GL_UNSIGNED_BYTE, ByteBuffer.wrap(var12));
            glBindTexture(GL_TEXTURE_CUBE_MAP, this.anIntArray2189[2]);
            glTexImage2D(GL_TEXTURE_CUBE_MAP_POSITIVE_X + var13, 0, GL_ALPHA, 64, 64, 0, GL_ALPHA, GL_UNSIGNED_BYTE, ByteBuffer.wrap(var10));
            Class31.anInt580 += var9 * 3;
        }

    }
}
