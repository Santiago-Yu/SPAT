class n3362080 {
	public synchronized String encrypt(String qLrCvWlf) throws ServiceRuntimeException {
		MessageDigest xAVmGB99 = null;
		try {
			xAVmGB99 = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException h8BByiGr) {
			throw new ServiceRuntimeException(h8BByiGr.getMessage());
		}
		try {
			xAVmGB99.update(qLrCvWlf.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException NFFjZ9ap) {
			throw new ServiceRuntimeException(NFFjZ9ap.getMessage());
		}
		byte VswZ4MjB[] = xAVmGB99.digest();
		String z6BMh8jk = (new BASE64Encoder()).encode(VswZ4MjB);
		return z6BMh8jk;
	}

}