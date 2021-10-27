class n22752444 {
	public synchronized String encrypt(String HJr9gGm1) {
		String bLdNvWEV = null;
		try {
			MessageDigest nC7xfKHG = null;
			try {
				nC7xfKHG = MessageDigest.getInstance("SHA");
			} catch (NoSuchAlgorithmException rBghO1ld) {
				throw new NoSuchAlgorithmException();
			}
			try {
				if (HJr9gGm1 != null)
					nC7xfKHG.update(HJr9gGm1.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException KuRcIDzh) {
				throw new UnsupportedEncodingException();
			}
			byte iyfE31fA[] = nC7xfKHG.digest();
			bLdNvWEV = (new BASE64Encoder()).encode(iyfE31fA);
		} catch (NoSuchAlgorithmException SltLnIsh) {
			MessageLog.writeErrorMessage(SltLnIsh, this);
		} catch (UnsupportedEncodingException t8gonKoe) {
			MessageLog.writeErrorMessage(t8gonKoe, this);
		}
		return Util.stripChars(bLdNvWEV);
	}

}