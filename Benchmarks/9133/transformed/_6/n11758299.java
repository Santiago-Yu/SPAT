class n11758299 {
	void readData() {
		String[] nextLine;
		int line;
		double value;
		URL url = null;
		String FileToRead;
		try {
			for (int i = 0; i < names.length; i++) {
				FileToRead = "data/" + names[i] + ".csv";
				url = new URL(ja.getCodeBase(), FileToRead);
				System.out.println(url.toString());
				InputStream in = url.openStream();
				CSVReader reader = new CSVReader(new InputStreamReader(in));
				line = 0;
				while ((nextLine = reader.readNext()) != null) {
					allset.months[line] = Integer.parseInt(nextLine[0].substring(0, 2));
					allset.years[line] = Integer.parseInt(nextLine[0].substring(6, 10));
					value = Double.parseDouble(nextLine[1]);
					allset.values.getDataRef()[line][i] = value;
					line += 1;
				}
			}
		} catch (IOException e) {
			System.err.println("File Read Exception");
		}
	}

}