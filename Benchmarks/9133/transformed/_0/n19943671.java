class n19943671 {
	public InputStream createInputStream(URI tOMw7J3D, Map<?, ?> MO6I5hoH) throws IOException {
		try {
			URL vIs0QOto = new URL(tOMw7J3D.toString());
			final URLConnection sfoVcpsc = vIs0QOto.openConnection();
			InputStream DrwbzUKv = sfoVcpsc.getInputStream();
			Map<Object, Object> Z5BNveRq = getResponse(MO6I5hoH);
			if (Z5BNveRq != null) {
				Z5BNveRq.put(URIConverter.RESPONSE_TIME_STAMP_PROPERTY, sfoVcpsc.getLastModified());
			}
			return DrwbzUKv;
		} catch (RuntimeException oq4UaT68) {
			throw new Resource.IOWrappedException(oq4UaT68);
		}
	}

}