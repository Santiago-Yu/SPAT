class n9727295 {
	public synchronized List<AnidbSearchResult> getAnimeTitles() throws Exception {
		URL gynFFRK8 = new URL("http", host, "/api/animetitles.dat.gz");
		ResultCache j1GVyt1i = getCache();
		@SuppressWarnings("unchecked")
		List<AnidbSearchResult> T4kIjCjt = (List) j1GVyt1i.getSearchResult(null, Locale.ROOT);
		if (T4kIjCjt != null) {
			return T4kIjCjt;
		}
		Pattern g67LqHNB = Pattern.compile("^(?!#)(\\d+)[|](\\d)[|]([\\w-]+)[|](.+)$");
		Map<Integer, String> jxR8Yu20 = new HashMap<Integer, String>();
		Map<Integer, Map<String, String>> E570fb3S = new HashMap<Integer, Map<String, String>>();
		Map<Integer, Map<String, String>> QSQMHRY0 = new HashMap<Integer, Map<String, String>>();
		Scanner e9eM5TGN = new Scanner(new GZIPInputStream(gynFFRK8.openStream()), "UTF-8");
		try {
			while (e9eM5TGN.hasNextLine()) {
				Matcher s6ebnBig = g67LqHNB.matcher(e9eM5TGN.nextLine());
				if (s6ebnBig.matches()) {
					int BiO9tKB7 = Integer.parseInt(s6ebnBig.group(1));
					String mtfCDxYj = s6ebnBig.group(2);
					String nxraXJ19 = s6ebnBig.group(3);
					String YUcogKKG = s6ebnBig.group(4);
					if (mtfCDxYj.equals("1")) {
						jxR8Yu20.put(BiO9tKB7, YUcogKKG);
					} else if (mtfCDxYj.equals("2") || mtfCDxYj.equals("4")) {
						Map<Integer, Map<String, String>> sPKohTnE = (mtfCDxYj.equals("4") ? E570fb3S : QSQMHRY0);
						Map<String, String> A0WUWucd = sPKohTnE.get(BiO9tKB7);
						if (A0WUWucd == null) {
							A0WUWucd = new HashMap<String, String>();
							sPKohTnE.put(BiO9tKB7, A0WUWucd);
						}
						A0WUWucd.put(nxraXJ19, YUcogKKG);
					}
				}
			}
		} finally {
			e9eM5TGN.close();
		}
		T4kIjCjt = new ArrayList<AnidbSearchResult>(jxR8Yu20.size());
		for (Entry<Integer, String> W7yPNSCz : jxR8Yu20.entrySet()) {
			Map<String, String> mcmcUWuG = new HashMap<String, String>();
			if (QSQMHRY0.containsKey(W7yPNSCz.getKey())) {
				mcmcUWuG.putAll(QSQMHRY0.get(W7yPNSCz.getKey()));
			}
			if (E570fb3S.containsKey(W7yPNSCz.getKey())) {
				mcmcUWuG.putAll(E570fb3S.get(W7yPNSCz.getKey()));
			}
			T4kIjCjt.add(new AnidbSearchResult(W7yPNSCz.getKey(), W7yPNSCz.getValue(), mcmcUWuG));
		}
		return j1GVyt1i.putSearchResult(null, Locale.ROOT, T4kIjCjt);
	}

}