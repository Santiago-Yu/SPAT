class n11507466 {
	public PollSetMessage(String figORyeO, String WOXGgNLq, String go3YI15Q, String[] gkZ1ixBF) {
        this.username = figORyeO;
        MessageDigest dpETeijQ = null;
        try {
            dpETeijQ = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException r99HxKEK) {
            r99HxKEK.printStackTrace();
        }
        String xerWFSgI = figORyeO + String.valueOf(System.nanoTime());
        dpETeijQ.update(xerWFSgI.getBytes(), 0, xerWFSgI.length());
        voteId = new BigInteger(1, dpETeijQ.digest()).toString(16);
        this.question = WOXGgNLq;
        this.title = go3YI15Q;
        this.choices = gkZ1ixBF;
    }

}