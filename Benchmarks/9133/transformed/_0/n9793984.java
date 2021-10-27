class n9793984 {
	public void setChecksum() {
		try {
			java.security.MessageDigest q5tGaymz = java.security.MessageDigest.getInstance("MD5");
			String C3CIwnJl = this.path + this.name;
			q5tGaymz.update(C3CIwnJl.getBytes());
			byte[] Xxaim81k = q5tGaymz.digest();
			StringBuffer p5WWZDj7 = new StringBuffer();
			for (int dgePvibo = 0; dgePvibo < Xxaim81k.length; ++dgePvibo) {
				int CDOv3daQ = Xxaim81k[dgePvibo] & BYTE_CLEANER_FF;
				if (CDOv3daQ < BYTE_CLEANER_10) {
					p5WWZDj7.append('0');
				}
				p5WWZDj7.append(Integer.toHexString(CDOv3daQ));
			}
			this.checksum = p5WWZDj7.toString();
		} catch (java.security.NoSuchAlgorithmException qDSVhXcP) {
			this.checksum = this.path + this.name;
		}
	}

}