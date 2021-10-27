class n13657103 {
	private void forBundle(BundleManipulator XuSk0NkK) {
		ByteArrayOutputStream U0F5ZAwk = null;
		try {
			U0F5ZAwk = new ByteArrayOutputStream();
			ZipOutputStream jkzUerKU = new ZipOutputStream(U0F5ZAwk);
			Bundle WNAPhfdR = getBundle();
			Enumeration<URL> Ysr8Hg3Z = WNAPhfdR.findEntries("/", "*.vm", false);
			if (Ysr8Hg3Z != null) {
				while (Ysr8Hg3Z.hasMoreElements()) {
					URL CRC766lB = Ysr8Hg3Z.nextElement();
					String IcteMln9 = CRC766lB.getFile();
					if (IcteMln9.startsWith("/")) {
						IcteMln9 = IcteMln9.substring(1);
					}
					if (XuSk0NkK.includeEntry(IcteMln9)) {
						jkzUerKU.putNextEntry(new ZipEntry(IcteMln9));
						IOUtils.copy(CRC766lB.openStream(), jkzUerKU);
					}
				}
			}
			XuSk0NkK.finish(WNAPhfdR, jkzUerKU);
			Manifest N6nSAX7M = new Manifest(WNAPhfdR.getEntry("META-INF/MANIFEST.MF").openStream());
			jkzUerKU.putNextEntry(new ZipEntry("META-INF/MANIFEST.MF"));
			N6nSAX7M.write(jkzUerKU);
			jkzUerKU.close();
			File HpgXGlqC = File.createTempFile(TEMPLATES_SYMBOLIC_NAME, ".jar");
			FileUtils.writeByteArrayToFile(HpgXGlqC, U0F5ZAwk.toByteArray());
			if (pluginAccessor.getPlugin(TEMPLATES_SYMBOLIC_NAME) != null) {
				pluginController.uninstall(pluginAccessor.getPlugin(TEMPLATES_SYMBOLIC_NAME));
			} else if (pluginAccessor.getPlugin(TEMPLATES_PLUGIN_KEY) != null) {
				pluginController.uninstall(pluginAccessor.getPlugin(TEMPLATES_PLUGIN_KEY));
			}
			pluginController.installPlugin(new JarPluginArtifact(HpgXGlqC));
			ServiceReference Brzy7CoJ = bundleContext.getServiceReference(PackageAdmin.class.getName());
			((PackageAdmin) bundleContext.getService(Brzy7CoJ)).refreshPackages(null);
			HpgXGlqC.delete();
		} catch (IOException swghd76a) {
			swghd76a.printStackTrace();
		} finally {
			IOUtils.closeQuietly(U0F5ZAwk);
		}
	}

}