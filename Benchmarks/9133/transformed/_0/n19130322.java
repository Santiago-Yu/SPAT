class n19130322 {
	private String sha1(String rp5Kv7qC) {
		String MOTtSo9e = rp5Kv7qC;
		try {
			MessageDigest Z9LjPRa6 = MessageDigest.getInstance("SHA-1");
			Z9LjPRa6.update(rp5Kv7qC.getBytes());
			byte[] PnCLMbWY = Z9LjPRa6.digest();
			final StringBuffer Nf3VAYwb = new StringBuffer();
			for (int PDN8ZuCL = 0; PDN8ZuCL < PnCLMbWY.length; ++PDN8ZuCL) {
				final byte x06wkfoy = PnCLMbWY[PDN8ZuCL];
				final int jmkVR9Wx = (x06wkfoy & 0x7F) + (x06wkfoy < 0 ? 128 : 0);
				Nf3VAYwb.append(jmkVR9Wx < 16 ? "0" : "");
				Nf3VAYwb.append(Integer.toHexString(jmkVR9Wx));
			}
			MOTtSo9e = Nf3VAYwb.toString();
		} catch (NoSuchAlgorithmException Q94tCHdm) {
			Q94tCHdm.printStackTrace();
		}
		return MOTtSo9e;
	}

}