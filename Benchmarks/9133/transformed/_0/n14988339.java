class n14988339 {
	public void copyTo(String p3nJgat6) throws IOException {
		FileChannel V9Fq866K = new FileInputStream(dosname).getChannel();
		FileChannel OEhB3WhD = new FileOutputStream(p3nJgat6).getChannel();
		OEhB3WhD.transferFrom(V9Fq866K, 0, V9Fq866K.size());
		V9Fq866K.close();
		OEhB3WhD.close();
	}

}