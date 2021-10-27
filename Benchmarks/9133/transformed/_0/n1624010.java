class n1624010 {
	public static void copy(String s5qiXlPl, String puhSLxxx) throws IOException {
		File iUe0Bu9v = new File(s5qiXlPl);
		File WS9vdeIC = new File(puhSLxxx);
		FileReader aKwILSQ6 = new FileReader(iUe0Bu9v);
		FileWriter UiBY4MML = new FileWriter(WS9vdeIC);
		int N8h2ky1N;
		while ((N8h2ky1N = aKwILSQ6.read()) != -1)
			UiBY4MML.write(N8h2ky1N);
		aKwILSQ6.close();
		UiBY4MML.close();
	}

}