package bitc.fullstack503.e2teamproject.service;


import bitc.fullstack503.e2teamproject.entity.UserEntity;

public interface UserService {

    //    사용자 존재 여부 확인
    boolean isUserInfo(String userId, String userPw);

    UserEntity getUserInfo(String userId);
}
