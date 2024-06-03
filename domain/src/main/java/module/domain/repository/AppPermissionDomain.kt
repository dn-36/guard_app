package module.domain.repository

interface AppPermissionDomain {
    val appName:String
    val appIcon:ByteArray
    val listPermssion:List<String>
}
