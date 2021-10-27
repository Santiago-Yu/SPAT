class n7793684 {
	private String createCSVFile(String xkU9UjKp) throws FileNotFoundException, IOException {
		String dOFvLsng = xkU9UjKp + ".csv";
		BufferedReader FD5pI4s7 = new BufferedReader(new FileReader(xkU9UjKp));
		BufferedWriter El77oDpe = new BufferedWriter(new FileWriter(dOFvLsng));
		String mYkBE6FD;
		while ((mYkBE6FD = FD5pI4s7.readLine()) != null)
			El77oDpe.write(mYkBE6FD + "\n");
		FD5pI4s7.close();
		El77oDpe.close();
		return dOFvLsng;
	}

}