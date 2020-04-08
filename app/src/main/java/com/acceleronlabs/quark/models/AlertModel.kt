package com.acceleronlabs.quark.models

import java.sql.Timestamp

data class AlertModel(
    var temperature: Int? = null,
    var cardSlot: String? = null,
    var warnings: String? = null,
    var alertTimestamp: Timestamp? = null
)