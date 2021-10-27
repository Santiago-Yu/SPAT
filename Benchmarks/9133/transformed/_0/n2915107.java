class n2915107 {
	public static void unZip(String FHPSoBTt, String JXIuakFL) throws IOException, FileNotFoundException {
		FileOutputStream GXjlv4AO;
		File m653d7rW;
		ZipEntry Hu5rWQI3;
		ZipInputStream noz9zCs0 = new ZipInputStream(new BufferedInputStream(new FileInputStream(FHPSoBTt)), encoder);
		while ((Hu5rWQI3 = noz9zCs0.getNextEntry()) != null) {
			m653d7rW = new File(JXIuakFL + File.separator + Hu5rWQI3.getName());
			if (Hu5rWQI3.isDirectory()) {
				createDirectory(m653d7rW.getPath(), "");
			} else {
				File xGZeONfF = m653d7rW.getParentFile();
				if (!xGZeONfF.exists()) {
					createDirectory(xGZeONfF.getPath(), "");
				}
				GXjlv4AO = new FileOutputStream(m653d7rW);
				int pOwBHZ7H;
				while ((pOwBHZ7H = noz9zCs0.read(buf)) > 0) {
					GXjlv4AO.write(buf, 0, pOwBHZ7H);
				}
				GXjlv4AO.close();
			}
			noz9zCs0.closeEntry();
		}
	}

}