package com.gabriel.taskManager.TaskManager.domain.ValueObjects;

public record Identification(String rg, String cpf, String passaporte) {
    public Identification {
        // Rule: At least one identification must be provided.
        if (isStringBlank(rg) && isStringBlank(cpf) && isStringBlank(passaporte)) {
            throw new IllegalArgumentException("At least one form of identification (RG, CPF, or Passport) must be provided.");
        }

        // Validate each field only if it's provided
        if (!isStringBlank(cpf) && !isValidCpf(cpf)) {
            throw new IllegalArgumentException("Invalid CPF format or checksum.");
        }
        if (!isStringBlank(rg) && !isValidRg(rg)) {
            throw new IllegalArgumentException("Invalid RG format.");
        }
        if (!isStringBlank(passaporte) && !isValidPassaporte(passaporte)) {
            throw new IllegalArgumentException("Invalid Passport format.");
        }
    }
    /**
     * A helper method to check if a string is null, empty, or just whitespace.
     */
    private static boolean isStringBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
    /**
     * Provides basic validation for an RG number.
     * Since RG formats vary significantly by state in Brazil, this check is intentionally broad.
     */
    private static boolean isValidRg(String rg) {
        // Checks for a reasonable length and that it contains mostly digits, allowing for 'X', '.', and '-'
        return rg.length() >= 5 && rg.length() <= 15 && rg.matches("^[0-9Xx.-]+$");
    }

    /**
     * Provides basic validation for a Passport number.
     * Since passport formats vary by country, this is a general check.
     */
    private static boolean isValidPassaporte(String passaporte) {
        // Checks for a reasonable length and alphanumeric characters.
        return passaporte.length() >= 6 && passaporte.length() <= 15 && passaporte.matches("^[A-Za-z0-9]+$");
    }
    /**
     * Validates a Brazilian CPF number, including its check digits.
     *
     * @param cpf The CPF string, which can be formatted (e.g., "123.456.789-00") or unformatted.
     * @return true if the CPF is valid, false otherwise.
     */
    private static boolean isValidCpf(String cpf) {
        // Remove common formatting characters
        String cleanedCpf = cpf.replaceAll("[.\\-]", "");

        // CPF must have 11 digits and must not be a sequence of repeated digits
        if (cleanedCpf.length() != 11 || cleanedCpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            // --- Calculate and verify the first check digit ---
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += (cleanedCpf.charAt(i) - '0') * (10 - i);
            }
            int firstCheckDigit = 11 - (sum % 11);
            if (firstCheckDigit >= 10) {
                firstCheckDigit = 0;
            }
            if ((cleanedCpf.charAt(9) - '0') != firstCheckDigit) {
                return false;
            }

            // --- Calculate and verify the second check digit ---
            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += (cleanedCpf.charAt(i) - '0') * (11 - i);
            }
            int secondCheckDigit = 11 - (sum % 11);
            if (secondCheckDigit >= 10) {
                secondCheckDigit = 0;
            }
            return (cleanedCpf.charAt(10) - '0') == secondCheckDigit;

        } catch (NumberFormatException e) {
            return false;
        }
    }
}
