package org.runite.client;

import java.awt.*;

abstract class Class158 {

    static int anInt2005 = -2;
    static byte[][][] aByteArrayArrayArray2008;
    static int anInt2010 = -16 + (int) (33.0D * Math.random());
    static int anInt2014 = 0;
    static int anInt2015;
    int[] anIntArray2007;
    Image anImage2009;
    int anInt2011;
    int anInt2012;

    static void method2180(CacheIndex var0, CacheIndex var1) {
        Unsorted.aClass153_4048 = var0;
        Class3_Sub13_Sub18.aClass153_3214 = var1;
    }

    static void method2183(int parent, boolean notifyScripts, int parentWidth, int parentHeight, RSInterface[] ifaces) {
        int var6 = 0;
        for (; ifaces.length > var6; ++var6) {
            RSInterface inface = ifaces[var6];
            if (inface != null && inface.parentId == parent) {
                Unsorted.calculateInterfaceSize(inface, parentWidth, parentHeight, notifyScripts);
                Unsorted.calculateInterfacePosition(inface, parentWidth, parentHeight);
                if (inface.anInt247 > inface.anInt240 - inface.width) {
                    inface.anInt247 = inface.anInt240 - inface.width;
                }

                if (inface.anInt208 > -inface.height + inface.anInt252) {
                    inface.anInt208 = inface.anInt252 - inface.height;
                }

                if (inface.anInt208 < 0) {
                    inface.anInt208 = 0;
                }

                if (inface.anInt247 < 0) {
                    inface.anInt247 = 0;
                }

                if (inface.type == 0) {
                    Unsorted.method2104(inface, notifyScripts, 235 + -343);
                }
            }
        }
    }

    static void method2186(Class25 var0) {
        for (int var1 = var0.anInt483; var1 <= var0.anInt495; ++var1) {
            for (int var2 = var0.anInt478; var2 <= var0.anInt481; ++var2) {
                Class3_Sub2 var3 = Class75_Sub2.aClass3_Sub2ArrayArrayArray2638[var0.anInt493][var1][var2];
                if (var3 != null) {
                    int var4;
                    for (var4 = 0; var4 < var3.anInt2223; ++var4) {
                        if (var3.aClass25Array2221[var4] == var0) {
                            --var3.anInt2223;

                            for (int var5 = var4; var5 < var3.anInt2223; ++var5) {
                                var3.aClass25Array2221[var5] = var3.aClass25Array2221[var5 + 1];
                                var3.anIntArray2237[var5] = var3.anIntArray2237[var5 + 1];
                            }

                            var3.aClass25Array2221[var3.anInt2223] = null;
                            break;
                        }
                    }

                    var3.anInt2228 = 0;

                    for (var4 = 0; var4 < var3.anInt2223; ++var4) {
                        var3.anInt2228 |= var3.anIntArray2237[var4];
                    }
                }
            }
        }

    }

    abstract void method2179(Graphics var3);

    final void method2182() {
        Class74.setBuffer(this.anIntArray2007, this.anInt2012, this.anInt2011);
    }

    abstract void drawGraphics(int var1, int var2, int var4, Graphics var5, int var6);

    abstract void method2185(int var1, int var3, Component var4);

}
