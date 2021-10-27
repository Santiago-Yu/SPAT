class n10231476 {
	protected Document SendRequest(Document u1i66DQX) throws WsmanException {
		HttpURLConnection NChGkLz0 = null;
		Document kKPg92HR = null;
		stampRequest(u1i66DQX);
		boolean DeUVhIq3 = System.getProperty("intel.management.wsman.debug", "false").equals("true");
		int hy7PziNL = 2;
		while (hy7PziNL > 0) {
			try {
				if (NChGkLz0 != null) {
					NChGkLz0.disconnect();
				}
				URL dQCF3XVo = new URL((String) properties.get("Address"));
				Proxy kx5d4jMn = (Proxy) properties.get("HttpProxy");
				if (kx5d4jMn != null)
					NChGkLz0 = (HttpURLConnection) dQCF3XVo.openConnection(kx5d4jMn);
				else
					NChGkLz0 = (HttpURLConnection) dQCF3XVo.openConnection();
				if (NChGkLz0 instanceof HttpsURLConnection) {
					HttpsURLConnection wme6Ntqz = (HttpsURLConnection) NChGkLz0;
					SSLSocketFactory CC3BntZx = (SSLSocketFactory) properties.get("SSLSocketFactory");
					X509TrustManager uyZz1Iea = (X509TrustManager) properties.get("X509TrustManager");
					HostnameVerifier GZK18R99 = (HostnameVerifier) properties.get("HostnameVerifier");
					X509KeyManager HDOIJJNc = (X509KeyManager) properties.get("X509KeyManager");
					if (CC3BntZx == null && (HDOIJJNc != null || uyZz1Iea != null)) {
						X509KeyManager[] pmX4Qhzo = null;
						X509TrustManager[] lszbS14Y = null;
						SSLContext ZFj0EbEI = SSLContext.getInstance("SSL");
						if (HDOIJJNc != null) {
							pmX4Qhzo = new X509KeyManager[1];
							pmX4Qhzo[0] = HDOIJJNc;
						}
						if (uyZz1Iea != null) {
							lszbS14Y = new X509TrustManager[1];
							lszbS14Y[0] = uyZz1Iea;
						}
						ZFj0EbEI.init(pmX4Qhzo, lszbS14Y, null);
						CC3BntZx = ZFj0EbEI.getSocketFactory();
						properties.put("SSLSocketFactory", CC3BntZx);
					}
					if (CC3BntZx != null)
						wme6Ntqz.setSSLSocketFactory(CC3BntZx);
					if (GZK18R99 != null)
						wme6Ntqz.setHostnameVerifier(GZK18R99);
				}
				Object PXQaIH26 = properties.get("AuthScheme");
				if (PXQaIH26 != null && PXQaIH26.equals("kerberos")) {
					Oid J1cDUDd5 = new Oid("1.3.6.1.5.5.2");
					GSSManager JcQb0pWn = org.ietf.jgss.GSSManager.getInstance();
					String F8uvtIQB = "HTTP/" + dQCF3XVo.getHost();
					int uKFluqFH = dQCF3XVo.getPort();
					if (uKFluqFH == 16992 || uKFluqFH == 16993 || uKFluqFH == 623 || uKFluqFH == 624) {
						F8uvtIQB = F8uvtIQB + ":" + Integer.toString(uKFluqFH);
					}
					GSSName LeGtq80g = JcQb0pWn.createName(F8uvtIQB, null);
					GSSContext x8plgB2f = JcQb0pWn.createContext(LeGtq80g, J1cDUDd5, null,
							GSSCredential.DEFAULT_LIFETIME);
					x8plgB2f.requestCredDeleg(true);
					byte[] U1CQyRD7 = new byte[0];
					U1CQyRD7 = x8plgB2f.initSecContext(U1CQyRD7, 0, U1CQyRD7.length);
					String WTaJvdml = WsmanUtils.getBase64String(U1CQyRD7);
					NChGkLz0.addRequestProperty("Authorization", "Negotiate " + WTaJvdml);
				} else if (PXQaIH26 != null && PXQaIH26.equals("basic")) {
					java.net.Authenticator.requestPasswordAuthentication(dQCF3XVo.getHost(), null, dQCF3XVo.getPort(),
							dQCF3XVo.getProtocol(), "", "basic");
					String AkitwBUW = "";
					NChGkLz0.addRequestProperty("Authorization", "Basic " + AkitwBUW);
				}
				NChGkLz0.setRequestMethod("POST");
				NChGkLz0.addRequestProperty("Content-Type", "application/soap+xml;charset=UTF-8");
				NChGkLz0.setDoOutput(true);
				if (DeUVhIq3)
					System.out.println(getXmlLoader().formatDocument(u1i66DQX));
				getXmlLoader().saveDocument(u1i66DQX, NChGkLz0.getOutputStream());
				InputStream Y9zkzUpJ = NChGkLz0.getInputStream();
				kKPg92HR = getXmlLoader().loadDocument(Y9zkzUpJ);
				if (DeUVhIq3) {
					System.out.println(getXmlLoader().formatDocument(kKPg92HR));
				}
				NChGkLz0.getResponseCode();
				hy7PziNL = 0;
				NChGkLz0.disconnect();
				NChGkLz0 = null;
			} catch (IOException oE903KGy) {
				hy7PziNL--;
				int CR4iFvAF = NChGkLz0.getHeaderFields().size();
				for (int IcZnJL8J = 0; IcZnJL8J < CR4iFvAF; IcZnJL8J++) {
					String dBe7Hw2G = NChGkLz0.getHeaderField(IcZnJL8J);
					dBe7Hw2G.toString();
				}
				NChGkLz0.getRequestProperty("Authorization");
				NChGkLz0.getHeaderField("Authorization");
				Object So0KUUCM = getResponse(NChGkLz0);
				if (So0KUUCM != null && So0KUUCM instanceof Document) {
					kKPg92HR = (Document) So0KUUCM;
					hy7PziNL = 0;
					throw new WsmanException(this, kKPg92HR);
				} else if (So0KUUCM != null)
					throw new WsmanException(oE903KGy);
				if (hy7PziNL == 0)
					throw new WsmanException(oE903KGy);
			} catch (Exception y7OO0YHw) {
				hy7PziNL = 0;
				throw new WsmanException(y7OO0YHw);
			}
		}
		return kKPg92HR;
	}

}