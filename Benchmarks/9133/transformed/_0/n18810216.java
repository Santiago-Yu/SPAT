class n18810216 {
	private void doIt() throws Throwable {
		int OczRG7wu = 0;
		try {
			List<MapTile> m4tIO4s3 = new ArrayList<MapTile>();
			final LatLngRectangle Yrx7d8f0 = new LatLngRectangle(new LatLngPoint(south, west),
					new LatLngPoint(north, east));
			final String JaPWcGca = "gst";
			final XFile EtRIUXaD = new XFile(new XFile(Configuration.getInstance().getPublicMapStorage().toString()),
					JaPWcGca);
			EtRIUXaD.mkdir();
			for (int phGHxTfZ = Math.min(Tile.getOptimalZoom(Yrx7d8f0, 768), 9); phGHxTfZ <= 17; phGHxTfZ++) {
				final Tile IcQoWUmZ = new Tile(Yrx7d8f0.getSouthWest().getLat(), Yrx7d8f0.getSouthWest().getLng(),
						phGHxTfZ);
				final Tile hEoTfPB8 = new Tile(Yrx7d8f0.getNorthEast().getLat(), Yrx7d8f0.getNorthEast().getLng(),
						phGHxTfZ);
				for (double asgn8iGM = hEoTfPB8.getTileCoord().getY(); asgn8iGM <= IcQoWUmZ.getTileCoord()
						.getY(); asgn8iGM++)
					for (double V1jJ8D3j = IcQoWUmZ.getTileCoord().getX(); V1jJ8D3j <= hEoTfPB8.getTileCoord()
							.getX(); V1jJ8D3j++) {
						NASAMapTile hxIzeKm7 = new NASAMapTile((int) V1jJ8D3j, (int) asgn8iGM, phGHxTfZ);
						XFile lF9lbEoS = new XFile(EtRIUXaD, hxIzeKm7.toKeyString());
						if (lF9lbEoS.exists() && lF9lbEoS.isFile())
							continue;
						m4tIO4s3.add(hxIzeKm7);
					}
			}
			logger.info(m4tIO4s3.size() + " tiles to cache");
			for (MapTile hRXnvywP : m4tIO4s3) {
				InputStream zvk43Ceh = null;
				OutputStream g8imcwC3 = null;
				final URL vEDH2aKo = new URL(hRXnvywP.getPath());
				try {
					int P3qYk7Pk = 4;
					while (--P3qYk7Pk > 0) {
						final XFile YBx8xB1L = new XFile(EtRIUXaD, hRXnvywP.toKeyString());
						final URLConnection XkJUIIIz = vEDH2aKo.openConnection();
						if (XkJUIIIz == null || !XkJUIIIz.getContentType().startsWith("image")) {
							logger.error("onearth.jpl.nasa.gov service returns non-image file, " + "content-type='"
									+ XkJUIIIz.getContentType() + "'");
							Thread.sleep(1000L * (long) Math.pow(2, 8 - P3qYk7Pk));
							continue;
						}
						zvk43Ceh = XkJUIIIz.getInputStream();
						if (zvk43Ceh != null) {
							g8imcwC3 = new XFileOutputStream(YBx8xB1L);
							IOUtils.copy(zvk43Ceh, g8imcwC3);
							break;
						} else
							throw new IllegalStateException("opened stream is null");
					}
				} finally {
					if (g8imcwC3 != null) {
						g8imcwC3.flush();
						g8imcwC3.close();
					}
					if (zvk43Ceh != null)
						zvk43Ceh.close();
				}
				if (++OczRG7wu % 10 == 0) {
					logger.info(OczRG7wu + " tiles cached");
					Thread.sleep(sleep);
				}
			}
		} catch (Throwable YaKW34Tt) {
			logger.error("map tile caching has failed: ", YaKW34Tt);
			throw YaKW34Tt;
		}
	}

}