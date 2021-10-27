class n19247466 {
	public void copyFile(File Z56gsMZP, File PHm8oWxk) throws IOException {
		Log.level3("Copying " + Z56gsMZP.getPath() + " to " + PHm8oWxk.getPath());
		if (!PHm8oWxk.exists()) {
			PHm8oWxk.createNewFile();
		}
		FileChannel FayucvRh = null;
		FileChannel hAtK4TNM = null;
		try {
			FayucvRh = new FileInputStream(Z56gsMZP).getChannel();
			hAtK4TNM = new FileOutputStream(PHm8oWxk).getChannel();
			hAtK4TNM.transferFrom(FayucvRh, 0, FayucvRh.size());
		} finally {
			if (FayucvRh != null) {
				FayucvRh.close();
			}
		}
		if (hAtK4TNM != null) {
			hAtK4TNM.close();
		}
	}

}