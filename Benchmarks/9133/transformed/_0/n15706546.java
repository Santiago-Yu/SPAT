class n15706546 {
	public boolean ImportData() {
		if (fileData == null) {
			return false;
		}
		String Mdbo07gt = new String();
		BufferedReader mV3YlGZc;
		BufferedWriter kxavOUwO;
		String uCaC9a2R = new String();
		List<String> Fw90NyPF = new ArrayList<String>();
		long fzTmu1K7;
		String HUWN2wGG = new String();
		File zT9EetaC;
		String pUkrFL9Q = new String();
		try {
			mV3YlGZc = new BufferedReader(new InputStreamReader(new FileInputStream(fileData)));
			if (mV3YlGZc.ready()) {
				if ((Mdbo07gt = mV3YlGZc.readLine()) != null) {
					do {
						uCaC9a2R = siteName + "_" + getTableName(Mdbo07gt);
						Fw90NyPF = getTableColumns(Mdbo07gt);
						zT9EetaC = new File("./Data/" + uCaC9a2R + ".txt");
						zT9EetaC.createNewFile();
						pUkrFL9Q = zT9EetaC.getCanonicalPath();
						HUWN2wGG = generateSQL(uCaC9a2R, Fw90NyPF, pUkrFL9Q);
						fzTmu1K7 = getRecordNumber(Mdbo07gt);
						kxavOUwO = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(zT9EetaC)));
						for (long Alwhs5HM = 0; Alwhs5HM < fzTmu1K7; Alwhs5HM++) {
							kxavOUwO.write(mV3YlGZc.readLine() + "\r\n");
						}
						kxavOUwO.close();
						if (sqlConnector != null) {
							sqlConnector.executeSQL(HUWN2wGG);
						} else {
							return false;
						}
					} while ((Mdbo07gt = mV3YlGZc.readLine()) != null);
				}
				mV3YlGZc.close();
			}
		} catch (Exception yOYU3TQC) {
			ExceptionHandler.handleExcptin(yOYU3TQC);
		}
		return true;
	}

}