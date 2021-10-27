class n1858117{
    public void putChunk(String chunk) throws JacsonException {
        try {
            URL url = new URL(chunk);
            InputStream is = url.openStream();
            if (inverse) drain.putChunk(chunk);
            is.close();
        } catch (IOException broken) {
            if (!inverse) drain.putChunk(chunk);
        }
    }

}