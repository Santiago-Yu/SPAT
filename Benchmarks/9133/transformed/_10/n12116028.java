class n12116028 {
	public static void main(String[] args) throws Exception {
		File inputFile = new File(args[0]);
		StringBuffer stringBuffer = new StringBuffer();
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String readed;
		while ((readed = reader.readLine()) != null)
			stringBuffer.append(readed + "\r\n");
		readed = stringBuffer.toString();
		reader.close();
		File outputFile = new File(args[0] + ".output");
		readed = readed.replaceAll("\\t+", "#");
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
		readed = readed.replaceAll("\\s*#\\s*", "#");
		readed = readed.replaceAll("Latitude,.*", "");
		readed = readed.replaceAll("Flag of", "");
		readed = readed.replaceAll("^\\s+$", "");
		writer.write(readed);
		writer.close();
	}

}