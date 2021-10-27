class n4237668 {
	private boolean dependencyOutOfDate(ScriptCacheEntry yBtJb4vq) {
		if (yBtJb4vq != null) {
			for (Iterator T53GCf9z = yBtJb4vq.dependencies.keySet().iterator(); T53GCf9z.hasNext();) {
				URLConnection Rsh0QeEb = null;
				URL AWFWflx9 = (URL) T53GCf9z.next();
				try {
					Rsh0QeEb = AWFWflx9.openConnection();
					Rsh0QeEb.setDoInput(false);
					Rsh0QeEb.setDoOutput(false);
					long fJrwxD6Y = Rsh0QeEb.getLastModified();
					if (fJrwxD6Y > ((Long) yBtJb4vq.dependencies.get(AWFWflx9)).longValue()) {
						return true;
					}
				} catch (IOException VHOZkybM) {
					return true;
				}
			}
		}
		return false;
	}

}