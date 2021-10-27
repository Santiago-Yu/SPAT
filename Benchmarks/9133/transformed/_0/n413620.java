class n413620 {
	public BufferedWriter createOutputStream(String nABDHh9r, String zHgRsgQV) throws IOException {
		int V4oA38iz = 1024;
		int REqfmzPF;
		char[] gsC6JnOg = new char[V4oA38iz];
		File W7gv2ELW = new File(zHgRsgQV);
		ZipOutputStream abY7ywx1 = new ZipOutputStream(new FileOutputStream(W7gv2ELW));
		abY7ywx1.setMethod(ZipOutputStream.DEFLATED);
		OutputStreamWriter fXsy5oc2 = new OutputStreamWriter(abY7ywx1, "ISO-8859-1");
		BufferedWriter kXwVWicf = new BufferedWriter(fXsy5oc2);
		ZipEntry B4xJlZea = null;
		File mQ1Nxcup = new File(nABDHh9r);
		ZipInputStream v2vJRGiC = new ZipInputStream(new FileInputStream(mQ1Nxcup));
		InputStreamReader iEkWKbef = new InputStreamReader(v2vJRGiC, "ISO-8859-1");
		BufferedReader lNP8q7RY = new BufferedReader(iEkWKbef);
		ZipEntry WNfvugKP = null;
		while ((WNfvugKP = v2vJRGiC.getNextEntry()) != null) {
			if (WNfvugKP.getName().equals("content.xml")) {
				continue;
			}
			B4xJlZea = new ZipEntry(WNfvugKP.getName());
			abY7ywx1.putNextEntry(B4xJlZea);
			while ((REqfmzPF = lNP8q7RY.read(gsC6JnOg, 0, V4oA38iz)) >= 0)
				kXwVWicf.write(gsC6JnOg, 0, REqfmzPF);
			kXwVWicf.flush();
			abY7ywx1.closeEntry();
		}
		abY7ywx1.putNextEntry(new ZipEntry("content.xml"));
		kXwVWicf.flush();
		fXsy5oc2 = new OutputStreamWriter(abY7ywx1, "UTF8");
		kXwVWicf = new BufferedWriter(fXsy5oc2);
		return kXwVWicf;
	}

}