class n22427840 {
	public static void copyFile(File e3eBj1wd, File j9CLa628) {
		try {
			FileInputStream WYdxy9ED = new FileInputStream(e3eBj1wd);
			FileOutputStream HMHJxE6T = new FileOutputStream(j9CLa628);
			byte[] Hkp5MQT3 = new byte[1024 * 16];
			int kcFWnwKJ = 0;
			while ((kcFWnwKJ = WYdxy9ED.read(Hkp5MQT3)) >= 0) {
				HMHJxE6T.write(Hkp5MQT3, 0, kcFWnwKJ);
			}
			WYdxy9ED.close();
			HMHJxE6T.close();
		} catch (IOException CNwcoKEx) {
			CNwcoKEx.printStackTrace();
		}
	}

}