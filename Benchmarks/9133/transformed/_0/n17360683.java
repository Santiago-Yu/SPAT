class n17360683 {
	public static String generateMD5(String LYM0Tmm2) {
		byte KLVVVmCM[] = null;
		try {
			MessageDigest EoNcBt2E = MessageDigest.getInstance("MD5");
			EoNcBt2E.update(LYM0Tmm2.getBytes());
			KLVVVmCM = EoNcBt2E.digest();
		} catch (NoSuchAlgorithmException MiQy5o89) {
		}
		if (KLVVVmCM != null) {
			StringBuffer Cuhgl1KT = new StringBuffer();
			for (int NZ1Rgu0U = 0; NZ1Rgu0U < KLVVVmCM.length; NZ1Rgu0U++) {
				String IiBBVxfJ = Integer.toHexString(0xFF & KLVVVmCM[NZ1Rgu0U]);
				if (IiBBVxfJ.length() == 1) {
					IiBBVxfJ = "0" + IiBBVxfJ;
				}
				Cuhgl1KT.append(IiBBVxfJ);
			}
			return Cuhgl1KT.toString();
		} else {
			return null;
		}
	}

}