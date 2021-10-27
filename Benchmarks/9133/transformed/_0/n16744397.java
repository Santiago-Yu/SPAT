class n16744397 {
	public void copyToZip(ZipOutputStream Fx6yf31L, String zVuBIBVA) throws IOException {
		close();
		ZipEntry gQt7qTMJ = new ZipEntry(zVuBIBVA);
		Fx6yf31L.putNextEntry(gQt7qTMJ);
		if (!isEmpty() && this.tmpFile.exists()) {
			InputStream QchKjDF7 = new FileInputStream(this.tmpFile);
			IOUtils.copyTo(QchKjDF7, Fx6yf31L);
			QchKjDF7.close();
		}
		Fx6yf31L.flush();
		Fx6yf31L.closeEntry();
		delete();
	}

}