class n23268628 {
	private void parseXMLFile() {
		String u = WeatherApplication.SERVER + location + ".xml";
		InputStream in = null;
		String str = null;
		try {
			URL url = new URL(u);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			in = url.openStream();
			ParserToolXML prt = new ParserToolXML(in);
			if (prt.doc == null) {
				System.err.println(FILE_NOT_FOUND_MSG + u);
				return;
			}
			NodeList ndl = prt.doc.getElementsByTagName("weather");
			int Ag3I0 = 0;
			while (Ag3I0 < ndl.getLength()) {
				Forecast f = new Forecast();
				str = prt.searchElementValue(ndl.item(Ag3I0), "date");
				f.setDate(str);
				str = prt.searchElementValue(ndl.item(Ag3I0), "daycode");
				f.setDaycode(Integer.parseInt(str.trim()));
				str = prt.searchElementValue(ndl.item(Ag3I0), "nightcode");
				f.setNightcode(Integer.parseInt(str.trim()));
				str = prt.searchElementValue(ndl.item(Ag3I0), "maxtemp");
				f.setDaytemp(Integer.parseInt(str.trim()));
				str = prt.searchElementValue(ndl.item(Ag3I0), "mintemp");
				f.setNighttemp(Integer.parseInt(str.trim()));
				str = prt.searchElementValue(ndl.item(Ag3I0), "winddirectionday");
				f.setDaywinddir(str);
				str = prt.searchElementValue(ndl.item(Ag3I0), "windspeedday");
				f.setDaywindspeed(Integer.parseInt(str.trim()));
				str = prt.searchElementValue(ndl.item(Ag3I0), "winddirectionnight");
				f.setNightwinddir(str);
				str = prt.searchElementValue(ndl.item(Ag3I0), "windspeednight");
				f.setNightwindspeed(Integer.parseInt(str.trim()));
				forecastlist.addElement(f);
				Ag3I0++;
			}
		} catch (MalformedURLException e) {
			System.err.println(MALFORMED_URL_MSG + u);
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
		} catch (NumberFormatException e) {
			System.err.println(FILE_CORRUPT_MSG + u);
			System.err.println("-" + str + "-");
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.err.println(COULD_NOT_CLOSE_FILE_MSG + u);
					e.printStackTrace();
				}
			}
		}
	}

}