package org.runite.client;
import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.glGetFloatv;
import static org.lwjgl.opengl.GL14.*;


final class Class127_Sub1 extends LoginHandler {

    private static int anInt2682;

    static {
        new Class128();
        anInt2682 = 2;
        new DataBuffer(131056);
    }

    static void method1755() {
        //TODO: Find LWJGL equivalent
//        if (var0.isExtensionAvailable("GL_ARB_point_parameters")) {
//            float[] var1 = new float[]{1.0F, 0.0F, 5.0E-4F};
//            glPointParameterfv(GL_POINT_DISTANCE_ATTENUATION, var1);//'\u8129', var1, 0
//            FloatBuffer var2 = FloatBuffer.allocate(1);
//            glGetFloatv(GL_POINT_SIZE_MAX, var2);
//            float var3 = var2.get(0);
//            if (var3 > 1024.0F) {
//                var3 = 1024.0F;
//            }
//
//            glPointParameterf(GL_POINT_SIZE_MIN, 1.0F);
//            glPointParameterf(GL_POINT_SIZE_MAX, var3);
//        }
        // Temporary work around until we can find out a way to check if the extensions are available
        float[] var1 = new float[]{1.0F, 0.0F, 5.0E-4F};
        glPointParameterfv(GL_POINT_DISTANCE_ATTENUATION, var1);//'\u8129', var1, 0
        FloatBuffer var2 = FloatBuffer.allocate(1);
        glGetFloatv(GL_POINT_SIZE_MAX, var2);
        float var3 = var2.get(0);
        if (var3 > 1024.0F) {
            var3 = 1024.0F;
        }

        glPointParameterf(GL_POINT_SIZE_MIN, 1.0F);
        glPointParameterf(GL_POINT_SIZE_MAX, var3);

//        if (var0.isExtensionAvailable("GL_ARB_point_sprite")) {
//
//        }

    }

    static int method1757() {
        return anInt2682;
    }

    static void method1758(int var0) {
        anInt2682 = var0;
    }
}
