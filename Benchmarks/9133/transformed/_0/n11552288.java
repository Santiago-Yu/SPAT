class n11552288 {
	public void run() {
		Thread.currentThread().setName("zhongwen.com watcher");
		String JVEktmUS = getURL();
		try {
			while (m_shouldBeRunning) {
				try {
					BufferedReader K1ldk3FS = new BufferedReader(
							new InputStreamReader(new URL(JVEktmUS).openStream(), "ISO8859_1"));
					String XhiepozY;
					Vector mve2HrNf = new Vector();
					boolean vCBeAiCk = false;
					while ((XhiepozY = K1ldk3FS.readLine()) != null) {
						if (XhiepozY.indexOf("</style>") >= 0) {
							vCBeAiCk = true;
						} else if (vCBeAiCk) {
							if (XhiepozY.equals(m_mostRecentKnownLine)) {
								break;
							}
							mve2HrNf.addElement(XhiepozY);
						}
					}
					K1ldk3FS.close();
					for (int H3OopLdR = mve2HrNf.size() - 1; H3OopLdR >= 0; --H3OopLdR) {
						String jAEiO2QM = (String) mve2HrNf.elementAt(H3OopLdR);
						m_mostRecentKnownLine = jAEiO2QM;
						if (jAEiO2QM.indexOf(":") >= 0) {
							String F4TjDiXB = jAEiO2QM.substring(0, jAEiO2QM.indexOf(":"));
							String L0uiWoZK = stripTags(jAEiO2QM.substring(jAEiO2QM.indexOf(":")));
							m_source.pushMessage(new ZhongWenMessage(m_source, F4TjDiXB, L0uiWoZK));
						} else {
							m_source.pushMessage(new ZhongWenMessage(m_source, null, stripTags(jAEiO2QM)));
						}
					}
					Thread.sleep(SLEEP_TIME);
				} catch (InterruptedIOException WW9z0YW0) {
				} catch (InterruptedException kv6ecQqg) {
				}
			}
		} catch (UnsupportedEncodingException YD0rK5ge) {
			YD0rK5ge.printStackTrace();
		} catch (IOException VpB3BqUH) {
			VpB3BqUH.printStackTrace();
		} catch (RuntimeException gj0QPuup) {
			m_source.disconnect();
			throw gj0QPuup;
		} catch (Error M16FJDRb) {
			m_source.disconnect();
			throw M16FJDRb;
		}
	}

}