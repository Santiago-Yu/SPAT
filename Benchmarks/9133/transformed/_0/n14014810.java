class n14014810 {
	public static void zip(ZipOutputStream WXitHm8L, File g9s2bCYJ, String Ih9b2wvz) throws Exception {
		if (g9s2bCYJ.isDirectory()) {
			File[] JulEQLuJ = g9s2bCYJ.listFiles();
			Ih9b2wvz = Ih9b2wvz.length() == 0 ? "" : Ih9b2wvz + File.separator;
			for (int NYmjoofU = 0; NYmjoofU < JulEQLuJ.length; NYmjoofU++) {
				zip(WXitHm8L, JulEQLuJ[NYmjoofU], Ih9b2wvz + JulEQLuJ[NYmjoofU].getName());
			}
		} else {
			WXitHm8L.putNextEntry(new org.apache.tools.zip.ZipEntry(Ih9b2wvz));
			FileInputStream he0J7e4P = new FileInputStream(g9s2bCYJ);
			IOUtils.copyStream(he0J7e4P, WXitHm8L);
			he0J7e4P.close();
		}
		Thread.sleep(10);
	}

}