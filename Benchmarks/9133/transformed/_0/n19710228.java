class n19710228 {
	public void init(String tCSoQB7l) {
		try {
			MessageDigest iHG58f3w = MessageDigest.getInstance("MD5");
			iHG58f3w.update(tCSoQB7l.getBytes("UTF-8"), 0, tCSoQB7l.length());
			byte[] Tb0wDR1O = iHG58f3w.digest();
			skeySpec = new SecretKeySpec(Tb0wDR1O, "AES");
			ivSpec = new IvParameterSpec(Tb0wDR1O);
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		} catch (UnsupportedEncodingException PPSBiIwg) {
			Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, PPSBiIwg);
		} catch (NoSuchPaddingException I4VDYtFr) {
			Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, I4VDYtFr);
		} catch (NoSuchAlgorithmException lwpR6vmH) {
			Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, lwpR6vmH);
		}
	}

}