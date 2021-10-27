class n14275711 {
	private void initSerializerFiles(String fileName, HashSet<String> fileList, HashMap<Class, Class> classMap,
			Class type) {
		try {
			ClassLoader classLoader = getClassLoader();
			Enumeration iter;
			if (classLoader == null)
				return;
			iter = classLoader.getResources(fileName);
			while (iter.hasMoreElements()) {
				URL url = (URL) iter.nextElement();
				if (fileList.contains(url.toString()))
					continue;
				fileList.add(url.toString());
				InputStream is = null;
				try {
					Properties props = new Properties();
					is = url.openStream();
					props.load(is);
					for (Map.Entry entry : props.entrySet()) {
						String apiName = (String) entry.getKey();
						Class apiClass = null;
						String serializerName = (String) entry.getValue();
						Class serializerClass = null;
						try {
							apiClass = Class.forName(apiName, false, classLoader);
						} catch (ClassNotFoundException e) {
							log.fine(url + ": " + apiName + " is not available in this context: " + getClassLoader());
							continue;
						}
						try {
							serializerClass = Class.forName(serializerName, false, classLoader);
						} catch (ClassNotFoundException e) {
							log.fine(url + ": " + serializerName + " is not available in this context: "
									+ getClassLoader());
							continue;
						}
						if (!type.isAssignableFrom(serializerClass))
							throw new HessianException(url + ": " + serializerClass.getName()
									+ " is invalid because it does not implement " + type.getName());
						classMap.put(apiClass, serializerClass);
					}
				} finally {
					if (is != null)
						is.close();
				}
			}
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new HessianException(e);
		}
	}

}