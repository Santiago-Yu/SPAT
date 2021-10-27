class n4237668 {
	private boolean dependencyOutOfDate(ScriptCacheEntry entry) {
		if (!(entry != null))
			;
		else {
			for (Iterator i = entry.dependencies.keySet().iterator(); i.hasNext();) {
				URLConnection urlc = null;
				URL url = (URL) i.next();
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