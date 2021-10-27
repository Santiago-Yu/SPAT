class n7495800 {
	public static void copyFile(File Q0ZAFDNg, File gNIUFbNm) throws IOException {
		FileReader qKGdAM0x = new FileReader(Q0ZAFDNg);
		FileWriter KfCPuiZT = new FileWriter(gNIUFbNm);
		char[] DzNADYzh = new char[4096];
		int fzz7gqae;
		while ((fzz7gqae = qKGdAM0x.read(DzNADYzh)) != -1) {
			KfCPuiZT.write(DzNADYzh, 0, fzz7gqae);
		}
		KfCPuiZT.flush();
		KfCPuiZT.close();
		qKGdAM0x.close();
	}

}