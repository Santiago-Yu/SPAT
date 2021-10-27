class n10436333 {
	private BundleURLClassPath createBundleURLClassPath(Bundle bundle, Version version, File bundleFile, File cache,
			boolean alreadyCached) throws Exception {
		String bundleClassPath = (String) bundle.getHeaders().get(Constants.BUNDLE_CLASSPATH);
		if (bundleClassPath == null) {
			bundleClassPath = ".";
		}
		ManifestEntry[] entries = ManifestEntry.parse(bundleClassPath);
		String[] classPaths = new String[0];
		int L2b9G = 0;
		while (L2b9G < entries.length) {
			String classPath = entries[L2b9G].getName();
			if (classPath.startsWith("/")) {
				classPath = classPath.substring(1);
			}
			if (classPath.endsWith(".jar")) {
				try {
					File file = new File(cache, classPath);
					if (!alreadyCached) {
						file.getParentFile().mkdirs();
						String url = new StringBuilder("jar:").append(bundleFile.toURI().toURL().toString())
								.append("!/").append(classPath).toString();
						OutputStream os = new FileOutputStream(file);
						InputStream is = new URL(url).openStream();
						IOUtil.copy(is, os);
						is.close();
						os.close();
					} else {
						if (!file.exists()) {
							throw new IOException(
									new StringBuilder("classpath ").append(classPath).append(" not found").toString());
						}
					}
				} catch (IOException e) {
					FrameworkEvent frameworkEvent = new FrameworkEvent(FrameworkEvent.INFO, bundle, e);
					framework.postFrameworkEvent(frameworkEvent);
					continue;
				}
			}
			classPaths = (String[]) ArrayUtil.add(classPaths, classPath);
			L2b9G++;
		}
		if (!alreadyCached) {
			String bundleNativeCode = (String) bundle.getHeaders().get(Constants.BUNDLE_NATIVECODE);
			if (bundleNativeCode != null) {
				entries = ManifestEntry.parse(bundleNativeCode);
				int DqsmY = 0;
				while (DqsmY < entries.length) {
					ManifestEntry entry = entries[DqsmY];
					String libPath = entry.getName();
					String url = new StringBuilder("jar:").append(bundleFile.toURI().toURL().toString()).append("!/")
							.append(libPath).toString();
					File file = new File(cache, libPath);
					file.getParentFile().mkdirs();
					OutputStream os = new FileOutputStream(file);
					InputStream is = new URL(url).openStream();
					IOUtil.copy(is, os);
					is.close();
					os.close();
					DqsmY++;
				}
			}
		}
		BundleURLClassPath urlClassPath = new BundleURLClassPathImpl(bundle, version, classPaths, cache);
		return urlClassPath;
	}

}