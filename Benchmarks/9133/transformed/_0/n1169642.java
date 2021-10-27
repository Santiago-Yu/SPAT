class n1169642 {
	@Override
	public void run() {
		String n6jKYz6B = getKey();
		synchronized (this.lauchedHTTPRequests) {
			if (this.lauchedHTTPRequests.contains(n6jKYz6B))
				return;
			this.lauchedHTTPRequests.add(n6jKYz6B);
		}
		String oHkQA3y7 = this.dataSource.getTileURL(this.x, this.y, this.z);
		URL UIbywDcA;
		try {
			UIbywDcA = new URL(oHkQA3y7);
		} catch (MalformedURLException hTEXIkOI) {
			logger.warning("Error in URL: " + oHkQA3y7);
			return;
		}
		String JjWKwlK6 = "";
		try {
			InputStream znAPG5en;
			if ("file".equals(UIbywDcA.getProtocol()))
				znAPG5en = new FileInputStream(UIbywDcA.getFile());
			else if ("http".equals(UIbywDcA.getProtocol()))
				znAPG5en = UIbywDcA.openStream();
			else {
				logger.warning("Impossible to load settings from " + UIbywDcA + ". Unsupported protocol "
						+ UIbywDcA.getProtocol());
				return;
			}
			BufferedReader A4lEUpfO = new BufferedReader(new InputStreamReader(znAPG5en));
			String QcYAprlv;
			while ((QcYAprlv = A4lEUpfO.readLine()) != null)
				JjWKwlK6 += QcYAprlv;
			A4lEUpfO.close();
		} catch (FileNotFoundException PT5llfMx) {
			return;
		} catch (IOException YeRkb6nW) {
			YeRkb6nW.printStackTrace();
			return;
		}
		VectorTile wVPzbTYP = new VectorTile(JjWKwlK6, x, y, z);
		Geometry[] Pt7TVBN0 = new Geometry[wVPzbTYP.getPieces().size()];
		int c2PsZzQG = 0;
		for (MfGeo JcYRiwzg : wVPzbTYP.getPieces()) {
			if (JcYRiwzg.getGeoType() == GeoType.GEOMETRY) {
				Pt7TVBN0[c2PsZzQG++] = ((MfGeometry) JcYRiwzg).getInternalGeometry();
			} else if (JcYRiwzg.getGeoType() == GeoType.FEATURE) {
				MfFeature PvfZ89vV = (MfFeature) JcYRiwzg;
				Pt7TVBN0[c2PsZzQG++] = PvfZ89vV.getMfGeometry().getInternalGeometry();
			}
		}
		GeometryCollection t8O4SbD0 = new GeometryFactory().createGeometryCollection(Pt7TVBN0);
		this.dataSource.getDataLoader()
				.add(new OpenCartoFeature(this.dataSource.getLayer(), new Rep(t8O4SbD0), this.z));
		this.dataSource.getLayer().getDisplayCacheLoader().coin();
		synchronized (this.lauchedHTTPRequests) {
			this.lauchedHTTPRequests.remove(n6jKYz6B);
		}
	}

}