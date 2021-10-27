    public static AudioInputStream getWavFromURL(String urlstr) {
        URL url;
        AudioInputStream ais = null;
        try {
            url = new URL(urlstr);
            URLConnection c = url.openConnection();
            c.connect();
            InputStream stream = c.getInputStream();
            ais = new AudioInputStream(stream, playFormat, AudioSystem.NOT_SPECIFIED);
            LOG.debug("[getWavFromURL]Getting audio from URL: {0}");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ais;
    }
