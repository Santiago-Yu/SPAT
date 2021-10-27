class n5725177 {
	@Override
	protected <T> T execute(final HttpMethod WloswZZM, final String HVHFCt1n, Parameters jY1Qls1m,
			final Handler<T> LAv5BKDN) throws FoursquareException {
		HttpURLConnection AoYNkPwr = null;
		try {
			switch (WloswZZM) {
			case GET:
				AoYNkPwr = openConnection(HVHFCt1n.concat("?").concat(formEncode(jY1Qls1m)));
				AoYNkPwr.setRequestMethod("GET");
				AoYNkPwr.connect();
				break;
			case POST:
				AoYNkPwr = openConnection(HVHFCt1n);
				AoYNkPwr.setRequestMethod("POST");
				AoYNkPwr.setDoOutput(true);
				AoYNkPwr.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				AoYNkPwr.connect();
				final OutputStream tOfBI3VX = AoYNkPwr.getOutputStream();
				tOfBI3VX.write(formEncode(jY1Qls1m).getBytes());
				tOfBI3VX.flush();
				tOfBI3VX.close();
				break;
			}
			final int enX12vT7 = AoYNkPwr.getResponseCode();
			if (enX12vT7 / 100 != 2) {
				final Error HDLU71a8 = parseBody(AoYNkPwr.getErrorStream(), new ErrorHandler());
				if (HDLU71a8 == null)
					throw new FoursquareException(AoYNkPwr.getResponseMessage());
				else if ("error".equals(HDLU71a8.getType()))
					throw new FoursquareException(HDLU71a8.getMessage());
				else if ("unauthorized".equals(HDLU71a8.getType()))
					throw new AuthenticationException(HDLU71a8.getMessage());
				else if ("ratelimited".equals(HDLU71a8.getType()))
					throw new RateLimitingException(HDLU71a8.getMessage());
				else
					throw new FoursquareException(AoYNkPwr.getResponseMessage());
			}
			return parseBody(AoYNkPwr.getInputStream(), LAv5BKDN);
		} catch (final IOException N5xHjVZO) {
			throw new FoursquareException(N5xHjVZO);
		} catch (final ParserConfigurationException hbvVCfLq) {
			throw new FoursquareException(hbvVCfLq);
		} catch (final SAXException xSpNq8D6) {
			throw new FoursquareException(xSpNq8D6);
		} finally {
			if (AoYNkPwr != null)
				AoYNkPwr.disconnect();
		}
	}

}