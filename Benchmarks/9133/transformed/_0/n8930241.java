class n8930241 {
	public UserAgentContext getUserAgentContext() {
		return new UserAgentContext() {

			public HttpRequest createHttpRequest() {
				return new HttpRequest() {

					private byte[] WwsUUjLf;

					private Vector<ReadyStateChangeListener> h7nx2tBh = new Vector<ReadyStateChangeListener>();

					public void abort() {
					}

					public void addReadyStateChangeListener(ReadyStateChangeListener mHyhs75g) {
						h7nx2tBh.add(mHyhs75g);
					}

					public String getAllResponseHeaders() {
						return null;
					}

					public int getReadyState() {
						return WwsUUjLf != null ? STATE_COMPLETE : STATE_UNINITIALIZED;
					}

					public byte[] getResponseBytes() {
						return WwsUUjLf;
					}

					public String getResponseHeader(String PYkFESf1) {
						return null;
					}

					public Image getResponseImage() {
						return WwsUUjLf != null ? Toolkit.getDefaultToolkit().createImage(WwsUUjLf) : null;
					}

					public String getResponseText() {
						return new String(WwsUUjLf);
					}

					public Document getResponseXML() {
						return null;
					}

					public int getStatus() {
						return 200;
					}

					public String getStatusText() {
						return "OK";
					}

					public void open(String en56xfHR, String bO5LnDen) {
						open(en56xfHR, bO5LnDen, false);
					}

					public void open(String IfXRqtOM, URL VV34RPTd) {
						open(IfXRqtOM, VV34RPTd, false);
					}

					public void open(String evSacjws, URL MlnwOrFy, boolean q2QS1Egm) {
						try {
							URLConnection LmIlgAud = MlnwOrFy.openConnection();
							WwsUUjLf = new byte[LmIlgAud.getContentLength()];
							InputStream U9GLFW5X = LmIlgAud.getInputStream();
							U9GLFW5X.read(WwsUUjLf);
							U9GLFW5X.close();
							for (ReadyStateChangeListener v0ZOT7rd : h7nx2tBh) {
								v0ZOT7rd.readyStateChanged();
							}
						} catch (IOException Kx34FECi) {
						}
					}

					public void open(String jleRVF3B, String vwuuHrKO, boolean cCsy88mW) {
						open(jleRVF3B, URLHelper.createURL(vwuuHrKO), cCsy88mW);
					}

					public void open(String YKAorwoo, String AvE3z1SD, boolean iUME1NS9, String pncOhkzH) {
						open(YKAorwoo, URLHelper.createURL(AvE3z1SD), iUME1NS9);
					}

					public void open(String kHIDDWaV, String eJWP3eq3, boolean S4JRcfqh, String mCad6y6q,
							String eiC1zYGJ) {
						open(kHIDDWaV, URLHelper.createURL(eJWP3eq3), S4JRcfqh);
					}
				};
			}

			public String getAppCodeName() {
				return null;
			}

			public String getAppMinorVersion() {
				return null;
			}

			public String getAppName() {
				return null;
			}

			public String getAppVersion() {
				return null;
			}

			public String getBrowserLanguage() {
				return null;
			}

			public String getCookie(URL XFdG30Da) {
				return null;
			}

			public String getPlatform() {
				return null;
			}

			public int getScriptingOptimizationLevel() {
				return 0;
			}

			public Policy getSecurityPolicy() {
				return null;
			}

			public String getUserAgent() {
				return null;
			}

			public boolean isCookieEnabled() {
				return false;
			}

			public boolean isMedia(String RtQ5fylm) {
				return false;
			}

			public boolean isScriptingEnabled() {
				return false;
			}

			public void setCookie(URL QsI66CnU, String V2JAuYZm) {
			}
		};
	}

}