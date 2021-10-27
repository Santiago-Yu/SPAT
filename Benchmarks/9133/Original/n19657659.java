class n19657659{
    public Download(URL url, int segs) {
        this.url = url;
        Mediator.register(this);
        status = "Starting...";
        try {
            totalSize = url.openConnection().getContentLength();
            name = url.getPath().substring(url.getPath().lastIndexOf('/') + 1);
            if (name.isEmpty()) {
                name = "UNKNOWN";
            }
            tempFolder = new File(Configuration.PARTS_FOLDER, getName());
            tempFolder.mkdir();
        } catch (IOException ex) {
            Logger.post(Logger.Level.WARNING, "URL could not be opened: " + url);
        }
        dest = new File(System.getProperty("user.home") + File.separator + name);
        if (segs > totalSize) {
            segs = totalSize;
        }
        Properties props = new Properties();
        props.setProperty("url", getUrl().toString());
        props.setProperty("segments", String.valueOf(segs));
        try {
            props.storeToXML(new FileOutputStream(new File(getTempFolder(), "index.xml")), "Warning: Editing this file may compromise the integrity of the download");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        segments = new Segment[segs];
        for (int i = 0; i < segs; i++) {
            segments[i] = new Segment(this, i);
        }
        Thread thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
        status = "Downloading...";
        Mediator.post(new DownloadStatusChanged(this));
        Logger.post(Logger.Level.INFO, "Starting download: " + getName());
    }

}