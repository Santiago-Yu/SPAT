class n11449915{
    public TtsTrackImpl(URL url, String voiceName, VoicesCache vc) throws IOException {
        this.voiceCache = vc;
        isReady = false;
        URLConnection connection = url.openConnection();
        frameSize = (int) (period * format.getChannels() * format.getSampleSizeInBits() * format.getSampleRate() / 8000);
        voice = voiceCache.allocateVoice(voiceName);
        TTSAudioBuffer audioBuffer = new TTSAudioBuffer();
        this.voice.setAudioPlayer(audioBuffer);
        this.voice.speak(connection.getInputStream());
        audioBuffer.flip();
    }

}