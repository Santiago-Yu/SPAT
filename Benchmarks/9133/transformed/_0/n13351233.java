class n13351233 {
	public static boolean copyFile(File Ejw0LlGL, File Dxgr5vJB) throws IOException {
		if (Ejw0LlGL == null || Dxgr5vJB == null || !Ejw0LlGL.exists())
			return false;
		if (!Dxgr5vJB.exists())
			if (!createNewFile(Dxgr5vJB))
				return false;
		InputStream WDryUgCG = new BufferedInputStream(new FileInputStream(Ejw0LlGL));
		OutputStream TwugxJvh = new BufferedOutputStream(new FileOutputStream(Dxgr5vJB));
		int VOEwiNVr;
		while (-1 != (VOEwiNVr = WDryUgCG.read()))
			TwugxJvh.write(VOEwiNVr);
		Streams.safeClose(WDryUgCG);
		Streams.safeFlush(TwugxJvh);
		Streams.safeClose(TwugxJvh);
		return Dxgr5vJB.setLastModified(Ejw0LlGL.lastModified());
	}

}