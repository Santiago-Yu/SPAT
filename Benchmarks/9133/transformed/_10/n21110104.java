class n21110104 {
	public static SimpleDataTable loadDataFromFile(URL urlMetadata, URL urlData) throws IOException {
		List<String> columnNamesList = new ArrayList<String>();
		BufferedReader in = new BufferedReader(new InputStreamReader(urlMetadata.openStream()));
		String[] lineParts = null;
		String line;
		in.readLine();
		while ((line = in.readLine()) != null) {
			lineParts = line.split(",");
			columnNamesList.add(lineParts[0]);
		}
		int index = 0;
		String[] columnNamesArray = new String[columnNamesList.size()];
		for (String s : columnNamesList) {
			columnNamesArray[index] = s;
			index++;
		}
		in = new BufferedReader(new InputStreamReader(urlData.openStream()));
		SimpleDataTable table = new SimpleDataTable("tabulka s daty", columnNamesArray);
		line = null;
		lineParts = null;
		double[] rowData;
		SimpleDataTableRow tableRow;
		while ((line = in.readLine()) != null) {
			rowData = new double[columnNamesList.size()];
			lineParts = line.split(",");
			for (int i = 0; i < columnNamesArray.length; i++) {
				rowData[i] = Double.parseDouble(lineParts[i + 1]);
			}
			tableRow = new SimpleDataTableRow(rowData, lineParts[0]);
			table.add(tableRow);
		}
		return table;
	}

}