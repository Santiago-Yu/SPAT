class n17208661 {
	protected void copyFile(File K0DTuuhR, File i4TuMo5i) throws IOException {
		new File(intSfPath).delete();
		if (i4TuMo5i.exists() && (K0DTuuhR.length() == i4TuMo5i.length())
				&& (K0DTuuhR.lastModified() == i4TuMo5i.lastModified()))
			return;
		if (i4TuMo5i.exists())
			i4TuMo5i.delete();
		i4TuMo5i.createNewFile();
		FileChannel og5ka7OL = null;
		FileChannel SeT23MvT = null;
		try {
			og5ka7OL = new FileInputStream(K0DTuuhR).getChannel();
			SeT23MvT = new FileOutputStream(i4TuMo5i).getChannel();
			long IGvd8sLj = SeT23MvT.transferFrom(og5ka7OL, 0, og5ka7OL.size());
			if (IGvd8sLj < og5ka7OL.size())
				throw new IOException("File copy failed");
		} finally {
			if (og5ka7OL != null) {
				try {
					og5ka7OL.close();
				} catch (IOException cW1K4JB2) {
				}
			}
			if (SeT23MvT != null) {
				try {
					SeT23MvT.close();
				} catch (IOException sdErrtEJ) {
				}
			}
			i4TuMo5i.setLastModified(K0DTuuhR.lastModified());
		}
	}

}