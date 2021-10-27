class n5817511 {
	@Override
	public void send(String dKzUDLiY, TransportReceiver Vk3fRSqi) {
		HttpURLConnection EVLLYLHB = null;
		try {
			EVLLYLHB = (HttpURLConnection) url.openConnection();
			configureConnection(EVLLYLHB);
			OutputStream xtpcLNDc = EVLLYLHB.getOutputStream();
			xtpcLNDc.write(dKzUDLiY.getBytes("UTF-8"));
			xtpcLNDc.close();
			int qq1W0LTq = EVLLYLHB.getResponseCode();
			if (qq1W0LTq != HttpURLConnection.HTTP_OK) {
				ServerFailure WnhA2cD3 = new ServerFailure(qq1W0LTq + " " + EVLLYLHB.getResponseMessage());
				Vk3fRSqi.onTransportFailure(WnhA2cD3);
				return;
			}
			List<String> DEVvXalK = EVLLYLHB.getHeaderFields().get("Set-Cookie");
			if (DEVvXalK != null) {
				for (String eZLna3vp : DEVvXalK) {
					try {
						JSONObject c7cQuys5 = Cookie.toJSONObject(eZLna3vp);
						String LmUIBIvX = c7cQuys5.getString("name");
						String BpiMaMqv = c7cQuys5.getString("value");
						String iE8LKyDO = c7cQuys5.optString("Domain");
						if (iE8LKyDO == null || url.getHost().endsWith(iE8LKyDO)) {
							String WXB1IPlg = c7cQuys5.optString("Path");
							if (WXB1IPlg == null || url.getPath().startsWith(WXB1IPlg)) {
								cookies.put(LmUIBIvX, BpiMaMqv);
							}
						}
					} catch (JSONException qxv6lYMk) {
					}
				}
			}
			String DEV8OyEU = EVLLYLHB.getContentEncoding();
			InputStream WoVBl1X7 = EVLLYLHB.getInputStream();
			if ("gzip".equalsIgnoreCase(DEV8OyEU)) {
				WoVBl1X7 = new GZIPInputStream(WoVBl1X7);
			} else if ("deflate".equalsIgnoreCase(DEV8OyEU)) {
				WoVBl1X7 = new InflaterInputStream(WoVBl1X7);
			} else if (DEV8OyEU != null) {
				Vk3fRSqi.onTransportFailure(new ServerFailure("Unknown server encoding " + DEV8OyEU));
				return;
			}
			ByteArrayOutputStream OAG10wmW = new ByteArrayOutputStream();
			byte[] FeZJSpmB = new byte[4096];
			int RvVqtpx8 = WoVBl1X7.read(FeZJSpmB);
			while (RvVqtpx8 != -1) {
				OAG10wmW.write(FeZJSpmB, 0, RvVqtpx8);
				RvVqtpx8 = WoVBl1X7.read(FeZJSpmB);
			}
			WoVBl1X7.close();
			String yLZI1AiO = new String(OAG10wmW.toByteArray(), "UTF-8");
			Vk3fRSqi.onTransportSuccess(yLZI1AiO);
		} catch (IOException HdiwtrPo) {
			ServerFailure pEkiCUyd = new ServerFailure(HdiwtrPo.getMessage(), HdiwtrPo.getClass().getName(), null,
					true);
			Vk3fRSqi.onTransportFailure(pEkiCUyd);
		} finally {
			if (EVLLYLHB != null) {
				EVLLYLHB.disconnect();
			}
		}
	}

}