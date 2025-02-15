package bitc.fullstack503.e2teamproject.service;


import bitc.fullstack503.e2teamproject.entity.UserEntity;

import java.util.List;

public interface UserService {

    //    사용자 존재 여부 확인
    boolean isUserInfo(String userId, String userPw);

    UserEntity getUserInfo(String userId);

    // 회원 존재 여부 확인
    boolean isUserExists(String userId);

    // 회원가입
    void registerUser(UserEntity user);

    List<UserEntity> getAllUsers();

//    회원삭제

    void deleteUserById(int id);

}
