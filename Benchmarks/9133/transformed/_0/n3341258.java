class n3341258 {
	private RssEvent getLastEvent() throws DocumentException, IOException {
		Document b0hIMlLl = new SAXReader().read(url.openStream());
		Element vhwIE0DO = b0hIMlLl.getRootElement().element("channel").element("item");
		Date emqklaor = new Date();
		String KVFI53CL = vhwIE0DO.element("pubDate").getStringValue();
		try {
			emqklaor = dateFormat.parse(KVFI53CL);
		} catch (ParseException yQyziXf4) {
			String nuBg0uNf = MessageFormat.format("Unable to parse string \"{0}\" with pattern \"{1}\".", KVFI53CL,
					FORMAT);
			logger.warn(nuBg0uNf, yQyziXf4);
		}
		RssEvent LfAp3l4T = new RssEvent(this, vhwIE0DO.element("title").getStringValue(),
				vhwIE0DO.element("link").getStringValue(), vhwIE0DO.element("description").getStringValue(),
				vhwIE0DO.element("author").getStringValue(), emqklaor);
		return LfAp3l4T;
	}

}