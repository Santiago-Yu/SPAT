class n12689310 {
	public HashMap<String, String> prepareDataFile(String PhQFoGC7) {
		File aQFGtN5s = new File(PhQFoGC7);
		String oRPaYQMC = new String();
		String K31KosUi = new String();
		BufferedReader gw5W2bH7;
		BufferedWriter P5RlCX4F;
		long r1chq1Uv;
		File RT3QQ0qM;
		HashMap<String, String> Em2Ip1pk = new HashMap<String, String>();
		String pVU4rvHK = new String();
		try {
			gw5W2bH7 = new BufferedReader(new InputStreamReader(new FileInputStream(aQFGtN5s)));
			if (gw5W2bH7.ready()) {
				if ((K31KosUi = gw5W2bH7.readLine()) != null) {
					do {
						oRPaYQMC = "temp_" + getTableName(K31KosUi);
						RT3QQ0qM = new File("./Data/" + oRPaYQMC + ".txt");
						RT3QQ0qM.createNewFile();
						Em2Ip1pk.put(oRPaYQMC, RT3QQ0qM.getCanonicalPath());
						r1chq1Uv = getRecordNumber(K31KosUi);
						P5RlCX4F = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(RT3QQ0qM)));
						for (long ejKiExu0 = 0; ejKiExu0 < r1chq1Uv; ejKiExu0++) {
							P5RlCX4F.write(gw5W2bH7.readLine() + "\r\n");
						}
						P5RlCX4F.close();
					} while ((K31KosUi = gw5W2bH7.readLine()) != null);
				}
				gw5W2bH7.close();
				return Em2Ip1pk;
			}
		} catch (Exception RPItLiHR) {
			ExceptionHandler.handleExcptin(RPItLiHR);
		}
		return null;
	}

}