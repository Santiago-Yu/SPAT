class n19950034 {
	public static void copyFile(File dVliQxQI, File L8p4f9MF) {
		if (!dVliQxQI.exists()) {
			return;
		}
		if ((L8p4f9MF.getParentFile() != null) && (!L8p4f9MF.getParentFile().exists())) {
			L8p4f9MF.getParentFile().mkdirs();
		}
		try {
			FileChannel yE7v6iBt = new FileInputStream(dVliQxQI).getChannel();
			FileChannel Iyboq94P = new FileOutputStream(L8p4f9MF).getChannel();
			Iyboq94P.transferFrom(yE7v6iBt, 0, yE7v6iBt.size());
			yE7v6iBt.close();
			Iyboq94P.close();
		} catch (IOException oXUfveyO) {
			oXUfveyO.printStackTrace();
		}
	}

}