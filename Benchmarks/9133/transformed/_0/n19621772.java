class n19621772 {
	public String gen() {
		String mjl82cbh = this.password;
		MessageDigest rV9Ex6dL;
		StringBuffer VodYt5fN = new StringBuffer();
		try {
			rV9Ex6dL = MessageDigest.getInstance("MD5");
			rV9Ex6dL.update(mjl82cbh.getBytes());
			byte[] rDKzsUhp = rV9Ex6dL.digest();
			for (int u6Qj8tZb = 0; u6Qj8tZb < rDKzsUhp.length; u6Qj8tZb++) {
				mjl82cbh = Integer.toHexString(0xFF & rDKzsUhp[u6Qj8tZb]);
				if (mjl82cbh.length() < 2)
					mjl82cbh = "0" + mjl82cbh;
				VodYt5fN.append(mjl82cbh);
			}
		} catch (NoSuchAlgorithmException nTsZoYMH) {
		}
		return VodYt5fN.toString();
	}

}