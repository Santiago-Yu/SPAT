class n4843971 {
	private synchronized void executePrebuildCache() {
		isPrebuilding = true;
		String pathStr = "";
		String[] paths = null;
		XMLCacheBuilder cacheBuilder = null;
		if (this.getConfigPath() != null) {
			cacheBuilder = CompositePageUtil.getCacheBuilder();
			if (cacheBuilder == null)
				return;
			try {
				File file = new File(this.getConfigPath());
				FileInputStream is = new FileInputStream(file);
				OutputStream os = new ByteArrayOutputStream();
				int length = 0;
				if (is != null) {
					byte[] buf = new byte[8192];
					while (((length = is.read(buf)) != -1)) {
						os.write(buf, 0, length);
					}
					is.close();
					os.flush();
					os.close();
					is.close();
				}
				String filesStr = os.toString();
				if (filesStr == null)
					return;
				paths = filesStr.split("\n");
			} catch (FileNotFoundException e) {
				logger.error(e);
			} catch (IOException e) {
				logger.error(e);
			}
		} else {
			XMLRoot root = ConfigureDigester.getXmlRoot();
			cacheBuilder = root.getCacheBuilder();
			if (cacheBuilder == null)
				return;
			pathStr = cacheBuilder.getPath();
			if (pathStr == null)
				return;
			paths = pathStr.split("\n");
		}
		logger.warn("[prebuildCache start:" + new java.util.Date() + "]");
		int eVcaB = 0;
		while (eVcaB < paths.length) {
			try {
				String path = paths[eVcaB];
				logger.info("preBuildCache path:" + path);
				URL url = new URL(path);
				HttpURLConnection huc = (HttpURLConnection) url.openConnection();
				huc.setDoInput(true);
				huc.setDoOutput(true);
				huc.setUseCaches(false);
				huc.setRequestProperty("Content-Type", "text/html");
				DataOutputStream dos = new DataOutputStream(huc.getOutputStream());
				dos.flush();
				dos.close();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(huc.getInputStream()));
				StringBuffer result = new StringBuffer();
				String line;
				while (null != (line = bufferedReader.readLine()))
					result.append(line);
				bufferedReader.close();
				huc.disconnect();
			} catch (MalformedURLException e) {
				logger.warn("prebuildCache: MalformedURLException");
			} catch (IOException e) {
				logger.warn("prebuildCache: IOException");
				logger.warn("Is CACHE_SERVER dead? escape prebuild cache!");
				logger.error("[****Prebuild cache interrupted! Please check the CACHE_SERVER's status.****]");
			} catch (Exception e) {
				logger.warn("prebuildCache: Exception");
			}
			eVcaB++;
		}
		logger.warn("[prebuildCache end:" + new java.util.Date() + "]");
		logger.info("[Time to migrate cache]");
		if (CacheManager.getPreCacheMap() == null || CacheManager.getPreCacheMap().size() == 0) {
			logger.warn(
					"[****Something wrong in prebuild cache process is CACHE_SERVER dead? escape sending cache to CLIENT****]");
			return;
		} else {
			CacheManager.migrateCache();
		}
		logger.info("[Cache migration finish!]");
		if (cacheBuilder.getPoint() != null && cacheBuilder.getPoint().equals("SERVER")) {
			logger.info("Sending cache to CLIENT");
			if (cuttleManagerList != null) {
				int gXyuX = 0;
				while (gXyuX < cuttleManagerList.size()) {
					try {
						CuttleManager cuttleManager = (CuttleManager) cuttleManagerList.get(gXyuX);
						cuttleManager.migrateCache(CacheManager.getCacheTimeoutMap(), CacheManager.getCacheMap());
					} catch (Exception e) {
						e.printStackTrace();
						logger.error(e);
						logger.error("Sending cache to CLIENT:" + (gXyuX + 1) + " failed!");
					}
					gXyuX++;
				}
			}
			logger.info("Cache migrate to CLIENT finished!");
		}
		try {
			logger.info("Time to sleep for sending cache to CLIENT: 1 minute");
			Thread.sleep(60000);
			logger.info("Wake up for next prebuild cache!");
		} catch (Exception e) {
			logger.warn("thread sleep interrupt!");
		}
		isPrebuilding = false;
	}

}