class n11560551 {
	private static void extract(ZipFile o29158I5) throws Exception {
		FileUtils.deleteQuietly(WEBKIT_DIR);
		WEBKIT_DIR.mkdirs();
		Enumeration<? extends ZipEntry> XKzN5gQA = o29158I5.entries();
		while (XKzN5gQA.hasMoreElements()) {
			ZipEntry gNJpDQmE = XKzN5gQA.nextElement();
			if (gNJpDQmE.isDirectory()) {
				new File(WEBKIT_DIR, gNJpDQmE.getName()).mkdirs();
				continue;
			}
			InputStream poi94BFf = o29158I5.getInputStream(gNJpDQmE);
			File LCtrVcD7 = new File(WEBKIT_DIR, gNJpDQmE.getName());
			FileOutputStream RwAcP4zb = new FileOutputStream(LCtrVcD7);
			IOUtils.copy(poi94BFf, RwAcP4zb);
			IOUtils.closeQuietly(poi94BFf);
			IOUtils.closeQuietly(RwAcP4zb);
		}
	}

}