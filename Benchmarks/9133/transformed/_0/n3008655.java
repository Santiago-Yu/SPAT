class n3008655 {
	public static void copyFile(File QO7tcNUa, File bYqFt85d) throws IOException {
		AssertUtility.notNull(QO7tcNUa);
		AssertUtility.notNull(bYqFt85d);
		FileInputStream I2Un7Xua = new FileInputStream(QO7tcNUa);
		FileOutputStream ue9R1UUX = new FileOutputStream(bYqFt85d);
		try {
			FileChannel ese8Ryq7 = I2Un7Xua.getChannel();
			FileChannel lsnWykOD = ue9R1UUX.getChannel();
			lsnWykOD.transferFrom(ese8Ryq7, 0, ese8Ryq7.size());
			ese8Ryq7.close();
			lsnWykOD.close();
		} finally {
			I2Un7Xua.close();
			ue9R1UUX.close();
		}
	}

}