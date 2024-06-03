package module.phoneinfo

import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.core.graphics.drawable.toBitmap
import module.phoneinfo.model.AppInfoData
import module.phoneinfo.model.AppPermissionInfo
import module.phoneinfo.model.InstalledAppsData
import module.phoneinfo.model.PhoneModelData
import java.io.ByteArrayOutputStream


class PhoneInfo  (
     val context: Context
) {

      fun getModelPhone(): PhoneModelData {
        val manufacturer = Build.MANUFACTURER
        val model = Build.MODEL
        return if (model.startsWith(manufacturer)) {
            PhoneModelData(capitalize(model))
        } else {
            PhoneModelData("${capitalize(manufacturer)} $model")
        }
    }

    fun deleteAppByAppName(appName: String) {
       val packageURI = Uri.parse("package:${appName}")
       val intent = Intent(Intent.ACTION_DELETE, packageURI)
       intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
       context.startActivity(intent)
    }

     fun getInstalledApps(): InstalledAppsData {
        val pm: PackageManager = context.packageManager
        val appsList = mutableListOf<AppInfoData>()

        // Получаем список установленных приложений
        val packages = pm.getInstalledApplications(PackageManager.GET_META_DATA)

        for (packageInfo in packages) {

            // Проверяем, является ли приложение видимым для пользователя
            if ((packageInfo.flags and ApplicationInfo.FLAG_SYSTEM) == 0) {
                val name = packageInfo.loadLabel(pm).toString()
                val icon = packageInfo.loadIcon(pm).toBitmap()
                val packageApp = packageInfo.packageName
                appsList.add(AppInfoData(name, icon, packageApp))
            }
        }

        return InstalledAppsData(appsList)
    }




    private fun capitalize(str: String?): String {
        if (str.isNullOrEmpty()) {
            return str ?: ""
        }
        val arr = str.toCharArray()
        var capitalizeNext = true

        val phrase = StringBuilder()
        for (c in arr) {
            if (capitalizeNext && c.isLetter()) {
                phrase.append(c.toUpperCase())
                capitalizeNext = false
                continue
            } else if (c.isWhitespace()) {
                capitalizeNext = true
            }
            phrase.append(c)
        }

        return phrase.toString()
    }


     fun getInfoPermission():MutableList<AppPermissionInfo> {

            val pm = context.packageManager
            var listResultPermission = mutableListOf<AppPermissionInfo>()
            val packages = pm.getInstalledApplications(PackageManager.GET_META_DATA)
            var appName = ""
            for (_packageInfo in packages) {
                appName = pm.getApplicationLabel(_packageInfo).toString()
                if ((_packageInfo.flags and ApplicationInfo.FLAG_SYSTEM) == 0) {

                    val packageInfo =
                        pm.getPackageInfo(_packageInfo.packageName, PackageManager.GET_PERMISSIONS)

                    val _listPermissions = packageInfo.requestedPermissions ?: arrayOf<String>()
                    Log.d("Icon_2", "App: $appName, permission: ${_listPermissions.toList()}")

                    val appIcon = pm.getApplicationIcon(_packageInfo).toBitmap()



                    listResultPermission.add(
                        AppPermissionInfo(
                            appName, bitmapToByteArray(appIcon),
                            _listPermissions.toList()
                        )
                    )
                }
            }
            return listResultPermission
        }

   private fun bitmapToByteArray(bitmap: Bitmap): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()
        // Используем формат компрессии, например, PNG
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        return byteArrayOutputStream.toByteArray()
    }



}


