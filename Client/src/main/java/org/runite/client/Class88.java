package org.runite.client;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;

import java.nio.ByteBuffer;


final class Class88 {

    static int[] anIntArray1223 = null;
    static int[] anIntArray1224 = null;
    static boolean Texture3DEnabled;
    static int anInt1228 = -1;
    private static ByteBuffer aByteBuffer1225;
    private static ByteBuffer aByteBuffer1226;

    static void method1454() {
        byte[] var1;
        if (aByteBuffer1226 == null) {
            Class164_Sub2_Sub1 var0 = new Class164_Sub2_Sub1();
            var1 = var0.method2250();
            aByteBuffer1226 = ByteBuffer.allocateDirect(var1.length);
            aByteBuffer1226.position(0);
            aByteBuffer1226.put(var1);
            aByteBuffer1226.flip();
        }

        if (aByteBuffer1225 == null) {
            Class164_Sub1_Sub1 var2 = new Class164_Sub1_Sub1();
            var1 = var2.method2243();
            aByteBuffer1225 = ByteBuffer.allocateDirect(var1.length);
            aByteBuffer1225.position(0);
            aByteBuffer1225.put(var1);
            aByteBuffer1225.flip();
        }

    }

    static void method1455() {
        int[] var1;
        if (anInt1228 != -1) {
            var1 = new int[]{anInt1228};
            glDeleteTextures(var1);//1, array, 0
            anInt1228 = -1;
            Class31.anInt580 -= aByteBuffer1226.limit() * 2;
        }

        if (anIntArray1224 != null) {
            glDeleteTextures(anIntArray1224);//64, array, 0
            anIntArray1224 = null;
            Class31.anInt580 -= aByteBuffer1226.limit() * 2;
        }

        if (WaterfallShader.waterfallTextureId != -1) {
            var1 = new int[]{WaterfallShader.waterfallTextureId};
            glDeleteTextures(var1);//1, array, 0
            WaterfallShader.waterfallTextureId = -1;
            Class31.anInt580 -= aByteBuffer1225.limit() * 2;
        }

        if (anIntArray1223 != null) {
            glDeleteTextures(anIntArray1223);
            anIntArray1223 = null;
            Class31.anInt580 -= aByteBuffer1225.limit() * 2;
        }

    }

    static void method1456() {
        Texture3DEnabled = HDToolKit.allows3DTextureMapping;
        method1454();
        method1458();
        method1459();
    }

    private static void method1458() {
        if (Texture3DEnabled) {
            int[] var1 = new int[1];
            glGenTextures(var1);//1, array, 0
            glBindTexture(GL_TEXTURE_3D, var1[0]);
            aByteBuffer1226.position(0);
            glTexImage3D(GL_TEXTURE_3D, 0, GL_LUMINANCE_ALPHA, 64, 64, 64, 0, GL_LUMINANCE_ALPHA, GL_UNSIGNED_BYTE, aByteBuffer1226);
            glTexParameteri(GL_TEXTURE_3D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
            glTexParameteri(GL_TEXTURE_3D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
            anInt1228 = var1[0];
        } else {
            anIntArray1224 = new int[64];
            glGenTextures(anIntArray1224);//64, array, 0

            for (int var2 = 0; var2 < 64; ++var2) {
                HDToolKit.bindTexture2D(anIntArray1224[var2]);
                aByteBuffer1226.position(var2 * 64 * 64 * 2);
                glTexImage2D(GL_TEXTURE_2D, 0, GL_LUMINANCE_ALPHA, 64, 64, 0, GL_LUMINANCE_ALPHA, GL_UNSIGNED_BYTE, aByteBuffer1226);
                glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
                glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
            }

        }
        Class31.anInt580 += aByteBuffer1226.limit() * 2;

    }

    private static void method1459() {
        if (Texture3DEnabled) {
            int[] var1 = new int[1];
            glGenTextures(var1);//1, array, 0
            glBindTexture(GL_TEXTURE_3D, var1[0]);
            aByteBuffer1225.position(0);
            glTexImage3D(GL_TEXTURE_3D, 0, GL_LUMINANCE_ALPHA, 64, 64, 64, 0, GL_LUMINANCE_ALPHA, GL_UNSIGNED_BYTE, aByteBuffer1225);
            glTexParameteri(GL_TEXTURE_3D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
            glTexParameteri(GL_TEXTURE_3D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
            WaterfallShader.waterfallTextureId = var1[0];
        } else {
            anIntArray1223 = new int[64];
            glGenTextures(anIntArray1223);//64, array, 0

            for (int var2 = 0; var2 < 64; ++var2) {
                HDToolKit.bindTexture2D(anIntArray1223[var2]);
                aByteBuffer1225.position(var2 * 64 * 64 * 2);
                glTexImage2D(GL_TEXTURE_2D, 0, GL_LUMINANCE_ALPHA, 64, 64, 0, GL_LUMINANCE_ALPHA, GL_UNSIGNED_BYTE, aByteBuffer1225);
                glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
                glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
            }

        }
        Class31.anInt580 += aByteBuffer1225.limit() * 2;

    }

}
