package com.jia.shiro;

import com.jia.model.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

/**
 * @Auther: jia
 * @Date: 2018/7/23 14:25
 * @Description:
 */
@Service("passwordHelper")
public class PasswordEncrypt {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public void encryptPassword(User user) {

        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
            algorithmName,
            user.getPassword(),
            ByteSource.Util.bytes(user.getSalt()),
            hashIterations
        ).toHex();

        user.setPassword(newPassword);
    }

    public String encryptOldPwd(String salt,String password){
        String oldPassword = new SimpleHash(
            algorithmName,
            password,
            ByteSource.Util.bytes(salt),
            hashIterations
        ).toHex();
        return oldPassword;
    }


}
