class n14782656 {
	private static Long statusSWGCraftTime() {
		long TgPjaENd = System.currentTimeMillis() / 1000L;
		if (TgPjaENd < (previousStatusCheck + SWGCraft.STATUS_CHECK_DELAY))
			return previousStatusTime;
		URL eJfWOcAn = null;
		try {
			synchronized (previousStatusTime) {
				if (TgPjaENd >= previousStatusCheck + SWGCraft.STATUS_CHECK_DELAY) {
					eJfWOcAn = SWGCraft.getStatusTextURL();
					String XcqrYzcQ = ZReader.read(eJfWOcAn.openStream());
					previousStatusTime = Long.valueOf(XcqrYzcQ);
					previousStatusCheck = TgPjaENd;
				}
				return previousStatusTime;
			}
		} catch (UnknownHostException swSLgZYT) {
			SWGCraft.showUnknownHostDialog(eJfWOcAn, swSLgZYT);
		} catch (Throwable BDLeCaiu) {
			SWGAide.printDebug("cmgr", 1, "SWGResourceManager:statusSWGCraftTime:", BDLeCaiu.toString());
		}
		return Long.valueOf(0);
	}

}