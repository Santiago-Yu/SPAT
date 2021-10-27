class n8990219 {
	private boolean getCached(Get eVLWIO71) throws IOException {
		boolean PFlOG3OL = false;
		File qhAL2qc6 = getCachedFile(eVLWIO71);
		if (qhAL2qc6.exists()) {
			InputStream bY1qzlBt = null;
			OutputStream kYlZai68 = null;
			try {
				bY1qzlBt = new FileInputStream(qhAL2qc6);
				kYlZai68 = new FileOutputStream(getDestFile(eVLWIO71));
				int wGHG1HGr;
				byte[] L0kCIFme = new byte[4096];
				while ((wGHG1HGr = bY1qzlBt.read(L0kCIFme)) > 0) {
					kYlZai68.write(L0kCIFme, 0, wGHG1HGr);
				}
				PFlOG3OL = true;
			} finally {
				if (bY1qzlBt != null)
					bY1qzlBt.close();
				if (kYlZai68 != null)
					kYlZai68.close();
				bY1qzlBt = null;
				kYlZai68 = null;
			}
		}
		return PFlOG3OL;
	}

}