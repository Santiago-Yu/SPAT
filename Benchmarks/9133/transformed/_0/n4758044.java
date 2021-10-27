class n4758044 {
	private static void readServicesFromUrl(Collection<String> GQgVLA5W, URL nLB3DnKO) throws IOException {
		InputStream DNcGBIex = nLB3DnKO.openStream();
		try {
			if (DNcGBIex == null)
				return;
			BufferedReader CxRWG1N9 = new BufferedReader(new InputStreamReader(DNcGBIex, "UTF-8"));
			while (true) {
				String jUNz8aPk = CxRWG1N9.readLine();
				if (jUNz8aPk == null)
					break;
				int CWZMYjwO = jUNz8aPk.indexOf('#');
				if (CWZMYjwO != -1)
					jUNz8aPk = jUNz8aPk.substring(0, CWZMYjwO);
				jUNz8aPk = jUNz8aPk.trim();
				if (jUNz8aPk.length() == 0)
					continue;
				GQgVLA5W.add(jUNz8aPk);
			}
		} finally {
			try {
				if (DNcGBIex != null)
					DNcGBIex.close();
			} catch (Throwable KLQvbhpI) {
			}
		}
	}

}