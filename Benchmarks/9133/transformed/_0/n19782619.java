class n19782619 {
	public synchronized String encrypt(String nSEouord) throws ServiceUnavailableException {
		MessageDigest HjpTG447 = null;
		try {
			HjpTG447 = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException dGgPx081) {
			throw new ServiceUnavailableException(dGgPx081.getMessage());
		}
		try {
			HjpTG447.update(nSEouord.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException xYBr3Yf5) {
			throw new ServiceUnavailableException(xYBr3Yf5.getMessage());
		}
		byte ao1hl6Ye[] = HjpTG447.digest();
		String EVYJAf8O = (new BASE64Encoder()).encode(ao1hl6Ye);
		return EVYJAf8O;
	}

}