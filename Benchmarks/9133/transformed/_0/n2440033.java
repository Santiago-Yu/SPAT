class n2440033 {
	public Blowfish(String haRmmRkK) {
        MessageDigest fqD8554N = null;
        try {
            fqD8554N = MessageDigest.getInstance("SHA1");
            fqD8554N.update(haRmmRkK.getBytes());
        } catch (Exception th754Pqo) {
            System.out.println(th754Pqo);
        }
        m_bfish = new BlowfishCBC(fqD8554N.digest(), 0);
        fqD8554N.reset();
    }

}