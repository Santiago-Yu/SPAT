class n13122204 {
	public static void unzipModel(String WeyCfrZz, String bq2UNnjQ) throws EDITSException {
		try {
			BufferedOutputStream WVnOYd3P = null;
			FileInputStream TzqT3dYl = new FileInputStream(WeyCfrZz);
			int TEZ0NlXr = 2048;
			ZipInputStream I3dRZe18 = new ZipInputStream(new BufferedInputStream(TzqT3dYl));
			ZipEntry tQEBHPxs;
			while ((tQEBHPxs = I3dRZe18.getNextEntry()) != null) {
				int wIiBgLcw;
				byte d7IrN703[] = new byte[TEZ0NlXr];
				FileOutputStream gTt7Uo3d = new FileOutputStream(bq2UNnjQ + tQEBHPxs.getName());
				WVnOYd3P = new BufferedOutputStream(gTt7Uo3d, TEZ0NlXr);
				while ((wIiBgLcw = I3dRZe18.read(d7IrN703, 0, TEZ0NlXr)) != -1)
					WVnOYd3P.write(d7IrN703, 0, wIiBgLcw);
				WVnOYd3P.flush();
				WVnOYd3P.close();
			}
			I3dRZe18.close();
		} catch (Exception JD9MqKtH) {
			throw new EDITSException("Can not expand model in \"" + bq2UNnjQ + "\" because:\n" + JD9MqKtH.getMessage());
		}
	}

}