class n14635922{
    public String contactService(String service, StringBuffer xmlRequest) throws Exception {
        Logger.debug(UPSConnections.class, "UPS CONNECTIONS ***** Started " + service + " " + new Date().toString() + " *****");
        HttpURLConnection connection;
        URL url;
        String response = "";
        try {
            Logger.debug(UPSConnections.class, "connect to " + protocol + "://" + hostname + "/" + URLPrefix + "/" + service);
            if (protocol.equalsIgnoreCase("https")) {
                java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                System.getProperties().put("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
                url = new URL(protocol + "://" + hostname + "/" + URLPrefix + "/" + service);
                connection = (HttpsURLConnection) url.openConnection();
            } else {
                url = new URL(protocol + "://" + hostname + "/" + URLPrefix + "/" + service);
                connection = (HttpURLConnection) url.openConnection();
            }
            Logger.debug(UPSConnections.class, "Establishing connection with " + url.toString());
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            OutputStream out = connection.getOutputStream();
            StringBuffer request = new StringBuffer();
            request.append(accessXMLRequest());
            request.append(xmlRequest);
            out.write((request.toString()).getBytes());
            Logger.debug(UPSConnections.class, "Transmission sent to " + url.toString() + ":\n" + xmlRequest);
            out.close();
            try {
                response = readURLConnection(connection);
            } catch (Exception e) {
                Logger.debug(UPSConnections.class, "Error in reading URL Connection" + e.getMessage());
                throw e;
            }
            Logger.debug(UPSConnections.class, "Response = " + response);
        } catch (Exception e1) {
            Logger.info(UPSConnections.class, "Error sending data to server" + e1.toString());
            Logger.debug(UPSConnections.class, "Error sending data to server" + e1.toString());
        } finally {
            Logger.info(UPSConnections.class, "****** Transmission Finished " + service + " " + new Date().toString() + " *********");
            Logger.debug(UPSConnections.class, "****** Transmission Finished " + service + " " + new Date().toString() + " *********");
        }
        return response;
    }

}