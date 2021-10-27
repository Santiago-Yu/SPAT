class n18029937 {
	private void buildCache() {
		cache = new HashMap<String, byte[]>();
		JarInputStream TPMbHEyW = null;
		BufferedInputStream BJYhdqpl = null;
		URL[] aiMaawEt = getURLs();
		for (URL xFIfFGhT : aiMaawEt) {
			try {
				if (xFIfFGhT.getPath().endsWith(".jar")) {
					TPMbHEyW = new JarInputStream(xFIfFGhT.openStream());
					BJYhdqpl = new BufferedInputStream(TPMbHEyW);
					JarEntry DRtS3MX5 = null;
					while ((DRtS3MX5 = TPMbHEyW.getNextJarEntry()) != null) {
						String R7OSmRyi = DRtS3MX5.getName();
						if (!DRtS3MX5.isDirectory() && R7OSmRyi.toLowerCase().endsWith(".class")) {
							String kpWVopR4 = R7OSmRyi.replaceAll("/", ".").substring(0, R7OSmRyi.length() - 6);
							if (isClassLoaderConditonVerified(kpWVopR4)) {
								ByteArrayOutputStream RoNB1EH1 = null;
								BufferedOutputStream R0TYguEk = null;
								try {
									RoNB1EH1 = new ByteArrayOutputStream();
									R0TYguEk = new BufferedOutputStream(RoNB1EH1);
									int UdBtHtnX = -1;
									while ((UdBtHtnX = BJYhdqpl.read()) != -1) {
										R0TYguEk.write(UdBtHtnX);
									}
									R0TYguEk.flush();
									cache.put(kpWVopR4, RoNB1EH1.toByteArray());
								} finally {
									if (RoNB1EH1 != null) {
										try {
											RoNB1EH1.close();
										} catch (IOException W66lNM2Y) {
										}
									}
									if (R0TYguEk != null) {
										try {
											R0TYguEk.close();
										} catch (IOException ZwfisJ6c) {
										}
									}
								}
								TPMbHEyW.closeEntry();
							}
						}
					}
					try {
						TPMbHEyW.close();
					} catch (IOException Ky82yGQF) {
					}
				} else {
					File VWxIOSyj = new File(xFIfFGhT.getFile());
					buildCacheFromFile(VWxIOSyj, null);
				}
			} catch (IOException mQ4RZF7T) {
				continue;
			}
		}
	}

}