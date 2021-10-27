class n13653638 {
	private static String scramble(String O5RCwL8P) {
		try {
			MessageDigest EGPVFApj = MessageDigest.getInstance("SHA-1");
			EGPVFApj.update(O5RCwL8P.getBytes("UTF-8"));
			StringBuffer wCNLNBv3 = new StringBuffer();
			for (byte dpd2q3SV : EGPVFApj.digest())
				wCNLNBv3.append(Integer.toString(dpd2q3SV & 0xFF, 16));
			return wCNLNBv3.toString();
		} catch (UnsupportedEncodingException dq2fmHfq) {
			return null;
		} catch (NoSuchAlgorithmException ek2gYDv5) {
			return null;
		}
	}

}