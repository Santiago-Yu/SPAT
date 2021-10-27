class n15674873{
    public static void uploadAsync(final String username, final String password, final String description, final String tags, final boolean addDateTags, final ArrayList<RecordedGeoPoint> recordedGeoPoints, final String pseudoFileName) {
        if (username == null || username.length() == 0) return;
        if (password == null || password.length() == 0) return;
        if (description == null || description.length() == 0) return;
        if (tags == null || tags.length() == 0) return;
        if (pseudoFileName == null || pseudoFileName.endsWith(".gpx")) return;
        new Thread(new Runnable() {

            public void run() {
                if (!Util.isSufficienDataForUpload(recordedGeoPoints)) return;
                final InputStream gpxInputStream = new ByteArrayInputStream(RecordedRouteGPXFormatter.create(recordedGeoPoints).getBytes());
                String tagsToUse = tags;
                if (addDateTags || tagsToUse == null) if (tagsToUse == null) tagsToUse = autoTagFormat.format(new GregorianCalendar().getTime()); else tagsToUse = tagsToUse + " " + autoTagFormat.format(new GregorianCalendar().getTime());
                try {
                    final String urlDesc = (description == null) ? DEFAULT_DESCRIPTION : description.replaceAll("\\.;&?,/", "_");
                    final String urlTags = (tagsToUse == null) ? DEFAULT_TAGS : tagsToUse.replaceAll("\\\\.;&?,/", "_");
                    final URL url = new URL("http://www.openstreetmap.org/api/" + API_VERSION + "/gpx/create");
                    final HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setConnectTimeout(15000);
                    con.setRequestMethod("POST");
                    con.setDoOutput(true);
                    con.addRequestProperty("Authorization", "Basic " + encodeBase64(username + ":" + password));
                    con.addRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
                    con.addRequestProperty("Connection", "close");
                    con.addRequestProperty("Expect", "");
                    con.connect();
                    DataOutputStream out = new DataOutputStream(new BufferedOutputStream(con.getOutputStream()));
                    writeContentDispositionFile(out, "file", gpxInputStream, pseudoFileName);
                    writeContentDisposition(out, "description", urlDesc);
                    writeContentDisposition(out, "tags", urlTags);
                    writeContentDisposition(out, "public", "1");
                    out.writeBytes("--" + BOUNDARY + "--" + LINE_END);
                    out.flush();
                    final int retCode = con.getResponseCode();
                    String retMsg = con.getResponseMessage();
                    if (retCode != 200) {
                        if (con.getHeaderField("Error") != null) retMsg += "\n" + con.getHeaderField("Error");
                        con.disconnect();
                        throw new RuntimeException(retCode + " " + retMsg);
                    }
                    out.close();
                    con.disconnect();
                } catch (Exception e) {
                }
            }
        }, "OSMUpload-Thread").start();
    }

}