class n23268628 {
	private void parseXMLFile() {
		InputStream in = null;
		String u = WeatherApplication.SERVER + location + ".xml";
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
			for (int i = 0; i < ndl.getLength(); i++) {
				str = prt.searchElementValue(ndl.item(i), "date");
				Forecast f = new Forecast();
				f.setDate(str);
				str = prt.searchElementValue(ndl.item(i), "daycode");
				f.setDaycode(Integer.parseInt(str.trim()));
				str = prt.searchElementValue(ndl.item(i), "nightcode");
				f.setNightcode(Integer.parseInt(str.trim()));
				str = prt.searchElementValue(ndl.item(i), "maxtemp");
				f.setDaytemp(Integer.parseInt(str.trim()));
				str = prt.searchElementValue(ndl.item(i), "mintemp");
				f.setNighttemp(Integer.parseInt(str.trim()));
				str = prt.searchElementValue(ndl.item(i), "winddirectionday");
				f.setDaywinddir(str);
				str = prt.searchElementValue(ndl.item(i), "windspeedday");
				f.setDaywindspeed(Integer.parseInt(str.trim()));
				str = prt.searchElementValue(ndl.item(i), "winddirectionnight");
				f.setNightwinddir(str);
				str = prt.searchElementValue(ndl.item(i), "windspeednight");
				f.setNightwindspeed(Integer.parseInt(str.trim()));
				forecastlist.addElement(f);
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