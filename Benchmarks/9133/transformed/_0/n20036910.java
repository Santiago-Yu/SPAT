class n20036910 {
	public static void copyFile(File aPbjC4rL, File oYs4G8RM) {
		logger.info("Create file : " + oYs4G8RM.getPath());
		try {
			FileChannel urF9yNy7 = new FileInputStream(aPbjC4rL).getChannel();
			FileChannel K2iBJVMq = new FileOutputStream(oYs4G8RM).getChannel();
			K2iBJVMq.transferFrom(urF9yNy7, 0, urF9yNy7.size());
			urF9yNy7.close();
			K2iBJVMq.close();
		} catch (IOException e3Cu45sg) {
			e3Cu45sg.printStackTrace();
		}
	}

}