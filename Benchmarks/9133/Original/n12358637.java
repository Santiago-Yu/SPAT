class n12358637{
    public AudioInputStream getAudioInputStream(URL url) throws UnsupportedAudioFileException, IOException {
        InputStream inputStream = url.openStream();
        try {
            return getAudioInputStream(inputStream);
        } catch (UnsupportedAudioFileException e) {
            inputStream.close();
            throw e;
        } catch (IOException e) {
            inputStream.close();
            throw e;
        }
    }

}