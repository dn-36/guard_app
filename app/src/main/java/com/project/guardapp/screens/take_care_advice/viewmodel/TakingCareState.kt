package com.project.guardapp.screens.take_care_advice.viewmodel

import module.domain.repository.AppPermissionDomain


data class TakingCareState(
    val listAppPermission:List<AppPermissionDomain>,
    val isSucsessData:Boolean = false,
)