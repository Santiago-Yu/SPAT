class n20188734 {
	public String output(final ComponentParameter compParameter) {
		InputStream inputStream;
		try {
			final URL url = new URL("http://xml.weather.yahoo.com/forecastrss?p="
					+ getPagelet().getOptionProperty("_weather_code") + "&u=c");
			inputStream = url.openStream();
		} catch (final IOException e) {
			return e.getMessage();
		}
		final StringBuilder sb = new StringBuilder();
		new AbstractXmlDocument(inputStream) {

			@Override
			protected void init() throws Exception {
				final Element root = getRoot();
				final Namespace ns = root.getNamespaceForPrefix("yweather");
				final Element channel = root.element("channel");
				final String link = channel.elementText("link");
				final Element item = channel.element("item");
				Element ele = item.element(QName.get("condition", ns));
				if (ele == null) {
					sb.append("ERROR");
					return;
				}
				final String imgPath = getPagelet().getColumnBean().getPortalBean()
						.getCssResourceHomePath(compParameter) + "/images/yahoo/";
				String image;
				String text;
				Date date = new SimpleDateFormat(YahooWeatherUtils.RFC822_MASKS[1], Locale.US)
						.parse(ele.attributeValue("date"));
				final int temp = Integer.parseInt(ele.attributeValue("temp"));
				int code = Integer.valueOf(ele.attributeValue("code")).intValue();
				if (code == 3200) {
					text = YahooWeatherUtils.yahooTexts[YahooWeatherUtils.yahooTexts.length - 1];
					image = imgPath + "3200.gif";
				} else {
					text = YahooWeatherUtils.yahooTexts[code];
					image = imgPath + code + ".gif";
				}
				sb.append("<div style=\"line-height: normal;\"><a target=\"_blank\" href=\"").append(link)
						.append("\"><img src=\"");
				sb.append(image).append("\" /></a>");
				sb.append(YahooWeatherUtils.formatHour(date)).append(" - ");
				sb.append(text).append(" - ").append(temp).append("¡æ").append("<br>");
				final Iterator<?> it = item.elementIterator(QName.get("forecast", ns));
				while (it.hasNext()) {
					ele = (Element) it.next();
					date = new SimpleDateFormat("dd MMM yyyy", Locale.US).parse(ele.attributeValue("date"));
					final int low = Integer.parseInt(ele.attributeValue("low"));
					final int high = Integer.parseInt(ele.attributeValue("high"));
					code = Integer.valueOf(ele.attributeValue("code")).intValue();
					if (code == 3200) {
						text = YahooWeatherUtils.yahooTexts[YahooWeatherUtils.yahooTexts.length - 1];
						image = imgPath + "3200.gif";
					} else {
						text = YahooWeatherUtils.yahooTexts[code];
						image = imgPath + code + ".gif";
					}
					sb.append(YahooWeatherUtils.formatWeek(date)).append(" ( ");
					sb.append(text).append(". ");
					sb.append(low).append("¡æ~").append(high).append("¡æ");
					sb.append(" )<br>");
				}
				sb.append("</div>");
			}
		};
		return sb.toString();
	}

}