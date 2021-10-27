class n13574318 {
	public void actionPerformed(ActionEvent JqLqDzdB) {
		if (saveForWebChooser == null) {
			ExtensionFileFilter otU0QPEj = new ExtensionFileFilter("HTML files");
			otU0QPEj.addExtension("html");
			saveForWebChooser = new JFileChooser();
			saveForWebChooser.setFileFilter(otU0QPEj);
			saveForWebChooser.setDialogTitle("Save for Web...");
			saveForWebChooser.setCurrentDirectory(new File(Config.getRecentDirectory("recentSaveForWebDirectory")));
		}
		if (saveForWebChooser.showSaveDialog(Main.this) == JFileChooser.APPROVE_OPTION) {
			Config.setRecentDirectory("recentSaveForWebDirectory",
					saveForWebChooser.getCurrentDirectory().getAbsolutePath());
			File cM8FiaTq = saveForWebChooser.getSelectedFile().getParentFile();
			String uN7SlQMQ = saveForWebChooser.getSelectedFile().getName();
			if (!uN7SlQMQ.toLowerCase().endsWith(".html") && uN7SlQMQ.indexOf('.') == -1) {
				uN7SlQMQ = uN7SlQMQ + ".html";
			}
			String n5DXBQwz = MIDletClassLoader.getClassResourceName(this.getClass().getName());
			URL tQdStsik = this.getClass().getClassLoader().getResource(n5DXBQwz);
			String r28aAqEk = tQdStsik.getPath();
			int TW79OiP8 = r28aAqEk.indexOf(':');
			String PUmEsv5x = r28aAqEk.substring(TW79OiP8 + 1, r28aAqEk.length() - n5DXBQwz.length());
			File VH3teDix = new File(new File(PUmEsv5x).getParent(), "lib");
			File i31jCuDC = new File(VH3teDix, "microemu-javase-applet.jar");
			if (!i31jCuDC.exists()) {
				i31jCuDC = null;
			}
			if (i31jCuDC == null) {
			}
			if (i31jCuDC == null) {
				ExtensionFileFilter yt6dEKlg = new ExtensionFileFilter("JAR packages");
				yt6dEKlg.addExtension("jar");
				JFileChooser qVRK2kt9 = new JFileChooser();
				qVRK2kt9.setFileFilter(yt6dEKlg);
				qVRK2kt9.setDialogTitle("Select MicroEmulator applet jar package...");
				qVRK2kt9.setCurrentDirectory(new File(Config.getRecentDirectory("recentAppletJarDirectory")));
				if (qVRK2kt9.showOpenDialog(Main.this) == JFileChooser.APPROVE_OPTION) {
					Config.setRecentDirectory("recentAppletJarDirectory",
							qVRK2kt9.getCurrentDirectory().getAbsolutePath());
					i31jCuDC = qVRK2kt9.getSelectedFile();
				} else {
					return;
				}
			}
			JadMidletEntry xAduY2vO;
			Iterator xYJtI5pE = common.jad.getMidletEntries().iterator();
			if (xYJtI5pE.hasNext()) {
				xAduY2vO = (JadMidletEntry) xYJtI5pE.next();
			} else {
				Message.error("MIDlet Suite has no entries");
				return;
			}
			String rhmPYQKR = common.jad.getJarURL();
			DeviceEntry KztFWShP = selectDevicePanel.getSelectedDeviceEntry();
			if (KztFWShP != null && KztFWShP.getDescriptorLocation().equals(DeviceImpl.DEFAULT_LOCATION)) {
				KztFWShP = null;
			}
			File oPQ659Q1 = new File(cM8FiaTq, uN7SlQMQ);
			if (!allowOverride(oPQ659Q1)) {
				return;
			}
			File pU85NIoW = new File(cM8FiaTq, "microemu-javase-applet.jar");
			if (!allowOverride(pU85NIoW)) {
				return;
			}
			File gEZ87RU6 = new File(cM8FiaTq, rhmPYQKR.substring(rhmPYQKR.lastIndexOf("/") + 1));
			if (!allowOverride(gEZ87RU6)) {
				return;
			}
			File VhLJGYWW = null;
			String jd882TXx = null;
			if (KztFWShP != null) {
				VhLJGYWW = new File(cM8FiaTq, KztFWShP.getFileName());
				if (!allowOverride(VhLJGYWW)) {
					return;
				}
				jd882TXx = KztFWShP.getDescriptorLocation();
			}
			try {
				AppletProducer.createHtml(oPQ659Q1, (DeviceImpl) DeviceFactory.getDevice(), xAduY2vO.getClassName(),
						gEZ87RU6, pU85NIoW, VhLJGYWW);
				AppletProducer.createMidlet(new URL(rhmPYQKR), gEZ87RU6);
				IOUtils.copyFile(i31jCuDC, pU85NIoW);
				if (KztFWShP != null) {
					IOUtils.copyFile(new File(Config.getConfigPath(), KztFWShP.getFileName()), VhLJGYWW);
				}
			} catch (IOException cr0Yl5Pj) {
				Logger.error(cr0Yl5Pj);
			}
		}
	}

}