class n22268799{
    @Override
    public void writeToContent(Object principal, String uniqueId, InputStream ins) throws IOException, ContentException {
        if (writable) {
            URL url = buildURL(uniqueId);
            URLConnection connection = url.openConnection();
            OutputStream outs = connection.getOutputStream();
            try {
                ContentUtil.pipe(ins, outs);
            } finally {
                try {
                    outs.close();
                } catch (Exception ex) {
                    log.log(Level.WARNING, "unable to close " + url, ex);
                }
            }
        } else {
            throw new ContentException("not writable");
        }
    }

}