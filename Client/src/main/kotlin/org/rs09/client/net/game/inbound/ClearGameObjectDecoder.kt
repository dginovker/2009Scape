package org.rs09.client.net.game.inbound

import org.runite.client.*

object ClearGameObjectDecoder : GamePacketDecoder {
    override fun decode(buffer: DataBuffer) {
        println("Clearing object with Game Object Decoder")
        val var1 = Network.incomingBuffer.readUnsignedNegativeByte()
        val var3 = var1 and 3
        val var2 = var1 shr 2
        val var4 = Class75.anIntArray1107[var2]
        val var5 = Network.incomingBuffer.readUnsignedByte()
        val chunkX = (125 and var5 shr 4) + Class39.currentChunkX
        val chunkY = (7 and var5) + Class39.currentChunkY
        if (0 <= chunkX && chunkY >= 0 && chunkX < 104 && 104 > chunkY) {
            Unsorted.method881(WorldListCountry.localPlane, chunkY, -101, var3, chunkX, -1, -1, var4, var2, 0)
        }
    }

}