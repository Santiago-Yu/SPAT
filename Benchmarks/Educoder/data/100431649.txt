    private static String getVersion() {
        debug.print("");
        String version = null;
        String version_url = "http://kmttg.googlecode.com/svn/trunk/version";
        try {
            URL url = new URL(version_url);
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) version = inputLine;
            in.close();
        } catch (Exception ex) {
            version = null;
        }
        return version;
    }
