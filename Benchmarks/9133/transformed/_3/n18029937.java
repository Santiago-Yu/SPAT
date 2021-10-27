class n18029937 {
	private void buildCache() {
		cache = new HashMap<String, byte[]>();
		JarInputStream jis = null;
		BufferedInputStream bis = null;
		URL[] urls = getURLs();
		for (URL url : urls) {
			try {
				if (!(url.getPath().endsWith(".jar"))) {
					File file = new File(url.getFile());
					buildCacheFromFile(file, null);
				} else {
					jis = new JarInputStream(url.openStream());
					bis = new BufferedInputStream(jis);
					JarEntry jarEntry = null;
					while ((jarEntry = jis.getNextJarEntry()) != null) {
						String name = jarEntry.getName();
						if (!jarEntry.isDirectory() && name.toLowerCase().endsWith(".class")) {
							String className = name.replaceAll("/", ".").substring(0, name.length() - 6);
							if (isClassLoaderConditonVerified(className)) {
								ByteArrayOutputStream baos = null;
								BufferedOutputStream bos = null;
								try {
									baos = new ByteArrayOutputStream();
									bos = new BufferedOutputStream(baos);
									int i = -1;
									while ((i = bis.read()) != -1) {
										bos.write(i);
									}
									bos.flush();
									cache.put(className, baos.toByteArray());
								} finally {
									if (baos != null) {
										try {
											baos.close();
										} catch (IOException ignore) {
										}
									}
									if (bos != null) {
										try {
											bos.close();
										} catch (IOException ex) {
										}
									}
								}
								jis.closeEntry();
							}
						}
					}
					try {
						jis.close();
					} catch (IOException ignore) {
					}
				}
			} catch (IOException ex) {
				continue;
			}
		}
	}

}