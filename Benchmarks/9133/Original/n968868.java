class n968868{
    public Document getDocument(String urlString) {
        Document doc = null;
        URLConnection conn = null;
        InputStream in = null;
        try {
            SAXBuilder sxbuild = new SAXBuilder();
            if (Osmolt.debug) {
                outputInterface.printDebugMessage("ProcessOSM", "url: " + urlString);
                in = new FileInputStream(new File(System.getProperty("user.home") + "/data.osm"));
                outputInterface.processSetStatus("getting data from " + System.getProperty("user.home") + "/data.osm");
            } else {
                URL url = new URL(urlString);
                outputInterface.printDebugMessage("ProcessOSM", "url: " + urlString);
                outputInterface.processSetStatus("connecting Server");
                conn = url.openConnection();
                outputInterface.processSetStatus("loading Data");
                in = conn.getInputStream();
            }
            doc = sxbuild.build(in);
        } catch (java.net.UnknownHostException e) {
            outputInterface.printError("Unknown Host: " + urlString);
        } catch (java.net.SocketTimeoutException e) {
            outputInterface.printError("Timeout: Server does not response");
        } catch (java.net.ConnectException e) {
            outputInterface.printError("Error Server response: " + e.getMessage());
        } catch (java.net.SocketException e) {
            outputInterface.printError("Error Server response: " + e.getMessage());
        } catch (JDOMException e) {
            outputInterface.printError(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            outputInterface.printError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            outputInterface.printError(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioe) {
            }
        }
        return doc;
    }

}