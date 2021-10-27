class n16604588{
    public static AudioFileFormat getAudioFileFormat(URL url) throws UnsupportedAudioFileException, IOException {
        InputStream inputStream = null;
        if (useragent != null) {
            URLConnection myCon = url.openConnection();
            myCon.setUseCaches(false);
            myCon.setDoInput(true);
            myCon.setDoOutput(true);
            myCon.setAllowUserInteraction(false);
            myCon.setRequestProperty("User-Agent", useragent);
            myCon.setRequestProperty("Accept", "*/*");
            myCon.setRequestProperty("Icy-Metadata", "1");
            myCon.setRequestProperty("Connection", "close");
            inputStream = new BufferedInputStream(myCon.getInputStream());
        } else {
            inputStream = new BufferedInputStream(url.openStream());
        }
        try {
            if (DEBUG == true) {
                System.err.println("Using AppletMpegSPIWorkaround to get codec (AudioFileFormat:url)");
            }
            return getAudioFileFormatForUrl(inputStream);
        } finally {
            inputStream.close();
        }
    }

}