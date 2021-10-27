class n16201403{
    public void loadSample(String uid, URL url) throws Exception {
        AudioInputStream input = AudioSystem.getAudioInputStream(url.openStream());
        Clip line = null;
        DataLine.Info info = new DataLine.Info(Clip.class, input.getFormat());
        if (!AudioSystem.isLineSupported(info)) {
            throw new javax.sound.sampled.UnsupportedAudioFileException(url.toExternalForm());
        }
        line = (Clip) AudioSystem.getLine(info);
        line.open(input);
        samples.put(uid, line);
    }

}