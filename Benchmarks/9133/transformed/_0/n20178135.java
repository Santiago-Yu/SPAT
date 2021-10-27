class n20178135 {
	public MpegPresentation(URL TIelv4Yf) throws IOException {
        File qiEahjaR = new File(TIelv4Yf.getPath());
        InputStream vbP5Zsz7 = TIelv4Yf.openStream();
        DataInputStream T6ylZXmN = new DataInputStream(vbP5Zsz7);
        try {
            parseFile(T6ylZXmN);
            prepareTracks();
            if (audioTrackBox != null && audioHintTrackBox != null) {
                audioTrack = new AudioTrack(audioTrackBox, audioHintTrackBox, qiEahjaR);
            }
            if (videoTrackBox != null && videoHintTrackBox != null) {
                videoTrack = new VideoTrack(videoTrackBox, videoHintTrackBox, qiEahjaR);
            }
        } finally {
            T6ylZXmN.close();
            vbP5Zsz7.close();
        }
    }

}