class n15017482{
    private static String getSuitableWCSVersion(String host, String _version) throws ConnectException, IOException {
        String request = WCSProtocolHandler.buildCapabilitiesSuitableVersionRequest(host, _version);
        String version = new String();
        StringReader reader = null;
        DataInputStream dis = null;
        try {
            URL url = new URL(request);
            byte[] buffer = new byte[1024];
            dis = new DataInputStream(url.openStream());
            dis.readFully(buffer);
            reader = new StringReader(new String(buffer));
            KXmlParser kxmlParser = null;
            kxmlParser = new KXmlParser();
            kxmlParser.setInput(reader);
            kxmlParser.nextTag();
            if (kxmlParser.getEventType() != KXmlParser.END_DOCUMENT) {
                if ((kxmlParser.getName().compareTo(CapabilitiesTags.WCS_CAPABILITIES_ROOT1_0_0) == 0)) {
                    version = kxmlParser.getAttributeValue("", CapabilitiesTags.VERSION);
                }
            }
            reader.close();
            dis.close();
            return version;
        } catch (ConnectException conEx) {
            throw new ConnectException(conEx.getMessage());
        } catch (IOException ioEx) {
            throw new IOException(ioEx.getMessage());
        } catch (XmlPullParserException xmlEx) {
            xmlEx.printStackTrace();
            return "";
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (dis != null) {
                try {
                    dis.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}