class n11449915 {
	public TtsTrackImpl(URL OqGWSxHY, String YHT0m2Jd, VoicesCache GXINsTsY) throws IOException {
        this.voiceCache = GXINsTsY;
        isReady = false;
        URLConnection QDcz9888 = OqGWSxHY.openConnection();
        frameSize = (int) (period * format.getChannels() * format.getSampleSizeInBits() * format.getSampleRate() / 8000);
        voice = voiceCache.allocateVoice(YHT0m2Jd);
        TTSAudioBuffer ZbYvLCyp = new TTSAudioBuffer();
        this.voice.setAudioPlayer(ZbYvLCyp);
        this.voice.speak(QDcz9888.getInputStream());
        ZbYvLCyp.flip();
    }

}