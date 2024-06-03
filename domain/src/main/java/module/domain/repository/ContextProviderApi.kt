package module.domain.repository

import android.app.Activity

class ContextProvider(val context:Any) {
    fun getContextActivity() = context
}