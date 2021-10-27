class n4237668 {
	private boolean dependencyOutOfDate(ScriptCacheEntry entry) {
		if (entry != null) {
			for (Iterator i = entry.dependencies.keySet().iterator(); i.hasNext();) {
				URL url = (URL) i.next();
				URLConnection urlc = null;
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