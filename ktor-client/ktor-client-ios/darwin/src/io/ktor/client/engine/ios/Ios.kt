package io.ktor.client.engine.ios

import io.ktor.client.engine.*
import platform.Foundation.*
import kotlin.native.concurrent.*

private val initHook = Ios

/**
 * [HttpClientEngineFactory] using a [NSURLRequest] in implementation
 * with the the associated requestConfig [HttpClientEngineConfig].
 */
object Ios : HttpClientEngineFactory<IosClientEngineConfig> {
    init {
        engines.add(this)
    }

    override fun create(block: IosClientEngineConfig.() -> Unit): HttpClientEngine =
        IosClientEngine(IosClientEngineConfig().apply(block))
}
