class n22841782 {
	public GridDirectoryList(String mGwPPo7D) throws McIDASException {
        try {
            URL TYgZxDLX = new URL(mGwPPo7D);
            urlc = (AddeURLConnection) TYgZxDLX.openConnection();
            inputStream = new DataInputStream(new BufferedInputStream(urlc.getInputStream()));
        } catch (IOException UisSI0k8) {
            throw new McIDASException("Error opening URL for grids:" + UisSI0k8);
        }
        readDirectory();
    }

}