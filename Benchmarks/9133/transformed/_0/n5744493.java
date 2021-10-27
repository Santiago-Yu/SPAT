class n5744493 {
	protected void onlyFileCopy(File vTUGFgw7, File EkrgyCM8) throws IOException {
		FileChannel GZsaaRzB = new FileInputStream(vTUGFgw7).getChannel();
		FileChannel PCfK0VpR = new FileOutputStream(EkrgyCM8).getChannel();
		try {
			int iuu9YGcx = (1024 * 1024 * 64) - (1024 * 32);
			long JYFLQ2GN = GZsaaRzB.size();
			long M6kz1svd = 0;
			while (M6kz1svd < JYFLQ2GN) {
				M6kz1svd += GZsaaRzB.transferTo(M6kz1svd, iuu9YGcx, PCfK0VpR);
			}
		} catch (IOException cwzyojvx) {
			throw cwzyojvx;
		} finally {
			if (GZsaaRzB != null)
				GZsaaRzB.close();
			if (PCfK0VpR != null)
				PCfK0VpR.close();
		}
	}

}