package org.runite.client;

import org.rs09.client.Linkable;

public final class Class3_Sub10 extends Linkable {

    static byte[][][] aByteArrayArrayArray2339;
    public RSString value;


    public Class3_Sub10() {
    }

    public Class3_Sub10(RSString var1, int var2) {
        try {
            this.value = var1;
        } catch (RuntimeException var4) {
            throw ClientErrorException.clientError(var4, "hb.<init>(" + (var1 != null ? "{...}" : "null") + ',' + var2 + ')');
        }
    }

    static void method138(RSString var0) {
        try {
            Unsorted.method1250(93, false);
            Class75.method1339(var0);
        } catch (RuntimeException var3) {
            throw ClientErrorException.clientError(var3, "hb.F(" + (var0 != null ? "{...}" : "null") + ',' + 0 + ')');
        }
    }

    static boolean method140(int var0) {
        try {
            return (var0 >= 0 && Class3_Sub24_Sub4.aBooleanArray3503.length > var0) && Class3_Sub24_Sub4.aBooleanArray3503[var0];
        } catch (RuntimeException var3) {
            throw ClientErrorException.clientError(var3, "hb.A(" + var0 + ',' + 20 + ')');
        }
    }

}
