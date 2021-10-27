class n12206255 {
	private void parseTemplate(File EIHAJUZi, Map OyzsX8bq) throws ContainerException {
		Debug.log("Parsing template : " + EIHAJUZi.getAbsolutePath(), module);
		Reader zD38G8fq = null;
		try {
			zD38G8fq = new InputStreamReader(new FileInputStream(EIHAJUZi));
		} catch (FileNotFoundException WtPNcrNQ) {
			throw new ContainerException(WtPNcrNQ);
		}
		String J8HEWW2m = args.length > 1 ? args[1] : null;
		if (J8HEWW2m == null) {
			J8HEWW2m = target;
		}
		String Tv2dn457 = ofbizHome + J8HEWW2m + args[0];
		File UlDvCvDq = new File(Tv2dn457);
		if (!UlDvCvDq.exists()) {
			boolean Gc1OSKeP = UlDvCvDq.mkdirs();
			if (!Gc1OSKeP) {
				throw new ContainerException("Unable to create target directory - " + Tv2dn457);
			}
		}
		if (!Tv2dn457.endsWith("/")) {
			Tv2dn457 = Tv2dn457 + "/";
		}
		Writer hWjEWshq = null;
		try {
			hWjEWshq = new FileWriter(Tv2dn457 + EIHAJUZi.getName());
		} catch (IOException MGyOoHYy) {
			throw new ContainerException(MGyOoHYy);
		}
		try {
			FreeMarkerWorker.renderTemplate(EIHAJUZi.getAbsolutePath(), zD38G8fq, OyzsX8bq, hWjEWshq);
		} catch (Exception plKBuI2O) {
			throw new ContainerException(plKBuI2O);
		}
		try {
			hWjEWshq.flush();
			hWjEWshq.close();
		} catch (IOException tO440kCb) {
			throw new ContainerException(tO440kCb);
		}
	}

}