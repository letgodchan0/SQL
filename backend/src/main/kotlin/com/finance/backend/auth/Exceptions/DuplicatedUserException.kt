package com.finance.backend.auth.Exceptions

class DuplicatedUserException : Exception() {
    override val message: String?
        get() = "이미 가입된 회원입니다."
}