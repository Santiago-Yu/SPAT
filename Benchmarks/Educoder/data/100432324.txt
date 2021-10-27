    public static URL[] getDirectoryListing(URL url) throws IOException, CancelledOperationException {
        FileSystem.logger.log(Level.FINER, "listing {0}", url);
        String file = url.getFile();
        if (file.charAt(file.length() - 1) != '/') {
            url = new URL(url.toString() + '/');
        }
        String userInfo = KeyChain.getDefault().getUserInfo(url);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setAllowUserInteraction(false);
        urlConnection.setConnectTimeout(FileSystem.settings().getConnectTimeoutMs());
        if (userInfo != null) {
            String encode = Base64.encodeBytes(userInfo.getBytes());
            urlConnection.setRequestProperty("Authorization", "Basic " + encode);
        }
        InputStream urlStream;
        urlStream = urlConnection.getInputStream();
        return getDirectoryListing(url, urlStream);
    }
