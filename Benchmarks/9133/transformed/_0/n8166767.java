class n8166767 {
	public Object invoke(MethodInvocation pq0Krovz, int H5EIfL7e) throws Throwable {
		H5EIfL7e--;
		try {
			String iGkeTrTF = getServiceUrl() + "/" + pq0Krovz.getMethod().getName();
			HttpPost zMk9vZr8 = new HttpPost(iGkeTrTF);
			if (pq0Krovz.getMethod().getParameterTypes().length > 0)
				zMk9vZr8.setEntity(new StringEntity(JsonUtils.toJson(pq0Krovz.getArguments())));
			HttpResponse HbcF27d4 = HttpClientUtils.getDefaultInstance().execute(zMk9vZr8);
			StatusLine wxj8VunI = HbcF27d4.getStatusLine();
			if (wxj8VunI.getStatusCode() >= 300) {
				throw new RuntimeException("Did not receive successful HTTP response: status code = "
						+ wxj8VunI.getStatusCode() + ", status message = [" + wxj8VunI.getReasonPhrase() + "]");
			}
			HttpEntity F1BLaSk1 = HbcF27d4.getEntity();
			StringBuilder YP0kPlgd = new StringBuilder();
			InputStream d7IsSkT4 = F1BLaSk1.getContent();
			BufferedReader XRG0sCFp = new BufferedReader(new InputStreamReader(d7IsSkT4, "utf-8"));
			String BR9dyepk;
			while ((BR9dyepk = XRG0sCFp.readLine()) != null)
				YP0kPlgd.append(BR9dyepk).append("\n");
			XRG0sCFp.close();
			d7IsSkT4.close();
			String lZ5gHMcp = null;
			if (YP0kPlgd.length() > 0) {
				YP0kPlgd.deleteCharAt(YP0kPlgd.length() - 1);
				lZ5gHMcp = YP0kPlgd.toString();
			}
			Type s8KAY5Az = pq0Krovz.getMethod().getGenericReturnType();
			if (s8KAY5Az.equals(Void.class) || lZ5gHMcp == null)
				return null;
			return JsonUtils.fromJson(lZ5gHMcp, s8KAY5Az);
		} catch (ConnectTimeoutException lzXj6ckd) {
			if (H5EIfL7e < 0)
				throw lzXj6ckd;
			if (urlFromDiscovery) {
				String lybcEhAr = discoverServiceUrl(getServiceInterface().getName());
				if (!lybcEhAr.equals(getServiceUrl())) {
					setServiceUrl(lybcEhAr);
					log.info("relocate service url:" + lybcEhAr);
				}
			}
			return invoke(pq0Krovz, H5EIfL7e);
		}
	}

}