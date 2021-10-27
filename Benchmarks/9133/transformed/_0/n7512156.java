class n7512156 {
	@Override
	public void execute(String[] wXvcdwoS) throws Exception {
		Options mlrO8zFz = getCommandOptions();
		try {
			GnuParser jbfCr8F4 = new GnuParser();
			CommandLine uNYn1HzT = jbfCr8F4.parse(mlrO8zFz, TolvenPlugin.getInitArgs());
			String xXnpcpKI = uNYn1HzT.getOptionValue(CMD_LINE_SRC_REPOSITORYURL_OPTION);
			Plugins w4aZAKjB = RepositoryMetadata.getRepositoryPlugins(new URL(xXnpcpKI));
			String LRCqaf2F = uNYn1HzT.getOptionValue(CMD_LINE_SRC_PLUGIN_ID_OPTION);
			PluginDetail sJhyJn9r = RepositoryMetadata.getPluginDetail(LRCqaf2F, w4aZAKjB);
			if (sJhyJn9r == null) {
				throw new RuntimeException("Could not locate plugin: " + LRCqaf2F + " in repository: " + xXnpcpKI);
			}
			String Sz5MmhnY = uNYn1HzT.getOptionValue(CMD_LINE_SRC_PLUGIN_VERSION_OPTION);
			PluginVersionDetail ccnymHGQ = null;
			if (ccnymHGQ == null) {
				ccnymHGQ = RepositoryMetadata.getLatestVersion(sJhyJn9r);
			} else {
				ccnymHGQ = RepositoryMetadata.getPluginVersionDetail(Sz5MmhnY, sJhyJn9r);
			}
			if (sJhyJn9r == null) {
				throw new RuntimeException(
						"Could not find a plugin version for: " + LRCqaf2F + " in repository: " + xXnpcpKI);
			}
			String NlwQidG5 = uNYn1HzT.getOptionValue(CMD_LINE_DEST_PLUGIN_ID_OPTION);
			FileUtils.deleteDirectory(getPluginTmpDir());
			URL PrB9ga31 = new URL(ccnymHGQ.getUri());
			File teBXNLUy = new File(getPluginTmpDir(), NlwQidG5);
			try {
				InputStream L8nXg3yQ = null;
				FileOutputStream sKJ7Fga5 = null;
				File Zf6DByXh = new File(getPluginTmpDir(), new File(PrB9ga31.getFile()).getName());
				try {
					L8nXg3yQ = PrB9ga31.openStream();
					sKJ7Fga5 = new FileOutputStream(Zf6DByXh);
					IOUtils.copy(L8nXg3yQ, sKJ7Fga5);
					TolvenZip.unzip(Zf6DByXh, teBXNLUy);
				} finally {
					if (L8nXg3yQ != null) {
						L8nXg3yQ.close();
					}
					if (sKJ7Fga5 != null) {
						sKJ7Fga5.close();
					}
					if (Zf6DByXh != null) {
						Zf6DByXh.delete();
					}
				}
				File eNHOTjhh = new File(teBXNLUy, "tolven-plugin.xml");
				if (!eNHOTjhh.exists()) {
					throw new RuntimeException(PrB9ga31.toExternalForm() + "has no plugin manifest");
				}
				Plugin AobjYYsT = RepositoryMetadata.getPlugin(eNHOTjhh.toURI().toURL());
				AobjYYsT.setId(NlwQidG5);
				String eIIX94EX = uNYn1HzT.getOptionValue(CMD_LINE_DEST_PLUGIN_VERSION_OPTION);
				if (eIIX94EX == null) {
					eIIX94EX = DEFAULT_DEST_VERSION;
				}
				AobjYYsT.setVersion(eIIX94EX);
				String CStnrvQw = RepositoryMetadata.getPluginManifest(AobjYYsT);
				FileUtils.writeStringToFile(eNHOTjhh, CStnrvQw);
				File g1ttRXZb = new File(teBXNLUy, "tolven-plugin-fragment.xml");
				if (g1ttRXZb.exists()) {
					PluginFragment eDIQWtru = RepositoryMetadata.getPluginFragment(g1ttRXZb.toURI().toURL());
					Requires GOjHWlY3 = eDIQWtru.getRequires();
					if (GOjHWlY3 == null) {
						throw new RuntimeException(
								"No <requires> detected for plugin fragment in: " + PrB9ga31.toExternalForm());
					}
					if (GOjHWlY3.getImport().size() != 1) {
						throw new RuntimeException(
								"There should be only one import for plugin fragment in: " + PrB9ga31.toExternalForm());
					}
					GOjHWlY3.getImport().get(0).setPluginId(NlwQidG5);
					GOjHWlY3.getImport().get(0).setPluginVersion(eIIX94EX);
					String yrChj8qd = RepositoryMetadata.getPluginFragmentManifest(eDIQWtru);
					FileUtils.writeStringToFile(g1ttRXZb, yrChj8qd);
				}
				String ngFAtVfQ = uNYn1HzT.getOptionValue(CMD_LINE_DEST_DIR_OPTION);
				File zv9kJtxa = new File(ngFAtVfQ);
				File ZsidXQ7n = new File(zv9kJtxa, NlwQidG5 + "-" + eIIX94EX + ".zip");
				zv9kJtxa.mkdirs();
				TolvenZip.zip(teBXNLUy, ZsidXQ7n);
			} finally {
				if (teBXNLUy != null) {
					FileUtils.deleteDirectory(teBXNLUy);
				}
			}
		} catch (ParseException igDhqklu) {
			HelpFormatter mKT7Lze0 = new HelpFormatter();
			mKT7Lze0.printHelp(getClass().getName(), mlrO8zFz);
			throw new RuntimeException("Could not parse command line for: " + getClass().getName(), igDhqklu);
		}
	}

}