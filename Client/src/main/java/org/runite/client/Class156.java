package org.runite.client;

import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL15.*;


final class Class156 {

    private final int anInt1992;
    private final boolean aBoolean1994;
    private int anInt1991;
    private int anInt1993;


    public Class156() {
        this(false);
    }

    Class156(boolean var1) {
        this.anInt1991 = -1;
        this.anInt1993 = 0;
        int[] var3 = new int[1];
        glGenBuffers(var3);//1, buffer, 0 OLD
        this.aBoolean1994 = var1;
        this.anInt1991 = var3[0];
        this.anInt1992 = Class31.anInt582;
    }

    final void method2168(ByteBuffer var1) {
        if (var1.limit() <= this.anInt1993) {
            glBindBuffer(GL_ARRAY_BUFFER, this.anInt1991);
            glBufferSubData(GL_ARRAY_BUFFER,0, var1);//34962, 0, var1.limit(), var1
        } else {
            this.method2172(var1);
        }

    }

    protected final void finalize() throws Throwable {
        if (this.anInt1991 != -1) {
            Class31.method989(this.anInt1991, this.anInt1993, this.anInt1992);
            this.anInt1991 = -1;
            this.anInt1993 = 0;
        }

        super.finalize();
    }

    final void method2169() {
        glBindBuffer(GL_ARRAY_BUFFER, this.anInt1991);
    }

    final void method2170(ByteBuffer var1) {
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, this.anInt1991);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, var1, this.aBoolean1994 ? GL_STREAM_DRAW : GL_STATIC_DRAW);//34963, var1.limit(), buffer, '\u88e0' : '\u88e4'
        Class31.anInt585 += var1.limit() - this.anInt1993;
        this.anInt1993 = var1.limit();
    }

    final void method2171() {
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, this.anInt1991);
    }

    final void method2172(ByteBuffer var1) {
        glBindBuffer(GL_ARRAY_BUFFER, this.anInt1991);
        glBufferData(GL_ARRAY_BUFFER, var1, this.aBoolean1994 ? GL_STREAM_DRAW : GL_STATIC_DRAW);//34962, var1.limit(), buffer, '\u88e0' : '\u88e4'
        Class31.anInt585 += var1.limit() - this.anInt1993;
        this.anInt1993 = var1.limit();
    }
}
