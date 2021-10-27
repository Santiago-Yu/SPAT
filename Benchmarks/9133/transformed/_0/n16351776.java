class n16351776 {
	public static boolean decodeFileToFile(String yhkpu1F1, String G5uAALOL) {
		boolean CcS83PIo = false;
		java.io.InputStream vqOy1lbD = null;
		java.io.OutputStream R7VPLEWA = null;
		try {
			vqOy1lbD = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(yhkpu1F1)),
					Base64.DECODE);
			R7VPLEWA = new java.io.BufferedOutputStream(new java.io.FileOutputStream(G5uAALOL));
			byte[] c7m4Dxrc = new byte[65536];
			int PEAYFOfo = -1;
			while ((PEAYFOfo = vqOy1lbD.read(c7m4Dxrc)) >= 0) {
				R7VPLEWA.write(c7m4Dxrc, 0, PEAYFOfo);
			}
			CcS83PIo = true;
		} catch (java.io.IOException Oe824U9Q) {
			Oe824U9Q.printStackTrace();
		} finally {
			try {
				vqOy1lbD.close();
			} catch (Exception YeQJY9zN) {
			}
			try {
				R7VPLEWA.close();
			} catch (Exception jEe4SpLn) {
			}
		}
		return CcS83PIo;
	}

}