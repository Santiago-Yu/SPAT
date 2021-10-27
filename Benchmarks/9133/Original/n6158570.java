class n6158570{
    public void download(String contentUuid, File path) throws WebServiceClientException {
        try {
            URL url = new URL(getPath("/download/" + contentUuid));
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            OutputStream output = new FileOutputStream(path);
            IoUtils.copyBytes(inputStream, output);
            IoUtils.close(inputStream);
            IoUtils.close(output);
        } catch (IOException ioex) {
            throw new WebServiceClientException("Could not download or saving content to path [" + path.getAbsolutePath() + "]", ioex);
        } catch (Exception ex) {
            throw new WebServiceClientException("Could not download content from web service.", ex);
        }
    }

}