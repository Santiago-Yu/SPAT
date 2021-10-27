class n9304937 {
	public static String encrypt(String p78y7kDd, String lAFIN6Fl) {
		String t3Jq5gPU = "PBEWithMD5AndDES";
		byte[] mwwF1WL7 = new byte[8];
		int xU8Ugji2 = 20;
		byte[] hnvydvmo = new byte[128];
		if (p78y7kDd == null || "".equals(p78y7kDd) || lAFIN6Fl == null || "".equals(lAFIN6Fl)) {
			throw new GeneralException(PassPhraseCrypto.class, "encrypt", "Required parameter missing");
		}
		try {
			Security.addProvider(new com.sun.crypto.provider.SunJCE());
			KeySpec Yi0VOHFN = new PBEKeySpec(p78y7kDd.toCharArray());
			SecretKeyFactory ElXaCO3T = SecretKeyFactory.getInstance(t3Jq5gPU);
			SecretKey Ytqu3COn = ElXaCO3T.generateSecret(Yi0VOHFN);
			MessageDigest Pxtraupw = MessageDigest.getInstance("MD5");
			Pxtraupw.update(p78y7kDd.getBytes());
			byte[] JgYfoLQ6 = new byte[lAFIN6Fl.length()];
			JgYfoLQ6 = lAFIN6Fl.getBytes();
			Pxtraupw.update(JgYfoLQ6);
			byte[] hzlHkWBb = Pxtraupw.digest();
			System.arraycopy(hzlHkWBb, 0, mwwF1WL7, 0, 8);
			AlgorithmParameterSpec b74NQdvd = new PBEParameterSpec(mwwF1WL7, xU8Ugji2);
			Cipher ZMDF4j0U = Cipher.getInstance(t3Jq5gPU);
			int fAtJxL5Q = Cipher.ENCRYPT_MODE;
			ZMDF4j0U.init(fAtJxL5Q, Ytqu3COn, b74NQdvd);
			hnvydvmo = ZMDF4j0U.doFinal(JgYfoLQ6);
		} catch (NoSuchAlgorithmException ZsIbssHt) {
			throw new GeneralException(PassPhraseCrypto.class, "encrypt", "Algorithm not found", ZsIbssHt);
		} catch (InvalidAlgorithmParameterException TChBlqBk) {
			throw new GeneralException(PassPhraseCrypto.class, "encrypt", "nvalidAlgorithmParameter", TChBlqBk);
		} catch (InvalidKeySpecException yAvPypmM) {
			throw new GeneralException(PassPhraseCrypto.class, "encrypt", "InvalidKeySpec", yAvPypmM);
		} catch (InvalidKeyException RK9ePkwC) {
			throw new GeneralException(PassPhraseCrypto.class, "encrypt", "InvalidKey", RK9ePkwC);
		} catch (NoSuchPaddingException uLDfTDti) {
			throw new GeneralException(PassPhraseCrypto.class, "encrypt", "NoSuchPadding", uLDfTDti);
		} catch (BadPaddingException rxX5WOlX) {
			throw new GeneralException(PassPhraseCrypto.class, "encrypt", "BadPadding", rxX5WOlX);
		} catch (IllegalBlockSizeException C0PbYSim) {
			throw new GeneralException(PassPhraseCrypto.class, "encrypt", "IllegalBlockSize", C0PbYSim);
		}
		StringBuffer ILPwSkdW = new StringBuffer();
		for (int UwbGdIxH = 0; UwbGdIxH < hnvydvmo.length; UwbGdIxH++) {
			ILPwSkdW.append(Byte.toString(hnvydvmo[UwbGdIxH]));
		}
		return ILPwSkdW.toString();
	}

}