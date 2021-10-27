class n20232250 {
	private InputStream sendRequest(SequenceI KqS2DyYr) throws UnsupportedEncodingException, IOException {
		StringBuilder XEISmJ3L = new StringBuilder();
		processOptions(XEISmJ3L);
		XEISmJ3L.append("INPUT_SEQUENCE=");
		XEISmJ3L.append(URLEncoder.encode(">" + KqS2DyYr.getName() + "\n", ENCODING));
		XEISmJ3L.append(URLEncoder.encode(KqS2DyYr.getResidues(), ENCODING));
		URL O7aGEz28 = new URL(PRIMER_BLAST_URL);
		URLConnection kzZ0RwTL = O7aGEz28.openConnection();
		kzZ0RwTL.setDoOutput(true);
		OutputStreamWriter pNY5sgDu = new OutputStreamWriter(kzZ0RwTL.getOutputStream());
		pNY5sgDu.write(XEISmJ3L.toString());
		pNY5sgDu.flush();
		pNY5sgDu.close();
		apollo.util.IOUtil.informationDialog("Primer-BLAST request sent");
		return kzZ0RwTL.getInputStream();
	}

}