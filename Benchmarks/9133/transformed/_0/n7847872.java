class n7847872 {
	public String encrypt(String PftUKywN, String yFgx3MxA, int GMNzMElH) {
		RC2ParameterSpec WfoSALAr = new RC2ParameterSpec(GMNzMElH);
		try {
			MessageDigest lfeMfEbg = MessageDigest.getInstance("MD5");
			lfeMfEbg.update(yFgx3MxA.getBytes(getCharset()));
			SecretKeySpec KnacYAyU = new SecretKeySpec(lfeMfEbg.digest(), "RC2");
			Cipher xwhcILIN = Cipher.getInstance("RC2/ECB/NoPadding");
			xwhcILIN.init(Cipher.ENCRYPT_MODE, KnacYAyU, WfoSALAr);
			byte[] HPGbhxk5 = encodeStringNew(PftUKywN);
			byte[] HFE5nvYo = xwhcILIN.doFinal(HPGbhxk5);
			return Base64.encodeBytes(HFE5nvYo);
		} catch (NoSuchAlgorithmException b2GK3Mut) {
			b2GK3Mut.printStackTrace();
		} catch (NoSuchPaddingException yZXdMTNO) {
			yZXdMTNO.printStackTrace();
		} catch (InvalidKeyException wltclnPc) {
			wltclnPc.printStackTrace();
		} catch (InvalidAlgorithmParameterException CpMxAlum) {
			CpMxAlum.printStackTrace();
		} catch (IllegalBlockSizeException X26QANmA) {
			X26QANmA.printStackTrace();
		} catch (BadPaddingException yHGzsYxv) {
			yHGzsYxv.printStackTrace();
		}
		return null;
	}

}