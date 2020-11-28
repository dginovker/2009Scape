package org.runite.client;

import java.util.Calendar;
import java.util.Date;

final class Class15 implements Runnable {

    static short[][] aShortArrayArray344;
    static int anInt4034 = -8 + (int) (17.0D * Math.random());
    static boolean aBoolean346;
    static int[] localNPCIndexes = new int['\u8000'];
    static Class64 aClass64_351;
    volatile boolean aBoolean345 = false;
    Signlink aClass87_350;
    volatile Class155[] aClass155Array352 = new Class155[2];
    volatile boolean aBoolean353 = false;


    static RSString method894(long var0) {
        try {
            Class3_Sub28_Sub5.aCalendar3581.setTime(new Date(var0));
            int var3 = Class3_Sub28_Sub5.aCalendar3581.get(Calendar.DAY_OF_WEEK);//Day of the week
            int var4 = Class3_Sub28_Sub5.aCalendar3581.get(Calendar.DATE);
            int var5 = Class3_Sub28_Sub5.aCalendar3581.get(Calendar.MONTH);
            int var6 = Class3_Sub28_Sub5.aCalendar3581.get(Calendar.YEAR);
            int var7 = Class3_Sub28_Sub5.aCalendar3581.get(Calendar.HOUR_OF_DAY);
            int var8 = Class3_Sub28_Sub5.aCalendar3581.get(Calendar.MINUTE);
            int var9 = Class3_Sub28_Sub5.aCalendar3581.get(Calendar.SECOND);
            return RSString.stringCombiner(new RSString[]{TextCore.DaysOfTheWeek[var3 + -1], TextCore.aClass94_3145, RSString.stringAnimator(var4 / 10), RSString.stringAnimator(var4 % 10), TextCore.aClass94_2025, TextCore.MonthsOfTheYear[var5], TextCore.aClass94_2025, RSString.stringAnimator(var6), TextCore.aClass94_465, RSString.stringAnimator(var7 / 10), RSString.stringAnimator(var7 % 10), TextCore.char_colon, RSString.stringAnimator(var8 / 10), RSString.stringAnimator(var8 % 10), TextCore.char_colon, RSString.stringAnimator(var9 / 10), RSString.stringAnimator(var9 % 10), TextCore.timeZone});
        } catch (RuntimeException var10) {
            throw ClientErrorException.clientError(var10, "cj.F(" + var0 + ')');
        }
    }

    public final void run() {
        try {
            this.aBoolean353 = true;

            try {
                while (!this.aBoolean345) {
                    for (int var1 = 0; var1 < 2; ++var1) {
                        Class155 var2 = this.aClass155Array352[var1];
                        if (var2 != null) {
                            var2.method2153();
                        }
                    }

                    TimeUtils.sleep(10L);
                    Class81.method1400(this.aClass87_350, null, -71);
                }
            } catch (Exception var7) {
                ClientErrorException.method1125(null, var7);
            } finally {
                this.aBoolean353 = false;
            }

        } catch (RuntimeException var9) {
            throw ClientErrorException.clientError(var9, "cj.run()");
        }
    }

}
