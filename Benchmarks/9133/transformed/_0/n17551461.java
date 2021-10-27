class n17551461 {
	public static void copyFromFileToFileUsingNIO(File enliunrc, File oRl4dKxn)
			throws FileNotFoundException, IOException {
		FileChannel WqUEjh1P = new FileInputStream(enliunrc).getChannel();
		FileChannel kthsQNdR = new FileOutputStream(oRl4dKxn).getChannel();
		try {
			WqUEjh1P.transferTo(0, WqUEjh1P.size(), kthsQNdR);
		} catch (IOException KUcSzjF5) {
			throw KUcSzjF5;
		} finally {
			if (WqUEjh1P != null)
				WqUEjh1P.close();
			if (kthsQNdR != null)
				kthsQNdR.close();
		}
	}

}