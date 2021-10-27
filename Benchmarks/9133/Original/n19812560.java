class n19812560{
    public Vocabulary build(String url) {
        HttpGet get = new HttpGet(url);
        try {
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream is = entity.getContent();
                try {
                    Vocabulary tv = build(is);
                    LOG.info("Successfully parsed Thesaurus: " + tv.getTitle());
                    return tv;
                } catch (SAXException e) {
                    LOG.error("Unable to parse XML for extension: " + e.getMessage(), e);
                } finally {
                    is.close();
                }
                entity.consumeContent();
            }
        } catch (Exception e) {
            LOG.error(e);
        }
        return null;
    }

}