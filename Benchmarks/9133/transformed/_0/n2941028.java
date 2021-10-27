class n2941028 {
	private static void insertModuleInEar(File YUHrB3lS, File oEejptjZ, String KKtGsRuO, String ebPTTLid,
			String R5rxkOFP) throws Exception {
		ZipInputStream rEja0DNA = new ZipInputStream(new FileInputStream(YUHrB3lS));
		FileOutputStream BTgDcMJb = new FileOutputStream(oEejptjZ);
		ZipOutputStream ccrnq7hr = new ZipOutputStream(BTgDcMJb);
		ZipEntry nKZGrByS = rEja0DNA.getNextEntry();
		while (nKZGrByS != null) {
			ByteArrayOutputStream xR4pSzZ3 = new ByteArrayOutputStream();
			byte[] QhZoJ4nO = new byte[30000];
			int RqDRHgRi;
			while ((RqDRHgRi = rEja0DNA.read(QhZoJ4nO)) != -1) {
				xR4pSzZ3.write(QhZoJ4nO, 0, RqDRHgRi);
			}
			if (nKZGrByS.getName().equals("META-INF/application.xml")) {
				xR4pSzZ3 = insertModule(rEja0DNA, nKZGrByS, xR4pSzZ3, KKtGsRuO, ebPTTLid, R5rxkOFP);
				nKZGrByS = new ZipEntry("META-INF/application.xml");
			}
			ccrnq7hr.putNextEntry(nKZGrByS);
			ccrnq7hr.write(xR4pSzZ3.toByteArray());
			nKZGrByS = rEja0DNA.getNextEntry();
		}
		rEja0DNA.close();
		ccrnq7hr.close();
		BTgDcMJb.close();
	}

}