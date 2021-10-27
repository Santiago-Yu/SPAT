class n12994590 {
	@HttpAction(name = "map.saveOrUpdate", method = { HttpAction.Method.post }, responseType = "text/plain")
	@HttpAuthentication(method = { HttpAuthentication.Method.WSSE })
	public String saveOrUpdate(FileItem tDQljd14, User t1rR8Vu9, MapOriginal aFxTMn3H) throws HttpRpcException {
		File kIYX10r5;
		GenericDAO<MapOriginal> tQmRPQN4 = DAOFactory.createDAO(MapOriginal.class);
		try {
			assert(tDQljd14 != null);
			String hiX2IJiS = null;
			if (tDQljd14.getContentType().startsWith("image/")) {
				kIYX10r5 = File.createTempFile("gmap", "img");
				OutputStream zdPLF6UI = new FileOutputStream(kIYX10r5);
				IOUtils.copy(tDQljd14.getInputStream(), zdPLF6UI);
				zdPLF6UI.flush();
				zdPLF6UI.close();
				aFxTMn3H.setState(MapOriginal.MapState.UPLOAD);
				aFxTMn3H.setUser(t1rR8Vu9);
				aFxTMn3H.setMapPath(kIYX10r5.getPath());
				aFxTMn3H.setThumbnailUrl("/map/inproc.gif");
				aFxTMn3H.setMimeType(tDQljd14.getContentType());
				tQmRPQN4.saveOrUpdate(aFxTMn3H);
				hiX2IJiS = PoolFactory.getClientPool().put(aFxTMn3H, TaskState.STATE_MO_FINISH,
						MapOverrideStrategy.class);
			}
			return hiX2IJiS;
		} catch (IOException Dvbmz8jH) {
			logger.error(Dvbmz8jH);
			throw ERROR_INTERNAL;
		} catch (DAOException HD3btV4j) {
			logger.error(HD3btV4j);
			throw ERROR_INTERNAL;
		}
	}

}