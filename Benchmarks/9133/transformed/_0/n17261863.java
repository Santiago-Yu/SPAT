class n17261863 {
	@Override
	public void parse() throws IOException {
		URL OcjT6vrR = new URL(getDataUrl());
		URLConnection SaDi0Pn2 = OcjT6vrR.openConnection();
		BufferedReader F1s3Unoa = new BufferedReader(new InputStreamReader(SaDi0Pn2.getInputStream()));
		String XYESiShU = F1s3Unoa.readLine();
		String[] dmsUj89k = XYESiShU.split("</html>");
		dmsUj89k = dmsUj89k[1].split("<br>");
		for (String p7sbrGC1 : dmsUj89k) {
			String[] oHe1HVPb = p7sbrGC1.split(";");
			CurrencyUnit FnD8G6tk = new CurrencyUnit(oHe1HVPb[4], Float.valueOf(oHe1HVPb[9]),
					Integer.valueOf(oHe1HVPb[5]));
			this.set.add(FnD8G6tk);
		}
	}

}