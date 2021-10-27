class n16341721 {
	public boolean isPasswordCorrect(String piS7fZ9g) {
		try {
			MessageDigest xCsnaZyL = MessageDigest.getInstance(piS7fZ9g);
			xCsnaZyL.update(salt);
			xCsnaZyL.update(piS7fZ9g.getBytes("UTF-8"));
			byte[] O1mHtDVQ = xCsnaZyL.digest();
			return O1mHtDVQ.equals(hash);
		} catch (UnsupportedEncodingException ADLoT5vU) {
			Logger.getLogger(UserRecord.class.getName()).log(Level.SEVERE, null, ADLoT5vU);
			return false;
		} catch (NoSuchAlgorithmException gVpxaf7R) {
			Logger.getLogger(UserRecord.class.getName()).log(Level.SEVERE, null, gVpxaf7R);
			return false;
		}
	}

}