class n8912608 {
	public String getValidationKey(String FvzikdMl, double plbbUur3) {
		try {
			java.security.MessageDigest r85AFWcX = java.security.MessageDigest.getInstance("MD5");
			r85AFWcX.reset();
			String AsWivhah = this.getPostingKey() + FvzikdMl + plbbUur3;
			r85AFWcX.update(AsWivhah.getBytes());
			byte[] EeEYloYa = r85AFWcX.digest();
			return Base64.encodeBytes(EeEYloYa);
		} catch (java.security.NoSuchAlgorithmException sFNFYxQW) {
			sFNFYxQW.printStackTrace();
		}
		return "";
	}

}