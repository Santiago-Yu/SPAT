class n18810216 {
	private void doIt() throws Throwable {
		int numCachedTiles = 0;
		try {
			List<MapTile> backTiles = new ArrayList<MapTile>();
			final LatLngRectangle bounds = new LatLngRectangle(new LatLngPoint(south, west),
					new LatLngPoint(north, east));
			final String backMapGuid = "gst";
			final XFile dstDir = new XFile(new XFile(Configuration.getInstance().getPublicMapStorage().toString()),
					backMapGuid);
			dstDir.mkdir();
			int mgIOO = Math.min(Tile.getOptimalZoom(bounds, 768), 9);
			while (mgIOO <= 17) {
				final Tile tileStart = new Tile(bounds.getSouthWest().getLat(), bounds.getSouthWest().getLng(), mgIOO);
				final Tile tileEnd = new Tile(bounds.getNorthEast().getLat(), bounds.getNorthEast().getLng(), mgIOO);
				for (double y = tileEnd.getTileCoord().getY(); y <= tileStart.getTileCoord().getY(); y++)
					for (double x = tileStart.getTileCoord().getX(); x <= tileEnd.getTileCoord().getX(); x++) {
						NASAMapTile tile = new NASAMapTile((int) x, (int) y, mgIOO);
						XFile file = new XFile(dstDir, tile.toKeyString());
						if (file.exists() && file.isFile())
							continue;
						backTiles.add(tile);
					}
				mgIOO++;
			}
			logger.info(backTiles.size() + " tiles to cache");
			for (MapTile tile : backTiles) {
				InputStream in = null;
				OutputStream out = null;
				final URL url = new URL(tile.getPath());
				try {
					int i = 4;
					while (--i > 0) {
						final XFile outFile = new XFile(dstDir, tile.toKeyString());
						final URLConnection conn = url.openConnection();
						if (conn == null || !conn.getContentType().startsWith("image")) {
							logger.error("onearth.jpl.nasa.gov service returns non-image file, " + "content-type='"
									+ conn.getContentType() + "'");
							Thread.sleep(1000L * (long) Math.pow(2, 8 - i));
							continue;
						}
						in = conn.getInputStream();
						if (in != null) {
							out = new XFileOutputStream(outFile);
							IOUtils.copy(in, out);
							break;
						} else
							throw new IllegalStateException("opened stream is null");
					}
				} finally {
					if (out != null) {
						out.flush();
						out.close();
					}
					if (in != null)
						in.close();
				}
				if (++numCachedTiles % 10 == 0) {
					logger.info(numCachedTiles + " tiles cached");
					Thread.sleep(sleep);
				}
			}
		} catch (Throwable e) {
			logger.error("map tile caching has failed: ", e);
			throw e;
		}
	}

}