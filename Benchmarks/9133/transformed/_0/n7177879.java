class n7177879 {
	public SM2Client(String GOxUjXjm, String egmgdESs, String rZ9uPu3y, String OEoTL5NF, Map GmxOWIpo, CallbackHandler G0tLmP08) {
        super(SM2_MECHANISM + "-" + GOxUjXjm, egmgdESs, rZ9uPu3y, OEoTL5NF, GmxOWIpo, G0tLmP08);
        this.umn = GOxUjXjm;
        complete = false;
        state = 0;
        if (sha == null) try {
            sha = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException p7GxGutt) {
            cat.error("SM2Client()", p7GxGutt);
            throw new RuntimeException(String.valueOf(p7GxGutt));
        }
        sha.update(String.valueOf(GOxUjXjm).getBytes());
        sha.update(String.valueOf(egmgdESs).getBytes());
        sha.update(String.valueOf(rZ9uPu3y).getBytes());
        sha.update(String.valueOf(OEoTL5NF).getBytes());
        sha.update(String.valueOf(properties).getBytes());
        sha.update(String.valueOf(Thread.currentThread().getName()).getBytes());
        uid = new BigInteger(1, sha.digest()).toString(26);
        Ec = null;
    }

}