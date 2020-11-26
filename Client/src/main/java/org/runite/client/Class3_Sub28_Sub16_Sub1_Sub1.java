package org.runite.client;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;

import java.nio.ByteBuffer;


final class Class3_Sub28_Sub16_Sub1_Sub1 extends HDSprite {

    Class3_Sub28_Sub16_Sub1_Sub1(int var1, int var2, int var3, int var4, int var5, int var6, int[] var7) {
        super(var1, var2, var3, var4, var5, var6, var7);
    }

    Class3_Sub28_Sub16_Sub1_Sub1(Class3_Sub28_Sub16_Sub2 var1) {
        super(var1);
    }

    final void method650(int[] var1) {
        this.anInt4075 = Class95.method1585((byte) 111, this.anInt3707);
        this.anInt4079 = Class95.method1585((byte) 76, this.anInt3696);
        byte[] var2 = new byte[this.anInt4075 * this.anInt4079 * 4];
        int var3 = 0;
        int var4 = 0;
        int var5 = (this.anInt4075 - this.anInt3707) * 4;

        for (int var6 = 0; var6 < this.anInt3696; ++var6) {
            for (int var7 = 0; var7 < this.anInt3707; ++var7) {
                int var8 = var1[var4++];
                if (var8 == 0) {
                    var3 += 4;
                } else {
                    var2[var3++] = (byte) (var8 >> 16);
                    var2[var3++] = (byte) (var8 >> 8);
                    var2[var3++] = (byte) var8;
                    var2[var3++] = (byte) (var8 >> 24);
                }
            }

            var3 += var5;
        }

        ByteBuffer var9 = ByteBuffer.wrap(var2);
        if (this.anInt4077 == -1) {
            int[] var11 = new int[1];
            glGenTextures(var11);//1, array, 0
            this.anInt4077 = var11[0];
        }

        HDToolKit.bindTexture2D(this.anInt4077);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, this.anInt4075, this.anInt4079, 0, GL_RGBA, GL_UNSIGNED_BYTE, var9);
        Class31.memory2D += var9.limit() - this.anInt4074;
        this.anInt4074 = var9.limit();
    }
}
