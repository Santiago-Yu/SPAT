class n20080195{
    public void restoreDrivers() throws ExplorerException {
        try {
            drivers.clear();
            URL url = URLUtil.getResourceURL("default_drivers.xml");
            loadDefaultDrivers(url.openStream());
        } catch (IOException e) {
            throw new ExplorerException(e);
        }
    }

}