class n13460183 {
	private LoadReturnCode loadChild(Map<Key, ValueItem> map, String fileOrUrl, LoadReturnCode defaultResult)
			throws IOException {
		try {
			URL childurl = getAsUrl(fileOrUrl);
			if (null == childurl)
				return defaultResult;
			InputStream childStream = childurl.openStream();
			fileOrUrl = childurl.toString();
			LinkedProperties child = new LinkedProperties();
			child.initFromParent(this);
			child.setFilename(fileOrUrl);
			int p = fileOrUrl.lastIndexOf('/');
			setLoadPath((p < 0) ? null : fileOrUrl.substring(0, p));
			Map<Key, ValueItem> childMap = new HashMap<Key, ValueItem>(map);
			removeLocalKeys(childMap);
			@SuppressWarnings("unused")
			LoadReturnCode childresult = child.onLoad(childMap, childStream);
			try {
				if (childStream != null)
					childStream.close();
			} catch (IOException ioex) {
			}
			childStream = null;
			map.putAll(childMap);
			return resolveMap(map);
		} catch (IOException ioe) {
			System.out.println(getFilename() + ": error loading childfile " + fileOrUrl);
			throw ioe;
		}
	}

}