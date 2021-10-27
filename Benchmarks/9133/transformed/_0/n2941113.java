class n2941113 {
	private void download(URL UziDRn1W, File otvuiD7H) throws IOException {
		System.out.println("Trying to download: " + UziDRn1W);
		InputStream QJurV82J = null;
		OutputStream hSK4pVeq = null;
		try {
			URLConnection p6loE9Vt = UziDRn1W.openConnection();
			QJurV82J = p6loE9Vt.getInputStream();
			hSK4pVeq = new BufferedOutputStream(new FileOutputStream(otvuiD7H));
			byte[] QiOmyaHI = new byte[1024];
			int gwWexCHH;
			while ((gwWexCHH = QJurV82J.read(QiOmyaHI)) > -1) {
				hSK4pVeq.write(QiOmyaHI, 0, gwWexCHH);
			}
		} finally {
			if (QJurV82J != null) {
				try {
					QJurV82J.close();
				} catch (IOException CH8qnmjz) {
					logger.error("Unable to close stream.", CH8qnmjz);
				}
			}
			if (hSK4pVeq != null) {
				try {
					hSK4pVeq.close();
				} catch (IOException mR4rPJIY) {
					logger.error("Unable to close stream.", mR4rPJIY);
				}
			}
		}
	}

}