class n8055627{
    void setURLObject(URL url, boolean forceLoad) {
        if (url != null) {
            if (urlString != null || inputStream != null) throw new IllegalArgumentException(Ding3dI18N.getString("MediaContainer5"));
            try {
                InputStream stream;
                stream = url.openStream();
                stream.close();
            } catch (Exception e) {
                throw new SoundException(javax.media.ding3d.Ding3dI18N.getString("MediaContainer0"));
            }
        }
        this.url = url;
        if (forceLoad) dispatchMessage();
    }

}