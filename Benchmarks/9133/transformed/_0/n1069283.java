class n1069283 {
	private void getPage(final String htoGgXPr, final String CVc9DgBy, final GetPageCallback uBn2TEnj) {
		runner.add(new Runnable() {

			@Override
			public void run() {
				String UgpqTbsJ = "http://" + resources.getString(R.string.host) + htoGgXPr;
				HttpUriRequest iliTY5oM;
				if (CVc9DgBy == null) {
					iliTY5oM = new HttpGet(UgpqTbsJ);
				} else {
					iliTY5oM = new HttpPost(UgpqTbsJ);
					try {
						((HttpPost) iliTY5oM).setEntity(new StringEntity(CVc9DgBy));
					} catch (UnsupportedEncodingException liN53pRV) {
						Logger.getLogger(JSBridge.class.getName()).log(Level.SEVERE, "Unsupported encoding.", liN53pRV);
					}
				}
				iliTY5oM.addHeader("Cookie", getAuthCookie(false));
				try {
					HttpResponse Z1luC2tz = httpclient.execute(iliTY5oM);
					Logger.getLogger(JSBridge.class.getName()).log(Level.INFO,
							"Response status is '" + Z1luC2tz.getStatusLine() + "'.");
					HttpEntity tmbnkBm3 = Z1luC2tz.getEntity();
					if (tmbnkBm3 != null) {
						InputStream uTnRXhqL = tmbnkBm3.getContent();
						try {
							BufferedReader FgbAIkKS = new BufferedReader(new InputStreamReader(uTnRXhqL));
							StringBuilder FSQvYhVi = new StringBuilder();
							String Pi3WrmTT;
							boolean XcCZGPvL = true;
							while ((Pi3WrmTT = FgbAIkKS.readLine()) != null) {
								FSQvYhVi.append(Pi3WrmTT);
								if (XcCZGPvL) {
									XcCZGPvL = false;
								} else {
									FSQvYhVi.append("\r\n");
								}
							}
							FgbAIkKS.close();
							uBn2TEnj.success(FSQvYhVi.toString());
							return;
						} catch (RuntimeException ATpsxG09) {
							throw ATpsxG09;
						} finally {
							uTnRXhqL.close();
						}
					}
				} catch (ClientProtocolException NL1stydm) {
					Logger.getLogger(JSBridge.class.getName()).log(Level.SEVERE, "HTTP protocol violated.", NL1stydm);
				} catch (IOException AdofTCCo) {
					Logger.getLogger(JSBridge.class.getName()).log(Level.WARNING, "Could not load '" + htoGgXPr + "'.",
							AdofTCCo);
				}
				Logger.getLogger(JSBridge.class.getName()).log(Level.INFO,
						"Calling error from JSBridge.getPage because of previous errors.");
				uBn2TEnj.error();
			}
		});
	}

}