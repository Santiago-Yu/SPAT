class n7237429{
    public void readContents() throws IOException {
        fireProgressEvent(new ProgressEvent(this, ProgressEvent.PROGRESS_START, 0.0f, "loading file"));
        URLConnection conn = url.openConnection();
        conn.connect();
        filesize = conn.getContentLength();
        logger.finest("filesize: " + filesize);
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        readFirstLine(in);
        readHeaderLines(in);
        readData(in);
        fireProgressEvent(new ProgressEvent(this, ProgressEvent.PROGRESS_FINISH, 1.0f, "loading file"));
    }

}