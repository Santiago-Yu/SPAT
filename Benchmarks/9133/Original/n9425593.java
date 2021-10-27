class n9425593{
    public ContentPackage resolveItem() {
        URL url;
        try {
            url = new URL(itembankURL + "/" + deposit.get("http://www.caret.cam.ac.uk/minibix/metadata/ticket"));
            return new ContentPackage(url.openStream());
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}