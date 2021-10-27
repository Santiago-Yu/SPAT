class n8350427 {
	public void handleEvent(Event AQntHjg2) {
		if (fileDialog == null) {
			fileDialog = new FileDialog(getShell(), SWT.OPEN);
			fileDialog.setText("Open device profile file...");
			fileDialog.setFilterNames(new String[] { "Device profile (*.jar)" });
			fileDialog.setFilterExtensions(new String[] { "*.jar" });
		}
		fileDialog.open();
		if (fileDialog.getFileName() != null) {
			File uqaCZd6U;
			String rY1WXQI8 = null;
			URL[] hOmWSzdQ = new URL[1];
			ArrayList atwvl8Ch = new ArrayList();
			try {
				uqaCZd6U = new File(fileDialog.getFilterPath(), fileDialog.getFileName());
				JarFile H1a3DoZT = new JarFile(uqaCZd6U);
				Manifest cghcUzek = H1a3DoZT.getManifest();
				if (cghcUzek != null) {
					Attributes HAyMPYjW = cghcUzek.getMainAttributes();
					rY1WXQI8 = HAyMPYjW.getValue("Device-Name");
				}
				for (Enumeration pZI7sYHH = H1a3DoZT.entries(); pZI7sYHH.hasMoreElements();) {
					String scw5pUXs = ((JarEntry) pZI7sYHH.nextElement()).getName();
					if ((scw5pUXs.toLowerCase().endsWith(".xml") || scw5pUXs.toLowerCase().endsWith("device.txt"))
							&& !scw5pUXs.toLowerCase().startsWith("meta-inf")) {
						atwvl8Ch.add(scw5pUXs);
					}
				}
				H1a3DoZT.close();
				hOmWSzdQ[0] = uqaCZd6U.toURL();
			} catch (IOException HClJRq3O) {
				Message.error(
						"Error reading file: " + fileDialog.getFileName() + ", " + Message.getCauseMessage(HClJRq3O),
						HClJRq3O);
				return;
			}
			if (atwvl8Ch.size() == 0) {
				Message.error("Cannot find any device profile in file: " + fileDialog.getFileName());
				return;
			}
			if (atwvl8Ch.size() > 1) {
				rY1WXQI8 = null;
			}
			ClassLoader gw2ErZzv = Common.createExtensionsClassLoader(hOmWSzdQ);
			HashMap Y0PEAO7g = new HashMap();
			for (Iterator wnQqpc5Z = atwvl8Ch.iterator(); wnQqpc5Z.hasNext();) {
				JarEntry mUNtsRXg = (JarEntry) wnQqpc5Z.next();
				try {
					Y0PEAO7g.put(mUNtsRXg.getName(),
							DeviceImpl.create(emulatorContext, gw2ErZzv, mUNtsRXg.getName(), SwtDevice.class));
				} catch (IOException m4TF5TcR) {
					Message.error("Error parsing device profile, " + Message.getCauseMessage(m4TF5TcR), m4TF5TcR);
					return;
				}
			}
			for (int kOuyhJza = 0; kOuyhJza < deviceModel.size(); kOuyhJza++) {
				DeviceEntry StCoS3SN = (DeviceEntry) deviceModel.elementAt(kOuyhJza);
				if (Y0PEAO7g.containsKey(StCoS3SN.getDescriptorLocation())) {
					Y0PEAO7g.remove(StCoS3SN.getDescriptorLocation());
				}
			}
			if (Y0PEAO7g.size() == 0) {
				Message.info("Device profile already added");
				return;
			}
			try {
				File sWgeFgMp = new File(Config.getConfigPath(), uqaCZd6U.getName());
				if (sWgeFgMp.exists()) {
					sWgeFgMp = File.createTempFile("device", ".jar", Config.getConfigPath());
				}
				IOUtils.copyFile(uqaCZd6U, sWgeFgMp);
				DeviceEntry CK8aPoTR = null;
				for (Iterator ekfP5K8z = Y0PEAO7g.keySet().iterator(); ekfP5K8z.hasNext();) {
					String RAtChRKV = (String) ekfP5K8z.next();
					Device Zx4lRVPQ = (Device) Y0PEAO7g.get(RAtChRKV);
					if (rY1WXQI8 != null) {
						CK8aPoTR = new DeviceEntry(rY1WXQI8, sWgeFgMp.getName(), RAtChRKV, false);
					} else {
						CK8aPoTR = new DeviceEntry(Zx4lRVPQ.getName(), sWgeFgMp.getName(), RAtChRKV, false);
					}
					deviceModel.addElement(CK8aPoTR);
					for (int C3wjAujT = 0; C3wjAujT < deviceModel.size(); C3wjAujT++) {
						if (deviceModel.elementAt(C3wjAujT) == CK8aPoTR) {
							lsDevices.add(CK8aPoTR.getName());
							lsDevices.select(C3wjAujT);
						}
					}
					Config.addDeviceEntry(CK8aPoTR);
				}
				lsDevicesListener.widgetSelected(null);
			} catch (IOException XdU6SEsG) {
				Message.error("Error adding device profile, " + Message.getCauseMessage(XdU6SEsG), XdU6SEsG);
				return;
			}
		}
	}

}