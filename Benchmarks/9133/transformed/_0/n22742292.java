class n22742292 {
	private static void initMagicRules() {
		InputStream EUX3mnrq = null;
		try {
			String CEhR7kbQ = System.getProperty("magic-mime");
			if (CEhR7kbQ != null && CEhR7kbQ.length() != 0) {
				EUX3mnrq = new FileInputStream(CEhR7kbQ);
				if (EUX3mnrq != null) {
					parse("-Dmagic-mime=" + CEhR7kbQ, new InputStreamReader(EUX3mnrq));
				}
			}
		} catch (Exception ijZzHhDI) {
			log.error("Failed to parse custom magic mime file defined by system property -Dmagic-mime ["
					+ System.getProperty("magic-mime") + "]. File will be ignored.", ijZzHhDI);
		} finally {
			EUX3mnrq = closeStream(EUX3mnrq);
		}
		try {
			Enumeration zhH9Sbl5 = MimeUtil.class.getClassLoader().getResources("magic.mime");
			while (zhH9Sbl5.hasMoreElements()) {
				URL HmpheVTF = (URL) zhH9Sbl5.nextElement();
				EUX3mnrq = HmpheVTF.openStream();
				if (EUX3mnrq != null) {
					try {
						parse("classpath:[" + HmpheVTF + "]", new InputStreamReader(EUX3mnrq));
					} catch (Exception WWLn8v6e) {
						log.error("Failed to parse magic.mime rule file [" + HmpheVTF
								+ "] on the classpath. File will be ignored.", WWLn8v6e);
					}
				}
			}
		} catch (Exception AqGRGwvK) {
			log.error("Problem while processing magic.mime files from classpath. Files will be ignored.", AqGRGwvK);
		} finally {
			EUX3mnrq = closeStream(EUX3mnrq);
		}
		try {
			File Iz00HSxc = new File(System.getProperty("user.home") + File.separator + ".magic.mime");
			if (Iz00HSxc.exists()) {
				EUX3mnrq = new FileInputStream(Iz00HSxc);
				if (EUX3mnrq != null) {
					try {
						parse(Iz00HSxc.getAbsolutePath(), new InputStreamReader(EUX3mnrq));
					} catch (Exception xUxoXWR4) {
						log.error(
								"Failed to parse .magic.mime file from the users home directory. File will be ignored.",
								xUxoXWR4);
					}
				}
			}
		} catch (Exception YRDEdJg9) {
			log.error("Problem while processing .magic.mime file from the users home directory. File will be ignored.",
					YRDEdJg9);
		} finally {
			EUX3mnrq = closeStream(EUX3mnrq);
		}
		try {
			String U8YHnPAp = System.getProperty("MAGIC");
			if (U8YHnPAp != null && U8YHnPAp.length() != 0) {
				if (U8YHnPAp.indexOf('.') < 0) {
					U8YHnPAp = U8YHnPAp + ".mime";
				} else {
					U8YHnPAp = U8YHnPAp.substring(0, U8YHnPAp.indexOf('.') - 1) + "mime";
				}
				File rg71E2vD = new File(U8YHnPAp);
				if (rg71E2vD.exists()) {
					EUX3mnrq = new FileInputStream(rg71E2vD);
					if (EUX3mnrq != null) {
						try {
							parse(rg71E2vD.getAbsolutePath(), new InputStreamReader(EUX3mnrq));
						} catch (Exception MFf2l5tt) {
							log.error(
									"Failed to parse magic.mime file from directory located by environment variable MAGIC. File will be ignored.",
									MFf2l5tt);
						}
					}
				}
			}
		} catch (Exception KjYfKW4f) {
			log.error(
					"Problem while processing magic.mime file from directory located by environment variable MAGIC. File will be ignored.",
					KjYfKW4f);
		} finally {
			EUX3mnrq = closeStream(EUX3mnrq);
		}
		int J3RXB9qW = mMagicMimeEntries.size();
		Iterator b9CzqTRZ = magicMimeFileLocations.iterator();
		while (b9CzqTRZ.hasNext()) {
			parseMagicMimeFileLocation((String) b9CzqTRZ.next());
		}
		if (J3RXB9qW == mMagicMimeEntries.size()) {
			try {
				String Z8dHXWQX = "eu/medsea/mimeutil/magic.mime";
				EUX3mnrq = MimeUtil.class.getClassLoader().getResourceAsStream(Z8dHXWQX);
				if (EUX3mnrq != null) {
					try {
						parse("resource:" + Z8dHXWQX, new InputStreamReader(EUX3mnrq));
					} catch (Exception YTNwSCJ5) {
						log.error("Failed to parse internal magic.mime file.", YTNwSCJ5);
					}
				}
			} catch (Exception ftMkdAK1) {
				log.error("Problem while processing internal magic.mime file.", ftMkdAK1);
			} finally {
				EUX3mnrq = closeStream(EUX3mnrq);
			}
		}
	}

}