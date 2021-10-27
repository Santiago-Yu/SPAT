class n4281604 {
	private void executeRequest(OperationContext fUAhsD4u) throws java.lang.Throwable {
		long Qkq0AFxH = System.currentTimeMillis();
		DirectoryParams xzlTisJ8 = fUAhsD4u.getRequestOptions().getDirectoryOptions();
		try {
			String yFqY3ZQo = fUAhsD4u.getRequestContext().getApplicationConfiguration().getCatalogConfiguration()
					.getParameters().getValue("openls.directory");
			HashMap<String, String> eaJT7Ihg = xzlTisJ8.getPoiProperties();
			Set<String> c8nDsz8w = eaJT7Ihg.keySet();
			Iterator<String> ecoAioUH = c8nDsz8w.iterator();
			StringBuffer pz9l7gF1 = new StringBuffer();
			while (ecoAioUH.hasNext()) {
				String ALthzIjD = ecoAioUH.next();
				QueryFilter iBcbjm9k = new QueryFilter(ALthzIjD, eaJT7Ihg.get(ALthzIjD));
				pz9l7gF1.append(makePOIRequest(iBcbjm9k));
			}
			String vaB17mgI = yFqY3ZQo + "/query?" + pz9l7gF1.toString();
			LOGGER.info("REQUEST=\n" + vaB17mgI);
			URL y7DWSGiV = new URL(vaB17mgI);
			URLConnection FlRAaiZx = y7DWSGiV.openConnection();
			String zA6jDBRV = "";
			String zxRw62GM = "";
			InputStream NzQwph0o = FlRAaiZx.getInputStream();
			InputStreamReader ZWMr6I32 = new InputStreamReader(NzQwph0o);
			BufferedReader TIezfhaW = new BufferedReader(ZWMr6I32);
			while ((zA6jDBRV = TIezfhaW.readLine()) != null) {
				zxRw62GM += zA6jDBRV;
			}
			TIezfhaW.close();
			y7DWSGiV = null;
			parsePOIResponse(zxRw62GM, xzlTisJ8);
		} catch (Exception xREbPwjW) {
			LOGGER.severe("Throwing exception" + xREbPwjW.getMessage());
			throw xREbPwjW;
		} finally {
			long nyKgsU1Y = System.currentTimeMillis();
			LOGGER.info("PERFORMANCE: " + (nyKgsU1Y - Qkq0AFxH) + " ms spent performing service");
		}
	}

}