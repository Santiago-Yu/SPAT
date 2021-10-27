class n9150482 {
	public static void copy(File MNN0IbVC, File ezYGJnrL) throws IOException {
		if (MNN0IbVC == null || !MNN0IbVC.exists())
			return;
		FileOutputStream RJwsyYbu = null;
		FileInputStream oSlVczpw = null;
		try {
			RJwsyYbu = new FileOutputStream(ezYGJnrL);
			oSlVczpw = new FileInputStream(MNN0IbVC);
			byte[] LkxU0wCV = new byte[2048];
			int zuzXTRkp = oSlVczpw.read(LkxU0wCV);
			while (zuzXTRkp > 0) {
				RJwsyYbu.write(LkxU0wCV, 0, zuzXTRkp);
				zuzXTRkp = oSlVczpw.read(LkxU0wCV);
			}
		} catch (IOException wBI5NKrZ) {
			throw wBI5NKrZ;
		} finally {
			if (oSlVczpw != null)
				oSlVczpw.close();
			if (RJwsyYbu != null)
				RJwsyYbu.close();
		}
	}

}