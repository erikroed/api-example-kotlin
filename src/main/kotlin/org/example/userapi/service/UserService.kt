package org.example.userapi.service

import org.example.userapi.model.User
import org.springframework.stereotype.Service

@Service
class UserService {

    fun getUsers(): List<User> {
        return listOf(
            User(1, "Erik", "Røed", 100, "Ække lett å værra blind på begge øra!"),
            User(2, "Ola", "Nordmann", 84, "Smil til verden, og du får en støvel i trynet"),
            User(3, "Kari", "Nordmann", 34, "Det er typisk norsk å være god!"),
        )
    }

    fun getUsers(id: Int): User? {
        val user = getUsers().find { it.id == id }
        return user
    }

}
