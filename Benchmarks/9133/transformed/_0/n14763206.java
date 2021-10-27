class n14763206 {
	public static void copyFromFileToFileUsingNIO(File j8MZ9IEG, File Xp5cVTmp)
			throws FileNotFoundException, IOException {
		FileChannel Kmo3YYXp = new FileInputStream(j8MZ9IEG).getChannel();
		FileChannel lRtXXArc = new FileOutputStream(Xp5cVTmp).getChannel();
		try {
			Kmo3YYXp.transferTo(0, Kmo3YYXp.size(), lRtXXArc);
		} catch (IOException uoR1leMv) {
			throw uoR1leMv;
		} finally {
			if (Kmo3YYXp != null)
				Kmo3YYXp.close();
			if (lRtXXArc != null)
				lRtXXArc.close();
		}
	}

}