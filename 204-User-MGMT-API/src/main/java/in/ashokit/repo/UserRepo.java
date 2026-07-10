package in.ashokit.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

	public Optional<UserEntity> findByEmail(String email);

	public Optional<UserEntity> findByEmailAndPwd(String email, String pwd);
}
