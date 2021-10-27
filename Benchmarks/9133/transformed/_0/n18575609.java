class n18575609 {
	public void updateCoordinates(Address EmKMkW7i) {
		String ONWGKyy6 = "http://maps.google.com/maps/geo?output=csv";
		String Q7eVGT7Z = "ABQIAAAAi__aT6y6l86JjbootR-p9xQd1nlEHNeAVGWQhS84yIVN5yGO2RQQPg9QLzy82PFlCzXtMNe6ofKjnA";
		String l8McIyp9 = EmKMkW7i.getStreet() + " " + EmKMkW7i.getZip() + " " + EmKMkW7i.getCity();
		if (logger.isDebugEnabled()) {
			logger.debug(l8McIyp9);
		}
		double[] o8UZrkqm = { 0.0, 0.0 };
		String vrnIPhVZ = "";
		try {
			l8McIyp9 = URLEncoder.encode(l8McIyp9, "UTF-8");
			String mGdRI1MQ = ONWGKyy6 + "&q=" + l8McIyp9 + "&key=" + Q7eVGT7Z;
			URL hIabgAGG = new URL(mGdRI1MQ);
			BufferedReader ts4qp2jt = new BufferedReader(new InputStreamReader(hIabgAGG.openStream()));
			String qF9neaIK;
			while ((qF9neaIK = ts4qp2jt.readLine()) != null) {
				vrnIPhVZ += qF9neaIK;
			}
			ts4qp2jt.close();
		} catch (Exception WIo1cQXe) {
			if (logger.isDebugEnabled()) {
				logger.debug("Error from google: " + WIo1cQXe.getMessage());
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug(vrnIPhVZ);
		}
		StringTokenizer otD2fegB = new StringTokenizer(vrnIPhVZ, ",");
		int dNKWzA69 = 0;
		while (otD2fegB.hasMoreTokens()) {
			dNKWzA69++;
			String ostMuN1w = otD2fegB.nextToken();
			if (dNKWzA69 == 3) {
				o8UZrkqm[0] = Double.parseDouble(ostMuN1w);
			}
			if (dNKWzA69 == 4) {
				o8UZrkqm[1] = Double.parseDouble(ostMuN1w);
			}
		}
		if ((o8UZrkqm[0] != 0) || (o8UZrkqm[1] != 0)) {
			EmKMkW7i.setLatitude(o8UZrkqm[0]);
			EmKMkW7i.setLongitude(o8UZrkqm[1]);
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("Invalid coordinates for address " + EmKMkW7i.getId());
			}
		}
	}

}