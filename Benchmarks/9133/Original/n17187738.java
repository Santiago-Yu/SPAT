class n17187738{
    public Music(URL url, boolean streamingHint) throws SlickException {
        SoundStore.get().init();
        String ref = url.getFile();
        try {
            if (ref.toLowerCase().endsWith(".ogg")) {
                if (streamingHint) {
                    sound = SoundStore.get().getOggStream(url);
                } else {
                    sound = SoundStore.get().getOgg(url.openStream());
                }
            } else if (ref.toLowerCase().endsWith(".wav")) {
                sound = SoundStore.get().getWAV(url.openStream());
            } else if (ref.toLowerCase().endsWith(".xm") || ref.toLowerCase().endsWith(".mod")) {
                sound = SoundStore.get().getMOD(url.openStream());
            } else if (ref.toLowerCase().endsWith(".aif") || ref.toLowerCase().endsWith(".aiff")) {
                sound = SoundStore.get().getAIF(url.openStream());
            } else {
                throw new SlickException("Only .xm, .mod, .ogg, and .aif/f are currently supported.");
            }
        } catch (Exception e) {
            Log.error(e);
            throw new SlickException("Failed to load sound: " + url);
        }
    }

}