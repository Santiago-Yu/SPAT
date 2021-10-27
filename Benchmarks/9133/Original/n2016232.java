class n2016232{
    protected void initConnection() {
        connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Range", "bytes=" + downloadedSize + "-");
            prepareConnectionBeforeConnect();
            connection.connect();
        } catch (IOException e) {
            status = STATUS_ERROR;
            Logger.getRootLogger().error("problem in connection", e);
        }
    }

}