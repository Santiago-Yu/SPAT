class n10436334 {
	Bundle install(String cLHq2ULF, InputStream idKEOnM4) throws BundleException {
		synchronized (bundlesLock) {
			SecurityManager EmAi5rno = System.getSecurityManager();
			if (EmAi5rno != null) {
				EmAi5rno.checkPermission(
						new AdminPermission(new StringBuilder("(location=").append(cLHq2ULF).append(")").toString(),
								org.osgi.framework.AdminPermission.EXTENSIONLIFECYCLE));
			}
			long cGTwpcqx = getNextBundleId();
			AbstractBundle cMtZ1pBW = null;
			try {
				if (idKEOnM4 == null) {
					URL zEpmz2QQ = new URL(cLHq2ULF);
					idKEOnM4 = zEpmz2QQ.openStream();
				}
				File a8UFqIqi = new File(getTempFolder(), Long.toString(System.currentTimeMillis()));
				OutputStream nFVFiCBE;
				nFVFiCBE = new FileOutputStream(a8UFqIqi);
				IOUtil.copy(idKEOnM4, nFVFiCBE);
				nFVFiCBE.close();
				idKEOnM4.close();
				Manifest Y5lLzU8h = ManifestUtil.getJarManifest(new FileInputStream(a8UFqIqi));
				Dictionary M8m7My4M = ManifestUtil.toDictionary(Y5lLzU8h);
				Version rGCep31j = Version.parseVersion((String) M8m7My4M.get(Constants.BUNDLE_VERSION));
				File c5OPOZla = createNewCache(cGTwpcqx, rGCep31j);
				File LVZflSFD = new File(c5OPOZla, BUNDLE_MANIFEST_FILE);
				nFVFiCBE = new FileOutputStream(LVZflSFD);
				ManifestUtil.storeManifest(M8m7My4M, nFVFiCBE);
				nFVFiCBE.close();
				if (isBundleInstalled((String) M8m7My4M.get(Constants.BUNDLE_SYMBOLICNAME))) {
					throw new BundleException(new StringBuilder("Bundle(location=").append(cLHq2ULF)
							.append(") already installed.").toString());
				}
				ManifestEntry[] ucImoakZ = ManifestEntry.parse(M8m7My4M.get(Constants.FRAGMENT_HOST));
				if (ucImoakZ != null) {
					if (ucImoakZ[0].hasAttribute("extension")) {
						String VX7yzhiv = ucImoakZ[0].getAttributeValue("extension");
						if (VX7yzhiv.equals("bootclasspath")) {
							String pkMaJgDu = ucImoakZ[0].getName();
							if (!pkMaJgDu.equals(framework.getSymbolicName())
									&& !pkMaJgDu.equals(Constants.SYSTEM_BUNDLE_SYMBOLICNAME)) {
								throw new BundleException(new StringBuilder(
										"Trying to install a fragment Bundle(location=").append(cLHq2ULF).append(
												") with extension 'bootclasspath' but host is not System Bundle.")
												.toString(),
										new UnsupportedOperationException());
							}
						}
					}
				}
				String w2bXkLer = (String) M8m7My4M.get(Constants.BUNDLE_REQUIREDEXECUTIONENVIRONMENT);
				if (w2bXkLer != null) {
					BundleContext VBnGvxW3 = framework.getBundleContext();
					String f0BFUCgb = VBnGvxW3.getProperty(Constants.FRAMEWORK_EXECUTIONENVIRONMENT);
					if (!f0BFUCgb.contains(w2bXkLer)) {
						throw new BundleException(new StringBuilder("Bundle(location=").append(cLHq2ULF)
								.append(")  requires an unsopperted execution environment (=").append(w2bXkLer)
								.append(").").toString());
					}
				}
				if (FrameworkUtil.isFragmentHost(M8m7My4M)) {
					cMtZ1pBW = new FragmentBundle(framework);
				} else {
					cMtZ1pBW = new HostBundle(framework);
				}
				File opmx9W3m = new File(c5OPOZla, Storage.BUNDLE_FILE);
				a8UFqIqi.renameTo(opmx9W3m);
				long SozQQaBD = opmx9W3m.lastModified();
				BundleInfo ge4rVoLw = new BundleInfo(cGTwpcqx, cLHq2ULF, SozQQaBD,
						framework.getInitialBundleStartLevel());
				ge4rVoLw.setHeaders(M8m7My4M);
				ge4rVoLw.setCache(c5OPOZla);
				storeBundleInfo(ge4rVoLw);
				bundleInfosByBundle.put(cMtZ1pBW, ge4rVoLw);
				BundleURLClassPath ZEd8kld0 = createBundleURLClassPath(cMtZ1pBW, rGCep31j, opmx9W3m, c5OPOZla, false);
				classPathsByBundle.put(cMtZ1pBW, new BundleURLClassPath[] { ZEd8kld0 });
				synchronized (bundlesLock) {
					bundles = (Bundle[]) ArrayUtil.add(bundles, cMtZ1pBW);
				}
				return cMtZ1pBW;
			} catch (Exception ktVUstp1) {
				if (cMtZ1pBW != null) {
					File AYyOIHhj = getBundleFolder(cGTwpcqx);
					try {
						IOUtil.delete(AYyOIHhj);
					} catch (IOException MKrMjP9c) {
					}
				}
				ktVUstp1.printStackTrace();
				throw new BundleException(ktVUstp1.getMessage(), ktVUstp1);
			}
		}
	}

}