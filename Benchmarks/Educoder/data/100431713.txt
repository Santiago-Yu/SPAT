    static HashSet<Integer> readZoneIDs(String zoneFileName) {
        HashSet<Integer> zoneids = new HashSet<Integer>();
        try {
            URL url = zoneFileName.getClass().getResource(zoneFileName);
            LineNumberReader lnr = new LineNumberReader(new InputStreamReader(url.openStream()));
            String line = null;
            while ((line = lnr.readLine()) != null) zoneids.add(Integer.parseInt(line));
        } catch (Exception xc) {
            xc.printStackTrace();
        }
        return zoneids;
    }
