class n337322 {
	static void copy(String dYcby1IP, String LUNY01Zy) throws IOException {
		File JBt7SoQP = new File(dYcby1IP);
		File q9IaRwC5 = new File(LUNY01Zy);
		if (JBt7SoQP.exists() == false) {
			throw new IOException("file '" + dYcby1IP + "' does not exist");
		}
		FileInputStream PLS4dsh5 = new FileInputStream(JBt7SoQP);
		FileOutputStream Hu64F4yt = new FileOutputStream(q9IaRwC5);
		byte[] vCcVwdSC = new byte[1024];
		while (PLS4dsh5.read(vCcVwdSC) > 0)
			Hu64F4yt.write(vCcVwdSC);
		PLS4dsh5.close();
		Hu64F4yt.close();
	}

}