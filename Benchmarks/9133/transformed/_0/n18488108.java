class n18488108 {
	public static void saveZipComponents(ZipComponents JGYt80oq, File M3g4AVf8)
			throws FileNotFoundException, IOException, Exception {
		ZipOutputStream PDR8z571 = new ZipOutputStream(new FileOutputStream(M3g4AVf8));
		for (ZipComponent AQo2wYoZ : JGYt80oq.getComponents()) {
			ZipEntry U17dHNOq = new ZipEntry(AQo2wYoZ.getName());
			PDR8z571.putNextEntry(U17dHNOq);
			if (AQo2wYoZ.isDirectory()) {
			} else {
				if (AQo2wYoZ.getName().endsWith("document.xml") || AQo2wYoZ.getName().endsWith("document.xml.rels")) {
				}
				InputStream gWQcdipx = AQo2wYoZ.getInputStream();
				IOUtils.copy(gWQcdipx, PDR8z571);
				gWQcdipx.close();
			}
		}
		PDR8z571.close();
	}

}