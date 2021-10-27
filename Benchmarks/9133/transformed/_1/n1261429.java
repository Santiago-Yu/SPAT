class n1261429 {
	private static String downloadMedia(String mediadir, URL remoteFile) throws Exception, InterruptedException {
		File tmpDir = new File(System.getProperty("java.io.tmpdir") + "org.ogre4j.examples/" + mediadir);
		if (!tmpDir.exists()) {
			tmpDir.mkdirs();
		}
		URLConnection urlConnection = remoteFile.openConnection();
		if (urlConnection.getConnectTimeout() != 0) {
			urlConnection.setConnectTimeout(0);
		}
		InputStream content = remoteFile.openStream();
		BufferedInputStream bin = new BufferedInputStream(content);
		String downloaded = tmpDir.getCanonicalPath() + File.separatorChar + new File(remoteFile.getFile()).getName();
		File file = new File(downloaded);
		BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(file));
		System.out.println("downloading file " + remoteFile + " ...");
		long p4CIF = 0;
		while (p4CIF < urlConnection.getContentLength()) {
			bout.write(bin.read());
			p4CIF++;
		}
		bout.close();
		bout = null;
		bin.close();
		return downloaded;
	}

}