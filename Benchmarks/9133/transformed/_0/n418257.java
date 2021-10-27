class n418257 {
	public BufferedWriter createOutputStream(String EOdp0o1I, String rtemxTgQ) throws IOException {
		int WLbFJ6UW = 1024;
		int aryVgtVK;
		char[] GhyTLqgX = new char[WLbFJ6UW];
		File uekFxoEA = new File(rtemxTgQ);
		ZipOutputStream tOBQRSbB = new ZipOutputStream(new FileOutputStream(uekFxoEA));
		tOBQRSbB.setMethod(ZipOutputStream.DEFLATED);
		OutputStreamWriter mGZRubCa = new OutputStreamWriter(tOBQRSbB, "ISO-8859-1");
		BufferedWriter ukjcxLKe = new BufferedWriter(mGZRubCa);
		ZipEntry i1J6JJHi = null;
		File qvkXKXag = new File(EOdp0o1I);
		ZipInputStream viNIWtUa = new ZipInputStream(new FileInputStream(qvkXKXag));
		InputStreamReader HFaoz38k = new InputStreamReader(viNIWtUa, "ISO-8859-1");
		BufferedReader vtZgjfmN = new BufferedReader(HFaoz38k);
		ZipEntry dGKfLJb2 = null;
		while ((dGKfLJb2 = viNIWtUa.getNextEntry()) != null) {
			if (dGKfLJb2.getName().equals("content.xml")) {
				continue;
			}
			i1J6JJHi = new ZipEntry(dGKfLJb2.getName());
			tOBQRSbB.putNextEntry(i1J6JJHi);
			while ((aryVgtVK = vtZgjfmN.read(GhyTLqgX, 0, WLbFJ6UW)) >= 0)
				ukjcxLKe.write(GhyTLqgX, 0, aryVgtVK);
			ukjcxLKe.flush();
			tOBQRSbB.closeEntry();
		}
		tOBQRSbB.putNextEntry(new ZipEntry("content.xml"));
		ukjcxLKe.flush();
		mGZRubCa = new OutputStreamWriter(tOBQRSbB, "UTF8");
		ukjcxLKe = new BufferedWriter(mGZRubCa);
		return ukjcxLKe;
	}

}