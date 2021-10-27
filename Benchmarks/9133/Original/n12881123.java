class n12881123{
    ServerInfo getServerInfo(String key, String protocol) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException {
        DESedeKeySpec ks = new DESedeKeySpec(Base64.decode(key));
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DESede");
        SecretKey sk = skf.generateSecret(ks);
        Cipher cipher = Cipher.getInstance("DESede");
        cipher.init(Cipher.DECRYPT_MODE, sk);
        ClassLoader cl = this.getClass().getClassLoader();
        URL url = cl.getResource(protocol + ".sobj");
        JarURLConnection jc = (JarURLConnection) url.openConnection();
        ObjectInputStream os = new ObjectInputStream(jc.getInputStream());
        SealedObject so = (SealedObject) os.readObject();
        return (ServerInfo) so.getObject(cipher);
    }

}