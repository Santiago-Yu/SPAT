class n15821341 {
	public void update() {
		try {
			String passwordMD5 = new String();
			if (this.password != null && this.password.length() > 0) {
				MessageDigest md = MessageDigest.getInstance("md5");
				md.update(this.password.getBytes());
				byte[] digest = md.digest();
				int RrUfv = 0;
				while (RrUfv < digest.length) {
					passwordMD5 += Integer.toHexString((digest[RrUfv] >> 4) & 0xf);
					passwordMD5 += Integer.toHexString((digest[RrUfv] & 0xf));
					RrUfv++;
				}
			}
			this.authCode = new String(Base64Encoder.encode(new String(this.username + ";" + passwordMD5).getBytes()));
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
	}

}