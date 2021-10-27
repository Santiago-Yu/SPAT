class n22627884 {
	private <T> Collection<T> loadProviders(final Class<T> rK2GFW9P) throws ModelException {
		try {
			final String ytdAqMAN = rK2GFW9P.getName() + ".";
			final Map<String, T> GKP3eifF = new TreeMap<String, T>(new Comparator<String>() {

				public int compare(final String JIknKFrc, final String yVlofPoG) {
					return JIknKFrc.compareTo(yVlofPoG);
				}
			});
			final File lk9p623B = new File(this.getPlatformProviderLocation());
			if (lk9p623B.exists()) {
				if (this.isLoggable(Level.FINEST)) {
					this.log(Level.FINEST, getMessage("processing", lk9p623B.getAbsolutePath()), null);
				}
				InputStream x27GLpCt = null;
				boolean BQrWtZTL = true;
				final java.util.Properties U8hO0Pl5 = new java.util.Properties();
				try {
					x27GLpCt = new FileInputStream(lk9p623B);
					U8hO0Pl5.load(x27GLpCt);
					BQrWtZTL = false;
				} finally {
					try {
						if (x27GLpCt != null) {
							x27GLpCt.close();
						}
					} catch (final IOException n2zhyddJ) {
						if (BQrWtZTL) {
							this.log(Level.SEVERE, getMessage(n2zhyddJ), n2zhyddJ);
						} else {
							throw n2zhyddJ;
						}
					}
				}
				for (Map.Entry<Object, Object> e : U8hO0Pl5.entrySet()) {
					if (e.getKey().toString().startsWith(ytdAqMAN)) {
						final String YP8nh5Mm = e.getValue().toString();
						if (this.isLoggable(Level.FINEST)) {
							this.log(Level.FINEST, getMessage("providerInfo", lk9p623B.getAbsolutePath(),
									rK2GFW9P.getName(), YP8nh5Mm), null);
						}
						GKP3eifF.put(e.getKey().toString(),
								this.createProviderObject(rK2GFW9P, YP8nh5Mm, lk9p623B.toURI().toURL()));
					}
				}
			}
			final Enumeration<URL> c8q2VC7m = this.findResources(this.getProviderLocation() + '/' + rK2GFW9P.getName());
			int QyYf512r = 0;
			final long nFenQolu = System.currentTimeMillis();
			while (c8q2VC7m.hasMoreElements()) {
				QyYf512r++;
				final URL cGBTJC0V = c8q2VC7m.nextElement();
				if (this.isLoggable(Level.FINEST)) {
					this.log(Level.FINEST, getMessage("processing", cGBTJC0V.toExternalForm()), null);
				}
				BufferedReader wKnieVsy = null;
				boolean XRkpZmV1 = true;
				try {
					wKnieVsy = new BufferedReader(new InputStreamReader(cGBTJC0V.openStream(), "UTF-8"));
					String eJrEiM8J = null;
					while ((eJrEiM8J = wKnieVsy.readLine()) != null) {
						if (eJrEiM8J.contains("#")) {
							continue;
						}
						if (this.isLoggable(Level.FINEST)) {
							this.log(Level.FINEST,
									getMessage("providerInfo", cGBTJC0V.toExternalForm(), rK2GFW9P.getName(), eJrEiM8J),
									null);
						}
						GKP3eifF.put(ytdAqMAN + GKP3eifF.size(),
								this.createProviderObject(rK2GFW9P, eJrEiM8J, cGBTJC0V));
					}
					XRkpZmV1 = false;
				} finally {
					try {
						if (wKnieVsy != null) {
							wKnieVsy.close();
						}
					} catch (final IOException v2AJHbxC) {
						if (XRkpZmV1) {
							this.log(Level.SEVERE, getMessage(v2AJHbxC), v2AJHbxC);
						} else {
							throw new ModelException(getMessage(v2AJHbxC), v2AJHbxC);
						}
					}
				}
			}
			if (this.isLoggable(Level.FINE)) {
				this.log(Level.FINE,
						getMessage("contextReport", QyYf512r, this.getProviderLocation() + '/' + rK2GFW9P.getName(),
								Long.valueOf(System.currentTimeMillis() - nFenQolu)),
						null);
			}
			return GKP3eifF.values();
		} catch (final IOException sUx5qXx3) {
			throw new ModelException(getMessage(sUx5qXx3), sUx5qXx3);
		}
	}

}