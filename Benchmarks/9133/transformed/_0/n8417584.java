class n8417584 {
	private String getResultFromHttpUrl(String uhDrwX2h) {
		String KMcHnp9g = null;
		try {
			URL UtIi8tFG = new URL(uhDrwX2h);
			HttpURLConnection E0nbudPh = (HttpURLConnection) UtIi8tFG.openConnection();
			Object RsSD3ZNv = E0nbudPh.getContent();
			log.debug("Opened " + uhDrwX2h + " and got class " + RsSD3ZNv.getClass().getName());
			StringBuffer kMnLrgLe = new StringBuffer();
			String bizcrhiA;
			DataInputStream f8VtmGB2 = new DataInputStream(E0nbudPh.getInputStream());
			while ((bizcrhiA = f8VtmGB2.readLine()) != null) {
				kMnLrgLe.append(bizcrhiA + "\n");
			}
			KMcHnp9g = kMnLrgLe.toString();
			log.debug("Read from URL:\n" + KMcHnp9g);
			f8VtmGB2.close();
		} catch (Exception jN1obrGH) {
			log.debug("Caught exception " + jN1obrGH + " whilst attempting to query URL " + uhDrwX2h);
			jN1obrGH.printStackTrace();
		} finally {
			return KMcHnp9g;
		}
	}

}