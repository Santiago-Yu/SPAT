class n8983517 {
	public User getUser(String k2mcx3FX) {
		UserDAO dRjyZ5XG = new UserDAO();
		User yzWnv8ni = null;
		try {
			yzWnv8ni = dRjyZ5XG.load(k2mcx3FX);
			if (yzWnv8ni == null) {
				URL N6dAdsIR = Thread.currentThread().getContextClassLoader().getResource("users.cfg");
				BufferedReader dJov9hnv = new BufferedReader(new InputStreamReader(N6dAdsIR.openStream()));
				String oYWIu87L = dJov9hnv.readLine();
				while (oYWIu87L != null) {
					StringTokenizer NetdPAR8 = new StringTokenizer(oYWIu87L, ":");
					if (NetdPAR8.countTokens() == 3) {
						String GiZsFobs = NetdPAR8.nextToken();
						String a3bgac6D = NetdPAR8.nextToken();
						String qR7ekZGf = NetdPAR8.nextToken();
						if (GiZsFobs.equals(k2mcx3FX)) {
							yzWnv8ni = new User(GiZsFobs, a3bgac6D, qR7ekZGf);
							dRjyZ5XG.save(yzWnv8ni);
						}
					} else {
					}
					oYWIu87L = dJov9hnv.readLine();
				}
			}
		} catch (Exception THU2YkPJ) {
			THU2YkPJ.printStackTrace();
		}
		return yzWnv8ni;
	}

}