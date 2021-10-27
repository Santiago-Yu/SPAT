class n598994 {
	public BufferedWriter createOutputStream(String inFile, String outFile) throws IOException {
		int byteCount;
		int k_blockSize = 1024;
		File ofp = new File(outFile);
		char[] buf = new char[k_blockSize];
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(ofp));
		zos.setMethod(ZipOutputStream.DEFLATED);
		OutputStreamWriter osw = new OutputStreamWriter(zos, "ISO-8859-1");
		ZipEntry zot = null;
		BufferedWriter bw = new BufferedWriter(osw);
		File ifp = new File(inFile);
		ZipInputStream zis = new ZipInputStream(new FileInputStream(ifp));
		InputStreamReader isr = new InputStreamReader(zis, "ISO-8859-1");
		ZipEntry zit = null;
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
		osw = new OutputStreamWriter(zos, "UTF8");
		bw = new BufferedWriter(osw);
		return bw;
	}

}