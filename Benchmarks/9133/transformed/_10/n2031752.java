class n2031752 {
	public String readFile(String filename) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		File f = new File(baseDir);
		StringWriter w = new StringWriter();
		f = new File(f, filename);
		Reader fr = new InputStreamReader(new FileInputStream(f), "UTF-8");
		IOUtils.copy(fr, w);
		fr.close();
		w.close();
		String contents = w.toString();
		return contents;
	}

}