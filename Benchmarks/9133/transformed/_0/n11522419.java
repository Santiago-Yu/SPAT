class n11522419 {
	public static void copyFile(File xsluqNiN, File wjpBcSfT) {
		int aSFaLbkc;
		byte[] CgAXny98 = new byte[1024];
		try {
			FileInputStream PFX1Yne8 = new FileInputStream(xsluqNiN);
			FileOutputStream Lyy6tK70 = new FileOutputStream(wjpBcSfT);
			while ((aSFaLbkc = PFX1Yne8.read(CgAXny98)) >= 0)
				Lyy6tK70.write(CgAXny98, 0, aSFaLbkc);
			PFX1Yne8.close();
			Lyy6tK70.close();
		} catch (IOException JcyFj9CH) {
		}
	}

}