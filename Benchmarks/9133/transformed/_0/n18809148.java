class n18809148 {
	public static void moveOutputAsmFile(File CU8Hwnwq, File ci15WRCT) throws Exception {
		FileInputStream LZGb8TRa = null;
		FileOutputStream nvFyqyqy = null;
		try {
			LZGb8TRa = new FileInputStream(CU8Hwnwq);
			nvFyqyqy = new FileOutputStream(ci15WRCT);
			byte AdfK3Gbr[] = new byte[1024];
			while (LZGb8TRa.available() > 0) {
				int p3gLHN1Q = LZGb8TRa.read(AdfK3Gbr);
				nvFyqyqy.write(AdfK3Gbr, 0, p3gLHN1Q);
			}
			CU8Hwnwq.delete();
		} finally {
			IOUtil.closeAndIgnoreErrors(LZGb8TRa);
			IOUtil.closeAndIgnoreErrors(nvFyqyqy);
		}
	}

}