package com.project.datasource.mappers

import module.domain.model.PhoneModelDomain
import module.phoneinfo.model.PhoneModelData


fun PhoneModelData.toPhoneModelDomain() = PhoneModelDomain(title)