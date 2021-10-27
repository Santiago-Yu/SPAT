class n7793684 {
	private String createCSVFile(String fileName) throws FileNotFoundException, IOException {
		String csvFile = fileName + ".csv";
		BufferedWriter out = new BufferedWriter(new FileWriter(csvFile));
		BufferedReader buf = new BufferedReader(new FileReader(fileName));
		String line;
		while ((line = buf.readLine()) != null)
			out.write(line + "\n");
		buf.close();
		out.close();
		return csvFile;
	}

}