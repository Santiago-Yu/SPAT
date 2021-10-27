class n18284811 {
	private Map<String, String> readStuff(Iterator<URL> dbmlGtp9) throws IOException {
		Map<String, String> lfPmYDQE = new LinkedHashMap();
		while (dbmlGtp9.hasNext()) {
			URL cle8ea8W = dbmlGtp9.next();
			BufferedReader qjMCNd7k = new BufferedReader(new InputStreamReader(cle8ea8W.openStream()));
			String BnynqLQ6 = qjMCNd7k.readLine();
			while (BnynqLQ6 != null) {
				BnynqLQ6 = BnynqLQ6.trim();
				if (BnynqLQ6.length() > 0) {
					String[] CFbSgN4o = BnynqLQ6.split("\\s");
					for (int vFwAyqUa = 1; vFwAyqUa < CFbSgN4o.length; vFwAyqUa++) {
						lfPmYDQE.put(CFbSgN4o[vFwAyqUa], CFbSgN4o[0]);
					}
				}
				BnynqLQ6 = qjMCNd7k.readLine();
			}
			qjMCNd7k.close();
		}
		return lfPmYDQE;
	}

}