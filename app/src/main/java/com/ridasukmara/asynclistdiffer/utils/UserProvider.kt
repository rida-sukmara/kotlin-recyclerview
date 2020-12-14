package com.ridasukmara.asynclistdiffer.utils

import com.ridasukmara.asynclistdiffer.model.User

class UserProvider {

    companion object {

        fun randomNumber(number: Int): Int {
            return (1..number).random()
        }

        fun randomUser(number: Int = 200): List<User> {

            var listNumbers = mutableListOf<Int>()

            val users = mutableListOf<User>()

            while (true) {

                if (listNumbers.size >= (number.plus(1))) {
                    break
                }

                val random = (0..number).random()

                val new = (listNumbers.indexOf(random) == -1)

                if (new) {
                    listNumbers.add(random)
                }
            }

            for (i in 0..number) {
                val rand = listNumbers[i.toInt()]
                users.add(
                    User(
                        id = rand,
                        image = "https://picsum.photos/id/$rand/50/50"
                    )
                )
            }
            return users
        }
    }
}
