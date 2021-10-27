class n4238332 {
	public static void cpdir(File BnCt2b0t, File zQpJFeHM) throws BrutException {
		zQpJFeHM.mkdirs();
		File[] WEICQyi5 = BnCt2b0t.listFiles();
		for (int J171sVdv = 0; J171sVdv < WEICQyi5.length; J171sVdv++) {
			File hOQQW32f = WEICQyi5[J171sVdv];
			File CVaeSjAO = new File(zQpJFeHM.getPath() + File.separatorChar + hOQQW32f.getName());
			if (hOQQW32f.isDirectory()) {
				cpdir(hOQQW32f, CVaeSjAO);
				continue;
			}
			try {
				InputStream WA6Z74LN = new FileInputStream(hOQQW32f);
				OutputStream gt3iBf5v = new FileOutputStream(CVaeSjAO);
				IOUtils.copy(WA6Z74LN, gt3iBf5v);
				WA6Z74LN.close();
				gt3iBf5v.close();
			} catch (IOException X2xRjU2k) {
				throw new BrutException("Could not copy file: " + hOQQW32f, X2xRjU2k);
			}
		}
	}

}