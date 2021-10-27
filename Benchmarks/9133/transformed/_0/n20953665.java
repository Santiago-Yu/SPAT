class n20953665 {
	private void packageDestZip(File ZJSEfHk3) throws FileNotFoundException, IOException {
		log("Creating launch profile package " + destfile);
		ZipOutputStream kKVPodlh = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(destfile)));
		ZipEntry DOt26vnP = new ZipEntry(RESOURCE_JAR_FILENAME);
		DOt26vnP.setMethod(ZipEntry.STORED);
		DOt26vnP.setSize(ZJSEfHk3.length());
		DOt26vnP.setCompressedSize(ZJSEfHk3.length());
		DOt26vnP.setCrc(calcChecksum(ZJSEfHk3, new CRC32()));
		kKVPodlh.putNextEntry(DOt26vnP);
		InputStream sc1bLkK7 = new BufferedInputStream(new FileInputStream(ZJSEfHk3));
		int dL8WSPGx;
		while ((dL8WSPGx = sc1bLkK7.read()) != -1)
			kKVPodlh.write(dL8WSPGx);
		sc1bLkK7.close();
		kKVPodlh.closeEntry();
		kKVPodlh.finish();
		kKVPodlh.close();
	}

}