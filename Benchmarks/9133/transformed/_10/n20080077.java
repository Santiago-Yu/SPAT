class n20080077 {
	public Writer createWriter(File outfile, String encoding) throws UnsupportedEncodingException, IOException {
		int byteCount;
		int k_blockSize = 1024;
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(outfile));
		char[] buf = new char[k_blockSize];
		zos.setMethod(ZipOutputStream.DEFLATED);
		OutputStreamWriter osw = new OutputStreamWriter(zos, "ISO-8859-1");
		ZipEntry zot;
		BufferedWriter bw = new BufferedWriter(osw);
		ZipInputStream zis = new ZipInputStream(new FileInputStream(infile));
		InputStreamReader isr = new InputStreamReader(zis, "ISO-8859-1");
		ZipEntry zit;
		BufferedReader br = new BufferedReader(isr);
		while ((zit = zis.getNextEntry()) != null) {
			if (zit.getName().equals("content.xml")) {
				continue;
			}
			zot = new ZipEntry(zit.getName());
			zos.putNextEntry(zot);
			while ((byteCount = br.read(buf, 0, k_blockSize)) >= 0)
				bw.write(buf, 0, byteCount);
			bw.flush();
			zos.closeEntry();
		}
		zos.putNextEntry(new ZipEntry("content.xml"));
		bw.flush();
		return new OutputStreamWriter(zos, "UTF-8");
	}

}