package com.example.card.password.business;

import org.springframework.stereotype.Service;

@Service

public class PasswordServiceImpl {
package com.appsdeveloperblog.encryption;

import java.security.SecureRandom;
import java.util.Random;

    public class GenerateSecurePassword {
        // Use SecureRandom to generate random numbers for password characters
        private static final Random RANDOM = new SecureRandom();
        // Define the character set for the password
        private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        public static void main(String[] args) {
            // Define desired password length
            int passwordLength = 10;

            // Generate Secure Password
            String password = generatePassword(passwordLength);

            // Print out password value
            System.out.println("Secure password: " + password);
        }

        // Method to generate a secure password of specified length
        public static String generatePassword(int length) {
            StringBuilder returnValue = new StringBuilder(length);

            // Iterate through password length and append random characters from character set
            for (int i = 0; i < length; i++) {
                returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
            }

            // Convert StringBuilder to String and return
            return new String(returnValue);
        }
    }
    import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

    public class PasswordHasher {
        public static String hashPassword(String password) throws NoSuchAlgorithmException {
            // Create a new instance of the SHA-256 hash function
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Compute the hash of the password bytes
            byte[] hash = md.digest(password.getBytes());

            // Convert the hash bytes to a string of hexadecimal digits
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }

            // Return the hashed password as a string
            return sb.toString();
        }

        public static void main(String[] args) throws NoSuchAlgorithmException {
            // Define a password to hash
            String password = "myPassword123";

            // Hash the password using the SHA-256 algorithm
            String hashedPassword = hashPassword(password);

            // Print the original password and the hashed password
            System.out.println("Original password: " + password);
            System.out.println("Hashed password: " + hashedPassword);
        }
    }
    import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

    public class SaltedPasswordHasher {
        private static final int SALT_LENGTH = 16;

        public static void main(String[] args) throws NoSuchAlgorithmException {
            // Define a password to hash and verify
            String password = "myPassword123";

            // Hash the password with a salt
            String saltedHash = SaltedPasswordHasher.hashPassword(password);
            System.out.println("Salted hash of password: " + saltedHash);

            // Verify the password against the salted hash
            boolean isCorrectPassword = SaltedPasswordHasher.verifyPassword(password, saltedHash);
            System.out.println("Is password correct? " + isCorrectPassword);
        }

        // Hashes the given password with a random salt
        public static String hashPassword(String password) throws NoSuchAlgorithmException {
            SecureRandom random = new SecureRandom();

            // Generate a random salt
            byte[] salt = new byte[SALT_LENGTH];
            random.nextBytes(salt);

            // Hash the password with the salt
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hash = md.digest(password.getBytes());

            // Concatenate the salt and hashed password, and encode as a Base64 string
            String saltedHash = Base64.getEncoder().encodeToString(concatenateArrays(salt, hash));
            return saltedHash;
        }

        // Verifies a password against a salted hash
        public static boolean verifyPassword(String password, String saltedHash) throws NoSuchAlgorithmException {
            // Decode the salted hash back into its constituent salt and hash values
            byte[] saltAndHash = Base64.getDecoder().decode(saltedHash);
            byte[] salt = new byte[SALT_LENGTH];
            byte[] hash = new byte[saltAndHash.length - SALT_LENGTH];
            splitArray(saltAndHash, salt, hash);

            // Hash the password with the retrieved salt
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] testHash = md.digest(password.getBytes());

            // Compare the computed hash with the stored hash
            return MessageDigest.isEqual(hash, testHash);
        }

        // Concatenates two byte arrays into a single array
        private static byte[] concatenateArrays(byte[] a, byte[] b) {
            byte[] result = new byte[a.length + b.length];
            System.arraycopy(a, 0, result, 0, a.length);
            System.arraycopy(b, 0, result, a.length, b.length);
            return result;
        }

        // Splits a byte array into two separate arrays
        private static void splitArray(byte[] source, byte[] dest1, byte[] dest2) {
            System.arraycopy(source, 0, dest1, 0, dest1.length);
            System.arraycopy(source, dest1.length, dest2, 0, dest2.length);
        }
    }



}
