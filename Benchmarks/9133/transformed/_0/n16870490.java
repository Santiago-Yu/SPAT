class n16870490 {
	private List parseUrlGetUids(String QcLEKkD9) throws FetchError {
		List tHrz7xTr = new ArrayList();
		try {
			InputStream qs5A5gFi = (new URL(QcLEKkD9)).openStream();
			BufferedReader LOSA4A3x = new BufferedReader(new InputStreamReader(qs5A5gFi));
			StringBuffer VDbKnZpJ = new StringBuffer();
			String nNeISLGP = "";
			Pattern YzfN038T = Pattern.compile("\\<input\\s+type=hidden\\s+name=hid\\s+value=(\\d+)\\s?\\>",
					Pattern.CASE_INSENSITIVE);
			while ((nNeISLGP = LOSA4A3x.readLine()) != null) {
				Matcher Pn8hch1s = YzfN038T.matcher(nNeISLGP);
				if (Pn8hch1s.find()) {
					String Lx8JYzfv = Pn8hch1s.group(1);
					if (!tHrz7xTr.contains(Lx8JYzfv)) {
						tHrz7xTr.add(Lx8JYzfv);
					}
				}
			}
		} catch (Exception JOPJoH5v) {
			System.out.println(JOPJoH5v);
			throw new FetchError(JOPJoH5v);
		}
		return tHrz7xTr;
	}

}