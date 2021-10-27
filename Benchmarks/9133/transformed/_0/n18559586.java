class n18559586 {
	public void loadJarFile(String IUUUahmo) throws KExceptionClass {
		jarFileName = IUUUahmo;
		{
			String lLnp1DAa = "Loading resource file [";
			lLnp1DAa += jarFileName;
			lLnp1DAa += "]...";
			log.log(this, lLnp1DAa);
		}
		try {
			URL gdPwiZi9 = new URL(jarFileName);
			JarURLConnection WqUlRAOy = (JarURLConnection) gdPwiZi9.openConnection();
			WqUlRAOy.setUseCaches(false);
			JarFile XApTt6ES = WqUlRAOy.getJarFile();
			Enumeration kYqcmtjX = XApTt6ES.entries();
			while (kYqcmtjX.hasMoreElements()) {
				ZipEntry mYCYAsjW = (ZipEntry) kYqcmtjX.nextElement();
				{
					String e22ArlMT = "Scanning [";
					e22ArlMT += jarFileName;
					e22ArlMT += "] found [";
					e22ArlMT += describeEntry(mYCYAsjW);
					e22ArlMT += "]";
					log.log(this, e22ArlMT);
				}
				htSizes.put(mYCYAsjW.getName(), new Integer((int) mYCYAsjW.getSize()));
			}
			;
			XApTt6ES.close();
			BufferedInputStream BFxIU43w = new BufferedInputStream(WqUlRAOy.getJarFileURL().openStream());
			ZipInputStream vJibzmul = new ZipInputStream(BFxIU43w);
			ZipEntry q12a50Hu = null;
			while ((q12a50Hu = vJibzmul.getNextEntry()) != null) {
				if (q12a50Hu.isDirectory())
					continue;
				{
					String pWJYbsaW = "Scanning [";
					pWJYbsaW += jarFileName;
					pWJYbsaW += "] loading [";
					pWJYbsaW += q12a50Hu.getName();
					pWJYbsaW += "] for [";
					pWJYbsaW += q12a50Hu.getSize();
					pWJYbsaW += "] bytes.";
					log.log(this, pWJYbsaW);
				}
				int GDfW37S0 = (int) q12a50Hu.getSize();
				if (GDfW37S0 == -1) {
					GDfW37S0 = ((Integer) htSizes.get(q12a50Hu.getName())).intValue();
				}
				;
				byte[] bpGco9AW = new byte[(int) GDfW37S0];
				int m0ChPtcj = 0;
				int wAJn8s7V = 0;
				while (((int) GDfW37S0 - m0ChPtcj) > 0) {
					wAJn8s7V = vJibzmul.read(bpGco9AW, m0ChPtcj, (int) GDfW37S0 - m0ChPtcj);
					if (wAJn8s7V == -1)
						break;
					m0ChPtcj += wAJn8s7V;
				}
				htJarContents.put(q12a50Hu.getName(), bpGco9AW);
				if (debugOn) {
					System.out.println(q12a50Hu.getName() + "  offset=" + m0ChPtcj + ",size=" + GDfW37S0 + ",csize="
							+ q12a50Hu.getCompressedSize());
				}
				;
			}
			;
		} catch (Exception inY8359j) {
			String aWXowHF0 = "Error loading data from JAR file [";
			aWXowHF0 += inY8359j.toString();
			aWXowHF0 += "]";
			throw new KExceptionClass(aWXowHF0, new KExceptionClass(inY8359j.toString(), null));
		}
		;
	}

}