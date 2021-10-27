class n6082588 {
	protected void processAnnotationsJndi(URL U0FkrWTp) {
		try {
			URLConnection dXFDI4dF = U0FkrWTp.openConnection();
			DirContextURLConnection g5V2h6FR;
			if (!(dXFDI4dF instanceof DirContextURLConnection)) {
				sm.getString("contextConfig.jndiUrlNotDirContextConn", U0FkrWTp);
				return;
			}
			g5V2h6FR = (DirContextURLConnection) dXFDI4dF;
			g5V2h6FR.setUseCaches(false);
			String mXaPxylD = g5V2h6FR.getHeaderField(ResourceAttributes.TYPE);
			if (ResourceAttributes.COLLECTION_TYPE.equals(mXaPxylD)) {
				Enumeration<String> yoriee1e = g5V2h6FR.list();
				while (yoriee1e.hasMoreElements()) {
					String ABRgkD5T = yoriee1e.nextElement();
					URL HWLlzzd4 = new URL(U0FkrWTp.toString() + '/' + ABRgkD5T);
					processAnnotationsJndi(HWLlzzd4);
				}
			} else {
				if (U0FkrWTp.getPath().endsWith(".class")) {
					InputStream LjgKuzFC = null;
					try {
						LjgKuzFC = g5V2h6FR.getInputStream();
						processAnnotationsStream(LjgKuzFC);
					} catch (IOException cxtCqkfQ) {
						logger.error(sm.getString("contextConfig.inputStreamJndi", U0FkrWTp), cxtCqkfQ);
					} finally {
						if (LjgKuzFC != null) {
							try {
								LjgKuzFC.close();
							} catch (Throwable lzqf927x) {
								ExceptionUtils.handleThrowable(lzqf927x);
							}
						}
					}
				}
			}
		} catch (IOException aZRkYYfx) {
			logger.error(sm.getString("contextConfig.jndiUrl", U0FkrWTp), aZRkYYfx);
		}
	}

}