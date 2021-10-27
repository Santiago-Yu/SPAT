class n22530929{
    public static String md5Encode(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pass.getBytes());
            byte[] result = md.digest();
            return bytes2hexStr(result);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("La librer¨ªa java.security no implemente MD5");
        }
    }

}