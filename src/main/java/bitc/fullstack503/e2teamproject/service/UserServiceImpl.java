package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.UserEntity;
import bitc.fullstack503.e2teamproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isUserInfo(String userId, String userPw) {
        return userRepository.findByIdAndPassword(userId, userPw).isPresent();
    }

    @Override
    public UserEntity getUserInfo(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public boolean isUserExists(String userId) {
        return userRepository.findById(userId).isPresent();
    }

    //회원가입
    @Transactional  // 추가
    @Override
    public void registerUser(UserEntity user) {

        userRepository.save(user);
    }



}
