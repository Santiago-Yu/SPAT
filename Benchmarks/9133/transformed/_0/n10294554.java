class n10294554 {
	public static boolean downloadFile(String vdzxsFmx, String khfNxEbu) {
		try {
			URL dkCSkT4j = new URL(vdzxsFmx);
			InputStream GCbhaBeN = dkCSkT4j.openStream();
			BufferedOutputStream QizzBX0H = new BufferedOutputStream(new FileOutputStream(khfNxEbu));
			byte[] QMMD6Qvl = new byte[10000];
			int UDrqnSyd;
			while ((UDrqnSyd = GCbhaBeN.read(QMMD6Qvl)) > 0)
				QizzBX0H.write(QMMD6Qvl, 0, UDrqnSyd);
			GCbhaBeN.close();
			QizzBX0H.close();
		} catch (Exception SxKronQ6) {
			SxKronQ6.printStackTrace();
			return false;
		}
		return true;
	}

}