class n20188734 {
	public String output(final ComponentParameter EenV0yjI) {
		InputStream Jjgv13mb;
		try {
			final URL iV0oeZwB = new URL("http://xml.weather.yahoo.com/forecastrss?p="
					+ getPagelet().getOptionProperty("_weather_code") + "&u=c");
			Jjgv13mb = iV0oeZwB.openStream();
		} catch (final IOException N1KQI2Ca) {
			return N1KQI2Ca.getMessage();
		}
		final StringBuilder ML0LPgWC = new StringBuilder();
		new AbstractXmlDocument(Jjgv13mb) {

			@Override
			protected void init() throws Exception {
				final Element EoE0M7lC = getRoot();
				final Namespace mTFmLyU2 = EoE0M7lC.getNamespaceForPrefix("yweather");
				final Element xxEQL9RJ = EoE0M7lC.element("channel");
				final String vNym6hyJ = xxEQL9RJ.elementText("link");
				final Element mJhgyVoL = xxEQL9RJ.element("item");
				Element jmbpq876 = mJhgyVoL.element(QName.get("condition", mTFmLyU2));
				if (jmbpq876 == null) {
					ML0LPgWC.append("ERROR");
					return;
				}
				final String PJcXmOVY = getPagelet().getColumnBean().getPortalBean().getCssResourceHomePath(EenV0yjI)
						+ "/images/yahoo/";
				String JikHMpy8, t4LADamR;
				Date rUFOOleb = new SimpleDateFormat(YahooWeatherUtils.RFC822_MASKS[1], Locale.US)
						.parse(jmbpq876.attributeValue("date"));
				final int kdtz8cRE = Integer.parseInt(jmbpq876.attributeValue("temp"));
				int Gjr1vs0Q = Integer.valueOf(jmbpq876.attributeValue("code")).intValue();
				if (Gjr1vs0Q == 3200) {
					JikHMpy8 = YahooWeatherUtils.yahooTexts[YahooWeatherUtils.yahooTexts.length - 1];
					t4LADamR = PJcXmOVY + "3200.gif";
				} else {
					JikHMpy8 = YahooWeatherUtils.yahooTexts[Gjr1vs0Q];
					t4LADamR = PJcXmOVY + Gjr1vs0Q + ".gif";
				}
				ML0LPgWC.append("<div style=\"line-height: normal;\"><a target=\"_blank\" href=\"").append(vNym6hyJ)
						.append("\"><img src=\"");
				ML0LPgWC.append(t4LADamR).append("\" /></a>");
				ML0LPgWC.append(YahooWeatherUtils.formatHour(rUFOOleb)).append(" - ");
				ML0LPgWC.append(JikHMpy8).append(" - ").append(kdtz8cRE).append("¡æ").append("<br>");
				final Iterator<?> lEbn08HL = mJhgyVoL.elementIterator(QName.get("forecast", mTFmLyU2));
				while (lEbn08HL.hasNext()) {
					jmbpq876 = (Element) lEbn08HL.next();
					rUFOOleb = new SimpleDateFormat("dd MMM yyyy", Locale.US).parse(jmbpq876.attributeValue("date"));
					final int Pp6xEfsN = Integer.parseInt(jmbpq876.attributeValue("low"));
					final int dXhFeJ5F = Integer.parseInt(jmbpq876.attributeValue("high"));
					Gjr1vs0Q = Integer.valueOf(jmbpq876.attributeValue("code")).intValue();
					if (Gjr1vs0Q == 3200) {
						JikHMpy8 = YahooWeatherUtils.yahooTexts[YahooWeatherUtils.yahooTexts.length - 1];
						t4LADamR = PJcXmOVY + "3200.gif";
					} else {
						JikHMpy8 = YahooWeatherUtils.yahooTexts[Gjr1vs0Q];
						t4LADamR = PJcXmOVY + Gjr1vs0Q + ".gif";
					}
					ML0LPgWC.append(YahooWeatherUtils.formatWeek(rUFOOleb)).append(" ( ");
					ML0LPgWC.append(JikHMpy8).append(". ");
					ML0LPgWC.append(Pp6xEfsN).append("¡æ~").append(dXhFeJ5F).append("¡æ");
					ML0LPgWC.append(" )<br>");
				}
				ML0LPgWC.append("</div>");
			}
		};
		return ML0LPgWC.toString();
	}

}