package com.finance.backend.Exceptions

class InvalidPasswordException : Exception() {
    override val message: String?
        get() = "비밀번호가 맞지 않습니다."
}