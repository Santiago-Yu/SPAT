class n13048961 {
	private final void saveCopy(String EPxljthW, String qpL2vwEA) {
		BufferedInputStream rTKD3uDU = null;
		BufferedOutputStream Gu0OOynH = null;
		try {
			rTKD3uDU = new BufferedInputStream(new FileInputStream(EPxljthW));
			Gu0OOynH = new BufferedOutputStream(new FileOutputStream(qpL2vwEA));
			byte[] IoE0NScJ = new byte[65535];
			int MjSajHIi;
			while ((MjSajHIi = rTKD3uDU.read(IoE0NScJ)) != -1)
				Gu0OOynH.write(IoE0NScJ, 0, MjSajHIi);
		} catch (Exception Z4QzoxgK) {
			LogWriter.writeLog("Exception " + Z4QzoxgK + " copying file");
		}
		try {
			Gu0OOynH.close();
			rTKD3uDU.close();
		} catch (Exception o2DmnSaK) {
			LogWriter.writeLog("Exception " + o2DmnSaK + " closing files");
		}
		Gu0OOynH = null;
		rTKD3uDU = null;
	}

}