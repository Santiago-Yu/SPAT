class n8594656{
    @Override
    public DownloadObject download() throws IOException {
        final HttpGet findLink = new HttpGet(url.toString());
        final HttpResponse response = this.client.execute(findLink);
        final String body = IOUtil.getString(response);
        LinkTag linkTag = null;
        try {
            linkTag = HtmlParserUtil.findLink(MegaUploadDownloader.DOWNLOAD_LINK_PATTERN, body);
        } catch (ParserException e) {
        }
        if (linkTag != null) {
            String link = linkTag.extractLink();
            final String filename = IOUtil.getBaseName(link).trim();
            link = link.replaceAll("&#[0-9]*;", "_");
            final URL url = new URL(link);
            final String newLink = link.replaceAll(Pattern.quote(IOUtil.getBaseName(url.getPath())), URLEncoder.encode(IOUtil.getBaseName(url.getPath()), "UTF-8"));
            final HttpGet download = new HttpGet(newLink);
            final HttpResponse downloadResponse = this.client.execute(download);
            final HttpEntity downloadEntity = downloadResponse.getEntity();
            final long filesize = downloadEntity.getContentLength();
            return createObject(downloadEntity.getContent(), filename, filesize);
        } else {
            throw new RuntimeException("No download link.");
        }
    }

}