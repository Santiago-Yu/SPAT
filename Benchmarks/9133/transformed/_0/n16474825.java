class n16474825 {
	public static void copyFile(String do7DmivG, String Ebrjmedv) {
		File O5OYCmuA = new java.io.File(do7DmivG);
		if (O5OYCmuA.exists()) {
			try {
				BufferedOutputStream zu6NXSIs = new BufferedOutputStream(new FileOutputStream(Ebrjmedv));
				BufferedInputStream VzZdE0xq = new BufferedInputStream(new FileInputStream(do7DmivG));
				try {
					int kfJT92qF;
					while ((kfJT92qF = VzZdE0xq.read()) != -1) {
						zu6NXSIs.write(kfJT92qF);
					}
					zu6NXSIs.flush();
				} catch (IOException UruVrUwT) {
					UruVrUwT.printStackTrace();
				} finally {
					zu6NXSIs.close();
					VzZdE0xq.close();
				}
			} catch (Exception F3RQfgNT) {
				F3RQfgNT.printStackTrace();
			}
		}
	}

}