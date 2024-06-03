package module.domain.usecases

import module.domain.repository.RepositoryApi

class RebootProgressDateBase(
    private val repositoryApi: RepositoryApi
){
    operator fun  invoke(){
        repositoryApi.rebootProgressDateBase()
    }
}