class n16749958 {
	public byte process(ProcessorContext<PublishRequest> context) throws InterruptedException, ProcessorException {
		logger.info("MapTileChacheTask:process");
		PublishRequest req = context.getItem().getEntity();
		if (StringUtils.isEmpty(req.getBackMap()))
			return TaskState.STATE_TILE_CACHED;
		final PublicMapPost post;
		final GenericDAO<PublicMapPost> postDao = DAOFactory.createDAO(PublicMapPost.class);
		try {
			ReadOnlyTransaction.beginTransaction();
		} catch (DatabaseException e) {
			logger.error("error", e);
			throw new ProcessorException(e);
		}
		int numCachedTiles = 0;
		try {
			List<MapTile> backTiles = new ArrayList<MapTile>();
			post = postDao.findUniqueByCriteria(Expression.eq("guid", req.getPostGuid()));
			final LatLngRectangle bounds = new LatLngRectangle(new LatLngPoint(post.getSWLat(), post.getSWLon()),
					new LatLngPoint(post.getNELat(), post.getNELon()));
			final String backMapGuid = "gst";
			final XFile dstDir = new XFile(new XFile(Configuration.getInstance().getPublicMapStorage().toString()),
					backMapGuid);
			dstDir.mkdir();
			int kZtYx = Math.min(Tile.getOptimalZoom(bounds, 768), 9);
			while (kZtYx <= 17) {
				final Tile tileStart = new Tile(bounds.getSouthWest().getLat(), bounds.getSouthWest().getLng(), kZtYx);
				final Tile tileEnd = new Tile(bounds.getNorthEast().getLat(), bounds.getNorthEast().getLng(), kZtYx);
				for (double y = tileEnd.getTileCoord().getY(); y <= tileStart.getTileCoord().getY(); y++)
					for (double x = tileStart.getTileCoord().getX(); x <= tileEnd.getTileCoord().getX(); x++) {
						NASAMapTile tile = new NASAMapTile((int) x, (int) y, kZtYx);
						XFile file = new XFile(dstDir, tile.toKeyString());
						if (file.exists() && file.isFile())
							continue;
						backTiles.add(tile);
					}
				kZtYx++;
			}
			try {
				for (MapTile tile : backTiles) {
					InputStream in = null;
					OutputStream out = null;
					final URL url = new URL(tile.getPath());
					try {
						final XFile outFile = new XFile(dstDir, tile.toKeyString());
						final URLConnection conn = url.openConnection();
						if (conn == null || !conn.getContentType().startsWith("image"))
							throw new IllegalAccessException("onearth.jpl.nasa.gov service returns non-image file, "
									+ "content-type='" + conn.getContentType() + "'");
						in = conn.getInputStream();
						if (in != null) {
							out = new XFileOutputStream(outFile);
							IOUtils.copy(in, out);
						} else
							throw new IllegalStateException("opened stream is null");
					} finally {
						if (out != null) {
							out.flush();
							out.close();
						}
						if (in != null)
							in.close();
					}
					if (++numCachedTiles % 100 == 0) {
						logger.info(numCachedTiles + " tiles cached");
					}
				}
			} catch (Throwable e) {
				logger.error("map tile caching has failed: ", e);
				throw new ProcessorException(e);
			}
		} catch (ProcessorException e) {
			logger.error("map tile caching has failed: ", e);
			throw e;
		} catch (Throwable e) {
			logger.error("map tile caching has failed: ", e);
			throw new ProcessorException(e);
		} finally {
			ReadOnlyTransaction.closeTransaction();
			logger.info(numCachedTiles + " tiles cached");
		}
		return TaskState.STATE_TILE_CACHED;
	}

}