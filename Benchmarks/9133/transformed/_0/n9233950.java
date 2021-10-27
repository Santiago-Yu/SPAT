class n9233950 {
	public static void copyFile(File qgzjDfVR, File gOTXwc2Q) throws IOException {
		if (!qgzjDfVR.exists())
			throw new IOException("File not found '" + qgzjDfVR.getAbsolutePath() + "'");
		BufferedOutputStream x6oZQ56e = new BufferedOutputStream(new FileOutputStream(gOTXwc2Q));
		BufferedInputStream rlYBvW53 = new BufferedInputStream(new FileInputStream(qgzjDfVR));
		byte[] ovmzPKGE = new byte[128];
		int YSGkcJz7 = 128;
		while ((YSGkcJz7 = rlYBvW53.read(ovmzPKGE)) > 0)
			x6oZQ56e.write(ovmzPKGE, 0, YSGkcJz7);
		x6oZQ56e.flush();
		x6oZQ56e.close();
		rlYBvW53.close();
	}

}