class n8288993{
    private SecretKey getSecretKey() {
        try {
            String path = "/org.dbreplicator/repconsole/secretKey.obj";
            java.net.URL url1 = getClass().getResource(path);
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(url1.openStream()));
            SecretKey sk = (SecretKey) ois.readObject();
            return sk;
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
        return null;
    }

}