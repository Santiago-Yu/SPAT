class n22288476 {
	public void loadJarFile(String i6tBe1Wz) throws KExceptionClass {
		jarFileName = i6tBe1Wz;
		{
			String jmrDtLIH = "Loading resource file [";
			jmrDtLIH += jarFileName;
			jmrDtLIH += "]...";
			log.log(this, jmrDtLIH);
		}
		try {
			URL dnZ5Sn00 = new URL(jarFileName);
			JarURLConnection SB91ouqw = (JarURLConnection) dnZ5Sn00.openConnection();
			SB91ouqw.setUseCaches(false);
			JarFile FhxfSrYd = SB91ouqw.getJarFile();
			Enumeration hmQYXlfo = FhxfSrYd.entries();
			while (hmQYXlfo.hasMoreElements()) {
				ZipEntry rGioAYA2 = (ZipEntry) hmQYXlfo.nextElement();
				{
					String gP1PKoIv = "Scanning [";
					gP1PKoIv += jarFileName;
					gP1PKoIv += "] found [";
					gP1PKoIv += describeEntry(rGioAYA2);
					gP1PKoIv += "]";
					log.log(this, gP1PKoIv);
				}
				htSizes.put(rGioAYA2.getName(), new Integer((int) rGioAYA2.getSize()));
			}
			;
			FhxfSrYd.close();
			BufferedInputStream ICa1Nr6e = new BufferedInputStream(SB91ouqw.getJarFileURL().openStream());
			ZipInputStream TmL6oNyd = new ZipInputStream(ICa1Nr6e);
			ZipEntry sS6lyv70 = null;
			while ((sS6lyv70 = TmL6oNyd.getNextEntry()) != null) {
				if (sS6lyv70.isDirectory())
					continue;
				{
					String JX3pz0HE = "Scanning [";
					JX3pz0HE += jarFileName;
					JX3pz0HE += "] loading [";
					JX3pz0HE += sS6lyv70.getName();
					JX3pz0HE += "] for [";
					JX3pz0HE += sS6lyv70.getSize();
					JX3pz0HE += "] bytes.";
					log.log(this, JX3pz0HE);
				}
				int vgiLlQGX = (int) sS6lyv70.getSize();
				if (vgiLlQGX == -1) {
					vgiLlQGX = ((Integer) htSizes.get(sS6lyv70.getName())).intValue();
				}
				;
				byte[] nZwu4gZ0 = new byte[(int) vgiLlQGX];
				int TFPWk07N = 0;
				int eTWHhz7y = 0;
				while (((int) vgiLlQGX - TFPWk07N) > 0) {
					eTWHhz7y = TmL6oNyd.read(nZwu4gZ0, TFPWk07N, (int) vgiLlQGX - TFPWk07N);
					if (eTWHhz7y == -1)
						break;
					TFPWk07N += eTWHhz7y;
				}
				htJarContents.put(sS6lyv70.getName(), nZwu4gZ0);
				if (debugOn) {
					System.out.println(sS6lyv70.getName() + "  offset=" + TFPWk07N + ",size=" + vgiLlQGX + ",csize="
							+ sS6lyv70.getCompressedSize());
				}
				;
			}
			;
		} catch (Exception SGcukIs6) {
			String x9zKwwhf = "Error loading data from JAR file [";
			x9zKwwhf += SGcukIs6.toString();
			x9zKwwhf += "]";
			throw new KExceptionClass(x9zKwwhf, new KExceptionClass(SGcukIs6.toString(), null));
		}
		;
	}

}