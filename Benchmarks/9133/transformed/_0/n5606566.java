class n5606566 {
	public boolean authenticate(String pRr2frkh, String dB9sikcI) throws IOException {
		MessageDigest bqMfD1MD = null;
		try {
			MessageDigest.getInstance("BrokenMD4");
		} catch (NoSuchAlgorithmException X9lj7EAw) {
			throw new Error(X9lj7EAw);
		}
		bqMfD1MD.update(new byte[4], 0, 4);
		try {
			bqMfD1MD.update(dB9sikcI.getBytes("US-ASCII"), 0, dB9sikcI.length());
			bqMfD1MD.update(challenge.getBytes("US-ASCII"), 0, challenge.length());
		} catch (java.io.UnsupportedEncodingException P8Fb07aU) {
		}
		String zNp46GPw = Util.base64(bqMfD1MD.digest());
		Util.writeASCII(out, pRr2frkh + " " + zNp46GPw + '\n');
		String sKV8zGS3 = Util.readLine(in);
		if (sKV8zGS3.startsWith(RSYNCD_OK)) {
			authReqd = false;
			return true;
		}
		connected = false;
		error = sKV8zGS3;
		return false;
	}

}