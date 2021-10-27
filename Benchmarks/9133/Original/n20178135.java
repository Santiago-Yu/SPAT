class n20178135{
    public MpegPresentation(URL url) throws IOException {
        File file = new File(url.getPath());
        InputStream input = url.openStream();
        DataInputStream ds = new DataInputStream(input);
        try {
            parseFile(ds);
            prepareTracks();
            if (audioTrackBox != null && audioHintTrackBox != null) {
                audioTrack = new AudioTrack(audioTrackBox, audioHintTrackBox, file);
            }
            if (videoTrackBox != null && videoHintTrackBox != null) {
                videoTrack = new VideoTrack(videoTrackBox, videoHintTrackBox, file);
            }
        } finally {
            ds.close();
            input.close();
        }
    }

}