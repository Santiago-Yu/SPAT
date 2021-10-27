class n18029937 {
	private void buildCache() {
		JarInputStream jis = null;
		cache = new HashMap<String, byte[]>();
		URL[] urls = getURLs();
		BufferedInputStream bis = null;
		for (URL url : urls) {
			try {
				if (url.getPath().endsWith(".jar")) {
					jis = new JarInputStream(url.openStream());
					JarEntry jarEntry = null;
					bis = new BufferedInputStream(jis);
					while ((jarEntry = jis.getNextJarEntry()) != null) {
						String name = jarEntry.getName();
						if (!jarEntry.isDirectory() && name.toLowerCase().endsWith(".class")) {
							String className = name.replaceAll("/", ".").substring(0, name.length() - 6);
							if (isClassLoaderConditonVerified(className)) {
								BufferedOutputStream bos = null;
								ByteArrayOutputStream baos = null;
								try {
									baos = new ByteArrayOutputStream();
									int i = -1;
									bos = new BufferedOutputStream(baos);
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
				} else {
					File file = new File(url.getFile());
					buildCacheFromFile(file, null);
				}
			} catch (IOException ex) {
				continue;
			}
		}
	}

}