class n11026476 {
	public Object invoke(Invocation JzLdZGSl) throws Throwable {
		SmartRef XndHCRbP = (SmartRef) JzLdZGSl.getValue(Invocation.SMARTREF);
		HttpURLConnection iZjzmqEd = null;
		ObjectOutputStream KZhjb4Ma = null;
		URL FIzSFfRY = null;
		try {
			FIzSFfRY = new URL(XndHCRbP.getProperties().getProperty("org.smartcc.connector.url"));
			FIzSFfRY = new URL(FIzSFfRY, XndHCRbP.getLookup());
			iZjzmqEd = (HttpURLConnection) FIzSFfRY.openConnection();
			iZjzmqEd.setRequestProperty("Content-Type", "application/octet-stream");
			iZjzmqEd.setDoOutput(true);
			iZjzmqEd.setDoInput(true);
			iZjzmqEd.setUseCaches(false);
			KZhjb4Ma = new ObjectOutputStream(iZjzmqEd.getOutputStream());
			KZhjb4Ma.writeObject(JzLdZGSl);
			KZhjb4Ma.flush();
		} catch (ObjectStreamException yDxktSgJ) {
			System.err.println("error: during serialization");
			throw new EJBException("error: during serialization", yDxktSgJ);
		} catch (IOException EkqsAQqY) {
			System.err.println("error: could not connect to " + FIzSFfRY);
			throw new ConnectIOException("could not connect to " + FIzSFfRY, EkqsAQqY);
		} finally {
			try {
				KZhjb4Ma.close();
			} catch (Exception GeNAwWwg) {
			}
		}
		boolean kzQwTjZP = false;
		Object Xt14dhjB = null;
		ObjectInputStream wgoRBrkx = null;
		try {
			wgoRBrkx = new ObjectInputStream(iZjzmqEd.getInputStream());
			kzQwTjZP = wgoRBrkx.readBoolean();
			if (kzQwTjZP || !JzLdZGSl.getMethod().getReturnType().equals(void.class))
				Xt14dhjB = wgoRBrkx.readObject();
		} catch (ObjectStreamException UE6Ik9mw) {
			System.err.println("error: during deserialization");
			throw new EJBException("error: during deserialization", UE6Ik9mw);
		} catch (IOException iOHyD0ez) {
			System.err.println("error: could not connect to " + FIzSFfRY);
			throw new ConnectIOException("could not connect to " + FIzSFfRY, iOHyD0ez);
		} finally {
			try {
				wgoRBrkx.close();
			} catch (Exception uAVPQJt0) {
			}
		}
		if (kzQwTjZP)
			throw (Throwable) Xt14dhjB;
		return Xt14dhjB;
	}

}