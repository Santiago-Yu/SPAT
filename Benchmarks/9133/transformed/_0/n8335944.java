class n8335944 {
	public static byte[] sendRequestV1(String ADQXbDvr, Map<String, Object> YnuZwrBd, String chUMzFz7, String XTRdRfnV,
			Map<String, String> P1btarml, String Fv3LslCs, String nsaUMGMB, Map<String, String> MhnFpGPg,
			String g589Ncj2) {
		HttpClient i8nIC9Py = new HttpClient();
		byte[] o39oyAis = null;
		if (XTRdRfnV.equalsIgnoreCase("get")) {
			GetMethod wrnXcIiF = new GetMethod(ADQXbDvr);
			if (g589Ncj2 == null || g589Ncj2.equals(""))
				wrnXcIiF.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			else
				wrnXcIiF.setRequestHeader("Content-Type", g589Ncj2);
			if (MhnFpGPg != null && MhnFpGPg.size() > 0) {
				Iterator<String> yWE0CtRB = MhnFpGPg.keySet().iterator();
				while (yWE0CtRB.hasNext()) {
					String AFAHRuwX = yWE0CtRB.next();
					wrnXcIiF.setRequestHeader(AFAHRuwX, MhnFpGPg.get(AFAHRuwX));
				}
			}
			try {
				NameValuePair[] PZEQz8Md;
				if (YnuZwrBd != null) {
					if (chUMzFz7 == null)
						PZEQz8Md = new NameValuePair[YnuZwrBd.size()];
					else
						PZEQz8Md = new NameValuePair[YnuZwrBd.size() + 1];
					Iterator<?> dkxIBCs2 = YnuZwrBd.keySet().iterator();
					int tvaQqDw4 = 0;
					while (dkxIBCs2.hasNext()) {
						String Fr35VYk3 = (String) dkxIBCs2.next();
						PZEQz8Md[tvaQqDw4] = new NameValuePair(Fr35VYk3, YnuZwrBd.get(Fr35VYk3).toString());
						tvaQqDw4++;
					}
					if (chUMzFz7 != null) {
						boolean SUtlMQ2h = false;
						if (nsaUMGMB != null && nsaUMGMB.equalsIgnoreCase("hmac"))
							SUtlMQ2h = true;
						String UlQTb322 = EncryptUtil.signature2(YnuZwrBd, chUMzFz7, "md5".equalsIgnoreCase(nsaUMGMB),
								SUtlMQ2h, PARAMETER_SIGN);
						PZEQz8Md[tvaQqDw4] = new NameValuePair(PARAMETER_SIGN, UlQTb322);
					}
					wrnXcIiF.setQueryString(PZEQz8Md);
				}
				i8nIC9Py.executeMethod(wrnXcIiF);
				ByteArrayOutputStream ThNw1d6S = new ByteArrayOutputStream();
				try {
					InputStream lKPczEym = wrnXcIiF.getResponseBodyAsStream();
					byte[] wG9wOtTM = new byte[500];
					int J6oqMi1D = 0;
					while ((J6oqMi1D = lKPczEym.read(wG9wOtTM)) > 0) {
						ThNw1d6S.write(wG9wOtTM, 0, J6oqMi1D);
					}
					o39oyAis = ThNw1d6S.toByteArray();
				} catch (Exception wLL50m2f) {
					wLL50m2f.printStackTrace();
				} finally {
					if (ThNw1d6S != null)
						ThNw1d6S.close();
				}
			} catch (Exception b0AGehi4) {
				logger.error(b0AGehi4, b0AGehi4);
			} finally {
				if (wrnXcIiF != null)
					wrnXcIiF.releaseConnection();
			}
		}
		if (XTRdRfnV.equalsIgnoreCase("post")) {
			PostMethod VMIZOFVU = new PostMethod(ADQXbDvr);
			if (MhnFpGPg != null && MhnFpGPg.size() > 0) {
				Iterator<String> cIam7qsH = MhnFpGPg.keySet().iterator();
				while (cIam7qsH.hasNext()) {
					String lUgXGuK8 = cIam7qsH.next();
					VMIZOFVU.setRequestHeader(lUgXGuK8, MhnFpGPg.get(lUgXGuK8));
				}
			}
			try {
				if (g589Ncj2 == null) {
					if (P1btarml != null && P1btarml.size() > 0) {
						Part[] iVHthcBM;
						if (chUMzFz7 == null)
							iVHthcBM = new Part[YnuZwrBd.size() + P1btarml.size()];
						else
							iVHthcBM = new Part[YnuZwrBd.size() + 1 + P1btarml.size()];
						Iterator<?> iLa7jXz9 = YnuZwrBd.keySet().iterator();
						int cLe1gxvs = 0;
						while (iLa7jXz9.hasNext()) {
							String fRjZbbrn = (String) iLa7jXz9.next();
							iVHthcBM[cLe1gxvs] = new StringPart(fRjZbbrn, YnuZwrBd.get(fRjZbbrn).toString(), "UTF-8");
							cLe1gxvs++;
						}
						if (chUMzFz7 != null) {
							boolean fVUayb00 = false;
							if (nsaUMGMB != null && nsaUMGMB.equalsIgnoreCase("hmac"))
								fVUayb00 = true;
							String zcv7jLmP = EncryptUtil.signature(YnuZwrBd, chUMzFz7, fVUayb00, PARAMETER_SIGN);
							iVHthcBM[cLe1gxvs] = new StringPart(PARAMETER_SIGN, zcv7jLmP);
							cLe1gxvs++;
						}
						iLa7jXz9 = P1btarml.keySet().iterator();
						while (iLa7jXz9.hasNext()) {
							String IT7LdaCE = (String) iLa7jXz9.next();
							if (P1btarml.get(IT7LdaCE).toString().startsWith("http://")) {
								InputStream ERfkMvgO = null;
								ByteArrayOutputStream TyavX6PS = new ByteArrayOutputStream();
								try {
									URL xW1D7YCF = new URL(P1btarml.get(IT7LdaCE).toString());
									ERfkMvgO = xW1D7YCF.openStream();
									byte[] CbQ4vuHX = new byte[500];
									int hWkeBzY9 = 0;
									while ((hWkeBzY9 = ERfkMvgO.read(CbQ4vuHX)) > 0) {
										TyavX6PS.write(CbQ4vuHX, 0, hWkeBzY9);
									}
									iVHthcBM[cLe1gxvs] = new FilePart(IT7LdaCE,
											new ByteArrayPartSource(
													xW1D7YCF.getFile()
															.substring(xW1D7YCF.getFile().lastIndexOf("/") + 1),
													TyavX6PS.toByteArray()));
								} catch (Exception tHPWuinL) {
									logger.error(tHPWuinL, tHPWuinL);
								} finally {
									if (ERfkMvgO != null)
										ERfkMvgO.close();
									if (TyavX6PS != null)
										TyavX6PS.close();
								}
							} else
								iVHthcBM[cLe1gxvs] = new FilePart(IT7LdaCE,
										new File(P1btarml.get(IT7LdaCE).toString()));
							cLe1gxvs++;
						}
						VMIZOFVU.setRequestEntity(new MultipartRequestEntity(iVHthcBM, VMIZOFVU.getParams()));
					} else {
						NameValuePair[] kzoSN4jq;
						if (YnuZwrBd != null) {
							if (chUMzFz7 == null)
								kzoSN4jq = new NameValuePair[YnuZwrBd.size()];
							else
								kzoSN4jq = new NameValuePair[YnuZwrBd.size() + 1];
							Iterator<?> yJ42iy9z = YnuZwrBd.keySet().iterator();
							int NgjFeeVa = 0;
							while (yJ42iy9z.hasNext()) {
								String LJNxWC4T = (String) yJ42iy9z.next();
								kzoSN4jq[NgjFeeVa] = new NameValuePair(LJNxWC4T, YnuZwrBd.get(LJNxWC4T).toString());
								NgjFeeVa++;
							}
							if (chUMzFz7 != null) {
								boolean c9DaWUV2 = false;
								if (nsaUMGMB != null && nsaUMGMB.equalsIgnoreCase("hmac"))
									c9DaWUV2 = true;
								String XPYFFJQz = EncryptUtil.signature(YnuZwrBd, chUMzFz7, c9DaWUV2, PARAMETER_SIGN);
								kzoSN4jq[NgjFeeVa] = new NameValuePair(PARAMETER_SIGN, XPYFFJQz);
							}
							VMIZOFVU.setRequestBody(kzoSN4jq);
						}
						if (g589Ncj2 == null || g589Ncj2.equals(""))
							VMIZOFVU.setRequestHeader("Content-Type",
									"application/x-www-form-urlencoded;charset=UTF-8");
					}
				} else {
					String NBDsdoh0 = (String) YnuZwrBd.get(YnuZwrBd.keySet().iterator().next());
					RequestEntity jTxXTGIr = new StringRequestEntity(NBDsdoh0, g589Ncj2, "UTF-8");
					VMIZOFVU.setRequestEntity(jTxXTGIr);
				}
				i8nIC9Py.executeMethod(VMIZOFVU);
				ByteArrayOutputStream GWcgKcUP = new ByteArrayOutputStream();
				try {
					InputStream hrUQBL9O = VMIZOFVU.getResponseBodyAsStream();
					byte[] KUptpEtv = new byte[500];
					int bKDQ3VTn = 0;
					while ((bKDQ3VTn = hrUQBL9O.read(KUptpEtv)) > 0) {
						GWcgKcUP.write(KUptpEtv, 0, bKDQ3VTn);
					}
					o39oyAis = GWcgKcUP.toByteArray();
				} catch (Exception xkf5Xu2y) {
					logger.error(xkf5Xu2y, xkf5Xu2y);
				} finally {
					if (GWcgKcUP != null)
						GWcgKcUP.close();
				}
			} catch (Exception we9ymj6G) {
				logger.error(we9ymj6G, we9ymj6G);
			} finally {
				if (VMIZOFVU != null)
					VMIZOFVU.releaseConnection();
			}
		}
		return o39oyAis;
	}

}