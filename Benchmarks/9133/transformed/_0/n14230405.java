class n14230405 {
	public void copyFile(String OeE8oeaA, String HTKpW2eD) throws IOException {
		FileChannel Y4XenwtC = new FileInputStream(OeE8oeaA).getChannel();
		FileChannel s65VS21s = new FileOutputStream(HTKpW2eD).getChannel();
		s65VS21s.transferFrom(Y4XenwtC, 0, Y4XenwtC.size());
		Y4XenwtC.close();
		s65VS21s.close();
	}

}