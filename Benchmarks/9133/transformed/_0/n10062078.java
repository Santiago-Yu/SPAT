class n10062078 {
	private void copy(File lQrX4MjN, File KsxJAaRZ) throws IOException {
		FileOutputStream V7V0g6UD = null;
		FileInputStream TTiKoEcX = null;
		try {
			V7V0g6UD = new FileOutputStream(KsxJAaRZ);
			TTiKoEcX = new FileInputStream(lQrX4MjN);
			byte[] DCnQHv2h = new byte[2048];
			int w2MuxlL1 = TTiKoEcX.read(DCnQHv2h);
			while (w2MuxlL1 > 0) {
				V7V0g6UD.write(DCnQHv2h, 0, w2MuxlL1);
				w2MuxlL1 = TTiKoEcX.read(DCnQHv2h);
			}
		} catch (IOException fplOSlyn) {
			throw fplOSlyn;
		} finally {
			if (TTiKoEcX != null)
				TTiKoEcX.close();
			if (V7V0g6UD != null)
				V7V0g6UD.close();
		}
	}

}