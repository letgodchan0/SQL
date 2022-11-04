package com.finance.backend.daily.entity

import com.finance.backend.user.User
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "attendance")
class Attendance (
        user : User
        ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, columnDefinition = "INT UNSIGNED")
    var id: Long = 0
        protected set

    @CreatedDate
    var attDate: LocalDateTime = LocalDateTime.now()

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user : User = user
}