package bitc.fullstack503.e2teamproject.service;

<<<<<<< HEAD
import bitc.fullstack503.e2teamproject.entity.UserEntity;
=======
>>>>>>> 76f865e63340db06a4e01bb474157331518fc843
import bitc.fullstack503.e2teamproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
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
=======
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;
>>>>>>> 76f865e63340db06a4e01bb474157331518fc843
}
