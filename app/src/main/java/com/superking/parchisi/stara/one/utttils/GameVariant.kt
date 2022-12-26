package com.superking.parchisi.stara.one.utttils

import com.superking.parchisi.stara.R

sealed class GameVariant(
    val stepInGame: Int,
    val enemyName: String,
    val enemyLogo: Int,
    val aboutEnemy: String,
    val priceForPlay: Int
) {
    class One(
        val _stepInGame: Int = 1,
        val _enemyName: String = "Blackout",
        val _enemyLogo: Int = R.drawable.enemy_1,
        val _aboutEnemy: String = "Blackout a powerful and violently loyal Decepticon, even a Third-in-Command to Megatron after Starscream. It was rare to not see him looming silently near Megatron, but if he was not by his masters side, he would be serving him in the field. Blackout also had a symbiotic companion named Scorponok. Blackout flew to the Us SOCCENT base in Qatar. His refusal to identify himself caused the base to send two F-22's to escort him. Suspicions were further raised when one of the pilots reported the registry number 4500X, a helicopter which had been destroyed three months prior. With soldiers surrounding him from all sides, Blackout then transformed and began his attack. He made his way to the operations bunker and tore off the roof. Blackout tried to download some classified data, but was thwarted when men cut the physical hard line." +
                "\n\n" +
                "Try to DESTROY him!\n" +
                "Are you ready?",

        val _priceForPlay: Int = 100
    ) : GameVariant(
        _stepInGame, _enemyName, _enemyLogo, _aboutEnemy, _priceForPlay
    )

    class Tvo(
        val _stepInGame: Int = 2,
        val _enemyName: String = "Sideways",
        val _enemyLogo: Int = R.drawable.enemy_2,
        val _aboutEnemy: String = "Sideways was a Decepticon who came to Earth some point after the death of Megatron, and hid from Humans and Autobots with the gigantic Demolishor. At some point after the Battle of Mission City, Sideways came to Earth to find his great leader Megatron had died. He went into hiding from the Humans, finds refuge behind the giant Constructicon Demolishor." +
                "\n\n" +
                "Try to DESTROY him!\n" +
                "Are you ready?",
        val _priceForPlay: Int = 150
    ) : GameVariant(
        _stepInGame, _enemyName, _enemyLogo, _aboutEnemy, _priceForPlay
    )

    class Three(
        val _stepInGame: Int = 3,
        val _enemyName: String = "Grindor",
        val _enemyLogo: Int = R.drawable.enemy_3,
        val _aboutEnemy: String = "Grindor is a massive hulking Decepticon who, like most Decepticons, was loyal to Megatron. He was a master strategist, and always planned ahead of his enemies. However, in Revenge of The Fallen, his head is ripped off by Optimus Prime in the forest fight. He bears a resemblance to Blackout. In Learning Curve, Grindor was sent to Las Vegas by Soundwave, but was frustrated at Soundwave's vagueness, being directed to an old car. Somewhat fed up, Grindor was pleased to be ordered to cut open the car and retrieve a Cybertronian memory tree." +
                "\n\n" +
                "Try to DESTROY him!\n" +
                "Are you ready?",

        val _priceForPlay: Int = 200
    ) : GameVariant(
        _stepInGame, _enemyName, _enemyLogo, _aboutEnemy, _priceForPlay
    )

    class Four(
        val _stepInGame: Int = 4,
        val _enemyName: String = "Bonecrusher",
        val _enemyLogo: Int = R.drawable.enemy_4,
        val _aboutEnemy: String = "Bonecrusher was a Decepticon who joined Megatron on Earth to get the AllSpark. He hated just about everything. This is what explains to describe ONE word of this robot. Here: Hate. He is voiced by Jimmie Wood. Which, of course, he hated. Bonecrusher is fueled by sheer, unrelenting hate. He hates everyone and everything, including actions, animals, things, or be they Autobot." +
                "\n\n" +
                "Try to DESTROY him!\n" +
                "Are you ready?",


        val _priceForPlay: Int = 250
    ) : GameVariant(
        _stepInGame, _enemyName, _enemyLogo, _aboutEnemy, _priceForPlay
    )

    class Five(
        val _stepInGame: Int = 5,
        val _enemyName: String = "Starscream",
        val _enemyLogo: Int = R.drawable.enemy_5,
        val _aboutEnemy: String = "Starscream was Megatron's air commander and treacherous Decepticon lieutenant. Though Starscream typically tried to suck up to Megatron, he secretly wanted to overthrow him as leader of the Decepticons. Megatron had little tolerance of Starscream's ambitious attempts, and usually punished his lieutenant for his treachery, which is likely why he kept up his sycophantic persona until the time was right, but he never cared of overthrowing Megatron, but whenever Megatron dies, Starscream would always take over, because he wouldn’t want the Decepticons to fall without a leader." +
                "\n\n" +
                "Try to DESTROY him!\n" +
                "Are you ready?",
        val _priceForPlay: Int = 250
    ) : GameVariant(
        _stepInGame, _enemyName, _enemyLogo, _aboutEnemy, _priceForPlay
    )

    class Six(
        val _stepInGame: Int = 6,
        val _enemyName: String = "Megatron",
        val _enemyLogo: Int = R.drawable.enemy_6,
        val _aboutEnemy: String = "Megatron grew up to become Lord High Protector of Cybertron while his adopted brother, Optimus became the head scientist of the Cybertronian scientific division. Eventually, Megatron came across The Fallen, who corrupted him and convinced him that the AllSpark should be his. Megatron and his followers attempted to seize it, but were stopped by Optimus and his Autobots, and the Cybertronian War began." +
                "\n\n" +
                "Try to DESTROY him!\n" +
                "Are you ready?",
        val _priceForPlay: Int = 300
    ) : GameVariant(
        _stepInGame, _enemyName, _enemyLogo, _aboutEnemy, _priceForPlay
    )


}
