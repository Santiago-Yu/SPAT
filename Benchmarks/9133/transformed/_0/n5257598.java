class n5257598 {
	public static int proxy(java.net.URI w6O0RUgX, HttpServletRequest I2ebMAXZ, HttpServletResponse qXVUzqc5)
			throws IOException {
		final HostConfiguration VvlAL1X2 = new HostConfiguration();
		VvlAL1X2.setHost(w6O0RUgX.getHost());
		HttpMethodBase G2817fXo = null;
		if (HttpRpcServer.METHOD_GET.equalsIgnoreCase(I2ebMAXZ.getMethod())) {
			G2817fXo = new GetMethod(w6O0RUgX.toString());
			G2817fXo.setFollowRedirects(true);
		} else if (HttpRpcServer.METHOD_POST.equalsIgnoreCase(I2ebMAXZ.getMethod())) {
			G2817fXo = new PostMethod(w6O0RUgX.toString());
			final Enumeration t7PVqvCK = I2ebMAXZ.getParameterNames();
			if (t7PVqvCK != null)
				while (t7PVqvCK.hasMoreElements()) {
					final String qD9d3GpS = (String) t7PVqvCK.nextElement();
					for (String WZMWV8Ei : I2ebMAXZ.getParameterValues(qD9d3GpS))
						((PostMethod) G2817fXo).addParameter(qD9d3GpS, WZMWV8Ei);
				}
			((PostMethod) G2817fXo).setRequestEntity(new InputStreamRequestEntity(I2ebMAXZ.getInputStream()));
		}
		if (G2817fXo == null)
			throw new IllegalArgumentException("Unsupported http request method");
		final int wTOF1vTn;
		final Enumeration C0YFaEdI = I2ebMAXZ.getHeaderNames();
		if (C0YFaEdI != null)
			while (C0YFaEdI.hasMoreElements()) {
				final String TZf17oQh = (String) C0YFaEdI.nextElement();
				final Enumeration sLQwcYcL = I2ebMAXZ.getHeaders(TZf17oQh);
				while (sLQwcYcL.hasMoreElements()) {
					G2817fXo.setRequestHeader(TZf17oQh, (String) sLQwcYcL.nextElement());
				}
			}
		final HttpState BJjpxOgs = new HttpState();
		if (I2ebMAXZ.getCookies() != null)
			for (Cookie dKVlh6GX : I2ebMAXZ.getCookies()) {
				String bGeyG5OZ = I2ebMAXZ.getHeader("Host");
				if (StringUtils.isEmpty(dKVlh6GX.getDomain()))
					dKVlh6GX.setDomain(
							StringUtils.isEmpty(bGeyG5OZ) ? I2ebMAXZ.getServerName() + ":" + I2ebMAXZ.getServerPort()
									: bGeyG5OZ);
				if (StringUtils.isEmpty(dKVlh6GX.getPath()))
					dKVlh6GX.setPath("/");
				BJjpxOgs.addCookie(new org.apache.commons.httpclient.Cookie(dKVlh6GX.getDomain(), dKVlh6GX.getName(),
						dKVlh6GX.getValue(), dKVlh6GX.getPath(), dKVlh6GX.getMaxAge(), dKVlh6GX.getSecure()));
			}
		G2817fXo.setQueryString(I2ebMAXZ.getQueryString());
		wTOF1vTn = (new HttpClient()).executeMethod(VvlAL1X2, G2817fXo, BJjpxOgs);
		if (wTOF1vTn < 0) {
			G2817fXo.releaseConnection();
			return wTOF1vTn;
		}
		if (G2817fXo.getResponseHeaders() != null)
			for (Header b8H1XwmM : G2817fXo.getResponseHeaders())
				qXVUzqc5.setHeader(b8H1XwmM.getName(), b8H1XwmM.getValue());
		final InputStream LKfYQJcM = G2817fXo.getResponseBodyAsStream();
		final OutputStream uyzE2tCl = qXVUzqc5.getOutputStream();
		IOUtils.copy(LKfYQJcM, uyzE2tCl);
		uyzE2tCl.flush();
		uyzE2tCl.close();
		LKfYQJcM.close();
		G2817fXo.releaseConnection();
		return wTOF1vTn;
	}

}