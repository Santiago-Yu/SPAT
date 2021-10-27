class n16875869 {
	public static ArrayList<Quote> fetchAllQuotes(String jWjHXR1O, Date CW3sEPXz, Date IXXF58nM) {
		try {
			GregorianCalendar BhfHmpYQ = new GregorianCalendar();
			BhfHmpYQ.setTime(CW3sEPXz);
			String GpcfrGod = (new Integer(BhfHmpYQ.get(GregorianCalendar.MONTH))).toString();
			String P0AWPUCF = (new Integer(BhfHmpYQ.get(GregorianCalendar.DAY_OF_MONTH))).toString();
			String x4CBUx7x = (new Integer(BhfHmpYQ.get(GregorianCalendar.YEAR))).toString();
			BhfHmpYQ.setTime(IXXF58nM);
			String DUnRIaeW = (new Integer(BhfHmpYQ.get(GregorianCalendar.MONTH))).toString();
			String iXJFZK8e = (new Integer(BhfHmpYQ.get(GregorianCalendar.DAY_OF_MONTH))).toString();
			String GzGGrlOL = (new Integer(BhfHmpYQ.get(GregorianCalendar.YEAR))).toString();
			URL HZs40opF = new URL("http://ichart.finance.yahoo.com/table.csv?s=" + jWjHXR1O + "&a=" + GpcfrGod + "&b="
					+ P0AWPUCF + "&c=" + x4CBUx7x + "&d=" + DUnRIaeW + "&e=" + iXJFZK8e + "&f=" + GzGGrlOL
					+ "&g=d&ignore=.csv");
			BufferedReader SMt0ssbP = new BufferedReader(new InputStreamReader(HZs40opF.openStream()));
			String wXWqc7eZ;
			ArrayList<Quote> NSKtUItq = new ArrayList<Quote>();
			SMt0ssbP.readLine();
			while ((wXWqc7eZ = SMt0ssbP.readLine()) != null) {
				String[] Az4m1nba = wXWqc7eZ.split(",");
				String yWjEftFE = Az4m1nba[0];
				Date af63a10M = new SimpleDateFormat("yyyy-MM-dd").parse(yWjEftFE);
				double RmjM4krW = Double.valueOf(Az4m1nba[1]);
				double klVjAbsJ = Double.valueOf(Az4m1nba[2]);
				double mggurKvm = Double.valueOf(Az4m1nba[3]);
				double uDGDsAZR = Double.valueOf(Az4m1nba[4]);
				long i09YiL8c = Long.valueOf(Az4m1nba[5]);
				double NMPTbuEN = Double.valueOf(Az4m1nba[6]);
				Quote dmXVR34P = new Quote(af63a10M, RmjM4krW, klVjAbsJ, mggurKvm, uDGDsAZR, i09YiL8c, NMPTbuEN);
				NSKtUItq.add(dmXVR34P);
			}
			SMt0ssbP.close();
			Collections.reverse(NSKtUItq);
			return NSKtUItq;
		} catch (MalformedURLException ZjhR6bxE) {
			System.out.println("URL malformee");
		} catch (IOException AXynjVE4) {
			System.out.println("Donnees illisibles");
		} catch (ParseException XTd97qgm) {
			XTd97qgm.printStackTrace();
		}
		return null;
	}

}