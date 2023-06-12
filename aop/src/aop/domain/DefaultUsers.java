package aop.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import aop.domain.portsin.User;
import aop.domain.portsin.Users;

@Component
public class DefaultUsers implements Users {

	private static List<User> users = List.of(new User(1, "emolinari"),
			new User(2, "nabaldo"), new User(3, "japalco"));

	@Override
	public List<User> users() {
		return users;
	}

	@Override
	public User userById(int id) {
		Optional<User> ouser = users.stream().filter(u -> u.sameId(id))
				.findFirst();

		return ouser.orElseThrow(
				() -> new RuntimeException("Id de usuario inválido"));
	}

	@Override
	@Trace
	public User usersByName(String userName) {
		Optional<User> ouser = users.stream()
				.filter(u -> u.sameUsername(userName))
				.findFirst();

		return ouser.orElseThrow(
				() -> new RuntimeException("nombre de usuario inexistente"));
	}
	
}
