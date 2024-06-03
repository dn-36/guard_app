package com.project.guardapp.common.navigate

enum class Screen(val route:String) {
    Loading("Loading"),
    Menu("Menu"),
    Progress("Progress"),
    ProgressClearApp("ProgressClearApp"),
    DuplicateContact("DuplicateContact"),
    GetPermissionReadCotact("AgreementToReadContactsScreen"),
    CongratulateClearContact("CongratulateClearContact"),
    CongratulateClearApps("CongratulateClearApps"),
    ClearCachesApplication("ClearCachesApplication"),
    CheckHackers("CheckHackers"),
    CleanMemory("CleanMemory"),
    TakingCare("TakingCare"),
    GetPermissionWriteReadFile("GetPermissionWriteFile"),
    SelectMessenger("SelectMessenger"),
    DeletePackageMessengerScreen("DeletePackageMessengerScreen")
}