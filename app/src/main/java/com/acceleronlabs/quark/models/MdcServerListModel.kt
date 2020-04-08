package com.acceleronlabs.quark.models

data class MDCServer(var name: String)

object Supplier {

    val servers = listOf<MDCServer>(
        MDCServer("MDC - X123456"), MDCServer("MDC - X145454"),
        MDCServer("MDC - X984675"), MDCServer("MDC - X876498")
    )
}