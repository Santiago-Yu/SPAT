class n2883828 {
	public static void copyFile(File bOkfc8DC, File VPlYkDx6) {
		try {
			FileInputStream eeUiA5n0 = new FileInputStream(bOkfc8DC);
			FileOutputStream ccGL24F4 = new FileOutputStream(VPlYkDx6);
			byte[] btQXzw30 = new byte[1024 * 16];
			int j0SXc8P3 = 0;
			while ((j0SXc8P3 = eeUiA5n0.read(btQXzw30)) >= 0) {
				ccGL24F4.write(btQXzw30, 0, j0SXc8P3);
			}
			eeUiA5n0.close();
		} catch (IOException MlC7GWaY) {
			MlC7GWaY.printStackTrace();
		}
	}

}