class n10450245{
    public Map<String, String> getMetadata(WebFileObject fo) throws IOException {
        if (!fo.wfs.getRootURL().getProtocol().equals("ftp")) {
            String realName = fo.pathname;
            boolean exists;
            URL ur = new URL(fo.wfs.getRootURL(), realName);
            HttpURLConnection connect = (HttpURLConnection) ur.openConnection();
            connect.setRequestMethod("HEAD");
            HttpURLConnection.setFollowRedirects(false);
            connect.connect();
            HttpURLConnection.setFollowRedirects(true);
            if (connect.getResponseCode() == 303) {
                String surl = connect.getHeaderField("Location");
                if (surl.startsWith(fo.wfs.root.toString())) {
                    realName = surl.substring(fo.wfs.root.toString().length());
                }
                connect.disconnect();
                ur = new URL(fo.wfs.getRootURL(), realName);
                connect = (HttpURLConnection) ur.openConnection();
                connect.setRequestMethod("HEAD");
                connect.connect();
            }
            exists = connect.getResponseCode() != 404;
            Map<String, String> result = new HashMap<String, String>();
            Map<String, List<String>> fields = connect.getHeaderFields();
            for (Entry<String, List<String>> e : fields.entrySet()) {
                String key = e.getKey();
                List<String> value = e.getValue();
                result.put(key, value.get(0));
            }
            result.put(META_EXIST, String.valueOf(exists));
            connect.disconnect();
            return result;
        } else {
            Map<String, String> result = new HashMap<String, String>();
            URL url = new URL(fo.wfs.getRootURL(), fo.pathname);
            URLConnection urlc = url.openConnection();
            try {
                urlc.connect();
                urlc.getInputStream().close();
                result.put(META_EXIST, "true");
            } catch (IOException ex) {
                result.put(META_EXIST, "false");
            }
            return result;
        }
    }

}