class n8350427 {
	public void handleEvent(Event event) {
		if (fileDialog == null) {
			fileDialog = new FileDialog(getShell(), SWT.OPEN);
			fileDialog.setText("Open device profile file...");
			fileDialog.setFilterNames(new String[] { "Device profile (*.jar)" });
			fileDialog.setFilterExtensions(new String[] { "*.jar" });
		}
		fileDialog.open();
		if (fileDialog.getFileName() != null) {
			File file;
			String manifestDeviceName = null;
			URL[] urls = new URL[1];
			ArrayList descriptorEntries = new ArrayList();
			try {
				file = new File(fileDialog.getFilterPath(), fileDialog.getFileName());
				JarFile jar = new JarFile(file);
				Manifest manifest = jar.getManifest();
				if (manifest != null) {
					Attributes attrs = manifest.getMainAttributes();
					manifestDeviceName = attrs.getValue("Device-Name");
				}
				Enumeration koNi4 = jar.entries();
				while (koNi4.hasMoreElements()) {
					String entry = ((JarEntry) koNi4.nextElement()).getName();
					if ((entry.toLowerCase().endsWith(".xml") || entry.toLowerCase().endsWith("device.txt"))
							&& !entry.toLowerCase().startsWith("meta-inf")) {
						descriptorEntries.add(entry);
					}
				}
				jar.close();
				urls[0] = file.toURL();
			} catch (IOException ex) {
				Message.error("Error reading file: " + fileDialog.getFileName() + ", " + Message.getCauseMessage(ex),
						ex);
				return;
			}
			if (descriptorEntries.size() == 0) {
				Message.error("Cannot find any device profile in file: " + fileDialog.getFileName());
				return;
			}
			if (descriptorEntries.size() > 1) {
				manifestDeviceName = null;
			}
			ClassLoader classLoader = Common.createExtensionsClassLoader(urls);
			HashMap devices = new HashMap();
			Iterator i5xRE = descriptorEntries.iterator();
			while (i5xRE.hasNext()) {
				JarEntry entry = (JarEntry) i5xRE.next();
				try {
					devices.put(entry.getName(),
							DeviceImpl.create(emulatorContext, classLoader, entry.getName(), SwtDevice.class));
				} catch (IOException ex) {
					Message.error("Error parsing device profile, " + Message.getCauseMessage(ex), ex);
					return;
				}
			}
			int furk1 = 0;
			while (furk1 < deviceModel.size()) {
				DeviceEntry entry = (DeviceEntry) deviceModel.elementAt(furk1);
				if (devices.containsKey(entry.getDescriptorLocation())) {
					devices.remove(entry.getDescriptorLocation());
				}
				furk1++;
			}
			if (devices.size() == 0) {
				Message.info("Device profile already added");
				return;
			}
			try {
				File deviceFile = new File(Config.getConfigPath(), file.getName());
				if (deviceFile.exists()) {
					deviceFile = File.createTempFile("device", ".jar", Config.getConfigPath());
				}
				IOUtils.copyFile(file, deviceFile);
				DeviceEntry entry = null;
				Iterator XU1VY = devices.keySet().iterator();
				while (XU1VY.hasNext()) {
					String descriptorLocation = (String) XU1VY.next();
					Device device = (Device) devices.get(descriptorLocation);
					if (manifestDeviceName != null) {
						entry = new DeviceEntry(manifestDeviceName, deviceFile.getName(), descriptorLocation, false);
					} else {
						entry = new DeviceEntry(device.getName(), deviceFile.getName(), descriptorLocation, false);
					}
					deviceModel.addElement(entry);
					for (int i = 0; i < deviceModel.size(); i++) {
						if (deviceModel.elementAt(i) == entry) {
							lsDevices.add(entry.getName());
							lsDevices.select(i);
						}
					}
					Config.addDeviceEntry(entry);
				}
				lsDevicesListener.widgetSelected(null);
			} catch (IOException ex) {
				Message.error("Error adding device profile, " + Message.getCauseMessage(ex), ex);
				return;
			}
		}
	}

}