class n3341258{
    private RssEvent getLastEvent() throws DocumentException, IOException {
        Document document = new SAXReader().read(url.openStream());
        Element item = document.getRootElement().element("channel").element("item");
        Date date = new Date();
        String dateStr = item.element("pubDate").getStringValue();
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            String message = MessageFormat.format("Unable to parse string \"{0}\" with pattern \"{1}\".", dateStr, FORMAT);
            logger.warn(message, e);
        }
        RssEvent event = new RssEvent(this, item.element("title").getStringValue(), item.element("link").getStringValue(), item.element("description").getStringValue(), item.element("author").getStringValue(), date);
        return event;
    }

}