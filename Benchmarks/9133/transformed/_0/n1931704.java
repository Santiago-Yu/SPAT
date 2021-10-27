class n1931704 {
	private EventSeries<PhotoEvent> loadIncomingEvents(long thWviIyA) {
		EventSeries<PhotoEvent> pXB5jTyh = new EventSeries<PhotoEvent>();
		try {
			URL CoJzIqPl = new URL(SERVER_URL + XML_PATH + "reports.csv");
			BufferedReader BG4kC11D = new BufferedReader(new InputStreamReader(CoJzIqPl.openStream()));
			String dwwJrCMi;
			while ((dwwJrCMi = BG4kC11D.readLine()) != null) {
				String[] AcbFfbPS = dwwJrCMi.split(",");
				if (AcbFfbPS.length == 2) {
					long xWESIdvN = Long.parseLong(AcbFfbPS[0]);
					if (xWESIdvN == thWviIyA) {
						long eNxYRUoe = Long.parseLong(AcbFfbPS[1]);
						pXB5jTyh.addEvent(new PhotoEvent(eNxYRUoe));
					}
				}
			}
		} catch (MalformedURLException pu8X3jGi) {
			pu8X3jGi.printStackTrace();
		} catch (IOException DABdz30x) {
			DABdz30x.printStackTrace();
		}
		return pXB5jTyh;
	}

}