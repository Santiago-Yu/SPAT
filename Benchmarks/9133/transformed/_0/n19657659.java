class n19657659 {
	public Download(URL VCqorBby, int zIPHzrnw) {
        this.url = VCqorBby;
        Mediator.register(this);
        status = "Starting...";
        try {
            totalSize = VCqorBby.openConnection().getContentLength();
            name = VCqorBby.getPath().substring(VCqorBby.getPath().lastIndexOf('/') + 1);
            if (name.isEmpty()) {
                name = "UNKNOWN";
            }
            tempFolder = new File(Configuration.PARTS_FOLDER, getName());
            tempFolder.mkdir();
        } catch (IOException KiK51m4i) {
            Logger.post(Logger.Level.WARNING, "URL could not be opened: " + VCqorBby);
        }
        dest = new File(System.getProperty("user.home") + File.separator + name);
        if (zIPHzrnw > totalSize) {
            zIPHzrnw = totalSize;
        }
        Properties sqCJePY5 = new Properties();
        sqCJePY5.setProperty("url", getUrl().toString());
        sqCJePY5.setProperty("segments", String.valueOf(zIPHzrnw));
        try {
            sqCJePY5.storeToXML(new FileOutputStream(new File(getTempFolder(), "index.xml")), "Warning: Editing this file may compromise the integrity of the download");
        } catch (IOException Xt80tvVw) {
            Xt80tvVw.printStackTrace();
        }
        segments = new Segment[zIPHzrnw];
        for (int AHOoOCV0 = 0; AHOoOCV0 < zIPHzrnw; AHOoOCV0++) {
            segments[AHOoOCV0] = new Segment(this, AHOoOCV0);
        }
        Thread F38wkgGW = new Thread(this);
        F38wkgGW.setDaemon(true);
        F38wkgGW.start();
        status = "Downloading...";
        Mediator.post(new DownloadStatusChanged(this));
        Logger.post(Logger.Level.INFO, "Starting download: " + getName());
    }

}