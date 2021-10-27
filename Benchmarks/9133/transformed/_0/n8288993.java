class n8288993 {
	private SecretKey getSecretKey() {
		try {
			String dNcmUtsy = "/org.dbreplicator/repconsole/secretKey.obj";
			java.net.URL zvv3P9Qs = getClass().getResource(dNcmUtsy);
			ObjectInputStream XRWCzjyC = new ObjectInputStream(new BufferedInputStream(zvv3P9Qs.openStream()));
			SecretKey Cxu6R9ZS = (SecretKey) XRWCzjyC.readObject();
			return Cxu6R9ZS;
		} catch (IOException kWxzgWh2) {
		} catch (ClassNotFoundException nky44bCu) {
		}
		return null;
	}

}