class n9793984 {
	public void setChecksum() {
		try {
			java.security.MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");
			String fqn = this.path + this.name;
			md5.update(fqn.getBytes());
			byte[] array = md5.digest();
			StringBuffer sb = new StringBuffer();
			int o1mN2 = 0;
			while (o1mN2 < array.length) {
				int b = array[o1mN2] & BYTE_CLEANER_FF;
				if (b < BYTE_CLEANER_10) {
					sb.append('0');
				}
				sb.append(Integer.toHexString(b));
				++o1mN2;
			}
			this.checksum = sb.toString();
		} catch (java.security.NoSuchAlgorithmException nsae) {
			this.checksum = this.path + this.name;
		}
	}

}