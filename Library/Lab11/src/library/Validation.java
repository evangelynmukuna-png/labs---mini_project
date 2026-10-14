package library;
final class Validation {
        private Validation() { }

        static String requireText(String value, String field) {
            if (value == null || value.isBlank()) {
                throw new IllegalArgumentException(field + " must not be blank");
            }
            if (value.contains(",")) {
                throw new IllegalArgumentException(field + " must not contain commas");
            }
            return value.trim();
        }
}

