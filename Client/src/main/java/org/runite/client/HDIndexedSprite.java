package org.runite.client;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;

import java.nio.ByteBuffer;


final class HDIndexedSprite extends AbstractIndexedSprite {

    private int anInt2675 = -1;
    private int anInt2676 = -1;
    private int anInt2677 = 0;
    private int anInt2678 = 0;
    private int anInt2679;
    private int anInt2680;
    private int anInt2681;


    HDIndexedSprite(int var1, int var2, int var3, int var4, int var5, int var6, byte[] var7, int[] var8) {
        this.anInt1469 = var1;
        this.anInt1467 = var2;
        this.anInt1470 = var3;
        this.anInt1464 = var4;
        this.width = var5;
        this.height = var6;
        this.method1678(var7, var8);
        this.method1680();
    }

    private void method1678(byte[] var1, int[] var2) {
        this.anInt2681 = Class95.method1585((byte) 62, this.width);
        this.anInt2680 = Class95.method1585((byte) 99, this.height);
        byte[] var3 = new byte[this.anInt2681 * this.anInt2680 * 4];
        int var4 = 0;
        int var5 = 0;

        for (int var6 = 0; var6 < this.height; ++var6) {
            for (int var7 = 0; var7 < this.width; ++var7) {
                // Hd Fix
                if (var1[var5] < 0) {
                    return;
                }
                byte var8 = var1[var5++];
                if (var8 == 0) {
                    var4 += 4;
                } else {
                    int var9 = var2[var8];
                    var3[var4++] = (byte) (var9 >> 16);
                    var3[var4++] = (byte) (var9 >> 8);
                    var3[var4++] = (byte) var9;
                    var3[var4++] = -1;
                }
            }
            var4 += (this.anInt2681 - this.width) * 4;
        }
        ByteBuffer byteBuffer = ByteBuffer.wrap(var3);
        if (this.anInt2675 == -1) {
            int[] var12 = new int[1];
            glGenTextures(var12);//1, array, 0
            this.anInt2675 = var12[0];
            this.anInt2679 = Class31.anInt582;
        }

        HDToolKit.bindTexture2D(this.anInt2675);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, this.anInt2681, this.anInt2680, 0, GL_RGBA, GL_UNSIGNED_BYTE, byteBuffer);
        Class31.memory2D += byteBuffer.limit() - this.anInt2678;
        this.anInt2678 = byteBuffer.limit();
    }

    final void method1666(int var1, int var2, int var3) {
        HDToolKit.method1828();
        var1 += this.anInt1470;
        var2 += this.anInt1464;
        HDToolKit.bindTexture2D(this.anInt2675);
        this.method1679();
        glColor4f(1.0F, 1.0F, 1.0F, (float) var3 / 256.0F);
        glTranslatef((float) var1, (float) (HDToolKit.viewHeight - var2), 0.0F);
        glCallList(this.anInt2676);
        glLoadIdentity();
    }

    private void method1679() {
        if (this.anInt2677 != 1) {
            this.anInt2677 = 1;
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        }
    }

    final void method1667(int var1, int var2) {
        HDToolKit.method1822();
        var1 += this.anInt1470;
        var2 += this.anInt1464;
        HDToolKit.bindTexture2D(this.anInt2675);
        this.method1679();
        glTranslatef((float) var1, (float) (HDToolKit.viewHeight - var2), 0.0F);
        glCallList(this.anInt2676);
        glLoadIdentity();
    }

    protected final void finalize() throws Throwable {
        if (this.anInt2675 != -1) {
            Class31.method991(this.anInt2675, this.anInt2678, this.anInt2679);
            this.anInt2675 = -1;
            this.anInt2678 = 0;
        }

        if (this.anInt2676 != -1) {
            Class31.method986(this.anInt2676, this.anInt2679);
            this.anInt2676 = -1;
        }

        super.finalize();
    }

    private void method1680() {
        float var1 = (float) this.width / (float) this.anInt2681;
        float var2 = (float) this.height / (float) this.anInt2680;
        if (this.anInt2676 == -1) {
            this.anInt2676 = glGenLists(1);
            this.anInt2679 = Class31.anInt582;
        }

        glNewList(this.anInt2676, GL_COMPILE);
        glBegin(GL_TRIANGLE_FAN);
        glTexCoord2f(var1, 0.0F);
        glVertex2f((float) this.width, 0.0F);
        glTexCoord2f(0.0F, 0.0F);
        glVertex2f(0.0F, 0.0F);
        glTexCoord2f(0.0F, var2);
        glVertex2f(0.0F, (float) (-this.height));
        glTexCoord2f(var1, var2);
        glVertex2f((float) this.width, (float) (-this.height));
        glEnd();
        glEndList();
    }
}
