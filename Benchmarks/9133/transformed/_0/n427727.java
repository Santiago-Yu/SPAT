class n427727 {
	public BufferedWriter createOutputStream(String N9JLTmQJ, String kpt1MtxS) throws IOException {
		int anfP8BqH = 1024;
		int XFen5fma;
		char[] WySvw340 = new char[anfP8BqH];
		File vxcqO2wA = new File(kpt1MtxS);
		ZipOutputStream XURGdYtG = new ZipOutputStream(new FileOutputStream(vxcqO2wA));
		XURGdYtG.setMethod(ZipOutputStream.DEFLATED);
		OutputStreamWriter dSvSAmfL = new OutputStreamWriter(XURGdYtG, "ISO-8859-1");
		BufferedWriter cgDwxBoJ = new BufferedWriter(dSvSAmfL);
		ZipEntry NCIqa3E7 = null;
		File fKBrIzU4 = new File(N9JLTmQJ);
		ZipInputStream hv40bPAi = new ZipInputStream(new FileInputStream(fKBrIzU4));
		InputStreamReader g2p30sk7 = new InputStreamReader(hv40bPAi, "ISO-8859-1");
		BufferedReader RLmZrNRQ = new BufferedReader(g2p30sk7);
		ZipEntry T6RFS0R5 = null;
		while ((T6RFS0R5 = hv40bPAi.getNextEntry()) != null) {
			if (T6RFS0R5.getName().equals("content.xml")) {
				continue;
			}
			NCIqa3E7 = new ZipEntry(T6RFS0R5.getName());
			XURGdYtG.putNextEntry(NCIqa3E7);
			while ((XFen5fma = RLmZrNRQ.read(WySvw340, 0, anfP8BqH)) >= 0)
				cgDwxBoJ.write(WySvw340, 0, XFen5fma);
			cgDwxBoJ.flush();
			XURGdYtG.closeEntry();
		}
		XURGdYtG.putNextEntry(new ZipEntry("content.xml"));
		cgDwxBoJ.flush();
		dSvSAmfL = new OutputStreamWriter(XURGdYtG, "UTF8");
		cgDwxBoJ = new BufferedWriter(dSvSAmfL);
		return cgDwxBoJ;
	}

}