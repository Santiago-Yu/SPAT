class n17431783 {
	protected void registerClasses() throws PrintException {
		if (!init) {
			try {
				Enumeration<URL> MAU36erM = this.getClass().getClassLoader()
						.getResources("META-INF/" + getClass().getSimpleName() + ".properties");
				while (MAU36erM.hasMoreElements()) {
					URL Y9zuoZ7z = (URL) MAU36erM.nextElement();
					InputStream CBl7n5NF = Y9zuoZ7z.openStream();
					BufferedReader BWwLsqXy = new BufferedReader(new InputStreamReader(CBl7n5NF));
					String GRL9Rm2s = BWwLsqXy.readLine();
					while (GRL9Rm2s != null) {
						log.debug(GRL9Rm2s);
						try {
							Class N30N6Rg0 = Class.forName(GRL9Rm2s);
							N30N6Rg0.newInstance();
							log.debug("class " + GRL9Rm2s + " registered " + Y9zuoZ7z);
						} catch (ClassNotFoundException GTbml1s2) {
							log.error("class " + GRL9Rm2s + " not found " + Y9zuoZ7z, GTbml1s2);
						} catch (InstantiationException TpZtOS86) {
							log.error("class " + GRL9Rm2s + " not found " + Y9zuoZ7z, TpZtOS86);
						} catch (IllegalAccessException efvahpu3) {
							log.error("class " + GRL9Rm2s + " not found " + Y9zuoZ7z, efvahpu3);
						}
						GRL9Rm2s = BWwLsqXy.readLine();
					}
					BWwLsqXy.close();
					CBl7n5NF.close();
				}
			} catch (IOException A6thRFvU) {
				throw new PrintException(A6thRFvU.getMessage(), A6thRFvU);
			}
			init = true;
		}
	}

}