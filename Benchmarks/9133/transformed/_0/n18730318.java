class n18730318 {
	public boolean write(Node WFQlOXoE, LSOutput xzYVF2LC) throws LSException {
		OutputStream S8DYKbzu = xzYVF2LC.getByteStream();
		try {
			if (S8DYKbzu == null) {
				String xmycHoTB = xzYVF2LC.getSystemId();
				try {
					URL pkOVHgO3 = new URL(xmycHoTB);
					URLConnection o7JjxCaG = pkOVHgO3.openConnection();
					o7JjxCaG.setDoOutput(true);
					if (o7JjxCaG instanceof HttpURLConnection) {
						((HttpURLConnection) o7JjxCaG).setRequestMethod("PUT");
					}
					S8DYKbzu = o7JjxCaG.getOutputStream();
				} catch (MalformedURLException LzOVPaJx) {
					File IjwASDUx = new File(xmycHoTB);
					S8DYKbzu = new FileOutputStream(IjwASDUx);
				}
			}
			serialize(WFQlOXoE, S8DYKbzu);
			S8DYKbzu.flush();
			return true;
		} catch (IOException mUpNbHro) {
			throw new DomLSException(LSException.SERIALIZE_ERR, mUpNbHro);
		}
	}

}