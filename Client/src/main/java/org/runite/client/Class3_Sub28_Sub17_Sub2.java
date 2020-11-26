package org.runite.client;

import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;

public final class Class3_Sub28_Sub17_Sub2 extends Class3_Sub28_Sub17 {

    private int anInt4083 = 0;
    private int anInt4084 = -1;
    private int[] anIntArray4085;
    private int anInt4086;
    private int anInt4087;


    Class3_Sub28_Sub17_Sub2(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, byte[][] var6) {
        super(var1, var2, var3, var4, var5);
        this.method708(var6);
        this.method707();
    }

    protected final void finalize() throws Throwable {
        if (this.anInt4084 != -1) {
            Class31.method991(this.anInt4084, this.anInt4083, this.anInt4086);
            this.anInt4084 = -1;
            this.anInt4083 = 0;
        }

        if (this.anIntArray4085 != null) {
            for (int var1 = 0; var1 < this.anIntArray4085.length; ++var1) {
                Class31.method986(this.anIntArray4085[var1], this.anInt4086);
            }

            this.anIntArray4085 = null;
        }

        super.finalize();
    }

    final void method678(int var1, int var2, int var3, int var4, int var5, int var6) {
        if (Class22.aHDSprite_447 == null) {
            HDToolKit.method1824();
            HDToolKit.bindTexture2D(this.anInt4084);
            glColor3ub((byte) (var6 >> 16), (byte) (var6 >> 8), (byte) var6);
            glTranslatef((float) var2, (float) (HDToolKit.viewHeight - var3), 0.0F);
            glCallList(this.anIntArray4085[var1]);
        } else {
            HDToolKit.method1824();
            glColor3ub((byte) (var6 >> 16), (byte) (var6 >> 8), (byte) var6);
            glTranslatef((float) var2, (float) (HDToolKit.viewHeight - var3), 0.0F);
            float var9 = (float) (var1 % 16) / 16.0F;
            float var10 = (float) (var1 / 16) / 16.0F;
            float var11 = var9 + (float) this.anIntArray3709[var1] / (float) this.anInt4087;
            float var12 = var10 + (float) this.anIntArray3721[var1] / (float) this.anInt4087;
            HDToolKit.bindTexture2D(this.anInt4084);
            HDSprite var13 = Class22.aHDSprite_447;
            glActiveTexture(GL_TEXTURE1);
            glEnable(GL_TEXTURE_2D);
            glBindTexture(GL_TEXTURE_2D, var13.anInt4077);
            glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_RGB, GL_REPLACE);
            glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_RGB, GL_PREVIOUS);
            float var14 = (float) (var2 - Class22.anInt449) / (float) var13.anInt4075;
            float var15 = (float) (var3 - Class22.anInt448) / (float) var13.anInt4079;
            float var16 = (float) (var2 + var4 - Class22.anInt449) / (float) var13.anInt4075;
            float var17 = (float) (var3 + var5 - Class22.anInt448) / (float) var13.anInt4079;
            glBegin(GL_TRIANGLE_FAN);
            glMultiTexCoord2f(GL_TEXTURE1, var16, var15);
            glTexCoord2f(var11, var10);
            glVertex2f((float) this.anIntArray3709[var1], 0.0F);
            glMultiTexCoord2f(GL_TEXTURE1, var14, var15);
            glTexCoord2f(var9, var10);
            glVertex2f(0.0F, 0.0F);
            glMultiTexCoord2f(GL_TEXTURE1, var14, var17);
            glTexCoord2f(var9, var12);
            glVertex2f(0.0F, (float) (-this.anIntArray3721[var1]));
            glMultiTexCoord2f(GL_TEXTURE1, var16, var17);
            glTexCoord2f(var11, var12);
            glVertex2f((float) this.anIntArray3709[var1], (float) (-this.anIntArray3721[var1]));
            glEnd();
            glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_RGB, GL_MODULATE);
            glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_RGB, GL_TEXTURE);
            glDisable(GL_TEXTURE_2D);
            glActiveTexture(GL_TEXTURE0);
        }
        glLoadIdentity();

    }

    final void method679(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        HDToolKit.method1824();
        HDToolKit.bindTexture2D(this.anInt4084);
        glColor4ub((byte) (var6 >> 16), (byte) (var6 >> 8), (byte) var6, var7 > 255 ? -1 : (byte) var7);
        glTranslatef((float) var2, (float) (HDToolKit.viewHeight - var3), 0.0F);
        glCallList(this.anIntArray4085[var1]);
        glLoadIdentity();
    }

    private void method707() {
        if (this.anIntArray4085 == null) {
            this.anIntArray4085 = new int[256];

            for (int var2 = 0; var2 < 256; ++var2) {
                float var3 = (float) (var2 % 16) / 16.0F;
                float var4 = (float) (var2 / 16) / 16.0F;
                float var5 = var3 + (float) this.anIntArray3709[var2] / (float) this.anInt4087;
                float var6 = var4 + (float) this.anIntArray3721[var2] / (float) this.anInt4087;
                this.anIntArray4085[var2] = glGenLists(1);
                glNewList(this.anIntArray4085[var2], GL_COMPILE);
                glBegin(GL_TRIANGLE_FAN);
                glTexCoord2f(var5, var4);
                glVertex2f((float) this.anIntArray3709[var2], 0.0F);
                glTexCoord2f(var3, var4);
                glVertex2f(0.0F, 0.0F);
                glTexCoord2f(var3, var6);
                glVertex2f(0.0F, (float) (-this.anIntArray3721[var2]));
                glTexCoord2f(var5, var6);
                glVertex2f((float) this.anIntArray3709[var2], (float) (-this.anIntArray3721[var2]));
                glEnd();
                glEndList();
            }

            this.anInt4086 = Class31.anInt582;
        }
    }

    private void method708(byte[][] var1) {
        if (this.anInt4084 == -1) {
            this.anInt4087 = 0;

            int var2;
            for (var2 = 0; var2 < 256; ++var2) {
                if (this.anIntArray3721[var2] > this.anInt4087) {
                    this.anInt4087 = this.anIntArray3721[var2];
                }

                if (this.anIntArray3709[var2] > this.anInt4087) {
                    this.anInt4087 = this.anIntArray3709[var2];
                }
            }

            this.anInt4087 *= 16;
            this.anInt4087 = Class95.method1585((byte) 104, this.anInt4087);
            var2 = this.anInt4087 / 16;
            byte[] var3 = new byte[this.anInt4087 * this.anInt4087 * 2];

            for (int var4 = 0; var4 < 256; ++var4) {
                int var5 = var4 % 16 * var2;
                int var6 = var4 / 16 * var2;
                int var7 = (var6 * this.anInt4087 + var5) * 2;
                int var8 = 0;
                int var9 = this.anIntArray3721[var4];
                int var10 = this.anIntArray3709[var4];
                byte[] var11 = var1[var4];

                for (int var12 = 0; var12 < var9; ++var12) {
                    for (int var13 = 0; var13 < var10; ++var13) {
                        if (var11[var8++] == 0) {
                            var7 += 2;
                        } else {
                            var3[var7++] = -1;
                            var3[var7++] = -1;
                        }
                    }

                    var7 += (this.anInt4087 - var10) * 2;
                }
            }

            ByteBuffer var14 = ByteBuffer.wrap(var3);
            if (this.anInt4084 == -1) {
                int[] var16 = new int[1];
                glGenTextures(var16);//1, buffer, 0
                this.anInt4084 = var16[0];
                this.anInt4086 = Class31.anInt582;
            }

            HDToolKit.bindTexture2D(this.anInt4084);
            glTexImage2D(GL_TEXTURE_2D, 0, GL_LUMINANCE_ALPHA, this.anInt4087, this.anInt4087, 0, GL_LUMINANCE_ALPHA, GL_UNSIGNED_BYTE, var14);
            Class31.memory2D += var14.limit() - this.anInt4083;
            this.anInt4083 = var14.limit();
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        }
    }
}
