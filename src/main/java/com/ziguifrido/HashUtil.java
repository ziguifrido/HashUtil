package com.ziguifrido;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * HashUtil.java
 * Purpose: Generate and validate MD5, SHA-1, SHA-256 and SHA-512 hashes.
 *
 * @author Marcos Oliveira
 * @version 1.0 09/01/2018
 */
class HashUtil {

    private static MessageDigest md;

    /**
     * Generates a MD5 hash from a key
     *
     * @return A String with MD5 hash.
     */
    public static String md5(String key) {
        return hash(key, "MD5");
    }

    /**
     * Generates a SHA-1 hash from a key
     *
     * @return A String with SHA-1 hash.
     */
    public static String sha1(String key) {
        return hash(key, "SHA-1");
    }

    /**
     * Generates a SHA-256 hash from a key
     *
     * @return A String with SHA-256 hash.
     */
    public static String sha256(String key) {
        return hash(key, "SHA-256");
    }

    /**
     * Generates a SHA-512 hash from a key
     *
     * @return A String with SHA-512 hash.
     */
    public static String sha512(String key) {
        return hash(key, "SHA-512");
    }


    /**
     * Generates a hash from determined key and hash algorithm (MD5, SHA-1, SHA-256, SHA-512)
     *
     * @return A String with the hash.
     */
    public static String hash(String key, String algorithm) {
        if (algorithm.matches("MD5|SHA-1|SHA-256|SHA-512")) {
            try {
                md = MessageDigest.getInstance(algorithm);
                byte hash[] = md.digest(key.getBytes("UTF-8"));
                StringBuilder sb = new StringBuilder();
                for (byte b : hash) {
                    sb.append(String.format("%02X", 0xFF & b));
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "ERROR: Incompatible hash algorithm!";
    }

    /**
     * Validates a hash from the hash MD5 generated from the given key
     *
     * @return A Boolean with the validation result.
     */
    public static boolean validateMD5(String key, String hash) {
        return validateHash(key, hash, "MD5");
    }

    /**
     * Validates a hash from the hash SHA-1 generated from the given key
     *
     * @return A Boolean with the validation result.
     */
    public static boolean validateSHA1(String key, String hash) {
        return validateHash(key, hash, "SHA-1");
    }

    /**
     * Validates a hash from the hash SHA-256 generated from the given key
     *
     * @return A Boolean with the validation result.
     */
    public static boolean validateSHA256(String key, String hash) {
        return validateHash(key, hash, "SHA-256");
    }

    /**
     * Validates a hash from the hash SHA-512 generated from the given key
     *
     * @return A Boolean with the validation result.
     */
    public static boolean validateSHA512(String key, String hash) {
        return validateHash(key, hash, "SHA-512");
    }

    /**
     * Validates a hash from the hash generated from the given key with given hash algorithm
     *
     * @return A Boolean with the validation result.
     */
    public static boolean validateHash(String key, String hash, String algorithm) {
        return hash.equals(hash(key, algorithm));
    }
}