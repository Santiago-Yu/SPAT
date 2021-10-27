    @Override
    public void run() {
        String key = getKey();
        synchronized (this.lauchedHTTPRequests) {
            if (this.lauchedHTTPRequests.contains(key)) return;
            this.lauchedHTTPRequests.add(key);
        }
        String st = this.dataSource.getTileURL(this.x, this.y, this.z);
        URL url;
        try {
            url = new URL(st);
        } catch (MalformedURLException e1) {
            logger.warning("Error in URL: " + st);
            return;
        }
        String geoJSON = "";
        try {
            InputStream is;
            if ("file".equals(url.getProtocol())) is = new FileInputStream(url.getFile()); else if ("http".equals(url.getProtocol())) is = url.openStream(); else {
                logger.warning("Impossible to load settings from " + url + ". Unsupported protocol " + url.getProtocol());
                return;
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = in.readLine()) != null) geoJSON += line;
            in.close();
        } catch (FileNotFoundException e) {
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        VectorTile tile = new VectorTile(geoJSON, x, y, z);
        Geometry[] geoms = new Geometry[tile.getPieces().size()];
        int i = 0;
        for (MfGeo geo : tile.getPieces()) {
            if (geo.getGeoType() == GeoType.GEOMETRY) {
                geoms[i++] = ((MfGeometry) geo).getInternalGeometry();
            } else if (geo.getGeoType() == GeoType.FEATURE) {
                MfFeature mf = (MfFeature) geo;
                geoms[i++] = mf.getMfGeometry().getInternalGeometry();
            }
        }
        GeometryCollection gc = new GeometryFactory().createGeometryCollection(geoms);
        this.dataSource.getDataLoader().add(new OpenCartoFeature(this.dataSource.getLayer(), new Rep(gc), this.z));
        this.dataSource.getLayer().getDisplayCacheLoader().coin();
        synchronized (this.lauchedHTTPRequests) {
            this.lauchedHTTPRequests.remove(key);
        }
    }
