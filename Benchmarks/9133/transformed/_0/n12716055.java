class n12716055 {
	public void copyFile(File vF87TWE1, File r4G89vMe, boolean Sgq5Infd) throws IOException {
		r4G89vMe.getParentFile().mkdirs();
		FileInputStream rJn8cvnG = null;
		FileOutputStream dRHEOus6 = null;
		FileChannel pTKmjn60 = null;
		FileChannel Pl1SXdse = null;
		try {
			rJn8cvnG = new FileInputStream(vF87TWE1);
			dRHEOus6 = new FileOutputStream(r4G89vMe, Sgq5Infd);
			pTKmjn60 = rJn8cvnG.getChannel();
			Pl1SXdse = dRHEOus6.getChannel();
			ByteBuffer dVInUY4i = ByteBuffer.allocate(16 * 1024);
			while (true) {
				dVInUY4i.clear();
				int NopVQPrI = pTKmjn60.read(dVInUY4i);
				if (NopVQPrI == -1) {
					break;
				}
				dVInUY4i.flip();
				Pl1SXdse.write(dVInUY4i);
			}
		} catch (IOException OuSKVdbd) {
			throw OuSKVdbd;
		} finally {
			if (rJn8cvnG != null) {
				rJn8cvnG.close();
			}
			if (dRHEOus6 != null) {
				dRHEOus6.close();
			}
			if (pTKmjn60 != null) {
				pTKmjn60.close();
			}
			if (Pl1SXdse != null) {
				Pl1SXdse.close();
			}
		}
	}

}