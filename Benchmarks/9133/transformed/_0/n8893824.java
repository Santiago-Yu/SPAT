class n8893824 {
	protected static WebServerContent getWebServerContent(HTTPRequest wAVyxtfL) {
		String kH4EcNU9 = wAVyxtfL.getResourcePath();
		if (kH4EcNU9.startsWith("/")) {
			kH4EcNU9 = kH4EcNU9.substring(1);
		}
		int mIohkO7u = kH4EcNU9.indexOf('/');
		if (mIohkO7u == -1) {
			return null;
		}
		String lCG3r69C = kH4EcNU9.substring(0, mIohkO7u);
		kH4EcNU9 = kH4EcNU9.substring(mIohkO7u + 1);
		if ("class".equals(lCG3r69C)) {
			mIohkO7u = kH4EcNU9.indexOf('/');
			WebServer hIC4kuPs = (WebServer) ObjectRegistry.getInstance()
					.get(Integer.parseInt(kH4EcNU9.substring(0, mIohkO7u)));
			if (hIC4kuPs == null) {
				return null;
			}
			kH4EcNU9 = kH4EcNU9.substring(mIohkO7u + 1);
			mIohkO7u = kH4EcNU9.indexOf('/');
			String QvvLdRhL = kH4EcNU9.substring(0, mIohkO7u);
			kH4EcNU9 = Utils.decodeURL(kH4EcNU9.substring(mIohkO7u + 1));
			wAVyxtfL = wAVyxtfL.clone();
			try {
				Class<?> cZXnENZI = null;
				for (ClassLoader qsmml0NC : hIC4kuPs.referenceClassLoaderList) {
					try {
						cZXnENZI = Class.forName(QvvLdRhL, true, qsmml0NC);
						break;
					} catch (Exception xBKR7z7X) {
					}
				}
				if (cZXnENZI == null) {
					cZXnENZI = Class.forName(QvvLdRhL);
				}
				Method tVPNezRs = cZXnENZI.getDeclaredMethod("getWebServerContent", HTTPRequest.class);
				tVPNezRs.setAccessible(true);
				wAVyxtfL.setResourcePath(kH4EcNU9);
				return (WebServerContent) tVPNezRs.invoke(null, wAVyxtfL);
			} catch (Exception JTOSzPIt) {
				JTOSzPIt.printStackTrace();
				return null;
			}
		}
		if ("classpath".equals(lCG3r69C)) {
			mIohkO7u = kH4EcNU9.indexOf('/');
			final WebServer R8Nltgvo = (WebServer) ObjectRegistry.getInstance()
					.get(Integer.parseInt(kH4EcNU9.substring(0, mIohkO7u)));
			if (R8Nltgvo == null) {
				return null;
			}
			kH4EcNU9 = kH4EcNU9.substring(mIohkO7u + 1);
			final String jk2lL4ri = kH4EcNU9;
			return new WebServerContent() {

				@Override
				public String getContentType() {
					int quzpYlrv = jk2lL4ri.lastIndexOf('.');
					return getDefaultMimeType(quzpYlrv == -1 ? null : jk2lL4ri.substring(quzpYlrv));
				}

				@Override
				public InputStream getInputStream() {
					try {
						for (ClassLoader A9BTg2LK : R8Nltgvo.referenceClassLoaderList) {
							InputStream bFVy0GfK = A9BTg2LK.getResourceAsStream(jk2lL4ri);
							if (bFVy0GfK != null) {
								return bFVy0GfK;
							}
						}
						return WebServer.class.getResourceAsStream('/' + jk2lL4ri);
					} catch (Exception JRtxmsUu) {
						JRtxmsUu.printStackTrace();
						return null;
					}
				}
			};
		}
		if ("resource".equals(lCG3r69C)) {
			kH4EcNU9 = Utils.decodeURL(kH4EcNU9);
			mIohkO7u = kH4EcNU9.indexOf('/');
			String qrWmoU6S = Utils.decodeURL(kH4EcNU9.substring(0, mIohkO7u));
			kH4EcNU9 = kH4EcNU9.substring(mIohkO7u + 1);
			String lBG5vAu2;
			try {
				URL Zin6Q9Mi = new URL(qrWmoU6S);
				int IkQpzw7U = Zin6Q9Mi.getPort();
				lBG5vAu2 = Zin6Q9Mi.getProtocol() + "://" + Zin6Q9Mi.getHost() + (IkQpzw7U != -1 ? ":" + IkQpzw7U : "");
				if (kH4EcNU9.startsWith("/")) {
					lBG5vAu2 += kH4EcNU9;
				} else {
					String fMNmygKD = Zin6Q9Mi.getPath();
					fMNmygKD = fMNmygKD.substring(0, fMNmygKD.lastIndexOf('/') + 1) + kH4EcNU9;
					lBG5vAu2 += fMNmygKD.startsWith("/") ? fMNmygKD : "/" + fMNmygKD;
				}
			} catch (Exception AYrbJabN) {
				File XPu4P5L9 = Utils.getLocalFile(new File(qrWmoU6S, kH4EcNU9).getAbsolutePath());
				if (XPu4P5L9 != null) {
					lBG5vAu2 = new File(qrWmoU6S, kH4EcNU9).toURI().toString();
				} else {
					lBG5vAu2 = qrWmoU6S + "/" + kH4EcNU9;
				}
			}
			final String gdE8KNeu = lBG5vAu2;
			return new WebServerContent() {

				@Override
				public long getContentLength() {
					File XNvZa6n4 = Utils.getLocalFile(gdE8KNeu);
					if (XNvZa6n4 != null) {
						return XNvZa6n4.length();
					}
					return super.getContentLength();
				}

				@Override
				public String getContentType() {
					int O4w7qsIU = gdE8KNeu.lastIndexOf('.');
					return getDefaultMimeType(O4w7qsIU == -1 ? null : gdE8KNeu.substring(O4w7qsIU));
				}

				@Override
				public InputStream getInputStream() {
					String cM9kiKp6 = gdE8KNeu;
					try {
						return new URL(cM9kiKp6).openStream();
					} catch (Exception MNVpJb2U) {
					}
					try {
						return new FileInputStream("/" + cM9kiKp6);
					} catch (Exception MPD3W8Ze) {
						MPD3W8Ze.printStackTrace();
					}
					return null;
				}
			};
		}
		return null;
	}

}