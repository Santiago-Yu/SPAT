    public void sendTextFile(String filename) throws IOException {
        Checker.checkEmpty(filename, "filename");
        URL url = _getFile(filename);
        PrintWriter out = getWriter();
        Streams.copy(new InputStreamReader(url.openStream()), out);
        out.close();
    }
