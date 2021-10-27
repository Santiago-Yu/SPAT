class n9547229{
            public void run() {
                String masterUrl = "http://localhost:" + masterJetty.getLocalPort() + "/solr/replication?command=" + ReplicationHandler.CMD_DETAILS;
                URL url;
                InputStream stream = null;
                try {
                    url = new URL(masterUrl);
                    stream = url.openStream();
                    response = IOUtils.toString(stream);
                    if (response.contains("<str name=\"status\">success</str>")) {
                        success = true;
                    }
                    stream.close();
                } catch (Exception e) {
                    fail = e.getMessage();
                } finally {
                    IOUtils.closeQuietly(stream);
                }
            }

}