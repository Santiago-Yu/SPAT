class n14652853 {
	public static void main(String Ni8Tucgk[]) {
		String qovFfCad = null;
		;
		File FSG4ajSu = null;
		File SVN5Uho9 = null;
		File ISx35e5A = null;
		File SQR3HGYf = null;
		File xfvQ1r1E = null;
		File zjBzlh6B = null;
		File oUI3T8d8 = null;
		List z8KSVcl8 = new ArrayList();
		for (int tbLvH4cT = 0; tbLvH4cT < Ni8Tucgk.length; tbLvH4cT++) {
			z8KSVcl8.add(Ni8Tucgk[tbLvH4cT]);
		}
		Iterator bQ2VkqQE = z8KSVcl8.iterator();
		while (bQ2VkqQE.hasNext()) {
			String tyVrUNil = (String) bQ2VkqQE.next();
			bQ2VkqQE.remove();
			if ((tyVrUNil.equals("--help")) || (tyVrUNil.equals("-help"))) {
				System.out.println(usage());
				System.exit(0);
			} else if (tyVrUNil.equals("--midletClass")) {
				qovFfCad = (String) bQ2VkqQE.next();
				bQ2VkqQE.remove();
			} else if (tyVrUNil.equals("--appletInput")) {
				FSG4ajSu = new File((String) bQ2VkqQE.next());
				bQ2VkqQE.remove();
			} else if (tyVrUNil.equals("--deviceInput")) {
				SVN5Uho9 = new File((String) bQ2VkqQE.next());
				bQ2VkqQE.remove();
			} else if (tyVrUNil.equals("--midletInput")) {
				ISx35e5A = new File((String) bQ2VkqQE.next());
				bQ2VkqQE.remove();
			} else if (tyVrUNil.equals("--htmlOutput")) {
				SQR3HGYf = new File((String) bQ2VkqQE.next());
				bQ2VkqQE.remove();
			} else if (tyVrUNil.equals("--appletOutput")) {
				xfvQ1r1E = new File((String) bQ2VkqQE.next());
				bQ2VkqQE.remove();
			} else if (tyVrUNil.equals("--deviceOutput")) {
				zjBzlh6B = new File((String) bQ2VkqQE.next());
				bQ2VkqQE.remove();
			} else if (tyVrUNil.equals("--midletOutput")) {
				oUI3T8d8 = new File((String) bQ2VkqQE.next());
				bQ2VkqQE.remove();
			}
		}
		if (qovFfCad == null || FSG4ajSu == null || SVN5Uho9 == null || ISx35e5A == null || SQR3HGYf == null
				|| xfvQ1r1E == null || zjBzlh6B == null || oUI3T8d8 == null) {
			System.out.println(usage());
			System.exit(0);
		}
		try {
			DeviceImpl SFX7Z0Ts = null;
			String CCCYZKdl = null;
			JarFile aqYb5670 = new JarFile(SVN5Uho9);
			for (Enumeration gpYKaCl1 = aqYb5670.entries(); gpYKaCl1.hasMoreElements();) {
				String QoxNXqcq = ((JarEntry) gpYKaCl1.nextElement()).getName();
				if ((QoxNXqcq.toLowerCase().endsWith(".xml") || QoxNXqcq.toLowerCase().endsWith("device.txt"))
						&& !QoxNXqcq.toLowerCase().startsWith("meta-inf")) {
					CCCYZKdl = QoxNXqcq;
					break;
				}
			}
			if (CCCYZKdl != null) {
				EmulatorContext AfvBfcwl = new EmulatorContext() {

					private DisplayComponent pFgJiabi = new NoUiDisplayComponent();

					private InputMethod en7ApOkv = new J2SEInputMethod();

					private DeviceDisplay uwcjh0h0 = new J2SEDeviceDisplay(this);

					private FontManager fChdQDnN = new J2SEFontManager();

					private DeviceComponent cJkFy3Rq = new SwingDeviceComponent(true);

					public DisplayComponent getDisplayComponent() {
						return pFgJiabi;
					}

					public InputMethod getDeviceInputMethod() {
						return en7ApOkv;
					}

					public DeviceDisplay getDeviceDisplay() {
						return uwcjh0h0;
					}

					public FontManager getDeviceFontManager() {
						return fChdQDnN;
					}

					public InputStream getResourceAsStream(String Cynoiftx) {
						return MIDletBridge.getCurrentMIDlet().getClass().getResourceAsStream(Cynoiftx);
					}

					public DeviceComponent getDeviceComponent() {
						return cJkFy3Rq;
					}
				};
				URL[] Z7gY6vLu = new URL[1];
				Z7gY6vLu[0] = SVN5Uho9.toURI().toURL();
				ClassLoader yKGdAm3u = new ExtensionsClassLoader(Z7gY6vLu, Z7gY6vLu.getClass().getClassLoader());
				SFX7Z0Ts = DeviceImpl.create(AfvBfcwl, yKGdAm3u, CCCYZKdl, J2SEDevice.class);
			}
			if (SFX7Z0Ts == null) {
				System.out.println("Error parsing device package: " + CCCYZKdl);
				System.exit(0);
			}
			createHtml(SQR3HGYf, SFX7Z0Ts, qovFfCad, oUI3T8d8, xfvQ1r1E, zjBzlh6B);
			createMidlet(ISx35e5A.toURI().toURL(), oUI3T8d8);
			IOUtils.copyFile(FSG4ajSu, xfvQ1r1E);
			IOUtils.copyFile(SVN5Uho9, zjBzlh6B);
		} catch (IOException CGII6pGj) {
			CGII6pGj.printStackTrace();
		}
		System.exit(0);
	}

}