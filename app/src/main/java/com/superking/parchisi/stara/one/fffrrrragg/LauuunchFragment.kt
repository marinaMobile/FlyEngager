package com.superking.parchisi.stara.one.fffrrrragg

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.superking.parchisi.stara.R
import com.superking.parchisi.stara.databinding.FragmentLauuunchBinding
import com.superking.parchisi.stara.one.AviOne.Companion.MAIN_KEY_SHARED_PREF_BALANVE
import com.superking.parchisi.stara.one.AviOne.Companion.KEY_BALAMCE
import com.superking.parchisi.stara.one.AviOne.Companion.KEY_GAME_VARIANT
import com.superking.parchisi.stara.one.utttils.GameVariant
import com.superking.parchisi.stara.one.utttils.GameVievModell


class LauuunchFragment : Fragment() {
    val MAIN_KEY_SHARED_PREF_BALANCE = MAIN_KEY_SHARED_PREF_BALANVE
    val KEY_BALANCE = KEY_BALAMCE

    private val sharBackground by lazy {
        requireActivity().getSharedPreferences("BACK", Context.MODE_PRIVATE)
    }

    private val settings by lazy {
        requireActivity().getSharedPreferences("PREFS_NAME", 0)
    }

    private var fragmentLauuunchBinding: FragmentLauuunchBinding? = null
    private val binding
        get() = fragmentLauuunchBinding
            ?: throw RuntimeException("FragmentLauuunchBinding = null")

    private val mainViewModel by activityViewModels<GameVievModell>()

    private val totalBalanceSP by lazy {
        requireActivity().getSharedPreferences(
            MAIN_KEY_SHARED_PREF_BALANCE,
            Context.MODE_PRIVATE
        )
    }

    private var totalBalance = 1000


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentLauuunchBinding = FragmentLauuunchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

//            if (settings.getBoolean("my_first_time", true)) {
//                sharBackground.edit().putInt("backgr", 4).apply()
//                settings.edit().putBoolean("my_first_time", false).apply()
//            } else {
            val back = sharBackground.getInt("backgr", 4)
            when (back) {
                0 -> binding.root.background =
                    ContextCompat.getDrawable(requireContext(), R.drawable.back_for_sale_1)
                1 -> binding.root.background =
                    ContextCompat.getDrawable(requireContext(), R.drawable.back_for_sale_2)
                2 -> binding.root.background =
                    ContextCompat.getDrawable(requireContext(), R.drawable.back_for_sale_3)
                3 -> binding.root.background =
                    ContextCompat.getDrawable(requireContext(), R.drawable.back_for_sale_4)
                else -> binding.root.background =
                    ContextCompat.getDrawable(requireContext(), R.drawable.hghgg)
            }
//            }


            binding.root.background.alpha = 218

            val savedGame = totalBalanceSP.getInt(KEY_GAME_VARIANT, 1)
            mainViewModel.checkSavedGame(savedGame)

            makeAllVisible()

            totalBalance = totalBalanceSP.getInt(KEY_BALANCE, 500)



            Log.d("lolo", "LaunchFrag vievModel is $mainViewModel")
            Log.d("lolo", "LaunchFrag gameVariant is ${mainViewModel.currentMode.value}")

            binding.tvUserBalancePoint.text = totalBalance.toString()
            initOnImagePressListeners()

            mainViewModel.currentMode.observe(viewLifecycleOwner) {
                when (it) {
                    is GameVariant.One -> {
                        saveCurrnetGameVariant(1)

                        changeBtnText(it)
                        one()
                        binding.btnPlay.setOnClickListener { viiiie ->
                            makeSnackMessage("Payed ${it.priceForPlay} points for game")
                            if (totalBalance >= it.priceForPlay) {
                                totalBalance -= it.priceForPlay
                                saveBalance()
                                findNavController().navigate(R.id.action_lauuunchFragment_to_aboutEnemyAndRulesFragment)

                            } else {
                                makeSnackBarLooovBalance()
                            }
                        }
                    }

                    is GameVariant.Tvo -> {
                        saveCurrnetGameVariant(2)

                        changeBtnText(it)
                        tvo()
                        binding.btnPlay.setOnClickListener { viiiie ->
                            makeSnackMessage("Payed ${it.priceForPlay} points for game")
                            if (totalBalance >= it.priceForPlay) {
                                totalBalance -= it.priceForPlay
                                saveBalance()
                                findNavController().navigate(R.id.action_lauuunchFragment_to_aboutEnemyAndRulesFragment)

                            } else {
                                makeSnackBarLooovBalance()
                            }
                        }
                    }

                    is GameVariant.Three -> {
                        saveCurrnetGameVariant(3)
                        changeBtnText(it)
                        threeGameAlpha()
                        binding.btnPlay.setOnClickListener { viiiie ->
                            makeSnackMessage("Payed ${it.priceForPlay} points for game")
                            if (totalBalance >= it.priceForPlay) {
                                totalBalance -= it.priceForPlay
                                saveBalance()
                                findNavController().navigate(R.id.action_lauuunchFragment_to_aboutEnemyAndRulesFragment)

                            } else {
                                makeSnackBarLooovBalance()
                            }
                        }
                    }

                    is GameVariant.Four -> {
                        saveCurrnetGameVariant(4)
                        changeBtnText(it)
                        fourGameAlpha()
                        binding.btnPlay.setOnClickListener { viiiie ->
                            makeSnackMessage("Payed ${it.priceForPlay} points for game")
                            if (totalBalance >= it.priceForPlay) {
                                totalBalance -= it.priceForPlay
                                saveBalance()
                                findNavController().navigate(R.id.action_lauuunchFragment_to_aboutEnemyAndRulesFragment)

                            } else {
                                makeSnackBarLooovBalance()
                            }
                        }
                    }

                    is GameVariant.Five -> {
                        saveCurrnetGameVariant(5)
                        changeBtnText(it)
                        fiveGameAlpha()
                        binding.btnPlay.setOnClickListener { viiiie ->
                            makeSnackMessage("Payed ${it.priceForPlay} points for game")
                            if (totalBalance >= it.priceForPlay) {
                                totalBalance -= it.priceForPlay
                                saveBalance()
                                findNavController().navigate(R.id.action_lauuunchFragment_to_aboutEnemyAndRulesFragment)

                            } else {
                                makeSnackBarLooovBalance()
                            }
                        }
                    }

                    is GameVariant.Six -> {
                        saveCurrnetGameVariant(6)
                        changeBtnText(it)
                        sixGameAlpha()
                        binding.btnPlay.setOnClickListener { viiiie ->
                            makeSnackMessage("Payed ${it.priceForPlay} points for game")
                            if (totalBalance >= it.priceForPlay) {
                                totalBalance -= it.priceForPlay
                                saveBalance()
                                findNavController().navigate(R.id.action_lauuunchFragment_to_aboutEnemyAndRulesFragment)

                            } else {
                                makeSnackBarLooovBalance()
                            }
                        }
                    }
                }
            }

        } catch (e: Exception) {
            vfvvf()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    private fun saveCurrnetGameVariant(gameVar: Int) {
        totalBalanceSP.edit().apply {
            putInt(KEY_GAME_VARIANT, gameVar)
            apply()
        }
    }

    private fun changeBtnText(it: GameVariant) {
        val text = "fight ${it.enemyName} - ${it.priceForPlay}"
        binding.btnPlay.text = text
    }

    private fun makeAllVisible() {
        binding.imgStrelki1.alpha = 1f
        binding.imgStrelki2.alpha = 1f
        binding.imgStrelki3.alpha = 1f
        binding.imgStrelki3.alpha = 1f
        binding.imgStrelki4.alpha = 1f
        binding.imgStrelki5.alpha = 1f
        binding.imgStrelki6.alpha = 1f

        binding.imgEnemy1.alpha = 1f
        binding.imgEnemy2.alpha = 1f
        binding.imgEnemy3.alpha = 1f
        binding.imgEnemy4.alpha = 1f
        binding.imgEnemy5.alpha = 1f
        binding.imgEnemy6.alpha = 1f

        binding.tvPrice1.alpha = 1f
        binding.tvPrice2.alpha = 1f
        binding.tvPrice3.alpha = 1f
        binding.tvPrice4.alpha = 1f
        binding.tvPrice5.alpha = 1f
        binding.tvPrice6.alpha = 1f
    }

    private fun tvo() {
        binding.imgStrelki3.alpha = 0.5f
        binding.imgStrelki3.alpha = 0.5f
        binding.imgStrelki4.alpha = 0.5f
        binding.imgStrelki5.alpha = 0.5f
        binding.imgStrelki6.alpha = 0.5f

        binding.imgEnemy3.alpha = 0.5f
        binding.imgEnemy4.alpha = 0.5f
        binding.imgEnemy5.alpha = 0.5f
        binding.imgEnemy6.alpha = 0.5f

        binding.tvPrice3.alpha = 0.5f
        binding.tvPrice4.alpha = 0.5f
        binding.tvPrice5.alpha = 0.5f
        binding.tvPrice6.alpha = 0.5f
    }

    private fun threeGameAlpha() {
        binding.imgStrelki4.alpha = 0.5f
        binding.imgStrelki5.alpha = 0.5f
        binding.imgStrelki6.alpha = 0.5f

        binding.imgEnemy4.alpha = 0.5f
        binding.imgEnemy5.alpha = 0.5f
        binding.imgEnemy6.alpha = 0.5f

        binding.tvPrice4.alpha = 0.5f
        binding.tvPrice5.alpha = 0.5f
        binding.tvPrice6.alpha = 0.5f
    }

    private fun fourGameAlpha() {
        binding.imgStrelki5.alpha = 0.5f
        binding.imgStrelki6.alpha = 0.5f

        binding.imgEnemy5.alpha = 0.5f
        binding.imgEnemy6.alpha = 0.5f

        binding.tvPrice5.alpha = 0.5f
        binding.tvPrice6.alpha = 0.5f
    }

    private fun fiveGameAlpha() {
        binding.imgStrelki6.alpha = 0.5f

        binding.imgEnemy6.alpha = 0.5f

        binding.tvPrice6.alpha = 0.5f
    }

    private fun sixGameAlpha() {
        binding.imgStrelki1.alpha = 1f
        binding.imgStrelki2.alpha = 1f
        binding.imgStrelki3.alpha = 1f
        binding.imgStrelki4.alpha = 1f
        binding.imgStrelki5.alpha = 1f
        binding.imgStrelki6.alpha = 1f

        binding.imgEnemy1.alpha = 1f
        binding.imgEnemy2.alpha = 1f
        binding.imgEnemy3.alpha = 1f
        binding.imgEnemy4.alpha = 1f
        binding.imgEnemy5.alpha = 1f
        binding.imgEnemy6.alpha = 1f

        binding.tvPrice1.alpha = 1f
        binding.tvPrice2.alpha = 1f
        binding.tvPrice3.alpha = 1f
        binding.tvPrice4.alpha = 1f
        binding.tvPrice5.alpha = 1f
        binding.tvPrice6.alpha = 1f
    }

    private fun initOnImagePressListeners() {
        binding.imgEnemy1.setOnClickListener {
            makeSnackMessage("My name is ${GameVariant.One()._enemyName}")
        }
        binding.imgEnemy2.setOnClickListener {
            makeSnackMessage("My name is ${GameVariant.Tvo()._enemyName}")
        }
        binding.imgEnemy3.setOnClickListener {
            makeSnackMessage("My name is ${GameVariant.Three()._enemyName}")
        }
        binding.imgEnemy4.setOnClickListener {
            makeSnackMessage("My name is ${GameVariant.Four()._enemyName}")
        }
        binding.imgEnemy5.setOnClickListener {
            makeSnackMessage("My name is ${GameVariant.Five()._enemyName}")
        }
        binding.imgEnemy6.setOnClickListener {
            makeSnackMessage("My name is ${GameVariant.Six()._enemyName}")
        }
    }

    private fun one() {
        binding.imgStrelki2.alpha = 0.5f
        binding.imgStrelki3.alpha = 0.5f
        binding.imgStrelki4.alpha = 0.5f
        binding.imgStrelki5.alpha = 0.5f
        binding.imgStrelki6.alpha = 0.5f

        binding.imgEnemy2.alpha = 0.5f
        binding.imgEnemy3.alpha = 0.5f
        binding.imgEnemy4.alpha = 0.5f
        binding.imgEnemy5.alpha = 0.5f
        binding.imgEnemy6.alpha = 0.5f

        binding.tvPrice2.alpha = 0.5f
        binding.tvPrice3.alpha = 0.5f
        binding.tvPrice4.alpha = 0.5f
        binding.tvPrice5.alpha = 0.5f
        binding.tvPrice6.alpha = 0.5f
    }

    private fun makeSnackBarLooovBalance() {
        Snackbar.make(
            binding.root,
            "Your balance is less than price for game. Need more money",
            Snackbar.LENGTH_LONG
        ).show()
    }

    private fun makeSnackMessage(text: String) {
        Snackbar.make(
            binding.root,
            text,
            Snackbar.LENGTH_LONG
        ).show()
    }

    private fun saveBalance() {
        totalBalanceSP.edit().apply {
            putInt(KEY_BALANCE, totalBalance)
            apply()
        }
    }


    override fun onPause() {
        onDestroy()
        super.onPause()
    }

    override fun onDestroy() {
        fragmentLauuunchBinding = null
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

}