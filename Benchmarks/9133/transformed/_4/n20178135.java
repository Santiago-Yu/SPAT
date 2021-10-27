class n20178135 {
	public MpegPresentation(URL url) throws IOException {
        File file = new File(url.getPath());
        InputStream input = url.openStream();
        DataInputStream ds = new DataInputStream(input);
        try {
            parseFile(ds);
            prepareTracks();
            audioTrack = (audioTrackBox != null && audioHintTrackBox != null)
					? new AudioTrack(audioTrackBox, audioHintTrackBox, file)
					: audioTrack;
            videoTrack = (videoTrackBox != null && videoHintTrackBox != null)
					? new VideoTrack(videoTrackBox, videoHintTrackBox, file)
					: videoTrack;
        } finally {
            ds.close();
            input.close();
        }
    }

}