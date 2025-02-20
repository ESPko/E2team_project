package bitc.fullstack503.e2teamproject.service;


import bitc.fullstack503.e2teamproject.entity.UserEntity;

import java.util.List;

public interface UserService {

    //    사용자 존재 여부 확인
    boolean isUserInfo(String userId, String userPw);

//    로그인
    UserEntity getUserInfo(String userId);

    // 회원 존재 여부 확인
    boolean isUserExists(String userId);

    // 회원가입
    void registerUser(UserEntity user);


// 회원 목록
    List<UserEntity> getNonAdminUsers();

//    회원삭제
    void deleteUserById(int id);

//    비밀번호 변경
void updateUserPassword(String userId, String newPassword);

// 휴대폰번호 변경
void updateUserPhone(String userId, String newPhone);


}
