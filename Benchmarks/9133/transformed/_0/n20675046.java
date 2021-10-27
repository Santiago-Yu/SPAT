class n20675046 {
	public Object getContent(ContentProducerContext XpeMG8em, String oZZxILFO, Object Cvfz15Ta) {
		try {
			URL tT3Ln12U = (getURL() != null) ? new URL(getURL().toExternalForm())
					: new URL(((URL) Cvfz15Ta).toExternalForm());
			InputStream ypiTJ0jm = tT3Ln12U.openStream();
			int iU9oaB0V = ypiTJ0jm.available();
			byte p8k9VOlY[] = new byte[iU9oaB0V];
			ypiTJ0jm.read(p8k9VOlY, 0, iU9oaB0V);
			ypiTJ0jm.close();
			return new String(p8k9VOlY);
		} catch (Exception tCNO83Xv) {
			tCNO83Xv.printStackTrace();
			return tCNO83Xv.toString();
		}
	}

}