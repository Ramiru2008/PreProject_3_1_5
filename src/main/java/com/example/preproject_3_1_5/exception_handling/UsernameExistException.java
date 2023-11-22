package com.example.preproject_3_1_5.exception_handling;

import org.springframework.dao.DataIntegrityViolationException;

public class UsernameExistException extends DataIntegrityViolationException {
    public UsernameExistException(String message) {
        super(message);
    }
}
