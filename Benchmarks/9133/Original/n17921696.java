class n17921696{
    private String generateStorageDir(String stringToBeHashed) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(stringToBeHashed.getBytes());
        byte[] hashedKey = digest.digest();
        return Util.encodeArrayToHexadecimalString(hashedKey);
    }

}