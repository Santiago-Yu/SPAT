class n15821341 {
	public void update() {
		try {
			String na3YjBRL = new String();
			if (this.password != null && this.password.length() > 0) {
				MessageDigest WnPuMeOg = MessageDigest.getInstance("md5");
				WnPuMeOg.update(this.password.getBytes());
				byte[] tLUiMmMD = WnPuMeOg.digest();
				for (int zvjme98Y = 0; zvjme98Y < tLUiMmMD.length; zvjme98Y++) {
					na3YjBRL += Integer.toHexString((tLUiMmMD[zvjme98Y] >> 4) & 0xf);
					na3YjBRL += Integer.toHexString((tLUiMmMD[zvjme98Y] & 0xf));
				}
			}
			this.authCode = new String(Base64Encoder.encode(new String(this.username + ";" + na3YjBRL).getBytes()));
		} catch (Throwable OfSjeyxH) {
			OfSjeyxH.printStackTrace();
		}
	}

}