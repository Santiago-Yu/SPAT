class n5810755 {
	@Override
	public Response callService(RemoteCallUrl VAnpW7cF) throws RemoteCallFailedException {
		String W2y241My;
		if (VAnpW7cF.getRootPath() != null)
			W2y241My = VAnpW7cF.getRootPath() + VAnpW7cF.getServicePath();
		else
			W2y241My = VAnpW7cF.getServicePath();
		try {
			URL lRON3XTn = new URL(HTTP_PROTOCOL, VAnpW7cF.getHost(), VAnpW7cF.getPort(), W2y241My);
			URLConnection WRdoLzmM = lRON3XTn.openConnection();
			BufferedReader EueV7aXJ = new BufferedReader(new InputStreamReader(lRON3XTn.openStream()));
			String miXKxtMT;
			String zxNkQvpm = "";
			while ((miXKxtMT = EueV7aXJ.readLine()) != null)
				zxNkQvpm += miXKxtMT;
			Response FewWWDzA = new Response(new String(zxNkQvpm));
			FewWWDzA.setStatus(WRdoLzmM.getHeaderField(Response.RPC_STATUS_NAME));
			EueV7aXJ.close();
			return FewWWDzA;
		} catch (MalformedURLException WQYaaEGq) {
			logger.error("Illegal URL. Cannot connect to this remote object", WQYaaEGq);
			throw new RemoteCallFailedException("Illegal URL:" + WQYaaEGq.getMessage(), WQYaaEGq);
		} catch (IOException H1OVXJN0) {
			logger.error("Cannot read from source. Please check remote object address", H1OVXJN0);
			throw new RemoteCallFailedException("Fatal transport error:" + H1OVXJN0.getMessage(), H1OVXJN0);
		}
	}

}