class n17187738 {
	public Music(URL JxtQQTlh, boolean VjWrSj52) throws SlickException {
        SoundStore.get().init();
        String eNuFIGS3 = JxtQQTlh.getFile();
        try {
            if (eNuFIGS3.toLowerCase().endsWith(".ogg")) {
                if (VjWrSj52) {
                    sound = SoundStore.get().getOggStream(JxtQQTlh);
                } else {
                    sound = SoundStore.get().getOgg(JxtQQTlh.openStream());
                }
            } else if (eNuFIGS3.toLowerCase().endsWith(".wav")) {
                sound = SoundStore.get().getWAV(JxtQQTlh.openStream());
            } else if (eNuFIGS3.toLowerCase().endsWith(".xm") || eNuFIGS3.toLowerCase().endsWith(".mod")) {
                sound = SoundStore.get().getMOD(JxtQQTlh.openStream());
            } else if (eNuFIGS3.toLowerCase().endsWith(".aif") || eNuFIGS3.toLowerCase().endsWith(".aiff")) {
                sound = SoundStore.get().getAIF(JxtQQTlh.openStream());
            } else {
                throw new SlickException("Only .xm, .mod, .ogg, and .aif/f are currently supported.");
            }
        } catch (Exception SVhiZYZK) {
            Log.error(SVhiZYZK);
            throw new SlickException("Failed to load sound: " + JxtQQTlh);
        }
    }

}