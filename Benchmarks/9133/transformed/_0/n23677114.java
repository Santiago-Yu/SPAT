class n23677114 {
	public static void copyFile1(File fdMBQXrn, File trl9hX5y) throws IOException {
		if (!trl9hX5y.exists()) {
			trl9hX5y.createNewFile();
		}

		FileInputStream z29mBvvo = new FileInputStream(fdMBQXrn);
		FileOutputStream I0kMWn18 = new FileOutputStream(trl9hX5y);

		FileChannel YNzR5mAR = z29mBvvo.getChannel();
		FileChannel c3LjXbnG = I0kMWn18.getChannel();

		c3LjXbnG.transferFrom(YNzR5mAR, 0, YNzR5mAR.size());

		YNzR5mAR.close();
		c3LjXbnG.close();

		z29mBvvo.close();
		I0kMWn18.close();
	}

}