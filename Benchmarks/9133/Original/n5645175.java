class n5645175{
    private String generaHashMD5(String plainText) throws Exception {
        MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
        mdAlgorithm.update(plainText.getBytes(FirmaUtil.CHARSET));
        byte[] digest = mdAlgorithm.digest();
        return toHex(digest);
    }

}