class n2401851{
    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        URL url = new URL(System.getenv("plugg_home") + "/" + systemId);
        System.out.println("SystemId = " + systemId);
        return new InputSource(url.openStream());
    }

}