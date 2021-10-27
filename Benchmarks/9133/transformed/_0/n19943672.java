class n19943672 {
	public void delete(URI Y8kEXdhr, Map<?, ?> maxOloCI) throws IOException {
		try {
			URL NXOarCLB = new URL(Y8kEXdhr.toString());
			URLConnection ftY3oyFW = NXOarCLB.openConnection();
			ftY3oyFW.setDoOutput(true);
			if (ftY3oyFW instanceof HttpURLConnection) {
				final HttpURLConnection N6sHuN1M = (HttpURLConnection) ftY3oyFW;
				N6sHuN1M.setRequestMethod("DELETE");
				int o2dNGUTI = N6sHuN1M.getResponseCode();
				switch (o2dNGUTI) {
				case HttpURLConnection.HTTP_OK:
				case HttpURLConnection.HTTP_ACCEPTED:
				case HttpURLConnection.HTTP_NO_CONTENT: {
					break;
				}
				default: {
					throw new IOException("DELETE failed with HTTP response code " + o2dNGUTI);
				}
				}
			} else {
				throw new IOException("Delete is not supported for " + Y8kEXdhr);
			}
		} catch (RuntimeException DTGLCufG) {
			throw new Resource.IOWrappedException(DTGLCufG);
		}
	}

}