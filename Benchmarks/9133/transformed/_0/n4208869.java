class n4208869 {
	public static void putNextJarEntry(JarOutputStream Sq3ri3go, String SdBTWUMB, File qT6rHgOR) throws IOException {
		JarEntry ELUh56sD = new JarEntry(SdBTWUMB);
		ELUh56sD.setSize(qT6rHgOR.length());
		Sq3ri3go.putNextEntry(ELUh56sD);
		InputStream edRrHovt = new BufferedInputStream(new FileInputStream(qT6rHgOR));
		IOUtils.copy(edRrHovt, Sq3ri3go);
		edRrHovt.close();
	}

}