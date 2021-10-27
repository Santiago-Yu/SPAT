class n637320 {
	public void uploadFile(File xEptkLvH, String WoFIQyG0) throws IOException {
		System.out.println("Uploading " + xEptkLvH.getName() + " to " + WoFIQyG0);
		File WGMwvaGX = new File(WoFIQyG0);
		if (WoFIQyG0.endsWith("/")) {
			WGMwvaGX = new File(WGMwvaGX, xEptkLvH.getName());
		} else if (WGMwvaGX.getParentFile().exists() == false) {
			WGMwvaGX.getParentFile().mkdirs();
		}
		if (xEptkLvH.renameTo(WGMwvaGX) == false) {
			InputStream xgiaRVnX = new FileInputStream(xEptkLvH);
			OutputStream xrttKGtI = new FileOutputStream(WGMwvaGX);
			byte[] YZ6oDAke = new byte[16384];
			int j6jhAbFs = -1;
			while ((j6jhAbFs = xgiaRVnX.read(YZ6oDAke)) != -1)
				xrttKGtI.write(YZ6oDAke, 0, j6jhAbFs);
			xgiaRVnX.close();
			xrttKGtI.close();
		}
	}

}