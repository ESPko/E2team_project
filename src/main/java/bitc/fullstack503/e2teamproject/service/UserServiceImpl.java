package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.UserEntity;
import bitc.fullstack503.e2teamproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

//  사용자 존재 여부 확인
  @Override
  public boolean isUserInfo(String userId, String userPw) {
    return userRepository.findByIdAndPassword(userId, userPw).isPresent();
  }

//  로그인
  @Override
  public UserEntity getUserInfo(String userId) {
    return userRepository.findById(userId).orElse(null);
  }

//  회원 존재 여부 확인
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

// 회원 목록
  @Override
  public List<UserEntity> getNonAdminUsers() {
    return userRepository.findByLevelNot(1);
  }

//  회원삭제
  @Override
  public void deleteUserById(int id) {
    userRepository.deleteById(id);
  }

// 비밀번호 변경
  @Transactional
  @Override
  public void updateUserPassword(String userId, String newPassword) {
    UserEntity user = userRepository.findById(userId).orElse(null);
    if (user != null) {
      user.setPassword(newPassword); // 암호화 없이 저장
      userRepository.save(user);
    }
  }

//  휴대폰번호 변경
  @Transactional
  @Override
  public void updateUserPhone(String userId, String newPhone) {
    UserEntity user = userRepository.findById(userId).orElse(null);
    if (user != null) {
      user.setPhone(newPhone);
      userRepository.save(user);
    }
  }

}
