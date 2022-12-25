package com.superking.parchisi.stara.one.fffrrrragg

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.superking.parchisi.stara.R
import com.superking.parchisi.stara.databinding.FragmentAboutEnemyAndRulesBinding
import com.superking.parchisi.stara.one.utttils.GameVariant
import com.superking.parchisi.stara.one.utttils.GameVievModell
import kotlinx.coroutines.delay


class AboutEnemyAndRulesFragment : Fragment() {

    var missileDamageMax = 20
    private var fragmentReeeeeloadBinding: FragmentAboutEnemyAndRulesBinding? = null
    private val binding get() = fragmentReeeeeloadBinding ?: throw RuntimeException("FragmentAboutEnemyAndRulesBinding = null")

    private val mainViewModel by activityViewModels<GameVievModell>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentReeeeeloadBinding = FragmentAboutEnemyAndRulesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            Log.d("lolo", "AboutEnemyFrag vievModel is $mainViewModel")

            binding.btnPlayGameeee.setOnClickListener {
                initAlertDialog()
            }

            mainViewModel.currentMode.observe(viewLifecycleOwner){
                when(it){
                    is GameVariant.One -> {
                        missileDamageMax = 20
                        binding.tvEnemyName.text = it._enemyName
                        binding.textAboutEnemy.text = it._aboutEnemy
                        ContextCompat.getDrawable(requireActivity(), it._enemyLogo).also { image ->
                            binding.imgEnemyLogo.setImageDrawable(image)
                        }
                    }
                    is GameVariant.Tvo -> {
                        missileDamageMax = 19
                        binding.tvEnemyName.text = it._enemyName
                        binding.textAboutEnemy.text = it._aboutEnemy
                        ContextCompat.getDrawable(requireActivity(), it._enemyLogo).also { image ->
                            binding.imgEnemyLogo.setImageDrawable(image)
                        }
                    }
                    is GameVariant.Three -> {
                        missileDamageMax = 18
                        binding.tvEnemyName.text = it._enemyName
                        binding.textAboutEnemy.text = it._aboutEnemy
                        ContextCompat.getDrawable(requireActivity(), it._enemyLogo).also { image ->
                            binding.imgEnemyLogo.setImageDrawable(image)
                        }
                    }
                    is GameVariant.Four -> {
                        missileDamageMax = 17
                        binding.tvEnemyName.text = it._enemyName
                        binding.textAboutEnemy.text = it._aboutEnemy
                        ContextCompat.getDrawable(requireActivity(), it._enemyLogo).also { image ->
                            binding.imgEnemyLogo.setImageDrawable(image)
                        }
                    }
                    is GameVariant.Five -> {
                        missileDamageMax = 16
                        binding.tvEnemyName.text = it._enemyName
                        binding.textAboutEnemy.text = it._aboutEnemy
                        ContextCompat.getDrawable(requireActivity(), it._enemyLogo).also { image ->
                            binding.imgEnemyLogo.setImageDrawable(image)
                        }
                    }
                    is GameVariant.Six -> {
                        missileDamageMax = 15
                        binding.tvEnemyName.text = it._enemyName
                        binding.textAboutEnemy.text = it._aboutEnemy
                        ContextCompat.getDrawable(requireActivity(), it._enemyLogo).also { image ->
                            binding.imgEnemyLogo.setImageDrawable(image)
                        }
                    }
                }
            }





        } catch (e: Exception) {
            vfvvf()
        }


        super.onViewCreated(view, savedInstanceState)
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


    private fun jkkjkoo(currentPoint: Int) {
        Snackbar.make(
            binding.root,
            "You recived $currentPoint points",
            Snackbar.LENGTH_LONG
        ).show()
    }

    private fun initAlertDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Game rules")
            .setMessage("You have ten missile. \nEach missile can deal damage from 1 to $missileDamageMax.\nThe enemy's total health  is 100 units. \nRockets can be fired every 3 seconds. \nIf you can destroy all the enemy's health balance - you win and get reward, if not - you lose and have to try again.\n\nAll clear?")
            .setPositiveButton("Yes, start") { _, _ ->
                findNavController().navigate(R.id.action_aboutEnemyAndRulesFragment_to_gameeeFragment)
            }
            .setNegativeButton("No") { _, _ ->

            }

            .setCancelable(true)
            .create()
            .show()
    }


}