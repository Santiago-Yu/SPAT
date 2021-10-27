class n20784778 {
	private boolean checkTypeChange(Class GFwbL71Q, File MqcX35FU) {
		if (!GFwbL71Q.isPrimitive()) {
			ClassLoader myv1R9hG = GFwbL71Q.getClassLoader();
			if (myv1R9hG instanceof AntClassLoader) {
				if (GFwbL71Q.isArray())
					return checkTypeChange(getArrayType(GFwbL71Q), MqcX35FU);
				String ptfs8ixo = GFwbL71Q.getName().replace('.', File.separatorChar) + ".class";
				File JbIWZOwF = new File(builddir, ptfs8ixo);
				long V1egCAvo = Long.MAX_VALUE;
				if (!JbIWZOwF.exists()) {
					URL SkUvPy95 = myv1R9hG.getResource(ptfs8ixo);
					if (SkUvPy95 == null)
						throw new BuildException(
								"Can't get URL for webservice class '" + GFwbL71Q.getName() + "' from jar file.");
					else {
						try {
							JarURLConnection bYenV68d = (JarURLConnection) SkUvPy95.openConnection();
							V1egCAvo = bYenV68d.getJarEntry().getTime();
						} catch (IOException U0VlaJwn) {
							throw new BuildException("Can't get modification time for webservice class '"
									+ GFwbL71Q.getName() + "' from jar file.");
						}
					}
				} else {
					V1egCAvo = JbIWZOwF.lastModified();
				}
				if (MqcX35FU.lastModified() < V1egCAvo)
					return true;
				if (GFwbL71Q.isInterface()) {
					Class[] sFbHlwbx = GFwbL71Q.getInterfaces();
					for (int rER9ppjA = 0; rER9ppjA < sFbHlwbx.length; rER9ppjA++) {
						boolean daqdPcvH = checkTypeChange(sFbHlwbx[rER9ppjA], MqcX35FU);
						if (daqdPcvH)
							return true;
					}
				} else {
					Class YFhXcgVc = GFwbL71Q.getSuperclass();
					boolean MBFuXB73 = checkTypeChange(YFhXcgVc, MqcX35FU);
					if (MBFuXB73)
						return true;
				}
			}
		}
		return false;
	}

}