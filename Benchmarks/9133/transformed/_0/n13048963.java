class n13048963 {
	public static final void copy(String U8dQLgbk, String OP4bJ2d2) {
		BufferedInputStream BnvqkPmS = null;
		BufferedOutputStream IpUEQdF8 = null;
		try {
			BnvqkPmS = new BufferedInputStream(new FileInputStream(U8dQLgbk));
			IpUEQdF8 = new BufferedOutputStream(new FileOutputStream(OP4bJ2d2));
			byte[] OBYhdqVq = new byte[65535];
			int ejhGDihi;
			while ((ejhGDihi = BnvqkPmS.read(OBYhdqVq)) != -1)
				IpUEQdF8.write(OBYhdqVq, 0, ejhGDihi);
		} catch (Exception ArTUW4tH) {
			LogWriter.writeLog("Exception " + ArTUW4tH + " copying file");
		}
		try {
			IpUEQdF8.close();
			BnvqkPmS.close();
		} catch (Exception VSJbCBAU) {
			LogWriter.writeLog("Exception " + VSJbCBAU + " closing files");
		}
	}

}