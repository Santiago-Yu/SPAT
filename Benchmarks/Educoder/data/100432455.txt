    private String getResultFromHttpUrl(String href) {
        String result = null;
        try {
            URL url = new URL(href);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            Object o = conn.getContent();
            log.debug("Opened " + href + " and got class " + o.getClass().getName());
            StringBuffer version = new StringBuffer();
            String inputLine;
            DataInputStream dis = new DataInputStream(conn.getInputStream());
            while ((inputLine = dis.readLine()) != null) {
                version.append(inputLine + "\n");
            }
            result = version.toString();
            log.debug("Read from URL:\n" + result);
            dis.close();
        } catch (Exception e) {
            log.debug("Caught exception " + e + " whilst attempting to query URL " + href);
            e.printStackTrace();
        } finally {
            return result;
        }
    }
