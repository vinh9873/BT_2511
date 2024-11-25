package vn.ute.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.ute.entity.UserInfo;
import vn.ute.repository.UserInfoRepository;

@Service
public record UserService(UserInfoRepository repository, PasswordEncoder passwordEncoder) {
	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		repository.save(userInfo);
		return "Thêm user thành công!";
	}
}
