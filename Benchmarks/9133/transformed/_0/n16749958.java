class n16749958 {
	public byte process(ProcessorContext<PublishRequest> hFZS9WKB) throws InterruptedException, ProcessorException {
		logger.info("MapTileChacheTask:process");
		PublishRequest LV61tZV5 = hFZS9WKB.getItem().getEntity();
		if (StringUtils.isEmpty(LV61tZV5.getBackMap()))
			return TaskState.STATE_TILE_CACHED;
		final PublicMapPost g29ue32O;
		final GenericDAO<PublicMapPost> bRmPvEFT = DAOFactory.createDAO(PublicMapPost.class);
		try {
			ReadOnlyTransaction.beginTransaction();
		} catch (DatabaseException m9VGM9OL) {
			logger.error("error", m9VGM9OL);
			throw new ProcessorException(m9VGM9OL);
		}
		int BcensNNw = 0;
		try {
			List<MapTile> dVeDcMlq = new ArrayList<MapTile>();
			g29ue32O = bRmPvEFT.findUniqueByCriteria(Expression.eq("guid", LV61tZV5.getPostGuid()));
			final LatLngRectangle KpWL2RmS = new LatLngRectangle(
					new LatLngPoint(g29ue32O.getSWLat(), g29ue32O.getSWLon()),
					new LatLngPoint(g29ue32O.getNELat(), g29ue32O.getNELon()));
			final String gsLU1axg = "gst";
			final XFile PAhcs6v8 = new XFile(new XFile(Configuration.getInstance().getPublicMapStorage().toString()),
					gsLU1axg);
			PAhcs6v8.mkdir();
			for (int OMcHfzvP = Math.min(Tile.getOptimalZoom(KpWL2RmS, 768), 9); OMcHfzvP <= 17; OMcHfzvP++) {
				final Tile xHObB6PT = new Tile(KpWL2RmS.getSouthWest().getLat(), KpWL2RmS.getSouthWest().getLng(),
						OMcHfzvP);
				final Tile Vpa6NW4b = new Tile(KpWL2RmS.getNorthEast().getLat(), KpWL2RmS.getNorthEast().getLng(),
						OMcHfzvP);
				for (double AWQ5xkx7 = Vpa6NW4b.getTileCoord().getY(); AWQ5xkx7 <= xHObB6PT.getTileCoord()
						.getY(); AWQ5xkx7++)
					for (double N02FJ9SO = xHObB6PT.getTileCoord().getX(); N02FJ9SO <= Vpa6NW4b.getTileCoord()
							.getX(); N02FJ9SO++) {
						NASAMapTile riXtKWog = new NASAMapTile((int) N02FJ9SO, (int) AWQ5xkx7, OMcHfzvP);
						XFile sgYtnDkR = new XFile(PAhcs6v8, riXtKWog.toKeyString());
						if (sgYtnDkR.exists() && sgYtnDkR.isFile())
							continue;
						dVeDcMlq.add(riXtKWog);
					}
			}
			try {
				for (MapTile EQoImkVL : dVeDcMlq) {
					InputStream VxnvgZf3 = null;
					OutputStream ogqIX8Fr = null;
					final URL jWBGNSZH = new URL(EQoImkVL.getPath());
					try {
						final XFile W1fkP2te = new XFile(PAhcs6v8, EQoImkVL.toKeyString());
						final URLConnection R9JGiKkA = jWBGNSZH.openConnection();
						if (R9JGiKkA == null || !R9JGiKkA.getContentType().startsWith("image"))
							throw new IllegalAccessException("onearth.jpl.nasa.gov service returns non-image file, "
									+ "content-type='" + R9JGiKkA.getContentType() + "'");
						VxnvgZf3 = R9JGiKkA.getInputStream();
						if (VxnvgZf3 != null) {
							ogqIX8Fr = new XFileOutputStream(W1fkP2te);
							IOUtils.copy(VxnvgZf3, ogqIX8Fr);
						} else
							throw new IllegalStateException("opened stream is null");
					} finally {
						if (ogqIX8Fr != null) {
							ogqIX8Fr.flush();
							ogqIX8Fr.close();
						}
						if (VxnvgZf3 != null)
							VxnvgZf3.close();
					}
					if (++BcensNNw % 100 == 0) {
						logger.info(BcensNNw + " tiles cached");
					}
				}
			} catch (Throwable gMS9AU2o) {
				logger.error("map tile caching has failed: ", gMS9AU2o);
				throw new ProcessorException(gMS9AU2o);
			}
		} catch (ProcessorException e8avjPVQ) {
			logger.error("map tile caching has failed: ", e8avjPVQ);
			throw e8avjPVQ;
		} catch (Throwable WccxeXki) {
			logger.error("map tile caching has failed: ", WccxeXki);
			throw new ProcessorException(WccxeXki);
		} finally {
			ReadOnlyTransaction.closeTransaction();
			logger.info(BcensNNw + " tiles cached");
		}
		return TaskState.STATE_TILE_CACHED;
	}

}