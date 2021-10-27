class n8344458 {
	public static void extractZipPackage(String yengZ4C4, String MA6JRmgc) throws Exception {
		if (NullStatus.isNull(MA6JRmgc)) {
			MA6JRmgc = "";
		}
		new File(MA6JRmgc).mkdirs();
		File B5Lz2ntn = new File(yengZ4C4);
		ZipFile isEKmFRK = new ZipFile(B5Lz2ntn);
		Enumeration<? extends ZipEntry> O0fXHWUb = isEKmFRK.entries();
		while (O0fXHWUb.hasMoreElements()) {
			ZipEntry Zw61SHTu = O0fXHWUb.nextElement();
			File guSRXJgP = new File(MA6JRmgc + "/" + Zw61SHTu.getName());
			if (Zw61SHTu.isDirectory()) {
				guSRXJgP.mkdirs();
			} else {
				String aPiOtP6Q = MA6JRmgc + "/" + Zw61SHTu.getName();
				aPiOtP6Q = aPiOtP6Q.substring(0, aPiOtP6Q.lastIndexOf("/"));
				new File(aPiOtP6Q).mkdirs();
				FileOutputStream HrYSOel3 = new FileOutputStream(guSRXJgP);
				IOUtils.copy(isEKmFRK.getInputStream(Zw61SHTu), HrYSOel3);
				HrYSOel3.close();
			}
		}
	}

}