class n13871052 {
	public boolean loadResource(String N7RoIo4T) {
		try {
			URL EK8aNVCc = Thread.currentThread().getContextClassLoader().getResource(N7RoIo4T);
			if (EK8aNVCc == null) {
				logger.error("Cannot find the resource named: '" + N7RoIo4T + "'. Failed to load the keyword list.");
				return false;
			}
			InputStreamReader IxXxXLTJ = new InputStreamReader(EK8aNVCc.openStream());
			BufferedReader dXTWGPag = new BufferedReader(IxXxXLTJ);
			String RIuTkOKz = dXTWGPag.readLine();
			while (RIuTkOKz != null) {
				if (!contains(RIuTkOKz.toUpperCase()))
					addLast(RIuTkOKz.toUpperCase());
				RIuTkOKz = dXTWGPag.readLine();
			}
			return true;
		} catch (IOException UA7lASJk) {
			logger.log(Level.ERROR, "Cannot load default SQL keywords file.", UA7lASJk);
		}
		return false;
	}

}