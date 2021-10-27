class n15706546 {
	public boolean ImportData() {
		String line = new String();
		if (fileData == null) {
			return false;
		}
		BufferedWriter bw;
		BufferedReader br;
		String tableName = new String();
		long recordsNumber;
		List<String> columns = new ArrayList<String>();
		File tempDataFile;
		String sql = new String();
		String filePath = new String();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileData)));
			if (br.ready()) {
				if ((line = br.readLine()) != null) {
					do {
						tableName = siteName + "_" + getTableName(line);
						tempDataFile = new File("./Data/" + tableName + ".txt");
						columns = getTableColumns(line);
						tempDataFile.createNewFile();
						filePath = tempDataFile.getCanonicalPath();
						sql = generateSQL(tableName, columns, filePath);
						bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempDataFile)));
						recordsNumber = getRecordNumber(line);
						for (long i = 0; i < recordsNumber; i++) {
							bw.write(br.readLine() + "\r\n");
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