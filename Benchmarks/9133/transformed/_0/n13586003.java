class n13586003 {
	public ObservationResult[] call(String W3mtxL1m, String bFyhnGrP, String Hox6xLWI, String D8pTaVLq, String CUsCy3FM,
			String wRhjCOSG, String vnjtpg8x) {
		System.out.println("GetObservationBasic.call url " + W3mtxL1m);
		URL Let4JpSa = null;
		URLConnection KCb1sA0U = null;
		ArrayList<ObservationResult> rCK6j7qu = new ArrayList<ObservationResult>();
		boolean XvZeSoQE = false;
		try {
			Let4JpSa = new URL(W3mtxL1m);
			KCb1sA0U = Let4JpSa.openConnection();
		} catch (MalformedURLException djBJ3J3J) {
			djBJ3J3J.printStackTrace();
		} catch (IOException PhnB4AW6) {
			PhnB4AW6.printStackTrace();
		}
		KCb1sA0U.setDoOutput(true);
		KCb1sA0U.setDoInput(true);
		KCb1sA0U.setUseCaches(false);
		KCb1sA0U.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		try {
			DataOutputStream SzoNYNR8 = new DataOutputStream(KCb1sA0U.getOutputStream());
			GetObservationDocument CevK6lUL = GetObservationDocument.Factory.newInstance();
			GetObservation ogEV6PnU = CevK6lUL.addNewGetObservation();
			ogEV6PnU.setService(bFyhnGrP);
			ogEV6PnU.setVersion(D8pTaVLq);
			ogEV6PnU.setSrsName(Hox6xLWI);
			ogEV6PnU.setOffering(CUsCy3FM);
			ogEV6PnU.setObservedPropertyArray(new String[] { wRhjCOSG });
			ogEV6PnU.setResponseFormat(vnjtpg8x);
			String KlzCGdez = URLEncoder.encode(CevK6lUL.xmlText(), "UTF-8");
			SzoNYNR8.writeBytes(KlzCGdez);
			SzoNYNR8.flush();
			SzoNYNR8.close();
		} catch (UnsupportedEncodingException unflEBgq) {
			unflEBgq.printStackTrace();
		} catch (IOException R0pE4kFU) {
			R0pE4kFU.printStackTrace();
		}
		try {
			URL cXMwhTQo = new URL("file:///E:/Temp/Observation.xml");
			URLConnection mp2mur7r = cXMwhTQo.openConnection();
			mp2mur7r.connect();
			InputStream NKuE8F5F = mp2mur7r.getInputStream();
			ObservationCollectionDocument UTMBV3Mp = ObservationCollectionDocument.Factory.parse(NKuE8F5F);
			ObservationCollectionType pGlaUkDE = UTMBV3Mp.getObservationCollection();
			ObservationPropertyType[] gScKJIPi = pGlaUkDE.getMemberArray();
			for (ObservationPropertyType AfJpBRmc : gScKJIPi) {
				ObservationType kHs7Gn4u = AfJpBRmc.getObservation();
				if (kHs7Gn4u != null) {
					System.out.println("observation " + kHs7Gn4u.getClass().getName());
					ObservationResult fm5vNaoK = new ObservationResult();
					if (kHs7Gn4u instanceof GeometryObservationTypeImpl) {
						GeometryObservationTypeImpl VVHkHmiQ = (GeometryObservationTypeImpl) kHs7Gn4u;
						TimeObjectPropertyType eTbdmeUY = VVHkHmiQ.getSamplingTime();
						TimeInstantTypeImpl kxd29G6H = (TimeInstantTypeImpl) eTbdmeUY.getTimeObject();
						TimePositionType cMbzo3Ho = kxd29G6H.getTimePosition();
						String gLllHmuZ = (String) cMbzo3Ho.getObjectValue();
						StringTokenizer Wd7pLsl3;
						String cWvgTCmR = new StringTokenizer(gLllHmuZ, "T").nextToken();
						SimpleDateFormat ehr1sIok = new SimpleDateFormat("yyyy-MM-dd");
						Date qGw8PYGX = ehr1sIok.parse(cWvgTCmR);
						String dM0Ppjeu = null;
						Wd7pLsl3 = new StringTokenizer(gLllHmuZ, "T");
						while (Wd7pLsl3.hasMoreElements())
							dM0Ppjeu = Wd7pLsl3.nextToken();
						ehr1sIok = new SimpleDateFormat("HH:mm:ss");
						Date CJIYUWo7 = ehr1sIok.parse(dM0Ppjeu.substring(0, dM0Ppjeu.lastIndexOf(':') + 2));
						qGw8PYGX.setHours(CJIYUWo7.getHours());
						qGw8PYGX.setMinutes(CJIYUWo7.getMinutes());
						qGw8PYGX.setSeconds(CJIYUWo7.getSeconds());
						fm5vNaoK.setDatetime(qGw8PYGX);
						String mQ50YAQH = "null";
						FeaturePropertyType ZlxufeC1 = (FeaturePropertyType) VVHkHmiQ.getFeatureOfInterest();
						Node lniBEaRi = ZlxufeC1.getDomNode();
						NodeList EsNVR3v0 = lniBEaRi.getChildNodes();
						for (int tDjGcn4W = 0; tDjGcn4W < EsNVR3v0.getLength(); tDjGcn4W++) {
							Node wRSIaYpD = EsNVR3v0.item(tDjGcn4W);
							if (wRSIaYpD.getNodeName().equals("n52:movingObject")) {
								NamedNodeMap vA7hybtc = wRSIaYpD.getAttributes();
								Node LOLG8JC3 = vA7hybtc.getNamedItem("gml:id");
								mQ50YAQH = LOLG8JC3.getNodeValue();
								fm5vNaoK.setTextValue(mQ50YAQH);
								fm5vNaoK.setIsTextValue(true);
							}
						}
						XmlObject m2R56y9E = VVHkHmiQ.getResult();
						if (m2R56y9E instanceof GeometryPropertyTypeImpl) {
							GeometryPropertyTypeImpl Cig5Jx4p = (GeometryPropertyTypeImpl) m2R56y9E;
							AbstractGeometryType Dwo3XdxN = Cig5Jx4p.getGeometry();
							String VzTxrNTn = Dwo3XdxN.getSrsName();
							StringTokenizer C3CLQ6AK = new StringTokenizer(VzTxrNTn, ":");
							String Q4KeIEj5 = null;
							while (C3CLQ6AK.hasMoreElements())
								Q4KeIEj5 = C3CLQ6AK.nextToken();
							int XsEsEYC0 = Integer.parseInt(Q4KeIEj5);
							if (Dwo3XdxN instanceof PointTypeImpl) {
								PointTypeImpl Nrp6F4lG = (PointTypeImpl) Dwo3XdxN;
								Node dcEje1vk = Nrp6F4lG.getDomNode();
								PointDocument I0BFy1Po = PointDocument.Factory.parse(dcEje1vk);
								PointType x4Lv2vUy = I0BFy1Po.getPoint();
								XmlCursor zgbwbZaq = Nrp6F4lG.newCursor();
								zgbwbZaq.toFirstChild();
								CoordinatesDocument dUYK8Xvn = CoordinatesDocument.Factory.parse(zgbwbZaq.xmlText());
								CoordinatesType IraiZc2B = dUYK8Xvn.getCoordinates();
								StringTokenizer FD8MpQqr = new StringTokenizer(IraiZc2B.getStringValue(), " ,;", false);
								double mwnxt8W2 = Double.parseDouble(FD8MpQqr.nextToken());
								double ZSOfCIvL = Double.parseDouble(FD8MpQqr.nextToken());
								double k7QGa70f = 0;
								if (FD8MpQqr.hasMoreTokens()) {
									k7QGa70f = Double.parseDouble(FD8MpQqr.nextToken());
								}
								mwnxt8W2 += 207561;
								ZSOfCIvL += 3318814;
								k7QGa70f += 20;
								Point3d Tvr7KUs6 = new Point3d(mwnxt8W2, ZSOfCIvL, k7QGa70f);
								fm5vNaoK.setCenter(Tvr7KUs6);
								GeometryFactory n90oD3qu = new GeometryFactory();
								Coordinate ZEc9V7dn = new Coordinate(mwnxt8W2, ZSOfCIvL, k7QGa70f);
								Geometry OnbdIes3 = n90oD3qu.createPoint(ZEc9V7dn);
								OnbdIes3.setSRID(XsEsEYC0);
								fm5vNaoK.setGeometry(OnbdIes3);
								String cvOLAifH = kHs7Gn4u.getProcedure().getHref();
								fm5vNaoK.setProcedure(cvOLAifH);
								rCK6j7qu.add(fm5vNaoK);
							}
						}
					}
				}
			}
			NKuE8F5F.close();
		} catch (IOException uRlpLxYK) {
			uRlpLxYK.printStackTrace();
		} catch (XmlException V2QZauJ1) {
			V2QZauJ1.printStackTrace();
		} catch (Exception LxtzK7lz) {
			LxtzK7lz.printStackTrace();
		}
		ObservationResult[] JVWDRYx0 = new ObservationResult[rCK6j7qu.size()];
		return rCK6j7qu.toArray(JVWDRYx0);
	}

}