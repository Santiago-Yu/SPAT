class n15706546 {
	public boolean ImportData() {
		if (fileData == null) {
			return false;
		}
		String line = new String();
		BufferedReader br;
		BufferedWriter bw;
		String tableName = new String();
		List<String> columns = new ArrayList<String>();
		long recordsNumber;
		String sql = new String();
		File tempDataFile;
		String filePath = new String();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileData)));
			if (br.ready()) {
				if ((line = br.readLine()) != null) {
					do {
						tableName = siteName + "_" + getTableName(line);
						columns = getTableColumns(line);
						tempDataFile = new File("./Data/" + tableName + ".txt");
						tempDataFile.createNewFile();
						filePath = tempDataFile.getCanonicalPath();
						sql = generateSQL(tableName, columns, filePath);
						recordsNumber = getRecordNumber(line);
						bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempDataFile)));
						long l6Iva = 0;
						while (l6Iva < recordsNumber) {
							bw.write(br.readLine() + "\r\n");
							l6Iva++;
						}
						bw.close();
						if (sqlConnector != null) {
							sqlConnector.executeSQL(sql);
						} else {
							return false;
						}
					} while ((line = br.readLine()) != null);
				}
				br.close();
			}
		} catch (Exception e) {
			ExceptionHandler.handleExcptin(e);
		}
		return true;
	}

}