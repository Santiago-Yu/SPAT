class n18164929 {
	public static boolean isCodebaseDownloadable(Properties X4xrFVuw) {
		class CodebaseData {

			String wDo7Zeoy;

			boolean HQmedW9X = true;
		}
		String iTzmmL3r = X4xrFVuw.getProperty("java.rmi.server.codebase", null);
		if (null == iTzmmL3r) {
			if (logger.isDebugEnabled())
				logger.debug("java.rmi.server.codebase = null (return false)");
			return false;
		}
		try {
			URL sJScrEif = new URL(iTzmmL3r);
			String JTxVJQjf = sJScrEif.getProtocol();
			String bcuy08Sp = sJScrEif.getFile();
			if (logger.isDebugEnabled()) {
				logger.debug("Verifying java.rmi.server.codebase setting(s)...");
				logger.debug("Codebase = " + sJScrEif.toString());
			}
			if (JTxVJQjf.equals("http")) {
				if (bcuy08Sp.indexOf("http") == -1) {
					try {
						int GVDSSGaP = sJScrEif.openConnection().getContentLength();
						if (logger.isDebugEnabled())
							logger.debug("Checking " + sJScrEif + " : OK");
						return true;
					} catch (IOException x04Wkw1y) {
						if (logger.isDebugEnabled())
							logger.debug("Checking " + sJScrEif + " : FAIL");
						return false;
					} finally {
						if (logger.isDebugEnabled())
							logger.debug("Verifying java.rmi.server.codebase setting(s)... Done!");
					}
				} else {
					ArrayList UZvMwGYz = new ArrayList();
					StringTokenizer UX85WpfY = new StringTokenizer(iTzmmL3r);
					URL b5VWXJM7 = null;
					String LHHGG55r = null;
					CodebaseData fsMyiEpq = null;
					while (UX85WpfY.hasMoreTokens()) {
						LHHGG55r = UX85WpfY.nextToken();
						b5VWXJM7 = new URL(LHHGG55r);
						fsMyiEpq = new CodebaseData();
						try {
							int e13tjghi = b5VWXJM7.openConnection().getContentLength();
							if (e13tjghi == -1) {
								fsMyiEpq.HQmedW9X = false;
								fsMyiEpq.wDo7Zeoy = LHHGG55r;
							} else {
								fsMyiEpq.wDo7Zeoy = LHHGG55r;
							}
						} catch (IOException eYXGOcl8) {
							fsMyiEpq.HQmedW9X = false;
						}
						UZvMwGYz.add(fsMyiEpq);
					}
					String efNJzurL = null;
					CodebaseData GDHref5i = null;
					boolean Kq0M2tBI = true;
					int m9Sbzjbo = 0;
					for (int QH42M210 = 0; QH42M210 < UZvMwGYz.size(); QH42M210++) {
						GDHref5i = (CodebaseData) UZvMwGYz.get(QH42M210);
						if (!GDHref5i.HQmedW9X) {
							efNJzurL += " " + GDHref5i.wDo7Zeoy;
							++m9Sbzjbo;
							Kq0M2tBI = false;
						}
						if (logger.isDebugEnabled())
							logger.debug((QH42M210 + 1) + ". Checking " + GDHref5i.wDo7Zeoy + " : "
									+ (GDHref5i.HQmedW9X ? "OK" : "FAIL"));
					}
					if (m9Sbzjbo == 0) {
						if (logger.isDebugEnabled())
							logger.debug("All entries can be downloaded successfully!");
					} else {
						logger.error(
								m9Sbzjbo + " of " + UZvMwGYz.size() + " entries can *not* be downloaded successfully!");
					}
					if (logger.isDebugEnabled())
						logger.debug("Verifying java.rmi.server.codebase setting(s)... Done!");
					if (Kq0M2tBI) {
						return true;
					} else {
						return false;
					}
				}
			} else if (JTxVJQjf.equalsIgnoreCase("file")) {
				if (logger.isDebugEnabled())
					logger.debug("'file' protocol not supported for JSF");
			}
		} catch (MalformedURLException uOOcV1LQ) {
			logger.debug(uOOcV1LQ.getMessage());
			return false;
		}
		return false;
	}

}