class n22304989 {
	public ArrayList loadData(String X3hypS74) {
		URL ovwUSaK1;
		BufferedReader dcx0kK6x = null;
		ArrayList cdWrYJB0 = new ArrayList();
		String N2OwJ4Gy;
		try {
			ovwUSaK1 = new URL(X3hypS74);
			dcx0kK6x = new BufferedReader(new InputStreamReader(ovwUSaK1.openStream()));
			while (((N2OwJ4Gy = dcx0kK6x.readLine()) != null)) {
				if (N2OwJ4Gy.startsWith("Date")) {
					continue;
				}
				if (N2OwJ4Gy != null && N2OwJ4Gy.length() > 0) {
					cdWrYJB0.add(N2OwJ4Gy);
				}
			}
			dcx0kK6x.close();
		} catch (Exception VHkh7wdK) {
			System.out.println("StockValumeHistory:loadData:Error:" + VHkh7wdK);
		}
		return cdWrYJB0;
	}

}