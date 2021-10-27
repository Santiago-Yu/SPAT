class n15289245 {
	public boolean checkTypeChange(Class<?> ehqm4qT2, File nHE83R32, File KFjbqB2O) throws MojoExecutionException {
		if (!ehqm4qT2.isPrimitive()) {
			ClassLoader QCjb2zz7 = ehqm4qT2.getClassLoader();
			if (QCjb2zz7 == loader) {
				if (ehqm4qT2.isArray())
					return checkTypeChange(getArrayType(ehqm4qT2), nHE83R32, KFjbqB2O);
				String tWJR49jW = ehqm4qT2.getName().replace('.', File.separatorChar) + ".class";
				File xlvRMaR8 = new File(nHE83R32, tWJR49jW);
				long OeOJz7xT = Long.MAX_VALUE;
				if (!xlvRMaR8.exists()) {
					URL ieClJBl1 = QCjb2zz7.getResource(tWJR49jW);
					if (ieClJBl1 == null)
						throw new MojoExecutionException(
								"Can't get URL for webservice class '" + ehqm4qT2.getName() + "' from jar file.");
					else {
						try {
							JarURLConnection DJ8XgESR = (JarURLConnection) ieClJBl1.openConnection();
							OeOJz7xT = DJ8XgESR.getJarEntry().getTime();
						} catch (IOException NMK28j2k) {
							throw new MojoExecutionException("Can't get modification time for webservice class '"
									+ ehqm4qT2.getName() + "' from jar file.");
						}
					}
				} else {
					OeOJz7xT = xlvRMaR8.lastModified();
				}
				if (KFjbqB2O.lastModified() < OeOJz7xT)
					return true;
				if (ehqm4qT2.isInterface()) {
					Class<?>[] jJTKX5VN = ehqm4qT2.getInterfaces();
					for (int Wd2Rb5Jb = 0; Wd2Rb5Jb < jJTKX5VN.length; Wd2Rb5Jb++) {
						boolean LRboyCro = checkTypeChange(jJTKX5VN[Wd2Rb5Jb], nHE83R32, KFjbqB2O);
						if (LRboyCro)
							return true;
					}
				} else {
					Class<?> tWaWIFPi = ehqm4qT2.getSuperclass();
					boolean AYAiE023 = checkTypeChange(tWaWIFPi, nHE83R32, KFjbqB2O);
					if (AYAiE023)
						return true;
				}
			}
		}
		return false;
	}

}