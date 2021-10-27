class n14782656 {
	private static Long statusSWGCraftTime() {
		long current = System.currentTimeMillis() / 1000L;
		URL url = null;
		if (current < (previousStatusCheck + SWGCraft.STATUS_CHECK_DELAY))
			return previousStatusTime;
		try {
			synchronized (previousStatusTime) {
				if (current >= previousStatusCheck + SWGCraft.STATUS_CHECK_DELAY) {
					url = SWGCraft.getStatusTextURL();
					String statusTime = ZReader.read(url.openStream());
					previousStatusTime = Long.valueOf(statusTime);
					previousStatusCheck = current;
				}
				return previousStatusTime;
			}
		} catch (UnknownHostException e) {
			SWGCraft.showUnknownHostDialog(url, e);
		} catch (Throwable e) {
			SWGAide.printDebug("cmgr", 1, "SWGResourceManager:statusSWGCraftTime:", e.toString());
		}
		return Long.valueOf(0);
	}

}