class n23268628 {
	private void parseXMLFile() {
		String Bsu9TjLQ = WeatherApplication.SERVER + location + ".xml";
		InputStream Zt4XEr8F = null;
		String qEvxRqLQ = null;
		try {
			URL blllNPyr = new URL(Bsu9TjLQ);
			HttpURLConnection ZokNQt37 = (HttpURLConnection) blllNPyr.openConnection();
			Zt4XEr8F = blllNPyr.openStream();
			ParserToolXML avrI1UW3 = new ParserToolXML(Zt4XEr8F);
			if (avrI1UW3.doc == null) {
				System.err.println(FILE_NOT_FOUND_MSG + Bsu9TjLQ);
				return;
			}
			NodeList NgCZhv4i = avrI1UW3.doc.getElementsByTagName("weather");
			for (int XLOKABAe = 0; XLOKABAe < NgCZhv4i.getLength(); XLOKABAe++) {
				Forecast LZbaovIu = new Forecast();
				qEvxRqLQ = avrI1UW3.searchElementValue(NgCZhv4i.item(XLOKABAe), "date");
				LZbaovIu.setDate(qEvxRqLQ);
				qEvxRqLQ = avrI1UW3.searchElementValue(NgCZhv4i.item(XLOKABAe), "daycode");
				LZbaovIu.setDaycode(Integer.parseInt(qEvxRqLQ.trim()));
				qEvxRqLQ = avrI1UW3.searchElementValue(NgCZhv4i.item(XLOKABAe), "nightcode");
				LZbaovIu.setNightcode(Integer.parseInt(qEvxRqLQ.trim()));
				qEvxRqLQ = avrI1UW3.searchElementValue(NgCZhv4i.item(XLOKABAe), "maxtemp");
				LZbaovIu.setDaytemp(Integer.parseInt(qEvxRqLQ.trim()));
				qEvxRqLQ = avrI1UW3.searchElementValue(NgCZhv4i.item(XLOKABAe), "mintemp");
				LZbaovIu.setNighttemp(Integer.parseInt(qEvxRqLQ.trim()));
				qEvxRqLQ = avrI1UW3.searchElementValue(NgCZhv4i.item(XLOKABAe), "winddirectionday");
				LZbaovIu.setDaywinddir(qEvxRqLQ);
				qEvxRqLQ = avrI1UW3.searchElementValue(NgCZhv4i.item(XLOKABAe), "windspeedday");
				LZbaovIu.setDaywindspeed(Integer.parseInt(qEvxRqLQ.trim()));
				qEvxRqLQ = avrI1UW3.searchElementValue(NgCZhv4i.item(XLOKABAe), "winddirectionnight");
				LZbaovIu.setNightwinddir(qEvxRqLQ);
				qEvxRqLQ = avrI1UW3.searchElementValue(NgCZhv4i.item(XLOKABAe), "windspeednight");
				LZbaovIu.setNightwindspeed(Integer.parseInt(qEvxRqLQ.trim()));
				forecastlist.addElement(LZbaovIu);
			}
		} catch (MalformedURLException FiPwu8rB) {
			System.err.println(MALFORMED_URL_MSG + Bsu9TjLQ);
			System.err.println(FiPwu8rB.getMessage());
			FiPwu8rB.printStackTrace();
		} catch (IOException eNe6I7bM) {
		} catch (NumberFormatException JVqyOdY5) {
			System.err.println(FILE_CORRUPT_MSG + Bsu9TjLQ);
			System.err.println("-" + qEvxRqLQ + "-");
			System.err.println(JVqyOdY5.getMessage());
			JVqyOdY5.printStackTrace();
		} finally {
			if (Zt4XEr8F != null) {
				try {
					Zt4XEr8F.close();
				} catch (IOException LqV6B1nf) {
					System.err.println(COULD_NOT_CLOSE_FILE_MSG + Bsu9TjLQ);
					LqV6B1nf.printStackTrace();
				}
			}
		}
	}

}