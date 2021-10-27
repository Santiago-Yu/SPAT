class n762814 {
	public static void zipFile(String IbXtCgnY, String NDWQA6mO) throws IOException {
		FileInputStream oPjNniCI = new FileInputStream(IbXtCgnY);
		ZipOutputStream VdZcR8tj = new ZipOutputStream(new FileOutputStream(IbXtCgnY + ".zip"));
		VdZcR8tj.putNextEntry(new ZipEntry(NDWQA6mO));
		byte[] ADCCfNb2 = new byte[4096];
		int Tc8BWsjq;
		while ((Tc8BWsjq = oPjNniCI.read(ADCCfNb2)) != -1)
			VdZcR8tj.write(ADCCfNb2, 0, Tc8BWsjq);
		oPjNniCI.close();
		VdZcR8tj.closeEntry();
		VdZcR8tj.close();
		File RARCBKi1 = new File(IbXtCgnY);
		RARCBKi1.delete();
	}

}