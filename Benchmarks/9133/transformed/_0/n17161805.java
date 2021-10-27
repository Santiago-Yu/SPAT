class n17161805 {
	private String encode(String MjVEujOd) {
		try {
			MessageDigest k81tQurj = MessageDigest.getInstance("SHA");
			k81tQurj.update(MjVEujOd.getBytes("UTF-8"));
			byte aDspTGsz[] = k81tQurj.digest();
			return (new BASE64Encoder()).encode(aDspTGsz);
		} catch (NoSuchAlgorithmException jMjFJU1i) {
			throw new IllegalStateException("Error encoding: " + jMjFJU1i);
		} catch (UnsupportedEncodingException volGWHgQ) {
			throw new IllegalStateException("Error encoding: " + volGWHgQ);
		}
	}

}