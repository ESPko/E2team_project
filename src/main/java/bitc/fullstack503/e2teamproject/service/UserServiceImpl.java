package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;
}
