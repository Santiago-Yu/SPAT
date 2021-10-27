class n22948959 {
	private static void copyFile(File NyxOk7JK, File kPFllAET) throws FileSaveException {
		try {
			FileInputStream DFlXMeLC = new FileInputStream(NyxOk7JK);
			FileOutputStream FgcFkIdO = new FileOutputStream(kPFllAET);
			FileChannel CbyflRK7 = DFlXMeLC.getChannel();
			FileChannel q2DzH9LV = FgcFkIdO.getChannel();
			q2DzH9LV.truncate(0);
			q2DzH9LV.transferFrom(CbyflRK7, 0, CbyflRK7.size());
			DFlXMeLC.close();
			FgcFkIdO.close();
		} catch (IOException Kwxu0yte) {
			String z4WaGulN = "An error occurred when copying from the file \"" + NyxOk7JK.getAbsolutePath()
					+ "\" to the file \"" + kPFllAET.getAbsolutePath() + "\".";
			throw new FileSaveException(z4WaGulN, Kwxu0yte);
		}
	}

}