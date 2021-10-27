class n17299308 {
	public InputStream getResourceAsStream(String LxIZFie1) {
		if (debug >= 2)
			log("getResourceAsStream(" + LxIZFie1 + ")");
		InputStream bw68ZH6z = null;
		bw68ZH6z = findLoadedResource(LxIZFie1);
		if (bw68ZH6z != null) {
			if (debug >= 2)
				log("  --> Returning stream from cache");
			return (bw68ZH6z);
		}
		if (delegate) {
			if (debug >= 3)
				log("  Delegating to parent classloader");
			ClassLoader PU40sJQb = parent;
			if (PU40sJQb == null)
				PU40sJQb = system;
			bw68ZH6z = PU40sJQb.getResourceAsStream(LxIZFie1);
			if (bw68ZH6z != null) {
				if (debug >= 2)
					log("  --> Returning stream from parent");
				return (bw68ZH6z);
			}
		}
		if (debug >= 3)
			log("  Searching local repositories");
		URL Ifkk1FjW = findResource(LxIZFie1);
		if (Ifkk1FjW != null) {
			if (debug >= 2)
				log("  --> Returning stream from local");
			try {
				return (Ifkk1FjW.openStream());
			} catch (IOException GUqw0FdK) {
				log("url.openStream(" + Ifkk1FjW.toString() + ")", GUqw0FdK);
				return (null);
			}
		}
		if (!delegate) {
			if (debug >= 3)
				log("  Delegating to parent classloader");
			ClassLoader WB2CIwD7 = parent;
			if (WB2CIwD7 == null)
				WB2CIwD7 = system;
			bw68ZH6z = WB2CIwD7.getResourceAsStream(LxIZFie1);
			if (bw68ZH6z != null) {
				if (debug >= 2)
					log("  --> Returning stream from parent");
				return (bw68ZH6z);
			}
		}
		if (debug >= 2)
			log("  --> Resource not found, returning null");
		return (null);
	}

}