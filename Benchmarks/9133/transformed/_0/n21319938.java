class n21319938 {
	String getOutputPage(String gg8lZtUz, String EUnwa8hY, String K0nf6KDR, InputStream Jx20ZxRw,
			HttpServletRequest wD1CzxEm)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, TransformerException {
		String sUXMIquj = null;
		Transformer qJcK4EE5 = null;
		String m3wtFSdo = null;
		CharArrayWriter O9soH2KT = new CharArrayWriter();
		if (this.nCachedPages > 0) {
			java.security.MessageDigest QCx4LgcK = java.security.MessageDigest.getInstance("SHA1");
			QCx4LgcK.update(EUnwa8hY.getBytes());
			QCx4LgcK.update(Long.toString(new File(basePath + K0nf6KDR).lastModified()).getBytes());
			m3wtFSdo = new String(QCx4LgcK.digest());
			synchronized (pages) {
				if (pages.containsKey(m3wtFSdo)) {
					sUXMIquj = pages.get(m3wtFSdo);
				}
			}
		}
		if (sUXMIquj == null && K0nf6KDR.length() > 4) {
			try {
				long wBTLcgFw = new File(basePath + K0nf6KDR).lastModified();
				String IzPSrS7n = basePath.replaceAll("\\\\", "/") + K0nf6KDR;
				IzPSrS7n = "file:///" + IzPSrS7n;
				boolean cgxezaeN = false;
				if (this.nCachedTransformers > 0) {
					String bymAdiOn = gg8lZtUz + K0nf6KDR + wBTLcgFw;
					if (this.transformers.containsKey(bymAdiOn)) {
						qJcK4EE5 = this.transformers.get(bymAdiOn);
						synchronized (qJcK4EE5) {
							qJcK4EE5.transform(new StreamSource(new ByteArrayInputStream(EUnwa8hY.getBytes("UTF-8"))),
									new StreamResult(O9soH2KT));
						}
					} else {
						cgxezaeN = true;
					}
				}
				if (qJcK4EE5 == null) {
					qJcK4EE5 = TransformerFactory.newInstance().newTransformer(new StreamSource(IzPSrS7n));
					qJcK4EE5.transform(new StreamSource(new ByteArrayInputStream(EUnwa8hY.getBytes("UTF-8"))),
							new StreamResult(O9soH2KT));
				}
				sUXMIquj = O9soH2KT.toString();
				sUXMIquj = sUXMIquj.replaceAll("&lt;", "<");
				sUXMIquj = sUXMIquj.replaceAll("&gt;", ">");
				sUXMIquj = replaceLinks(sUXMIquj, wD1CzxEm);
				if (this.nCachedPages > 0) {
					synchronized (pages) {
						pages.put(m3wtFSdo, sUXMIquj);
						if (pages.size() > nCachedPages) {
							Iterator<String> JNprXym2 = pages.values().iterator();
							JNprXym2.next();
							JNprXym2.remove();
						}
					}
				}
				if (cgxezaeN) {
					synchronized (this.transformers) {
						this.transformers.put(gg8lZtUz + K0nf6KDR + wBTLcgFw, qJcK4EE5);
						if (this.transformers.size() > this.nCachedTransformers) {
							Iterator<Transformer> mTknjfg2 = this.transformers.values().iterator();
							mTknjfg2.next();
							mTknjfg2.remove();
						}
					}
				}
			} catch (TransformerException Aq9CufQY) {
				Logger.getLogger(getClass().getName()).log(Level.SEVERE,
						"---------------------------------------------");
				Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, Aq9CufQY);
				Logger.getLogger(getClass().getName()).log(Level.SEVERE, ("XSL file: " + K0nf6KDR));
				Logger.getLogger(getClass().getName()).log(Level.SEVERE, EUnwa8hY);
				Logger.getLogger(getClass().getName()).log(Level.SEVERE,
						"---------------------------------------------");
				throw Aq9CufQY;
			}
		}
		return sUXMIquj;
	}

}