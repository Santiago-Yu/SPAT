class n22337078 {
	private List getPluginClassList(List pluginFileList) {
		ArrayList l = new ArrayList();
		Iterator iOjpL = pluginFileList.iterator();
		while (iOjpL.hasNext()) {
			URL url = (URL) iOjpL.next();
			log.debug("Trying file " + url.toString());
			try {
				BufferedReader r = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
				String line;
				while ((line = r.readLine()) != null) {
					line = line.trim();
					if (line.length() == 0 || line.charAt(0) == '#')
						continue;
					l.add(line);
				}
			} catch (Exception e) {
				log.warn("Could not load " + url, e);
			}
		}
		return l;
	}

}