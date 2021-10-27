class n14341904 {
	private static void copyFile(String leYY17sk, String L3QBK384) throws IOException {
		FileReader EsLlzf05 = new FileReader(leYY17sk);
		FileWriter BNYvbsFW = new FileWriter(L3QBK384);
		int K964SBk4;
		while ((K964SBk4 = EsLlzf05.read()) != -1)
			BNYvbsFW.write(K964SBk4);
		EsLlzf05.close();
		BNYvbsFW.close();
	}

}