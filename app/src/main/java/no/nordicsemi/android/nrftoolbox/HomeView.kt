package no.nordicsemi.android.nrftoolbox

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import no.nordicsemi.android.theme.view.CloseIconAppBar

@Composable
fun HomeView(viewModel: HomeViewModel) {
    Column {
        val context = LocalContext.current
        CloseIconAppBar(stringResource(id = R.string.app_name)) {
            (context as? Activity)?.finish()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                DoubleSection(
                    leftView = {
                        FeatureButton(R.drawable.ic_csc, R.string.csc_module, R.string.csc_module_full) {
                            viewModel.openProfile(Profile.CSC)
                        }
                    },
                    rightView = {
                        FeatureButton(R.drawable.ic_hrs, R.string.hrs_module, R.string.hrs_module_full) {
                            viewModel.openProfile(Profile.HRS)
                        }
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                DoubleSection(
                    leftView = {
                        FeatureButton(R.drawable.ic_gls, R.string.gls_module, R.string.gls_module_full) {
                            viewModel.openProfile(Profile.GLS)
                        }
                    },
                    rightView = {
                        FeatureButton(R.drawable.ic_hts, R.string.hts_module, R.string.hts_module_full) {
                            viewModel.openProfile(Profile.HTS)
                        }
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                DoubleSection(
                    leftView = {
                        FeatureButton(R.drawable.ic_bps, R.string.bps_module, R.string.bps_module_full) {
                            viewModel.openProfile(Profile.BPS)
                        }
                    },
                    rightView = {
                        FeatureButton(R.drawable.ic_rscs, R.string.rscs_module, R.string.rscs_module_full) {
                            viewModel.openProfile(Profile.RSCS)
                        }
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                DoubleSection(
                    leftView = {
                        FeatureButton(R.drawable.ic_prx, R.string.prx_module, R.string.prx_module_full) {
                            viewModel.openProfile(Profile.PRX)
                        }
                    },
                    rightView = {
                        FeatureButton(R.drawable.ic_cgm, R.string.cgm_module, R.string.cgm_module_full) {
                            viewModel.openProfile(Profile.CGMS)
                        }
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                FeatureButton(R.drawable.ic_uart, R.string.uart_module, R.string.uart_module_full) {
                    viewModel.openProfile(Profile.UART)
                }

                Spacer(modifier = Modifier.height(16.dp))

                FeatureButton(R.drawable.ic_dfu, R.string.dfu_module, R.string.dfu_module_full) {

                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun DoubleSection(
    leftView: @Composable () -> Unit,
    rightView: @Composable () -> Unit,
) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            leftView()
        }
        Spacer(modifier = Modifier.width(16.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            rightView()
        }
    }
}