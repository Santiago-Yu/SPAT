class n6918042{
    public void updateMetaList() {
        metaserverModel.begin();
        serverCache.expire(EXPIRE_INTERVAL * 1000);
        final Map<String, MetaserverEntry> oldEntries = serverCache.getAll();
        final MetaserverEntry localhostMetaserverEntry = MetaserverEntryParser.parseEntry(ServerCache.DEFAULT_ENTRY_LOCALHOST);
        assert localhostMetaserverEntry != null;
        metaserverModel.add(localhostMetaserverEntry);
        oldEntries.remove(ServerCache.makeKey(localhostMetaserverEntry));
        serverCache.put(localhostMetaserverEntry);
        try {
            final URL url = new URL(METASERVER_URL);
            final String httpProxy = System.getenv("http_proxy");
            if (httpProxy != null && httpProxy.length() > 0) {
                if (httpProxy.regionMatches(true, 0, "http://", 0, 7)) {
                    final String[] tmp = httpProxy.substring(7).replaceAll("/.*", "").split(":", 2);
                    System.setProperty("http.proxyHost", tmp[0]);
                    System.setProperty("http.proxyPort", tmp.length >= 2 ? tmp[1] : "80");
                } else {
                    System.err.println("Warning: unsupported http_proxy protocol: " + httpProxy);
                }
            }
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            try {
                conn.setRequestMethod("GET");
                conn.setUseCaches(false);
                conn.connect();
                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    final InputStream in = conn.getInputStream();
                    final InputStreamReader isr = new InputStreamReader(in, "ISO-8859-1");
                    try {
                        final BufferedReader br = new BufferedReader(isr);
                        try {
                            final MetaserverEntryParser metaserverEntryParser = new MetaserverEntryParser();
                            while (true) {
                                final String line = br.readLine();
                                if (line == null) {
                                    break;
                                }
                                final MetaserverEntry metaserverEntry = metaserverEntryParser.parseLine(line);
                                if (metaserverEntry != null) {
                                    metaserverModel.add(metaserverEntry);
                                    oldEntries.remove(ServerCache.makeKey(metaserverEntry));
                                    serverCache.put(metaserverEntry);
                                }
                            }
                        } finally {
                            br.close();
                        }
                    } finally {
                        isr.close();
                    }
                }
            } finally {
                conn.disconnect();
            }
        } catch (final IOException ignored) {
        }
        for (final MetaserverEntry metaserverEntry : oldEntries.values()) {
            metaserverModel.add(metaserverEntry);
        }
        metaserverModel.commit();
        serverCache.save();
    }

}