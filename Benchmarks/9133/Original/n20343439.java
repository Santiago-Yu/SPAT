class n20343439{
        public void run() {
            URLConnection con = null;
            try {
                con = url.openConnection();
                if ("HTTPS".equalsIgnoreCase(url.getProtocol())) {
                    HttpsURLConnection scon = (HttpsURLConnection) con;
                    try {
                        scon.setSSLSocketFactory(SSLUtil.getSSLSocketFactory(clientCertAlias));
                        HostnameVerifier hv = SSLUtil.getHostnameVerifier(hostCertLevel);
                        if (hv != null) {
                            scon.setHostnameVerifier(hv);
                        }
                    } catch (GeneralSecurityException e) {
                        Debug.logError(e, module);
                    } catch (GenericConfigException e) {
                        Debug.logError(e, module);
                    }
                }
            } catch (IOException e) {
                Debug.logError(e, module);
            }
            synchronized (URLConnector.this) {
                if (timedOut && con != null) {
                    close(con);
                } else {
                    connection = con;
                    URLConnector.this.notify();
                }
            }
        }

}