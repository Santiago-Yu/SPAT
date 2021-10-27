class n5620476 {
	private String[] verifyConnection(Socket rWZA0qR9) throws Exception {
		List<String> U2BVeaIT = new ArrayList<String>();
		InputStream pHU8zYOW = rWZA0qR9.getInputStream();
		BufferedReader FCZUtr2E = new BufferedReader(new InputStreamReader(pHU8zYOW));
		StringTokenizer HGXtIT2Z = new StringTokenizer(FCZUtr2E.readLine());
		if (!HGXtIT2Z.hasMoreTokens()) {
			throw new IllegalArgumentException("There's no method token in this connection");
		}
		String buUOxFRw = HGXtIT2Z.nextToken();
		if (!HGXtIT2Z.hasMoreTokens()) {
			throw new IllegalArgumentException("There's no URI token in this connection");
		}
		String UofN3i7I = decodePercent(HGXtIT2Z.nextToken());
		if (!HGXtIT2Z.hasMoreTokens()) {
			throw new IllegalArgumentException("There's no version token in this connection");
		}
		String ywFFawRq = HGXtIT2Z.nextToken();
		Properties FBV3fq31 = new Properties();
		int U6yAyP5I = UofN3i7I.indexOf('?');
		if (U6yAyP5I >= 0) {
			decodeParms(UofN3i7I.substring(U6yAyP5I + 1), FBV3fq31);
			UofN3i7I = decodePercent(UofN3i7I.substring(0, U6yAyP5I));
		}
		String ji85XPGy = "";
		if (FBV3fq31.size() > 0) {
			ji85XPGy = "?";
			for (Object DWm9v0od : FBV3fq31.keySet()) {
				ji85XPGy = ji85XPGy + DWm9v0od + "=" + FBV3fq31.getProperty(((String) DWm9v0od)) + "&";
			}
			ji85XPGy = ji85XPGy.substring(0, ji85XPGy.length() - 1).replace(" ", "%20");
		}
		logger.debug("HTTP Request: " + buUOxFRw + " " + UofN3i7I + ji85XPGy + " " + ywFFawRq);
		U2BVeaIT.add(buUOxFRw + " " + UofN3i7I + ji85XPGy + " " + ywFFawRq);
		Properties mUHUgLqV = new Properties();
		String gE3IVr3b;
		String bdefjL3n = null;
		Stack<String> Nx1ZYTLK = new Stack<String>();
		boolean UCYeNGfc = false;
		String HyLgaMCK = "";
		while (FCZUtr2E.ready() && (gE3IVr3b = FCZUtr2E.readLine()) != null) {
			if (gE3IVr3b.equals("")
					&& (mUHUgLqV.get("Content-Type") == null || mUHUgLqV.get("Content-Length") == null)) {
				break;
			}
			logger.debug("HTTP Request Header: " + gE3IVr3b);
			if (gE3IVr3b.contains(": ")) {
				String FEKrz9js[] = gE3IVr3b.split(": ");
				mUHUgLqV.put(FEKrz9js[0].trim(), FEKrz9js[1].trim());
			}
			if (!UCYeNGfc && gE3IVr3b.contains(": ")) {
				if (gE3IVr3b.contains("boundary=")) {
					bdefjL3n = gE3IVr3b.split("boundary=")[1].trim();
					Nx1ZYTLK.push("--" + bdefjL3n);
				}
				continue;
			} else if (gE3IVr3b.equals("") && Nx1ZYTLK.isEmpty()) {
				int SaTThpf3 = Integer.parseInt((String) mUHUgLqV.get("Content-Length"));
				if (mUHUgLqV.getProperty("Content-Type").contains("x-www-form-urlencoded")) {
					char E5vFRwjy[] = new char[SaTThpf3];
					int xoNOUB1i = FCZUtr2E.read(E5vFRwjy);
					gE3IVr3b = String.valueOf(E5vFRwjy, 0, xoNOUB1i);
					HyLgaMCK = gE3IVr3b;
					logger.debug("HTTP Request Header Form Parameters: " + gE3IVr3b);
				}
			} else if (gE3IVr3b.equals(Nx1ZYTLK.peek()) && !UCYeNGfc) {
				UCYeNGfc = true;
			} else if (gE3IVr3b.equals(Nx1ZYTLK.peek()) && UCYeNGfc) {
				UCYeNGfc = false;
			} else if (gE3IVr3b.contains(": ") && UCYeNGfc) {
				if (buUOxFRw.equalsIgnoreCase("PUT")) {
					if (gE3IVr3b.contains("form-data; ")) {
						String eferrsAo = gE3IVr3b.split("form-data; ")[1];
						for (String rfeDVMyM : eferrsAo.replace("\"", "").split("; ")) {
							String[] PY3k9L01 = rfeDVMyM.split("=");
							PY3k9L01[0] = decodePercent(PY3k9L01[0]);
							PY3k9L01[1] = decodePercent(PY3k9L01[1]);
							mUHUgLqV.put(PY3k9L01[0], PY3k9L01[1]);
						}
					}
				}
			} else if (gE3IVr3b.contains("") && UCYeNGfc && !Nx1ZYTLK.isEmpty() && mUHUgLqV.get("filename") != null) {
				int jqotIk90 = Integer.parseInt(mUHUgLqV.getProperty("Content-Length"));
				if (mUHUgLqV.getProperty("Content-Transfer-Encoding").contains("binary")) {
					File yBLoNwOc = new File(VOctopusConfigurationManager.WebServerProperties.HTTPD_CONF
							.getPropertyValue("TempDirectory"));
					if (!yBLoNwOc.exists()) {
						logger.error("Temporaty dir does not exist: " + yBLoNwOc.getCanonicalPath());
					}
					if (!yBLoNwOc.isDirectory()) {
						logger.error("Temporary dir is not a directory: " + yBLoNwOc.getCanonicalPath());
					}
					if (!yBLoNwOc.canWrite()) {
						logger.error("VOctopus Webserver doesn't have permissions to write on temporary dir: "
								+ yBLoNwOc.getCanonicalPath());
					}
					FileOutputStream sw2rxCtl = null;
					try {
						String X2kEZjRW = yBLoNwOc.getAbsolutePath() + "/" + mUHUgLqV.getProperty("filename");
						sw2rxCtl = new FileOutputStream(X2kEZjRW);
						OutputStream TzMisgR7 = new BufferedOutputStream(sw2rxCtl);
						int SkFcfZUP;
						while (FCZUtr2E.ready() && (SkFcfZUP = FCZUtr2E.read()) != -1 && jqotIk90-- > 0) {
							TzMisgR7.write(SkFcfZUP);
						}
					} finally {
						if (sw2rxCtl != null) {
							sw2rxCtl.close();
						}
					}
					File MQDu4eMi = new File(VOctopusConfigurationManager.getInstance().getDocumentRootPath() + UofN3i7I
							+ mUHUgLqV.get("filename"));
					File by4FlyPs = new File(VOctopusConfigurationManager.WebServerProperties.HTTPD_CONF
							.getPropertyValue("TempDirectory") + "/" + mUHUgLqV.get("filename"));
					FileChannel Oq9CTUXC = new FileInputStream(by4FlyPs.getAbsolutePath()).getChannel();
					FileChannel y7QOHb4H = new FileOutputStream(MQDu4eMi.getAbsolutePath()).getChannel();
					Oq9CTUXC.transferTo(0, Oq9CTUXC.size(), y7QOHb4H);
					Oq9CTUXC.close();
					y7QOHb4H.close();
				}
			}
		}
		for (Object JByINrsx : mUHUgLqV.keySet()) {
			U2BVeaIT.add(JByINrsx + ": " + mUHUgLqV.get(JByINrsx));
		}
		if (!HyLgaMCK.equals("")) {
			U2BVeaIT.add("ADDITIONAL" + HyLgaMCK);
		}
		return U2BVeaIT.toArray(new String[U2BVeaIT.size()]);
	}

}