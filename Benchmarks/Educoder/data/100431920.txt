    protected boolean checkLink(URL url) {
        try {
            URLConnection connection = url.openConnection();
            connection.connect();
            return true;
        } catch (IOException e) {
            MsgLog.error("DapParser.checkLink(): IOException: " + e.toString());
            return false;
        }
    }
