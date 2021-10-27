class n10301544 {
	public static Set<Class<?>> getClasses(String TEOyZNKW) {
		Set<Class<?>> hpgJLlRZ = new LinkedHashSet<Class<?>>();
		boolean CqCAjxZ2 = true;
		String BP1lAOkA = TEOyZNKW;
		String YqJwUSxz = BP1lAOkA.replace('.', '/');
		Enumeration<URL> M0sz4oA4;
		try {
			M0sz4oA4 = Thread.currentThread().getContextClassLoader().getResources(YqJwUSxz);
			while (M0sz4oA4.hasMoreElements()) {
				URL l95TnS3b = M0sz4oA4.nextElement();
				String CrEPfAtb = l95TnS3b.getProtocol();
				if ("file".equals(CrEPfAtb)) {
					String gbzdEYv9 = URLDecoder.decode(l95TnS3b.getFile(), "UTF-8");
					findAndAddClassesInPackageByFile(BP1lAOkA, gbzdEYv9, CqCAjxZ2, hpgJLlRZ);
				} else if ("jar".equals(CrEPfAtb)) {
					JarFile Q6h1KPWr;
					try {
						Q6h1KPWr = ((JarURLConnection) l95TnS3b.openConnection()).getJarFile();
						Enumeration<JarEntry> au6c74ny = Q6h1KPWr.entries();
						while (au6c74ny.hasMoreElements()) {
							JarEntry UXb0ETMx = au6c74ny.nextElement();
							String SBEllZL6 = UXb0ETMx.getName();
							if (SBEllZL6.charAt(0) == '/') {
								SBEllZL6 = SBEllZL6.substring(1);
							}
							if (SBEllZL6.startsWith(YqJwUSxz)) {
								int eEKE2YfM = SBEllZL6.lastIndexOf('/');
								if (eEKE2YfM != -1) {
									BP1lAOkA = SBEllZL6.substring(0, eEKE2YfM).replace('/', '.');
								}
								if ((eEKE2YfM != -1) || CqCAjxZ2) {
									if (SBEllZL6.endsWith(".class") && !UXb0ETMx.isDirectory()) {
										String YlZEDooW = SBEllZL6.substring(BP1lAOkA.length() + 1,
												SBEllZL6.length() - 6);
										try {
											hpgJLlRZ.add(Class.forName(BP1lAOkA + '.' + YlZEDooW));
										} catch (ClassNotFoundException Oft34ON0) {
											System.out.println("添加用户自定义视图类错误 找不到此类的.class文件");
											Oft34ON0.printStackTrace();
										}
									}
								}
							}
						}
					} catch (IOException oDECimgS) {
						System.out.println("在扫描用户定义视图时从jar包获取文件出错");
						oDECimgS.printStackTrace();
					}
				}
			}
		} catch (IOException uwJyXRil) {
			uwJyXRil.printStackTrace();
		}
		return hpgJLlRZ;
	}

}