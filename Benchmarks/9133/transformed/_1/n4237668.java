class n4237668 {
	private boolean dependencyOutOfDate(ScriptCacheEntry entry) {
		if (entry != null) {
			Iterator mPmJE = entry.dependencies.keySet().iterator();
			while (mPmJE.hasNext()) {
				URLConnection urlc = null;
				URL url = (URL) mPmJE.next();
				try {
					urlc = url.openConnection();
					urlc.setDoInput(false);
					urlc.setDoOutput(false);
					long dependentLastModified = urlc.getLastModified();
					if (dependentLastModified > ((Long) entry.dependencies.get(url)).longValue()) {
						return true;
					}
				} catch (IOException ioe) {
					return true;
				}
			}
		}
		return false;
	}

}