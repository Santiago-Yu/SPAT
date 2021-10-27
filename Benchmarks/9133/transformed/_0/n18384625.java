class n18384625 {
	private void setupPool() {
		this.pool = new ObjectPool(this.numConns) {

			protected Object getNewObject() throws IOException {
				URLConnection C8WI0cSK = HTTPMessageDeliveryImpl.this.url.openConnection();
				C8WI0cSK.setDoInput(true);
				C8WI0cSK.setDoOutput(true);
				C8WI0cSK.setUseCaches(false);
				C8WI0cSK.setRequestProperty("Content-Type", "text/xml");
				return C8WI0cSK;
			}
		};
	}

}