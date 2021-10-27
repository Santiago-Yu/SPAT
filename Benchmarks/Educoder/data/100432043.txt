    private boolean saveNodeMeta(NodeInfo info, int properties) {
        boolean rCode = false;
        String query = mServer + "save.php" + ("?id=" + info.getId());
        try {
            URL url = new URL(query);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            byte[] body = Helpers.EncodeString(Helpers.ASCII, createURLEncodedPropertyString(info, properties));
            conn.setAllowUserInteraction(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            setCredentials(conn);
            conn.setDoOutput(true);
            conn.getOutputStream().write(body);
            rCode = saveNode(info, conn);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.toString());
        }
        return rCode;
    }
