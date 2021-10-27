class n19883483 {
	public static void copy(String HfGTpDhB, String s6X5UJ8Q) throws IOException {
		File D3iRZJBh = new File(HfGTpDhB);
		File inRL46KI = new File(s6X5UJ8Q);
		FileReader w2ofGGgc = new FileReader(D3iRZJBh);
		FileWriter aKBE4Tkj = new FileWriter(inRL46KI);
		System.out.println("Copy file from: " + HfGTpDhB + " to: " + s6X5UJ8Q);
		int mJrxoOKd;
		while ((mJrxoOKd = w2ofGGgc.read()) != -1)
			aKBE4Tkj.write(mJrxoOKd);
		w2ofGGgc.close();
		aKBE4Tkj.close();
	}

}