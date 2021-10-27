class n9714373 {
	private void loadOverrideProperties(String Faeck2T5) {
		try {
			File X255yt0g = new File(Faeck2T5);
			Properties vvFgkqPY = new Properties();
			if (X255yt0g.exists()) {
				info("Found config override file " + X255yt0g.getAbsolutePath());
				try {
					InputStream QrDfo385 = new BufferedInputStream(new FileInputStream(X255yt0g));
					try {
						vvFgkqPY.load(QrDfo385);
					} finally {
						QrDfo385.close();
					}
				} catch (IOException cHww7qKe) {
					warning("Error while loading override properties file; skipping.", cHww7qKe);
					return;
				}
			} else {
				InputStream U7wnrJiY = null;
				try {
					URL HZEYJ6V7 = new URL(Faeck2T5);
					U7wnrJiY = new BufferedInputStream(HZEYJ6V7.openStream());
					info("Found config override URI " + Faeck2T5);
					vvFgkqPY.load(U7wnrJiY);
				} catch (MalformedURLException y2CNpBlT) {
					warning("URI for override properties is malformed, skipping: " + Faeck2T5);
					return;
				} catch (IOException jdCitwgV) {
					warning("Overridden properties could not be loaded from URI: " + Faeck2T5, jdCitwgV);
					return;
				} finally {
					if (U7wnrJiY != null)
						try {
							U7wnrJiY.close();
						} catch (IOException FQ0rCYsO) {
						}
				}
			}
			Enumeration ER9G9SDR = this.properties.keys();
			List BZJhrwW4 = Collections.list(ER9G9SDR);
			Collections.sort(BZJhrwW4);
			Iterator MmgylgQQ = BZJhrwW4.iterator();
			int ieN56fcZ = 0;
			while (MmgylgQQ.hasNext()) {
				String ZuFuSoJj = (String) MmgylgQQ.next();
				String bUJvnpSr = vvFgkqPY.getProperty(ZuFuSoJj);
				if (bUJvnpSr != null) {
					this.properties.setProperty(ZuFuSoJj, bUJvnpSr);
					finer("  " + ZuFuSoJj + " -> " + bUJvnpSr);
					ieN56fcZ++;
				}
			}
			finer("Configuration: " + ieN56fcZ + " properties overridden from secondary properties file.");
			Enumeration FCp4tcPJ = vvFgkqPY.keys();
			List t5KqH9J9 = Collections.list(FCp4tcPJ);
			Collections.sort(t5KqH9J9);
			MmgylgQQ = t5KqH9J9.iterator();
			ieN56fcZ = 0;
			while (MmgylgQQ.hasNext()) {
				String Nc3ttYTT = (String) MmgylgQQ.next();
				String iFVjzgzP = vvFgkqPY.getProperty(Nc3ttYTT);
				if (iFVjzgzP != null) {
					this.properties.setProperty(Nc3ttYTT, iFVjzgzP);
					finer("  (+)" + Nc3ttYTT + " -> " + iFVjzgzP);
					ieN56fcZ++;
				}
			}
			finer("Configuration: " + ieN56fcZ + " properties added from secondary properties file.");
		} catch (SecurityException GoQnadKM) {
			System.err.println(GoQnadKM.getLocalizedMessage());
		}
	}

}