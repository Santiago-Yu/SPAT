class n7490069{
    public void run() {
        if (isRunning) return;
        isRunning = true;
        Core core = Core.getInstance();
        URL url = null;
        InputStream input = null;
        DataInputStream datastream;
        try {
            url = new URL(Constants.UpdateCheckUrl);
        } catch (MalformedURLException e) {
            if (!firstRun) core.showMessage(1, core.getString("error"), core.getString("errorUpdateCheck"));
            isRunning = false;
            return;
        }
        try {
            input = url.openStream();
        } catch (IOException e) {
            if (!firstRun) core.showMessage(1, core.getString("error"), core.getString("errorUpdateCheck"));
            isRunning = false;
            return;
        }
        datastream = new DataInputStream(new BufferedInputStream(input));
        String line = null;
        try {
            line = datastream.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            if (!firstRun) core.showMessage(1, core.getString("error"), core.getString("errorUpdateCheck"));
            isRunning = false;
            return;
        }
        if (line == null) {
            if (!firstRun) core.showMessage(1, core.getString("error"), core.getString("errorUpdateCheck"));
            isRunning = false;
            return;
        }
        if (line.trim().equalsIgnoreCase(Constants.version)) {
            if (!firstRun) core.showMessage(0, core.getString("checkUpdateButton"), core.getString("versionMatch"));
        } else {
            core.showMessage(1, core.getString("checkUpdateButton"), core.getString("errorNewerVersion") + ": " + line);
        }
        isRunning = false;
    }

}