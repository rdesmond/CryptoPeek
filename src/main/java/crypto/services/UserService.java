package crypto.services;

import crypto.model.cryptoCompareModels.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
