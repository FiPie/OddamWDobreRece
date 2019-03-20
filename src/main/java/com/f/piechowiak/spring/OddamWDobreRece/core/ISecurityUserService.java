package com.f.piechowiak.spring.OddamWDobreRece.core;

public interface ISecurityUserService {

    String validatePasswordResetToken(long id, String token);
}
