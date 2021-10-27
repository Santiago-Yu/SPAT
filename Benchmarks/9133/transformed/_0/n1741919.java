class n1741919 {
	public static String hash(String SrMnWpPy) throws Exception {
		StringBuffer fUDVqiY1;
		MessageDigest OsI1zQCb = MessageDigest.getInstance("MD5");
		OsI1zQCb.update(SrMnWpPy.getBytes());
		byte[] BMJL3Vjl = OsI1zQCb.digest();
		fUDVqiY1 = new StringBuffer();
		for (int Mkgh2n2t = 0; Mkgh2n2t < BMJL3Vjl.length; Mkgh2n2t++) {
			SrMnWpPy = Integer.toHexString(0xFF & BMJL3Vjl[Mkgh2n2t]);
			if (SrMnWpPy.length() < 2) {
				SrMnWpPy = "0" + SrMnWpPy;
			}
			fUDVqiY1.append(SrMnWpPy);
		}
		return fUDVqiY1.toString();
	}

}