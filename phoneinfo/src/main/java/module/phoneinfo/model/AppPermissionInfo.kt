package module.phoneinfo.model


data class AppPermissionInfo (
    val appName:String,
    val appIcon:ByteArray,
    val listPermssion:List<String>
    )