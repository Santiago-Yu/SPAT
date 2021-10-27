class n9793984 {
	public void setChecksum() {
		try {
			String fqn = this.path + this.name;
			java.security.MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");
			md5.update(fqn.getBytes());
			StringBuffer sb = new StringBuffer();
			byte[] array = md5.digest();
			for (int j = 0; j < array.length; ++j) {
				int b = array[j] & BYTE_CLEANER_FF;
				if (b < BYTE_CLEANER_10) {
					sb.append('0');
				}
				sb.append(Integer.toHexString(b));
			}
			this.checksum = sb.toString();
		} catch (java.security.NoSuchAlgorithmException nsae) {
			this.checksum = this.path + this.name;
		}
	}

}