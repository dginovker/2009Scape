package org.rs09.client.rendering.opengl

import org.lwjgl.opengl.GL11.*
import org.rs09.client.rendering.Toolkit
import org.runite.client.HDToolKit

class OpenGlToolkit : Toolkit() {

    override fun fillRect(x: Int, y: Int, w: Int, h: Int, rgb: Int, alpha: Int) {
        HDToolKit.method1835()
        val var6 = x.toFloat()
        val var7 = var6 + w.toFloat()
        val var8 = (HDToolKit.viewHeight - y).toFloat()
        val var9 = var8 - h.toFloat()

        glBegin(GL_TRIANGLE_FAN)
        glColor4ub((rgb shr 16).toByte(), (rgb shr 8).toByte(), rgb.toByte(), if (alpha > 255) -1 else alpha.toByte())
        glVertex2f(var6, var8)
        glVertex2f(var6, var9)
        glVertex2f(var7, var9)
        glVertex2f(var7, var8)
        glEnd()
    }

    override fun drawHorizontalLine(x: Int, y: Int, w: Int, rgb: Int) {
        HDToolKit.method1835()
        val startX = x.toFloat() + 0.3f
        val endX = startX + w.toFloat()
        val yPos = HDToolKit.viewHeight.toFloat() - (y.toFloat() + 0.3f)

        glBegin(GL_LINES)
        glColor3ub((rgb shr 16).toByte(), (rgb shr 8).toByte(), rgb.toByte())
        glVertex2f(startX, yPos)
        glVertex2f(endX, yPos)
        glEnd()
    }

    override fun drawVerticalLine(x: Int, y: Int, h: Int, rgb: Int) {
        HDToolKit.method1835()
        val var4 = x.toFloat() + .3f
        val var5 = HDToolKit.viewHeight.toFloat() - (y.toFloat() + 0.3f)
        val var6 = var5 - h.toFloat()

        glBegin(GL_LINES)
        glColor3ub((rgb shr 16).toByte(), (rgb shr 8).toByte(), rgb.toByte())
        glVertex2f(var4, var5)
        glVertex2f(var4, var6)
        glEnd()
    }

    override fun drawRect(x: Int, y: Int, w: Int, h: Int, rgb: Int, alpha: Int) {
        HDToolKit.method1835()
        val var5 = x.toFloat() + 0.3f
        val var6 = var5 + (w.toFloat() - 1)
        val var7 = (HDToolKit.viewHeight.toFloat() - (y.toFloat() + 0.3f))
        val var8 = var7 - (h.toFloat() - 1)

        glBegin(GL_LINE_LOOP)
        glColor4ub((rgb shr 16).toByte(), (rgb shr 8).toByte(), rgb.toByte(), if (alpha > 255) -1 else alpha.toByte())
        glVertex2f(var5, var7)
        glVertex2f(var5, var8)
        glVertex2f(var6, var8)
        glVertex2f(var6, var7)
        glEnd()
    }

    override fun method934(x: Int, y: Int, w: Int, h: Int, rgb: Int) {
        HDToolKit.method1835()
        val var5 = x.toFloat()
        val var6 = var5 + w.toFloat()
        val var7 = (HDToolKit.viewHeight - y).toFloat()
        val var8 = var7 - h.toFloat()

        glBegin(GL_TRIANGLE_FAN)
        glColor3ub((rgb shr 16).toByte(), (rgb shr 8).toByte(), rgb.toByte())
        glVertex2f(var5, var7)
        glVertex2f(var5, var8)
        glVertex2f(var6, var8)
        glVertex2f(var6, var7)
        glEnd()
    }
}