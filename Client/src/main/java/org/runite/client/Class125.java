package org.runite.client;


import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.charset.StandardCharsets;

import static org.lwjgl.opengl.ARBFragmentProgram.GL_FRAGMENT_PROGRAM_ARB;
import static org.lwjgl.opengl.ARBVertexProgram.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;


final class Class125 implements ShaderInterface {

    private static final float[] aFloatArray2185 = new float[4];
    private int anInt2182 = -1;
    private FloatBuffer aFloatBuffer2183;
    private int anInt2184;
    private int anInt2186 = -1;


    public Class125() {
        if (HDToolKit.supportVertexProgram && HDToolKit.maxTextureUnits >= 2) {
            int[] var1 = new int[1];
            glGenProgramsARB(var1);//1, buffer, 0 OLD
            this.anInt2184 = var1[0];
            int[][] var3 = method895(0);
            int[][] var4 = method895(8);
            DataBuffer var5 = new DataBuffer(262144);

            for (int var6 = 0; var6 < 256; ++var6) {
                int[] var7 = var3[var6];
                int[] var8 = var4[var6];

                for (int var9 = 0; var9 < 64; ++var9) {
                    if (HDToolKit.aBoolean1790) {
                        var5.writeFloat((float) var7[var9] / 4096.0F);
                        var5.writeFloat((float) var8[var9] / 4096.0F);
                        var5.writeFloat(1.0F);
                        var5.writeFloat(1.0F);
                    } else {
                        var5.writeFloatLE((float) var7[var9] / 4096.0F);
                        var5.writeFloatLE((float) var8[var9] / 4096.0F);
                        var5.writeFloatLE(1.0F);
                        var5.writeFloatLE(1.0F);
                    }
                }
            }

            ByteBuffer var10 = ByteBuffer.allocateDirect(var5.index).order(ByteOrder.nativeOrder());
            var10.put(var5.buffer, 0, var5.index);
            var10.flip();
            this.aFloatBuffer2183 = var10.asFloatBuffer().asReadOnlyBuffer();
            this.method1749();
            this.method1750();
        }

    }

    static int[][] method895(int var4) {
        try {
            int[][] var9 = new int[256][64];
            Class3_Sub13_Sub4 var10 = new Class3_Sub13_Sub4();
            var10.anInt3062 = (int) ((float) 0.4 * 4096.0F);
            var10.anInt3058 = 3;
            var10.anInt3056 = 4;
            var10.aBoolean3065 = false;
            var10.anInt3060 = 8;
            var10.method158(16251);
            Class3_Sub13_Sub3.method180(122, 256, 64);

            for (int var11 = 0; var11 < 256; ++var11) {
                var10.method186(var11, var9[var11]);
            }

            return var9;
        } catch (RuntimeException var12) {
            throw ClientErrorException.clientError(var12, "cj.B(" + false + ',' + 3 + ',' + 64 + ',' + 256 + ',' + var4 + ',' + 4 + ',' + 8 + ',' + (float) 0.4 + ')');
        }
    }

    public final void method21() {
        if (this.anInt2186 >= 0) {
            glCallList(this.anInt2186 + 1);
        }
    }

    public final int method24() {
        return 0;
    }

    public final void method22() {
        if (this.anInt2186 >= 0) {
            glCallList(this.anInt2186);
            glActiveTexture(GL_TEXTURE1);
            glMatrixMode(GL_TEXTURE);
            glTranslatef((float) Unsorted.anInt144, (float) Unsorted.anInt3695, (float) LinkableRSString.anInt2587);
            glRotatef(-((float) Class3_Sub13_Sub8.anInt3103 * 360.0F) / 2048.0F, 0.0F, 1.0F, 0.0F);
            glRotatef(-((float) Class140_Sub7.anInt2938 * 360.0F) / 2048.0F, 1.0F, 0.0F, 0.0F);
            glRotatef(-180.0F, 1.0F, 0.0F, 0.0F);
            glMatrixMode(GL_MODELVIEW);
            if (!Class88.Texture3DEnabled) {
                glBindTexture(GL_TEXTURE_2D, Class88.anIntArray1224[(int) ((float) (HDToolKit.anInt1791 * 64) * 0.0050F) % 64]);
            }

            glActiveTexture(GL_TEXTURE0);
            if (this.anInt2182 != HDToolKit.anInt1791) {
                int var2 = (HDToolKit.anInt1791 & 255) * 256;

                for (int var3 = 0; var3 < 64; ++var3) {
                    this.aFloatBuffer2183.position(var2);
                    glProgramLocalParameter4fvARB(GL_VERTEX_PROGRAM_ARB, var3, this.aFloatBuffer2183);
                    var2 += 4;
                }

                if (Class88.Texture3DEnabled) {
                    glProgramLocalParameter4fARB(GL_VERTEX_PROGRAM_ARB, 65, (float) HDToolKit.anInt1791 * 0.0050F, 0.0F, 0.0F, 1.0F);
                } else {
                    glProgramLocalParameter4fARB(GL_VERTEX_PROGRAM_ARB, 65, 0.0F, 0.0F, 0.0F, 1.0F);
                }

                this.anInt2182 = HDToolKit.anInt1791;
            }

        }
    }

    private void method1749() {
        this.anInt2186 = glGenLists(2);
        glNewList(this.anInt2186, GL_COMPILE);
        glActiveTexture(GL_TEXTURE1);
        if (Class88.Texture3DEnabled) {
            glBindTexture(GL_TEXTURE_3D, Class88.anInt1228);
        }
        glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_RGB, GL_ADD);
        glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_ALPHA, GL_REPLACE);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_ALPHA, GL_PREVIOUS);
        glActiveTexture(GL_TEXTURE0);
        glBindProgramARB(GL_VERTEX_PROGRAM_ARB, this.anInt2184);
        glEnable(GL_VERTEX_PROGRAM_ARB);
        glEndList();
        glNewList(this.anInt2186 + 1, GL_COMPILE);
        glActiveTexture(GL_TEXTURE1);
        glMatrixMode(GL_TEXTURE);
        glLoadIdentity();
        glMatrixMode(GL_MODELVIEW);
        glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_RGB, GL_MODULATE);
        glTexEnvi(GL_TEXTURE_ENV, GL_COMBINE_ALPHA, GL_MODULATE);
        glTexEnvi(GL_TEXTURE_ENV, GL_SOURCE0_ALPHA, GL_TEXTURE);
        glDisable(Class88.Texture3DEnabled ? GL_TEXTURE_3D : GL_TEXTURE_2D);
        glActiveTexture(GL_TEXTURE0);
        glBindProgramARB(GL_VERTEX_PROGRAM_ARB, 0);
        glDisable(GL_VERTEX_PROGRAM_ARB);
        glDisable(GL_FRAGMENT_PROGRAM_ARB);
        glEndList();
    }

    private void method1750() {
        if (this.anInt2186 >= 0) {
            int[] var2 = new int[1];
            glBindProgramARB(GL_VERTEX_PROGRAM_ARB, this.anInt2184);
            //This should work, if it throws errors the script will have to be loaded externally
            glProgramStringARB(GL_VERTEX_PROGRAM_ARB, GL_PROGRAM_FORMAT_ASCII_ARB, vp_str);
            //glProgramStringARB(GL_VERTEX_PROGRAM_ARB, GL_PROGRAM_FORMAT_ASCII_ARB, "!!ARBvp1.0\nATTRIB  iPos         = vertex.position;\nATTRIB  iColour      = vertex.color;\nOUTPUT  oPos         = result.position;\nOUTPUT  oColour      = result.color;\nOUTPUT  oTexCoord0   = result.texcoord[0];\nOUTPUT  oTexCoord1   = result.texcoord[1];\nOUTPUT  oFogCoord    = result.fogcoord;\nPARAM   time         = program.local[65];\nPARAM   turbulence   = program.local[64];\nPARAM   lightAmbient = program.local[66]; \nPARAM   pMatrix[4]   = { state.matrix.projection };\nPARAM   mvMatrix[4]  = { state.matrix.modelview };\nPARAM   ivMatrix[4]  = { state.matrix.texture[1] };\nPARAM   fNoise[64]   = { program.local[0..63] };\nTEMP    noise, clipPos, viewPos, worldPos;\nADDRESS noiseAddr;\nDP4   viewPos.x, mvMatrix[0], iPos;\nDP4   viewPos.y, mvMatrix[1], iPos;\nDP4   viewPos.z, mvMatrix[2], iPos;\nDP4   viewPos.w, mvMatrix[3], iPos;\nDP4   worldPos.x, ivMatrix[0], viewPos;\nDP4   worldPos.y, ivMatrix[1], viewPos;\nDP4   worldPos.z, ivMatrix[2], viewPos;\nDP4   worldPos.w, ivMatrix[3], viewPos;\nADD   noise.x, worldPos.x, worldPos.z;SUB   noise.y, worldPos.z, worldPos.x;MUL   noise, noise, 0.0001220703125;\nFRC   noise, noise;\nMUL   noise, noise, 64;\nARL   noiseAddr.x, noise.x;\nMOV   noise.x, fNoise[noiseAddr.x].x;\nARL   noiseAddr.x, noise.y;\nMOV   noise.y, fNoise[noiseAddr.x].y;\nMUL   noise, noise, turbulence.x;\nMAD   oTexCoord0, worldPos.xzww, 0.0078125, noise;\nMOV   oTexCoord0.w, 1;\nMUL   oTexCoord1.xy, worldPos.xzww, 0.0009765625;\nMOV   oTexCoord1.zw, time.xxxw;\nDP4   clipPos.x, pMatrix[0], viewPos;\nDP4   clipPos.y, pMatrix[1], viewPos;\nDP4   clipPos.z, pMatrix[2], viewPos;\nDP4   clipPos.w, pMatrix[3], viewPos;\nMUL   oColour.xyz, iColour, lightAmbient;\nMOV   oColour.w, 1;\nMOV   oFogCoord.x, clipPos.z;\nMOV   oPos, clipPos; \nEND".length(), "!!ARBvp1.0\nATTRIB  iPos         = vertex.position;\nATTRIB  iColour      = vertex.color;\nOUTPUT  oPos         = result.position;\nOUTPUT  oColour      = result.color;\nOUTPUT  oTexCoord0   = result.texcoord[0];\nOUTPUT  oTexCoord1   = result.texcoord[1];\nOUTPUT  oFogCoord    = result.fogcoord;\nPARAM   time         = program.local[65];\nPARAM   turbulence   = program.local[64];\nPARAM   lightAmbient = program.local[66]; \nPARAM   pMatrix[4]   = { state.matrix.projection };\nPARAM   mvMatrix[4]  = { state.matrix.modelview };\nPARAM   ivMatrix[4]  = { state.matrix.texture[1] };\nPARAM   fNoise[64]   = { program.local[0..63] };\nTEMP    noise, clipPos, viewPos, worldPos;\nADDRESS noiseAddr;\nDP4   viewPos.x, mvMatrix[0], iPos;\nDP4   viewPos.y, mvMatrix[1], iPos;\nDP4   viewPos.z, mvMatrix[2], iPos;\nDP4   viewPos.w, mvMatrix[3], iPos;\nDP4   worldPos.x, ivMatrix[0], viewPos;\nDP4   worldPos.y, ivMatrix[1], viewPos;\nDP4   worldPos.z, ivMatrix[2], viewPos;\nDP4   worldPos.w, ivMatrix[3], viewPos;\nADD   noise.x, worldPos.x, worldPos.z;SUB   noise.y, worldPos.z, worldPos.x;MUL   noise, noise, 0.0001220703125;\nFRC   noise, noise;\nMUL   noise, noise, 64;\nARL   noiseAddr.x, noise.x;\nMOV   noise.x, fNoise[noiseAddr.x].x;\nARL   noiseAddr.x, noise.y;\nMOV   noise.y, fNoise[noiseAddr.x].y;\nMUL   noise, noise, turbulence.x;\nMAD   oTexCoord0, worldPos.xzww, 0.0078125, noise;\nMOV   oTexCoord0.w, 1;\nMUL   oTexCoord1.xy, worldPos.xzww, 0.0009765625;\nMOV   oTexCoord1.zw, time.xxxw;\nDP4   clipPos.x, pMatrix[0], viewPos;\nDP4   clipPos.y, pMatrix[1], viewPos;\nDP4   clipPos.z, pMatrix[2], viewPos;\nDP4   clipPos.w, pMatrix[3], viewPos;\nMUL   oColour.xyz, iColour, lightAmbient;\nMOV   oColour.w, 1;\nMOV   oFogCoord.x, clipPos.z;\nMOV   oPos, clipPos; \nEND");
            glGetIntegerv(GL_PROGRAM_ERROR_POSITION_ARB, var2);//int, buffer, 0 OLD
            if (var2[0] != -1) {
                return;
            }
        }
    }

    public final void method23(int var1) {
        if (this.anInt2186 >= 0) {
            glActiveTexture(GL_TEXTURE1);
            if ((var1 & 128) == 0) {
                glEnable(Class88.Texture3DEnabled ? GL_TEXTURE_3D : GL_TEXTURE_2D);
            } else {
                glDisable(Class88.Texture3DEnabled ? GL_TEXTURE_3D : GL_TEXTURE_2D);
            }

            glActiveTexture(GL_TEXTURE0);
            if ((var1 & 64) == 0) {
                glGetFloatv(GL_LIGHT_MODEL_AMBIENT, aFloatArray2185);
                glProgramLocalParameter4fvARB(GL_VERTEX_PROGRAM_ARB, 66, aFloatArray2185);
            } else {
                glProgramLocalParameter4fARB(GL_VERTEX_PROGRAM_ARB, 66, 1.0F, 1.0F, 1.0F, 1.0F);
            }

            int var3 = var1 & 3;
            if (var3 == 2) {
                glProgramLocalParameter4fARB(GL_VERTEX_PROGRAM_ARB, 64, 0.05F, 1.0F, 1.0F, 1.0F);
            } else if (var3 == 3) {
                glProgramLocalParameter4fARB(GL_VERTEX_PROGRAM_ARB, 64, 0.1F, 1.0F, 1.0F, 1.0F);
            } else {
                glProgramLocalParameter4fARB(GL_VERTEX_PROGRAM_ARB, 64, 0.025F, 1.0F, 1.0F, 1.0F);
            }

        }
    }

    ByteBuffer vp_str = StandardCharsets.UTF_8.encode(
            "!!ARBvp1.0\n" +
            "ATTRIB  iPos         = vertex.position;\n" +
            "ATTRIB  iColour      = vertex.color;\n" +
            "OUTPUT  oPos         = result.position;\n" +
            "OUTPUT  oColour      = result.color;\n" +
            "OUTPUT  oTexCoord0   = result.texcoord[0];\n" +
            "OUTPUT  oTexCoord1   = result.texcoord[1];\n" +
            "OUTPUT  oFogCoord    = result.fogcoord;\n" +
            "PARAM   time         = program.local[65];\n" +
            "PARAM   turbulence   = program.local[64];\n" +
            "PARAM   lightAmbient = program.local[66]; \n" +
            "PARAM   pMatrix[4]   = { state.matrix.projection };\n" +
            "PARAM   mvMatrix[4]  = { state.matrix.modelview };\n" +
            "PARAM   ivMatrix[4]  = { state.matrix.texture[1] };\n" +
            "PARAM   fNoise[64]   = { program.local[0..63] };\n" +
            "TEMP    noise, clipPos, viewPos, worldPos;\n" +
            "ADDRESS noiseAddr;\n" +
            "DP4   viewPos.x, mvMatrix[0], iPos;\n" +
            "DP4   viewPos.y, mvMatrix[1], iPos;\n" +
            "DP4   viewPos.z, mvMatrix[2], iPos;\n" +
            "DP4   viewPos.w, mvMatrix[3], iPos;\n" +
            "DP4   worldPos.x, ivMatrix[0], viewPos;\n" +
            "DP4   worldPos.y, ivMatrix[1], viewPos;\n" +
            "DP4   worldPos.z, ivMatrix[2], viewPos;\n" +
            "DP4   worldPos.w, ivMatrix[3], viewPos;\n" +
            "ADD   noise.x, worldPos.x, worldPos.z;SUB   noise.y, worldPos.z, worldPos.x;MUL   noise, noise, 0.0001220703125;\n" +
            "FRC   noise, noise;\n" +
            "MUL   noise, noise, 64;\n" +
            "ARL   noiseAddr.x, noise.x;\n" +
            "MOV   noise.x, fNoise[noiseAddr.x].x;\n" +
            "ARL   noiseAddr.x, noise.y;\n" +
            "MOV   noise.y, fNoise[noiseAddr.x].y;\n" +
            "MUL   noise, noise, turbulence.x;\n" +
            "MAD   oTexCoord0, worldPos.xzww, 0.0078125, noise;\n" +
            "MOV   oTexCoord0.w, 1;\n" +
            "MUL   oTexCoord1.xy, worldPos.xzww, 0.0009765625;\n" +
            "MOV   oTexCoord1.zw, time.xxxw;\n" +
            "DP4   clipPos.x, pMatrix[0], viewPos;\n" +
            "DP4   clipPos.y, pMatrix[1], viewPos;\n" +
            "DP4   clipPos.z, pMatrix[2], viewPos;\n" +
            "DP4   clipPos.w, pMatrix[3], viewPos;\n" +
            "MUL   oColour.xyz, iColour, lightAmbient;\n" +
            "MOV   oColour.w, 1;\n" +
            "MOV   oFogCoord.x, clipPos.z;\n" +
            "MOV   oPos, clipPos; \n" +
            "END");

}
