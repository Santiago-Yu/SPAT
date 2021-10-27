class n17268049 {
	public DProblem loadProblem(String YZY7PbnW) throws DataStoreException {
		try {
			URL y3l36vxK = new URL(YZY7PbnW);
			IWPLog.info(this, "[DProblemManager_HTTP] URL :" + YZY7PbnW);
			BufferedReader EjwvU0x7 = new BufferedReader(new InputStreamReader(y3l36vxK.openStream()));
			StringBuffer Hk4nkOAk = new StringBuffer();
			String KQXZAnVs;
			int cqGmVuao = 0;
			while ((KQXZAnVs = EjwvU0x7.readLine()) != null) {
				Hk4nkOAk.append(KQXZAnVs + "\n");
				cqGmVuao++;
			}
			DProblem uXw8vh4F = DProblemXMLParser.load(Hk4nkOAk.toString());
			if (uXw8vh4F != null) {
				uXw8vh4F.setUsername("Local");
				uXw8vh4F.setFilename(YZY7PbnW);
				uXw8vh4F.setAccessMode(DProblemManager.HTTP);
			}
			return uXw8vh4F;
		} catch (MalformedURLException icjAbjIg) {
			throw new DataStoreException(icjAbjIg);
		} catch (IOException AF0m5las) {
			IWPLog.info(this,
					"[DProblemManager_HTTP.loadProblem] unable to load: " + YZY7PbnW + ": " + AF0m5las.getMessage());
			AF0m5las.printStackTrace();
			throw new DataStoreException(AF0m5las);
		} catch (XMLParserException YlFS6IWZ) {
			throw new DataStoreException(YlFS6IWZ);
		}
	}

}