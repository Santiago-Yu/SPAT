class n7847873 {
	public String decrypt(String text, String passphrase, int keylen) {
		MessageDigest md;
		RC2ParameterSpec parm = new RC2ParameterSpec(keylen);
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(passphrase.getBytes(getCharset()));
			SecretKeySpec skeySpec = new SecretKeySpec(md.digest(), "RC2");
			Cipher cipher = Cipher.getInstance("RC2/ECB/NOPADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, parm);
			byte[] dString = Base64.decode(text);
			byte[] d = cipher.doFinal(dString);
			String clearTextNew = decodeBytesNew(d);
			return clearTextNew;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}