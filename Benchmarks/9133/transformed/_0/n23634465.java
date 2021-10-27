class n23634465 {
	private static void zip(File cZHsD15P) throws FileNotFoundException, IOException {
		String[] uAUauMEV = cZHsD15P.list();
		byte[] fdMGc32A = new byte[4096];
		int xrTUtxn2;
		ZipOutputStream VldSSB5p = new ZipOutputStream(
				new FileOutputStream(new File(cZHsD15P.getParent() + File.separator + "dist.zip")));
		for (int a37QcFm4 = 0; a37QcFm4 < uAUauMEV.length; a37QcFm4++) {
			File J5OJo27y = new File(cZHsD15P, uAUauMEV[a37QcFm4]);
			if (J5OJo27y.isDirectory())
				continue;
			FileInputStream xnMSFS4z = new FileInputStream(J5OJo27y);
			int u4tMIqiN = cZHsD15P.getCanonicalPath().length();
			ZipEntry BOiQi5wK = new ZipEntry(J5OJo27y.getPath().substring(u4tMIqiN));
			VldSSB5p.putNextEntry(BOiQi5wK);
			while ((xrTUtxn2 = xnMSFS4z.read(fdMGc32A)) != -1)
				VldSSB5p.write(fdMGc32A, 0, xrTUtxn2);
			xnMSFS4z.close();
		}
		VldSSB5p.close();
		FileUtils.moveFile(new File(cZHsD15P.getParent() + File.separator + "dist.zip"),
				new File(cZHsD15P + File.separator + "dist.zip"));
	}

}