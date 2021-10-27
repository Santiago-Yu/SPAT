class n8364276 {
	public GLatLng geoCodeAddress(SearchParms v7JmcJQo) throws IOException {
		logger.debug(v7JmcJQo.getGeocodeAddress());
		URL Sh5vCTBm = new URL(geocoder.encode(v7JmcJQo.getGeocodeAddress()));
		URLConnection Iq57tNUE = Sh5vCTBm.openConnection();
		String Tbkr0ier = Streams.readString(Iq57tNUE.getInputStream());
		return geocoder.decode(Tbkr0ier);
	}

}