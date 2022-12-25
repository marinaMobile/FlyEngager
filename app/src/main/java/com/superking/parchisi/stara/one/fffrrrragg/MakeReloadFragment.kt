package com.superking.parchisi.stara.one.fffrrrragg

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.superking.parchisi.stara.R
import com.superking.parchisi.stara.databinding.FragmentMakeReloadBinding
import com.superking.parchisi.stara.one.AviOne
import com.superking.parchisi.stara.one.AviOne.Companion.MAIN_KEY_SHARED_PREF_BALANVE
import com.superking.parchisi.stara.one.AviOne.Companion.KEY_BALAMCE
import com.superking.parchisi.stara.one.utttils.GameVariant
import com.superking.parchisi.stara.one.utttils.GameVievModell
import kotlinx.coroutines.delay


class MakeReloadFragment : Fragment() {


    private var fragmentReeeeeloadBinding: FragmentMakeReloadBinding? = null
    private val binding
        get() = fragmentReeeeeloadBinding ?: throw RuntimeException("FragmentMakeReloadBinding = null")

    private val mainViewModel by activityViewModels<GameVievModell>()

    private val totalBalanceSP by lazy {
        requireActivity().getSharedPreferences(
            MAIN_KEY_SHARED_PREF_BALANVE,
            Context.MODE_PRIVATE
        )
    }

    private var totalBalance = 1000

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentReeeeeloadBinding = FragmentMakeReloadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            Log.d("lolo", "ReloadFrag vievModel is $mainViewModel")

            totalBalance = totalBalanceSP.getInt(KEY_BALAMCE, 1000)

            val curentGameVariantPoints = mainViewModel.currentMode.value!!.priceForPlay
            val currentEnemyName = mainViewModel.currentMode.value!!.enemyName

            Log.d("lolo", "ReloadFrag curentGameVariant ${mainViewModel.currentMode.value!!}")

            mainViewModel.vinOrLose.observe(viewLifecycleOwner) {
                when (it) {

                    GameVievModell.VIN -> {
                        binding.tvRestartTest.text = "You destroyed him! \nYou also earned 100 points! \nMoving to the next enemy..."
                        totalBalance += curentGameVariantPoints
                        saveBalance()

                        launchNextLevelGame()

                        binding.loooottttiefrgt.setAnimation(R.raw.done)
                        makeSnack("Done")
                        jukujkjukujk()
                    }

                    GameVievModell.LOSE -> {
                        binding.tvRestartTest.text = "You failed! \n${currentEnemyName} destroyed you!\nReloading missiles and trying again..."

                        mainViewModel.launchGameVariant1()
                        binding.loooottttiefrgt.setAnimation(R.raw.failed)
                        makeSnack("Failed")
                        jukujkjukujk()
                    }
                }
            }


        } catch (e: Exception) {
            vfvvf()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    private fun launchNextLevelGame() {

        Log.d("lolo", "in launchNextLevelGame")
        when (mainViewModel.currentMode.value!!) {
            is GameVariant.Three -> {
                saveCurrnetGameVariant(4)
                Log.d("lolo", "in launchNextLevelGame is GameVariant.Three")
                mainViewModel.launchGameVariant4()
            }
            is GameVariant.One -> {
                saveCurrnetGameVariant(2)
                Log.d("lolo", "in launchNextLevelGame is GameVariant.One")
                mainViewModel.launchGameVariant2()
            }
            is GameVariant.Tvo -> {
                saveCurrnetGameVariant(3)
                Log.d("lolo", "in launchNextLevelGame is GameVariant.Tvo")
                mainViewModel.launchGameVariant3()
            }

            is GameVariant.Four -> {
                saveCurrnetGameVariant(5)
                Log.d("lolo", "in launchNextLevelGame is GameVariant.Four")
                mainViewModel.launchGameVariant5()
            }
            is GameVariant.Five -> {
                saveCurrnetGameVariant(6)
                Log.d("lolo", "in launchNextLevelGame is GameVariant.Five")
                mainViewModel.launchGameVariant6()
            }
            is GameVariant.Six -> {
                saveCurrnetGameVariant(6)
                Log.d("lolo", "in launchNextLevelGame is GameVariant.Six")
                mainViewModel.launchGameVariant6()
            }
        }
    }

    private fun saveCurrnetGameVariant(gameVar:Int) {
        totalBalanceSP.edit().apply {
            putInt(AviOne.KEY_GAME_VARIANT, gameVar)
            apply()
        }
    }

    private fun jukujkjukujk() {
        lifecycleScope.launchWhenCreated {
            delay(4500)
            findNavController().navigate(R.id.action_makeReloadFragment_to_lauuunchFragment)
        }
    }

    override fun onPause() {
        onDestroy()
        super.onPause()
    }

    override fun onDestroy() {
        fragmentReeeeeloadBinding = null
        super.onDestroy()
    }

    private fun vfvvf() {
        Snackbar.make(
            binding.root,
            "Some error...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }


    private fun makeSnack(text: String) {
        Snackbar.make(
            binding.root,
            text,
            Snackbar.LENGTH_LONG
        ).show()
    }

    private fun saveBalance() {
        totalBalanceSP.edit().apply {
            putInt(KEY_BALAMCE, totalBalance)
            apply()
        }
    }


}