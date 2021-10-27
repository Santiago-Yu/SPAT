class n7194282 {
	public static String createNormalizedJarDescriptorDigest(String e1boeoO4) throws Exception {
		String MRnSWj8z = createNormalizedDescriptor(new JarFile2(e1boeoO4));
		try {
			MessageDigest WFiZvTNx = MessageDigest.getInstance("MD5");
			WFiZvTNx.update(MRnSWj8z.getBytes());
			byte[] S4bojFJ4 = WFiZvTNx.digest();
			StringBuffer bDXrKtpu = new StringBuffer();
			for (int Kks7SdLc = 0; Kks7SdLc < S4bojFJ4.length; Kks7SdLc++) {
				bDXrKtpu.append(Integer.toHexString(0xFF & S4bojFJ4[Kks7SdLc]));
			}
			return bDXrKtpu.toString();
		} catch (NoSuchAlgorithmException JoBSN2mi) {
			JoBSN2mi.printStackTrace();
		}
		return "";
	}

}