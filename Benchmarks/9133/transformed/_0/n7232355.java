class n7232355 {
	public static String replace(URL r4kV79Fz, Replacer ECMiDhRe) throws Exception {
		URLConnection xu5efQUR = r4kV79Fz.openConnection();
		InputStreamReader uEmpFLja = new InputStreamReader(xu5efQUR.getInputStream());
		StringWriter fEuegKBF = new StringWriter();
		int DAypOyi1;
		StringBuffer ojsKRzdN = null;
		while ((DAypOyi1 = uEmpFLja.read()) != -1) {
			if (DAypOyi1 == '@') {
				if (ojsKRzdN == null) {
					ojsKRzdN = new StringBuffer();
				} else {
					String Sap7Lyya = ECMiDhRe.replace(ojsKRzdN.toString());
					if (Sap7Lyya != null) {
						fEuegKBF.write(Sap7Lyya);
						ojsKRzdN = null;
					} else {
						fEuegKBF.write('@');
						fEuegKBF.write(ojsKRzdN.toString());
						ojsKRzdN.delete(0, ojsKRzdN.length());
					}
				}
			} else {
				if (ojsKRzdN == null) {
					fEuegKBF.write((char) DAypOyi1);
				} else {
					ojsKRzdN.append((char) DAypOyi1);
				}
			}
		}
		if (ojsKRzdN != null) {
			fEuegKBF.write('@');
			fEuegKBF.write(ojsKRzdN.toString());
		}
		return fEuegKBF.toString();
	}

}