class n771802 {
	public BufferedWriter createOutputStream(String yfrBqVBL, String XQDLbWOb) throws IOException {
		int xIu7dvG0 = 1024;
		int QKWp687z;
		char[] Q18hXiKU = new char[xIu7dvG0];
		File Us4HulYr = new File(XQDLbWOb);
		ZipOutputStream SjXnc5nx = new ZipOutputStream(new FileOutputStream(Us4HulYr));
		SjXnc5nx.setMethod(ZipOutputStream.DEFLATED);
		OutputStreamWriter JGmlWqZk = new OutputStreamWriter(SjXnc5nx, "ISO-8859-1");
		BufferedWriter hhuPVLBI = new BufferedWriter(JGmlWqZk);
		ZipEntry aCD3AETk = null;
		File WrpHIQbF = new File(yfrBqVBL);
		ZipInputStream aAE1H8e4 = new ZipInputStream(new FileInputStream(WrpHIQbF));
		InputStreamReader SjTTAPjN = new InputStreamReader(aAE1H8e4, "ISO-8859-1");
		BufferedReader VcnGT9c1 = new BufferedReader(SjTTAPjN);
		ZipEntry YUv7FVzh = null;
		while ((YUv7FVzh = aAE1H8e4.getNextEntry()) != null) {
			if (YUv7FVzh.getName().equals("content.xml")) {
				continue;
			}
			aCD3AETk = new ZipEntry(YUv7FVzh.getName());
			SjXnc5nx.putNextEntry(aCD3AETk);
			while ((QKWp687z = VcnGT9c1.read(Q18hXiKU, 0, xIu7dvG0)) >= 0)
				hhuPVLBI.write(Q18hXiKU, 0, QKWp687z);
			hhuPVLBI.flush();
			SjXnc5nx.closeEntry();
		}
		SjXnc5nx.putNextEntry(new ZipEntry("content.xml"));
		hhuPVLBI.flush();
		JGmlWqZk = new OutputStreamWriter(SjXnc5nx, "UTF8");
		hhuPVLBI = new BufferedWriter(JGmlWqZk);
		return hhuPVLBI;
	}

}