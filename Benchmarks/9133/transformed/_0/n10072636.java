class n10072636 {
	public Blowfish(String sklPBh9Y) {
        MessageDigest SUs2NXKJ = null;
        try {
            SUs2NXKJ = MessageDigest.getInstance("SHA1");
            SUs2NXKJ.update(sklPBh9Y.getBytes());
        } catch (Exception mOvMAAV5) {
            Log.error(mOvMAAV5.getMessage(), mOvMAAV5);
        }
        m_bfish = new BlowfishCBC(SUs2NXKJ.digest(), 0);
        SUs2NXKJ.reset();
    }

}