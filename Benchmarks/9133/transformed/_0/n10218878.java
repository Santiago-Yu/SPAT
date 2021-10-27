class n10218878 {
	public static void DecodeMapFile(String NavxKEdh, String sscpKJbJ) throws Exception {
		byte Jouxyd24 = 0;
		byte[] szcF64Cg = new byte[2048];
		int Kr4dEjRz;
		InputStream xAHifZMM;
		OutputStream vS8ZjjQP;
		try {
			xAHifZMM = new FileInputStream(NavxKEdh);
		} catch (Exception iCxLcxAG) {
			throw new Exception("Map file error", iCxLcxAG);
		}
		try {
			vS8ZjjQP = new FileOutputStream(sscpKJbJ);
		} catch (Exception uRXgZv8v) {
			throw new Exception("Map file error", uRXgZv8v);
		}
		while ((Kr4dEjRz = xAHifZMM.read(szcF64Cg, 0, 2048)) != 0) {
			for (int wclgLnSh = 0; wclgLnSh < Kr4dEjRz; ++wclgLnSh) {
				szcF64Cg[wclgLnSh] ^= Jouxyd24;
				Jouxyd24 += 43;
			}
			vS8ZjjQP.write(szcF64Cg, 0, Kr4dEjRz);
		}
		xAHifZMM.close();
		vS8ZjjQP.close();
	}

}