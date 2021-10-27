class n8335460 {
	public static String encrypt(String Ayr1inTC, String VwXnNMtG, byte[] pbr4Zy8L) {
		StringBuffer HFoLW5Nc = new StringBuffer();
		MessageDigest MtHF9w4Z = null;
		int huzWt8ZI = 0;
		if ("CRYPT".equalsIgnoreCase(VwXnNMtG)) {
			throw new InternalError("Not implemented");
		} else if ("SHA".equalsIgnoreCase(VwXnNMtG) || "SSHA".equalsIgnoreCase(VwXnNMtG)) {
			huzWt8ZI = 20;
			if (pbr4Zy8L != null && pbr4Zy8L.length > 0) {
				HFoLW5Nc.append("{SSHA}");
			} else {
				HFoLW5Nc.append("{SHA}");
			}
			try {
				MtHF9w4Z = MessageDigest.getInstance("SHA-1");
			} catch (NoSuchAlgorithmException edBJvPCi) {
				throw new InternalError("Invalid algorithm");
			}
		} else if ("MD5".equalsIgnoreCase(VwXnNMtG) || "SMD5".equalsIgnoreCase(VwXnNMtG)) {
			huzWt8ZI = 16;
			if (pbr4Zy8L != null && pbr4Zy8L.length > 0) {
				HFoLW5Nc.append("{SMD5}");
			} else {
				HFoLW5Nc.append("{MD5}");
			}
			try {
				MtHF9w4Z = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException Fkd38FEe) {
				throw new InternalError("Invalid algorithm");
			}
		}
		int QA1V3T7F = huzWt8ZI;
		MtHF9w4Z.reset();
		MtHF9w4Z.update(Ayr1inTC.getBytes());
		if (pbr4Zy8L != null && pbr4Zy8L.length > 0) {
			MtHF9w4Z.update(pbr4Zy8L);
			QA1V3T7F += pbr4Zy8L.length;
		}
		byte[] rSUw0D1b = new byte[QA1V3T7F];
		System.arraycopy(MtHF9w4Z.digest(), 0, rSUw0D1b, 0, huzWt8ZI);
		if (pbr4Zy8L != null && pbr4Zy8L.length > 0) {
			System.arraycopy(pbr4Zy8L, 0, rSUw0D1b, huzWt8ZI, pbr4Zy8L.length);
		}
		HFoLW5Nc.append(Base64.encode(rSUw0D1b));
		return HFoLW5Nc.toString();
	}

}