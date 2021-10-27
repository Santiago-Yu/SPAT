class n17299308 {
	public InputStream getResourceAsStream(String name) {
		if (debug >= 2)
			log("getResourceAsStream(" + name + ")");
		InputStream stream = null;
		stream = findLoadedResource(name);
		if (stream != null) {
			if (debug >= 2)
				log("  --> Returning stream from cache");
			return (stream);
		}
		if (delegate) {
			if (debug >= 3)
				log("  Delegating to parent classloader");
			ClassLoader loader = parent;
			loader = (loader == null) ? system : loader;
			stream = loader.getResourceAsStream(name);
			if (stream != null) {
				if (debug >= 2)
					log("  --> Returning stream from parent");
				return (stream);
			}
		}
		if (debug >= 3)
			log("  Searching local repositories");
		URL url = findResource(name);
		if (url != null) {
			if (debug >= 2)
				log("  --> Returning stream from local");
			try {
				return (url.openStream());
			} catch (IOException e) {
				log("url.openStream(" + url.toString() + ")", e);
				return (null);
			}
		}
		if (!delegate) {
			if (debug >= 3)
				log("  Delegating to parent classloader");
			ClassLoader loader = parent;
			loader = (loader == null) ? system : loader;
			stream = loader.getResourceAsStream(name);
			if (stream != null) {
				if (debug >= 2)
					log("  --> Returning stream from parent");
				return (stream);
			}
		}
		if (debug >= 2)
			log("  --> Resource not found, returning null");
		return (null);
	}

}