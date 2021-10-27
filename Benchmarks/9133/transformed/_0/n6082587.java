class n6082587 {
	protected void processAnnotationsJar(URL jIY2yJwC) {
		JarFile hiDxU2iC = null;
		try {
			URLConnection JhptvRZk = jIY2yJwC.openConnection();
			JarURLConnection yT2WJ6q5;
			if (!(JhptvRZk instanceof JarURLConnection)) {
				sm.getString("contextConfig.jarUrl", jIY2yJwC);
				return;
			}
			yT2WJ6q5 = (JarURLConnection) JhptvRZk;
			yT2WJ6q5.setUseCaches(false);
			hiDxU2iC = yT2WJ6q5.getJarFile();
			Enumeration<JarEntry> SWj3UBMF = hiDxU2iC.entries();
			while (SWj3UBMF.hasMoreElements()) {
				JarEntry YY4nGa97 = SWj3UBMF.nextElement();
				String smdRqqlj = YY4nGa97.getName();
				if (smdRqqlj.endsWith(".class")) {
					InputStream Gxt3hjnz = null;
					try {
						Gxt3hjnz = hiDxU2iC.getInputStream(YY4nGa97);
						processAnnotationsStream(Gxt3hjnz);
					} catch (IOException STQEKqxf) {
						logger.error(sm.getString("contextConfig.inputStreamJar", smdRqqlj, jIY2yJwC), STQEKqxf);
					} finally {
						if (Gxt3hjnz != null) {
							try {
								Gxt3hjnz.close();
							} catch (Throwable pjKaSpiN) {
								ExceptionUtils.handleThrowable(pjKaSpiN);
							}
						}
					}
				}
			}
		} catch (IOException Oc81F0jH) {
			logger.error(sm.getString("contextConfig.jarFile", jIY2yJwC), Oc81F0jH);
		} finally {
			if (hiDxU2iC != null) {
				try {
					hiDxU2iC.close();
				} catch (Throwable VW2jITSY) {
					ExceptionUtils.handleThrowable(VW2jITSY);
				}
			}
		}
	}

}