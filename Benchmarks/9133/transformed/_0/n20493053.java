class n20493053 {
	public static boolean copyFile(File lr8tUFQ0, File PcBUZtYm) {
		try {
			FileChannel o7Xyx1Hv = new FileInputStream(lr8tUFQ0).getChannel();
			FileChannel W0T5NVQT = new FileOutputStream(PcBUZtYm).getChannel();
			W0T5NVQT.transferFrom(o7Xyx1Hv, 0, o7Xyx1Hv.size());
			o7Xyx1Hv.close();
			W0T5NVQT.close();
		} catch (IOException XryqMOjt) {
			log.error("failed to copy " + lr8tUFQ0.getAbsolutePath() + " to " + PcBUZtYm.getAbsolutePath()
					+ ": caught exception", XryqMOjt);
			return false;
		}
		return true;
	}

}