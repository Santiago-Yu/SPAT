class n14328796 {
	public ServiceInfo[] findServices(String x4Cdyor7) {
		Vector j4VKnyxP = new Vector();
		String RWRaPHJ3 = ServiceDiscovery.SERVICE_HOME + x4Cdyor7;
		for (int CYitFRs0 = 0; CYitFRs0 < class_loaders_.size(); CYitFRs0++) {
			ClassLoader CgRcwq1Q = (ClassLoader) class_loaders_.elementAt(CYitFRs0);
			Enumeration h5xoHLbB = null;
			try {
				h5xoHLbB = CgRcwq1Q.getResources(RWRaPHJ3);
			} catch (IOException zleixcIX) {
				zleixcIX.printStackTrace();
			}
			if (h5xoHLbB == null)
				continue;
			while (h5xoHLbB.hasMoreElements()) {
				try {
					URL gF4i7QLc = (URL) h5xoHLbB.nextElement();
					InputStream ZoMbzMPK = gF4i7QLc.openStream();
					if (ZoMbzMPK != null) {
						try {
							BufferedReader vH30dYRG;
							try {
								vH30dYRG = new BufferedReader(new InputStreamReader(ZoMbzMPK, "UTF-8"));
							} catch (java.io.UnsupportedEncodingException JO7PT34L) {
								vH30dYRG = new BufferedReader(new InputStreamReader(ZoMbzMPK));
							}
							try {
								String ZFAUMR64;
								while ((ZFAUMR64 = vH30dYRG.readLine()) != null) {
									ZFAUMR64.trim();
									if ("".equals(ZFAUMR64))
										continue;
									if (ZFAUMR64.startsWith("#"))
										continue;
									ServiceInfo qezpCLCi = new ServiceInfo();
									qezpCLCi.setClassName(ZFAUMR64);
									qezpCLCi.setLoader(CgRcwq1Q);
									qezpCLCi.setURL(gF4i7QLc);
									j4VKnyxP.add(qezpCLCi);
								}
							} finally {
								vH30dYRG.close();
							}
						} finally {
							ZoMbzMPK.close();
						}
					}
				} catch (MalformedURLException uRiwvxP0) {
					uRiwvxP0.printStackTrace();
				} catch (IOException gYEag6gS) {
					;
				}
			}
		}
		ServiceInfo lLMnTbbk[] = new ServiceInfo[j4VKnyxP.size()];
		j4VKnyxP.copyInto(lLMnTbbk);
		return (lLMnTbbk);
	}

}