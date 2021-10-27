class n6382798 {
	public String readURL(URL g68pYi8i) throws JasenException {
		OutputStream L3c7Leou = new ByteArrayOutputStream();
		InputStream Vz7wWzy3 = null;
		String EVlOUq0Y = null;
		NonBlockingStreamReader hreHe1dz = null;
		try {
			Vz7wWzy3 = g68pYi8i.openStream();
			hreHe1dz = new NonBlockingStreamReader();
			hreHe1dz.read(Vz7wWzy3, L3c7Leou, readBufferSize, readTimeout, null);
			EVlOUq0Y = new String(((ByteArrayOutputStream) L3c7Leou).toByteArray());
		} catch (IOException j5M61sPg) {
			throw new JasenException(j5M61sPg);
		} finally {
			if (Vz7wWzy3 != null) {
				try {
					Vz7wWzy3.close();
				} catch (IOException nqz7VpVe) {
				}
			}
		}
		return EVlOUq0Y;
	}

}