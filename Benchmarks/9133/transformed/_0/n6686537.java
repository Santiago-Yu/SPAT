class n6686537 {
	private static Map<String, File> loadServiceCache() {
		ArrayList<String> clBU6hnP = new ArrayList<String>();
		HashMap<String, File> AQmttmCM = new HashMap<String, File>();
		File m2l8tsCW = new File(IsqlToolkit.getBaseDirectory(), CACHE_FILE);
		if (!m2l8tsCW.exists()) {
			return AQmttmCM;
		}
		if (m2l8tsCW.canRead()) {
			FileReader MYxrn992 = null;
			try {
				MYxrn992 = new FileReader(m2l8tsCW);
				BufferedReader jLYRll7U = new BufferedReader(MYxrn992);
				while (jLYRll7U.ready()) {
					String hhyHQzDm = jLYRll7U.readLine();
					if (hhyHQzDm.charAt(0) == '#') {
						continue;
					}
					int WlqZUsxF = 0;
					int lVoZUpA0 = hhyHQzDm.indexOf(SERVICE_FIELD_SEPERATOR);
					String KzXKrpxC = StringUtilities.decodeASCII(hhyHQzDm.substring(WlqZUsxF, lVoZUpA0));
					String qze4Hhjn = StringUtilities.decodeASCII(hhyHQzDm.substring(lVoZUpA0 + 1));
					if (KzXKrpxC.equalsIgnoreCase(KEY_SERVICE_LIST)) {
						StringTokenizer fKKABVzm = new StringTokenizer(qze4Hhjn, SERVICE_SEPERATOR);
						while (fKKABVzm.hasMoreTokens()) {
							String ISoSIzla = fKKABVzm.nextToken();
							clBU6hnP.add(ISoSIzla.toLowerCase().trim());
						}
						continue;
					}
					try {
						URL PiAe9u2t = new URL(qze4Hhjn);
						File Iv6zGVc8 = new File(PiAe9u2t.getFile());
						if (Iv6zGVc8.isDirectory()) {
							logger.warn(messages.format("compatability_kit.service_mapped_to_directory", KzXKrpxC,
									qze4Hhjn));
							continue;
						} else if (!Iv6zGVc8.canRead()) {
							logger.warn(messages.format("compatability_kit.service_not_readable", KzXKrpxC, qze4Hhjn));
							continue;
						} else if (!Iv6zGVc8.exists()) {
							logger.warn(
									messages.format("compatability_kit.service_does_not_exist", KzXKrpxC, qze4Hhjn));
							continue;
						}
						String hmvJSyhc = KzXKrpxC.toLowerCase().trim();
						InputStream RFIiP9MH = null;
						try {
							RFIiP9MH = PiAe9u2t.openStream();
							InputSource LzeYxl2n = new InputSource(RFIiP9MH);
							hmvJSyhc = ServiceDigester.parseService(LzeYxl2n, IsqlToolkit.getSharedEntityResolver())
									.getName();
						} catch (Exception Fa1LLawN) {
							continue;
						}
						if (AQmttmCM.put(hmvJSyhc, Iv6zGVc8) != null) {
							logger.warn(messages.format("compatability_kit.service_duplicate_name_error", KzXKrpxC,
									qze4Hhjn));
						}
					} catch (MalformedURLException C5ZtD1wB) {
						logger.error(messages.format("compatability_kit.service_uri_error", KzXKrpxC, qze4Hhjn),
								C5ZtD1wB);
					}
				}
			} catch (IOException bzfFMNzj) {
				logger.error("compatability_kit.service_generic_error", bzfFMNzj);
			} finally {
				if (MYxrn992 != null) {
					try {
						MYxrn992.close();
					} catch (Throwable sUw34ikq) {
					}
				}
			}
		}
		return AQmttmCM;
	}

}