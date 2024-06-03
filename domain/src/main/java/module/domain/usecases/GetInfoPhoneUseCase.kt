package module.domain.usecases

import module.domain.model.PhoneModelDomain
import module.domain.repository.RepositoryApi


class GetInfoPhoneUseCase(
   val repository: RepositoryApi
) {

   operator fun invoke(): PhoneModelDomain = repository.getInphoPhoneModel()//getInpxhoPhoneModel()

}

