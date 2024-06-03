package com.project.guardapp.common.navigate

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.guardapp.common.get_permession.screen.AgreementScreen
import com.project.guardapp.screens.clear_applications.screen.InstalledApplicationScreen
import com.project.guardapp.screens.congratulate_clear_app.screen.CongratulateClearAppScreen
import com.project.guardapp.screens.congratulation_clear_contacts.screen.CongratulateContactScreen
import com.project.guardapp.screens.duplicate_contact.screen.DuplicateContactScreen
import com.project.guardapp.screens.file_optimization.screen.CleanFileOptimization
import com.project.guardapp.screens.haccers.screen.HackersScreen
import com.project.guardapp.screens.loading.screen.ScreenLoading
import com.project.guardapp.screens.menu.screen.ScreenMenu
import com.project.guardapp.screens.progress.screen.ScreenProgress
import com.project.guardapp.screens.select_delete_res_messenger.screen.DeleteResMessengerScreen
import com.project.guardapp.screens.select_messengers.screen.SelectMessengerScreen
import com.project.guardapp.screens.take_care_advice.screen.TakingCareScreen

@Composable
    fun Navigation(
        isAgreementToReadContacts:Boolean,
        isAgreementToDeletePackage:Boolean,
   ) {

        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = Screen.Loading.route) {
            composable(Screen.Loading.route) {backStackEntry ->
                val parentEntry = remember(backStackEntry) {
                    navController.getBackStackEntry(Screen.Loading.route)
                }

                ScreenLoading(
                    navController = navController
                )
            }
            composable(Screen.Menu.route) {
                ScreenMenu(
                    navController,
                    isAgreementToReadContacts = isAgreementToReadContacts,
                    isAgreementToDeletePackage = isAgreementToDeletePackage
                    )
            }

            composable(Screen.GetPermissionReadCotact.route) {
                //val viewModel:ViewModelAgreementToReadContacts = viewModel()
                AgreementScreen(
                    isAgreementToReadContacts,
                  //  viewModel,//viewModelAgreementGetPermission,
                    navController,
                    "Чтобы удалить дубликаты и " +
                            "пустые записи нам требуется " +
                            "разрешение",
                    arrayOf(
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.WRITE_CONTACTS
                    ),
                    com.project.guardapp.common.ConstDataApp.REQUEST_CODE_READ_CONTACTS
                    )
            }
            composable(Screen.GetPermissionWriteReadFile.route) {
                // val viewModel:ViewModelAgreementToReadContacts = viewModel()
                    AgreementScreen(
                        isAgreementToDeletePackage,
                       // viewModel,
                        navController,
                        "Чтобы Очищать медиа " +
                                "файлы мессенджеров " +
                                "нам требуется " +
                                "разрешение",
                        arrayOf(
                                    Manifest.permission.READ_EXTERNAL_STORAGE,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                    Manifest.permission.MANAGE_EXTERNAL_STORAGE,

                        ),
                        com.project.guardapp.common.ConstDataApp.REQUEST_CODE_DELETE_FILE
                    )

            }
            composable(Screen.SelectMessenger.route){
               // val viewModel:ViewModelSelectMessenger = viewModel()
                SelectMessengerScreen(
                 //   viewModelSelectMessenger = viewModel ,
                    navController = navController
                )
            }

            composable(Screen.DuplicateContact.route){
             //   val viewModel:ViewModelDuplicateContacts = viewModel()
                DuplicateContactScreen(
                   // viewModelDuplicateContacts = viewModel,
                    navController = navController
                )
            }
            composable(Screen.CongratulateClearContact.route){
              //  val viewModel : ViewModelCongratulationClearContact = viewModel()
                CongratulateContactScreen(
                  //  viewModel,
                    navController
                )
            }
            composable(Screen.CongratulateClearApps.route){
              //  val viewModel:ViewModelCongratulationClearApp = viewModel()
                CongratulateClearAppScreen(
                  //  viewModel = viewModel,
                    navController = navController
                )

            }
            composable(Screen.ClearCachesApplication.route){

                InstalledApplicationScreen(
                    navController
                )
            }
            composable(Screen.CheckHackers.route){
                HackersScreen().Show{
                    navController.navigate(Screen.Menu.route)
                }
            }
            composable(Screen.CleanMemory.route){
              //  val viewModel:FileOptimizationViewModel = viewModel()
                CleanFileOptimization (
                    navController = navController,
                    //viewModel = viewModel
                )
            }
            composable(Screen.TakingCare.route){
              //  val viewModel:ViewModelTakingCare = viewModel()
                TakingCareScreen.Content(
                    //vm = viewModel,
                    navController)
            }
            composable(Screen.DeletePackageMessengerScreen.route){
                DeleteResMessengerScreen(
                    navController = navController
                )
            }
            composable(Screen.ProgressClearApp.route){
                ScreenProgress(navController = navController)
            }
            composable(Screen.Progress.route) {
                ScreenProgress(
                  navController = navController
                )
            }
        }
    }
//}