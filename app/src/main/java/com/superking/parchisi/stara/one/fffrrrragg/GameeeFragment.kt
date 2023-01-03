package com.superking.parchisi.stara.one.fffrrrragg

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.superking.parchisi.stara.R
import com.superking.parchisi.stara.databinding.FragmentGameeeBinding
import com.superking.parchisi.stara.one.AviOne
import com.superking.parchisi.stara.one.utttils.GameVariant
import com.superking.parchisi.stara.one.utttils.GameVievModell
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


class GameeeFragment : Fragment() {

    var eachMissileDamage =20

    private val timeForReloadingMissiles: Int =1
    var missileCounter = 0

    var enemyHealth = 100
    var totalDamge = 0

    private var fragmentGameeeBinding: FragmentGameeeBinding? = null
    private val binding
        get() = fragmentGameeeBinding ?: throw RuntimeException("FragmentGameeeBinding = null")

    private val mainViewModel by activityViewModels<GameVievModell>()

    private val totalBalanceSP by lazy {
        requireActivity().getSharedPreferences(
            AviOne.MAIN_KEY_SHARED_PREF_BALANVE,
            Context.MODE_PRIVATE
        )
    }

    private val listMissile by lazy {
        listOf(
            binding.imgMissile1,
            binding.imgMissile2,
            binding.imgMissile3,
            binding.imgMissile4,
            binding.imgMissile5,
            binding.imgMissile6,
            binding.imgMissile7,
            binding.imgMissile8,
            binding.imgMissile9,
            binding.imgMissile10,
        ).shuffled()
    }

    private fun generateRandomDamage() = Random.nextInt(from = 1, until = eachMissileDamage)

    private var totalBalance = 1000

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentGameeeBinding = FragmentGameeeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {


            Log.d("lolo", "GameFrag vievModel is $mainViewModel")
            var ttt = "$totalDamge/100"
            binding.enemyHealth.text = ttt

            totalBalance = totalBalanceSP.getInt(AviOne.KEY_BALAMCE, 500)

            val curentGameVariant = mainViewModel.currentMode.value!!

            when(curentGameVariant.stepInGame){
                1-> {
                    eachMissileDamage = 20
                }
                2-> {
                    eachMissileDamage = 19
                }
                3-> {
                    eachMissileDamage = 18
                }
                4-> {
                    eachMissileDamage = 17
                }
                5-> {
                    eachMissileDamage = 16
                }
                6-> {
                    eachMissileDamage = 15
                }
            }


            ContextCompat.getDrawable(requireActivity(), curentGameVariant.enemyLogo).also {
                binding.imgEnemy.setImageDrawable(it)
            }

            binding.btnMakeDamage.setOnClickListener {

                missileCounter++

                val damage = generateRandomDamage()
                totalDamge += damage

                Snackbar.make(
                    binding.root,
                    "Missile strike $damage damage",
                    Snackbar.LENGTH_LONG
                ).show()

                ttt = "$totalDamge/100"
                binding.enemyHealth.text = ttt

                enemyHealth -= damage

                makeBtnUnActiove()
                launchSingleMissile()

                binding.progBarHalth.progress = totalDamge

                if (missileCounter == 10 || totalDamge >= 100) {
                    if (totalDamge >= 100) {
                        mainViewModel.userVin()
                    } else {
                        mainViewModel.userLose()
                    }
                    makeExplosionAndGoNext()

                } else {
                    makeExplosion()
                }
            }


        } catch (e: Exception) {
            vfvvf()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    private fun makeExplosion() {
        lifecycleScope.launch {

            binding.lotExplosion.visibility = View.VISIBLE
            delay(1200)
            binding.lotExplosion.visibility = View.GONE

        }
    }

    private fun makeExplosionAndGoNext() {
        lifecycleScope.launch {

            binding.lotExplosion.visibility = View.VISIBLE
            delay(1200)
            binding.lotExplosion.visibility = View.GONE

            findNavController().navigate(R.id.action_gameeeFragment_to_makeReloadFragment)

        }
    }

    private fun makeBtnUnActiove() {

        if (missileCounter == 10){
            binding.btnMakeDamage.alpha = 0.3f
            binding.btnMakeDamage.isEnabled = false
            binding.btnMakeDamage.text = "All missiles already used"

        } else{
            lifecycleScope.launch {
                var counter = 1
                binding.btnMakeDamage.alpha = 0.3f
                binding.btnMakeDamage.isEnabled = false

                repeat(counter) {
                    if (counter > 0) {
                        binding.btnMakeDamage.text = "Reloading...$counter"
                        delay(1000)
                        counter -= 1
                    }
                }
                binding.btnMakeDamage.text = "Strike missile"
                binding.btnMakeDamage.alpha = 1f
                binding.btnMakeDamage.isEnabled = true
            }
        }
    }

    private fun makeMissileNormal() {
        for (i in listMissile) {
            i.alpha = 1f
        }
    }


    private fun launchSingleMissile() {

        for (i in listMissile) {
            if (i.alpha == 1f) {
                i.alpha = 0.3f
                return
            }
        }
    }


    override fun onPause() {
        onDestroy()
        super.onPause()
    }

    override fun onDestroy() {
        fragmentGameeeBinding = null
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
            putInt(AviOne.KEY_BALAMCE, totalBalance)
            apply()
        }
    }


}