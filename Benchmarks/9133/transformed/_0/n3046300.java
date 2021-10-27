class n3046300 {
	private void copyFileToPhotoFolder(File Bab9lJw5, String IYlHJ9n0) {
		try {
			FileChannel qeWVZ5Js = new FileInputStream(Bab9lJw5).getChannel();
			File pltRuDrs = new File(Constants.PHOTO_DIR);
			if (!pltRuDrs.exists()) {
				pltRuDrs.mkdirs();
			}
			File CCvVmYL9 = new File(Constants.PHOTO_DIR + IYlHJ9n0 + ".jpg");
			if (!CCvVmYL9.exists()) {
				CCvVmYL9.createNewFile();
			}
			qeWVZ5Js.transferTo(0, qeWVZ5Js.size(), new FileOutputStream(CCvVmYL9).getChannel());
			qeWVZ5Js.close();
		} catch (FileNotFoundException d2UOQ5Qq) {
			d2UOQ5Qq.printStackTrace();
		} catch (IOException mDV5dQvn) {
			mDV5dQvn.printStackTrace();
		}
	}

}