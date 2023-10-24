package com.ziguifrido;

import java.io.Console;
import java.util.Arrays;

public class ConsoleApp {

    private static Console console = System.console();

    static final String HASH = "Hash: ";
    static final String VALID_HASH = "The Hash is valid!!!\n\n";
    static final String INVALID_HASH = "The Hash is NOT valid!!!\n\n";
    static final String INVALID_OPTION = "ERROR: Invalid option!!!\n\n";
    static final String[] VALID_OPTIONS = { "1", "2" };
    static final String[] VALID_HASH_OPTIONS = { "1", "2", "3", "4" };

    public static void main(String[] args) {

        String option;
        String algorithm;
        String key;
        String hash;

        option = console.readLine("HashUtil\n\nChoose one option:\n\n1- Generate Hash;\n2- Validate Hash;\n\n:  ");

        if (!Arrays.asList(VALID_OPTIONS).contains(option)) {
            console.printf(INVALID_OPTION);
            return;
        }

        algorithm = console
                .readLine(
                        "Choose the Hash Algorithm:\n\n1- MD5;\n2- SHA-1;\n3- SHA-256;\n4- SHA-512;\n\n:  ");

        if (!Arrays.asList(VALID_HASH_OPTIONS).contains(algorithm)) {
            console.printf(INVALID_OPTION);
            return;
        }

        key = console.readLine("Enter the Key:  ");

        if (algorithm.equals("1")) {
            generateHash(algorithm, key);
        } else {
            hash = console.readLine("Enter the Hash:  ");
            validateHash(algorithm, key, hash);
        }

    }

    private static void generateHash(String algorithm, String key) {
        switch (algorithm) {
            case "1":
                console.printf(HASH + HashUtil.md5(key) + "\n\n");
                break;

            case "2":
                console.printf(HASH + HashUtil.sha1(key) + "\n\n");
                break;

            case "3":
                console.printf(HASH + HashUtil.sha256(key) + "\n\n");
                break;

            case "4":
                console.printf(HASH + HashUtil.sha512(key) + "\n\n");
                break;

            default:
                console.printf(INVALID_OPTION);
                break;
        }
    }

    public static void validateHash(String algorithm, String key, String hash) {
        switch (algorithm) {
            case "1":
                console.printf(HashUtil.validateMD5(key, hash) ? VALID_HASH : INVALID_HASH);
                break;

            case "2":
                console.printf(HashUtil.validateSHA1(key, hash) ? VALID_HASH : INVALID_HASH);
                break;

            case "3":
                console.printf(HashUtil.validateSHA256(key, hash) ? VALID_HASH : INVALID_HASH);
                break;

            case "4":
                console.printf(HashUtil.validateSHA512(key, hash) ? VALID_HASH : INVALID_HASH);
                break;

            default:
                console.printf(INVALID_OPTION);
                break;
        }
    }
}
