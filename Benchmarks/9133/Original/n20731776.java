class n20731776{
    public void readDirectoryFrom(String urlString) throws Exception {
        URL url = new URL(urlString + DIR_INFO_FIENAME);
        PushbackInputStream in = new PushbackInputStream(new BufferedInputStream(url.openStream()));
        readDataFrom(in);
        TextToken t = TextToken.nextToken(in);
        while (t != null && t.isString()) {
            DirectoryInfoModel dir = addDirectory(new DirectoryInfo(t.getString()));
            dir.setUrl(urlString + t.getString() + '/');
            t = TextToken.nextToken(in);
        }
        in.close();
    }

}