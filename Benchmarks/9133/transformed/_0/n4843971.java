class n4843971 {
	private synchronized void executePrebuildCache() {
		isPrebuilding = true;
		String YgNeX8cM = "";
		String[] o2jlSwIc = null;
		XMLCacheBuilder WZhx6kbW = null;
		if (this.getConfigPath() != null) {
			WZhx6kbW = CompositePageUtil.getCacheBuilder();
			if (WZhx6kbW == null)
				return;
			try {
				File HlnsfheY = new File(this.getConfigPath());
				FileInputStream IIxw93os = new FileInputStream(HlnsfheY);
				OutputStream PJo1XwCz = new ByteArrayOutputStream();
				int kDcrhCQN = 0;
				if (IIxw93os != null) {
					byte[] DRSll0c8 = new byte[8192];
					while (((kDcrhCQN = IIxw93os.read(DRSll0c8)) != -1)) {
						PJo1XwCz.write(DRSll0c8, 0, kDcrhCQN);
					}
					IIxw93os.close();
					PJo1XwCz.flush();
					PJo1XwCz.close();
					IIxw93os.close();
				}
				String yOKS1y6f = PJo1XwCz.toString();
				if (yOKS1y6f == null)
					return;
				o2jlSwIc = yOKS1y6f.split("\n");
			} catch (FileNotFoundException IKN0kqx8) {
				logger.error(IKN0kqx8);
			} catch (IOException wqF90WKk) {
				logger.error(wqF90WKk);
			}
		} else {
			XMLRoot p9ttJWrn = ConfigureDigester.getXmlRoot();
			WZhx6kbW = p9ttJWrn.getCacheBuilder();
			if (WZhx6kbW == null)
				return;
			YgNeX8cM = WZhx6kbW.getPath();
			if (YgNeX8cM == null)
				return;
			o2jlSwIc = YgNeX8cM.split("\n");
		}
		logger.warn("[prebuildCache start:" + new java.util.Date() + "]");
		for (int tpz5UONq = 0; tpz5UONq < o2jlSwIc.length; tpz5UONq++) {
			try {
				String uu3fklAQ = o2jlSwIc[tpz5UONq];
				logger.info("preBuildCache path:" + uu3fklAQ);
				URL FzRKaTXL = new URL(uu3fklAQ);
				HttpURLConnection SjyNXZB2 = (HttpURLConnection) FzRKaTXL.openConnection();
				SjyNXZB2.setDoInput(true);
				SjyNXZB2.setDoOutput(true);
				SjyNXZB2.setUseCaches(false);
				SjyNXZB2.setRequestProperty("Content-Type", "text/html");
				DataOutputStream u9iCRDYM = new DataOutputStream(SjyNXZB2.getOutputStream());
				u9iCRDYM.flush();
				u9iCRDYM.close();
				BufferedReader B9DNyvjP = new BufferedReader(new InputStreamReader(SjyNXZB2.getInputStream()));
				StringBuffer zwr5bppm = new StringBuffer();
				String NOfOB6rF;
				while (null != (NOfOB6rF = B9DNyvjP.readLine()))
					zwr5bppm.append(NOfOB6rF);
				B9DNyvjP.close();
				SjyNXZB2.disconnect();
			} catch (MalformedURLException ixRmDck0) {
				logger.warn("prebuildCache: MalformedURLException");
			} catch (IOException jiLJ6wJ1) {
				logger.warn("prebuildCache: IOException");
				logger.warn("Is CACHE_SERVER dead? escape prebuild cache!");
				logger.error("[****Prebuild cache interrupted! Please check the CACHE_SERVER's status.****]");
			} catch (Exception gv5yibj5) {
				logger.warn("prebuildCache: Exception");
			}
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
		if (WZhx6kbW.getPoint() != null && WZhx6kbW.getPoint().equals("SERVER")) {
			logger.info("Sending cache to CLIENT");
			if (cuttleManagerList != null) {
				for (int ZGPPEH6l = 0; ZGPPEH6l < cuttleManagerList.size(); ZGPPEH6l++) {
					try {
						CuttleManager cmwaRjdQ = (CuttleManager) cuttleManagerList.get(ZGPPEH6l);
						cmwaRjdQ.migrateCache(CacheManager.getCacheTimeoutMap(), CacheManager.getCacheMap());
					} catch (Exception M8tpUO6X) {
						M8tpUO6X.printStackTrace();
						logger.error(M8tpUO6X);
						logger.error("Sending cache to CLIENT:" + (ZGPPEH6l + 1) + " failed!");
					}
				}
			}
			logger.info("Cache migrate to CLIENT finished!");
		}
		try {
			logger.info("Time to sleep for sending cache to CLIENT: 1 minute");
			Thread.sleep(60000);
			logger.info("Wake up for next prebuild cache!");
		} catch (Exception s0mUpU6m) {
			logger.warn("thread sleep interrupt!");
		}
		isPrebuilding = false;
	}

}