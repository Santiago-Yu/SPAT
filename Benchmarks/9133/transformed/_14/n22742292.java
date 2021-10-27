class n22742292 {
	private static void initMagicRules() {
		InputStream in = null;
		try {
			String fname = System.getProperty("magic-mime");
			if (fname != null && fname.length() != 0) {
				in = new FileInputStream(fname);
				if (in != null) {
					parse("-Dmagic-mime=" + fname, new InputStreamReader(in));
				}
			}
		} catch (Exception e) {
			log.error("Failed to parse custom magic mime file defined by system property -Dmagic-mime ["
					+ System.getProperty("magic-mime") + "]. File will be ignored.", e);
		} finally {
			in = closeStream(in);
		}
		try {
			Enumeration en = MimeUtil.class.getClassLoader().getResources("magic.mime");
			while (en.hasMoreElements()) {
				URL url = (URL) en.nextElement();
				in = url.openStream();
				if (in != null) {
					try {
						parse("classpath:[" + url + "]", new InputStreamReader(in));
					} catch (Exception ex) {
						log.error("Failed to parse magic.mime rule file [" + url
								+ "] on the classpath. File will be ignored.", ex);
					}
				}
			}
		} catch (Exception e) {
			log.error("Problem while processing magic.mime files from classpath. Files will be ignored.", e);
		} finally {
			in = closeStream(in);
		}
		try {
			File f = new File(System.getProperty("user.home") + File.separator + ".magic.mime");
			if (f.exists()) {
				in = new FileInputStream(f);
				if (in != null) {
					try {
						parse(f.getAbsolutePath(), new InputStreamReader(in));
					} catch (Exception ex) {
						log.error(
								"Failed to parse .magic.mime file from the users home directory. File will be ignored.",
								ex);
					}
				}
			}
		} catch (Exception e) {
			log.error("Problem while processing .magic.mime file from the users home directory. File will be ignored.",
					e);
		} finally {
			in = closeStream(in);
		}
		try {
			String name = System.getProperty("MAGIC");
			if (name != null && name.length() != 0) {
				if (name.indexOf('.') < 0) {
					name = name + ".mime";
				} else {
					name = name.substring(0, name.indexOf('.') - 1) + "mime";
				}
				File f = new File(name);
				if (f.exists()) {
					in = new FileInputStream(f);
					if (in != null) {
						try {
							parse(f.getAbsolutePath(), new InputStreamReader(in));
						} catch (Exception ex) {
							log.error(
									"Failed to parse magic.mime file from directory located by environment variable MAGIC. File will be ignored.",
									ex);
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(
					"Problem while processing magic.mime file from directory located by environment variable MAGIC. File will be ignored.",
					e);
		} finally {
			in = closeStream(in);
		}
		int mMagicMimeEntriesSizeBeforeReadingOS = mMagicMimeEntries.size();
		Iterator it = magicMimeFileLocations.iterator();
		while (it.hasNext()) {
			parseMagicMimeFileLocation((String) it.next());
		}
		if (mMagicMimeEntries.size() == mMagicMimeEntriesSizeBeforeReadingOS) {
			try {
				String resource = "eu/medsea/mimeutil/magic.mime";
				in = MimeUtil.class.getClassLoader().getResourceAsStream(resource);
				if (in != null) {
					try {
						parse("resource:" + resource, new InputStreamReader(in));
					} catch (Exception ex) {
						log.error("Failed to parse internal magic.mime file.", ex);
					}
				}
			} catch (Exception e) {
				log.error("Problem while processing internal magic.mime file.", e);
			} finally {
				in = closeStream(in);
			}
		}
	}

}