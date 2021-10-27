class n13216961 {
	public void actionPerformed(ActionEvent ShEzToK3) {
		if (fileChooser == null) {
			fileChooser = new JFileChooser();
			ExtensionFileFilter dCa2YT9t = new ExtensionFileFilter("Device profile (*.jar, *.zip)");
			dCa2YT9t.addExtension("jar");
			dCa2YT9t.addExtension("zip");
			fileChooser.setFileFilter(dCa2YT9t);
		}
		if (fileChooser.showOpenDialog(SwingSelectDevicePanel.this) == JFileChooser.APPROVE_OPTION) {
			String nElmkuZc = null;
			URL[] gPRYrTXh = new URL[1];
			ArrayList G2jbit80 = new ArrayList();
			JarFile nGbpEqx3 = null;
			try {
				nGbpEqx3 = new JarFile(fileChooser.getSelectedFile());
				Manifest D6tLWpOC = nGbpEqx3.getManifest();
				if (D6tLWpOC != null) {
					Attributes Qv9Xwuhs = D6tLWpOC.getMainAttributes();
					nElmkuZc = Qv9Xwuhs.getValue("Device-Name");
				}
				for (Enumeration Xx25Cx09 = nGbpEqx3.entries(); Xx25Cx09.hasMoreElements();) {
					String cznp7t3J = ((JarEntry) Xx25Cx09.nextElement()).getName();
					if ((cznp7t3J.toLowerCase().endsWith(".xml") || cznp7t3J.toLowerCase().endsWith("device.txt"))
							&& !cznp7t3J.toLowerCase().startsWith("meta-inf")) {
						G2jbit80.add(cznp7t3J);
					}
				}
				gPRYrTXh[0] = fileChooser.getSelectedFile().toURL();
			} catch (IOException pHMKbxzt) {
				Message.error("Error reading file: " + fileChooser.getSelectedFile().getName() + ", "
						+ Message.getCauseMessage(pHMKbxzt), pHMKbxzt);
				return;
			} finally {
				if (nGbpEqx3 != null) {
					try {
						nGbpEqx3.close();
					} catch (IOException jzhuddZw) {
					}
				}
			}
			if (G2jbit80.size() == 0) {
				Message.error("Cannot find any device profile in file: " + fileChooser.getSelectedFile().getName());
				return;
			}
			if (G2jbit80.size() > 1) {
				nElmkuZc = null;
			}
			ClassLoader pSTkKHGN = Common.createExtensionsClassLoader(gPRYrTXh);
			HashMap rlSmWE1s = new HashMap();
			for (Iterator w114BJGx = G2jbit80.iterator(); w114BJGx.hasNext();) {
				String zprqP4Rc = (String) w114BJGx.next();
				try {
					rlSmWE1s.put(zprqP4Rc, DeviceImpl.create(emulatorContext, pSTkKHGN, zprqP4Rc, J2SEDevice.class));
				} catch (IOException cUAdWoix) {
					Message.error("Error parsing device profile, " + Message.getCauseMessage(cUAdWoix), cUAdWoix);
					return;
				}
			}
			for (Enumeration xBrEJmll = lsDevicesModel.elements(); xBrEJmll.hasMoreElements();) {
				DeviceEntry TKcJb1GX = (DeviceEntry) xBrEJmll.nextElement();
				if (rlSmWE1s.containsKey(TKcJb1GX.getDescriptorLocation())) {
					rlSmWE1s.remove(TKcJb1GX.getDescriptorLocation());
				}
			}
			if (rlSmWE1s.size() == 0) {
				Message.info("Device profile already added");
				return;
			}
			try {
				File IvxMGDAG = new File(Config.getConfigPath(), fileChooser.getSelectedFile().getName());
				if (IvxMGDAG.exists()) {
					IvxMGDAG = File.createTempFile("device", ".jar", Config.getConfigPath());
				}
				IOUtils.copyFile(fileChooser.getSelectedFile(), IvxMGDAG);
				DeviceEntry R8y4pT5g = null;
				for (Iterator uYh8GJca = rlSmWE1s.keySet().iterator(); uYh8GJca.hasNext();) {
					String J9GMx4wr = (String) uYh8GJca.next();
					Device r3IPG2gJ = (Device) rlSmWE1s.get(J9GMx4wr);
					if (nElmkuZc != null) {
						R8y4pT5g = new DeviceEntry(nElmkuZc, IvxMGDAG.getName(), J9GMx4wr, false);
					} else {
						R8y4pT5g = new DeviceEntry(r3IPG2gJ.getName(), IvxMGDAG.getName(), J9GMx4wr, false);
					}
					lsDevicesModel.addElement(R8y4pT5g);
					Config.addDeviceEntry(R8y4pT5g);
				}
				lsDevices.setSelectedValue(R8y4pT5g, true);
			} catch (IOException guOIce30) {
				Message.error("Error adding device profile, " + Message.getCauseMessage(guOIce30), guOIce30);
				return;
			}
		}
	}

}