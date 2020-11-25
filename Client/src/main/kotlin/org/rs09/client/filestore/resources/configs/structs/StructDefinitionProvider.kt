package org.rs09.client.filestore.resources.configs.structs

import org.rs09.client.data.NodeCache
import org.runite.client.CacheIndex
import org.runite.client.DataBuffer

object StructDefinitionProvider {
    private val cache = NodeCache<StructDefinition>(64)
    private lateinit var index: CacheIndex

    @JvmStatic
    fun provide(id: Int): StructDefinition? {
        var def = cache.get(id.toLong())
        if (def != null) return def

        def = StructDefinition()
        val bytes = index.getFile(26, id)
        if (bytes != null) def.decode(DataBuffer(bytes))

        cache.put(id.toLong(), def)
        return def
    }

    @JvmStatic
    fun setIndex(index: CacheIndex) {
        this.index = index
    }
}