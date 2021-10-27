class n16223923{
    public AudioInputStream getAudioInputStream(URL url) throws UnsupportedAudioFileException, IOException {
        InputStream urlStream = url.openStream();
        AudioFileFormat fileFormat = null;
        try {
            fileFormat = getFMT(urlStream, false);
        } finally {
            if (fileFormat == null) {
                urlStream.close();
            }
        }
        return new AudioInputStream(urlStream, fileFormat.getFormat(), fileFormat.getFrameLength());
    }

}