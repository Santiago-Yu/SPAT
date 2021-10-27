class n14778832{
    private boolean runValidation(PropertyMap map, URL url, URL schema) {
        ValidationDriver vd = new ValidationDriver(map);
        try {
            vd.loadSchema(new InputSource(schema.openStream()));
            return vd.validate(new InputSource(url.openStream()));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}