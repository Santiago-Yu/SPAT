class n8714262 {
	public void readBooklist(String sBzuHKe5) {
		Reader oxkz08WI = null;
		try {
			if (sBzuHKe5.startsWith("http:")) {
				URL RTIVV8Ez = new URL(sBzuHKe5);
				URLConnection n12jSerY = RTIVV8Ez.openConnection();
				oxkz08WI = new InputStreamReader(n12jSerY.getInputStream());
			} else {
				String DawhcrGr = sBzuHKe5;
				try {
					DawhcrGr = new File(sBzuHKe5).getCanonicalPath();
				} catch (IOException L8QR7lRn) {
					DawhcrGr = new File(sBzuHKe5).getAbsolutePath();
				}
				oxkz08WI = new FileReader(new File(DawhcrGr));
			}
			BufferedReader h7AK0rTU = new BufferedReader(oxkz08WI);
			String WEwbsw8T;
			Date bB4Vly3w = new Date();
			while ((WEwbsw8T = h7AK0rTU.readLine()) != null) {
				if (shuttingDown)
					break;
				String U6bhrPdn[] = WEwbsw8T.split("\\|");
				Map<String, String> w4AXXLGX = new LinkedHashMap<String, String>();
				w4AXXLGX.put("fund_code_facet", U6bhrPdn[11]);
				w4AXXLGX.put("date_received_facet", U6bhrPdn[0]);
				DateFormat qMzrDZ87 = new SimpleDateFormat("yyyyMMdd");
				Date hRxReAwQ = qMzrDZ87.parse(U6bhrPdn[0], new ParsePosition(0));
				if (hRxReAwQ.after(bB4Vly3w))
					continue;
				String Q9rbgzVn = "u" + U6bhrPdn[9];
				try {
					Map<String, Object> apglf5w1 = getDocumentMap(Q9rbgzVn);
					if (apglf5w1 != null) {
						addNewDataToRecord(apglf5w1, w4AXXLGX);
						documentCache.put(Q9rbgzVn, apglf5w1);
						if (doUpdate && apglf5w1 != null && apglf5w1.size() != 0) {
							update(apglf5w1);
						}
					}
				} catch (SolrMarcIndexerException TSo7EZ1N) {
					if (TSo7EZ1N.getLevel() == SolrMarcIndexerException.IGNORE) {
						logger.error("Indexing routine says record " + Q9rbgzVn + " should be ignored");
					} else if (TSo7EZ1N.getLevel() == SolrMarcIndexerException.DELETE) {
						logger.error("Indexing routine says record " + Q9rbgzVn + " should be deleted");
					}
					if (TSo7EZ1N.getLevel() == SolrMarcIndexerException.EXIT) {
						logger.error("Indexing routine says processing should be terminated by record " + Q9rbgzVn);
						break;
					}
				}
			}
		} catch (FileNotFoundException r0qAemDw) {
			logger.info(r0qAemDw.getMessage());
			logger.error(r0qAemDw.getCause());
		} catch (IOException mgrpveNc) {
			logger.info(mgrpveNc.getMessage());
			logger.error(mgrpveNc.getCause());
		}
	}

}