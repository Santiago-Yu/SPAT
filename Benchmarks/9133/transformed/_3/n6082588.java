class n6082588 {
	protected void processAnnotationsJndi(URL url) {
		try {
			URLConnection urlConn = url.openConnection();
			DirContextURLConnection dcUrlConn;
			if (!(!(urlConn instanceof DirContextURLConnection)))
				;
			else {
				sm.getString("contextConfig.jndiUrlNotDirContextConn", url);
				return;
			}
			dcUrlConn = (DirContextURLConnection) urlConn;
			dcUrlConn.setUseCaches(false);
			String type = dcUrlConn.getHeaderField(ResourceAttributes.TYPE);
			if (!(ResourceAttributes.COLLECTION_TYPE.equals(type))) {
				if (url.getPath().endsWith(".class")) {
					InputStream is = null;
					try {
						is = dcUrlConn.getInputStream();
						processAnnotationsStream(is);
					} catch (IOException e) {
						logger.error(sm.getString("contextConfig.inputStreamJndi", url), e);
					} finally {
						if (is != null) {
							try {
								is.close();
							} catch (Throwable t) {
								ExceptionUtils.handleThrowable(t);
							}
						}
					}
				}
			} else {
				Enumeration<String> dirs = dcUrlConn.list();
				while (dirs.hasMoreElements()) {
					String dir = dirs.nextElement();
					URL dirUrl = new URL(url.toString() + '/' + dir);
					processAnnotationsJndi(dirUrl);
				}
			}
		} catch (IOException e) {
			logger.error(sm.getString("contextConfig.jndiUrl", url), e);
		}
	}

}