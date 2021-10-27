class n18880056 {
	public static File extract(File pObkHyNt, String eNEMpFYZ, File eDbVByDS) {
		if (pObkHyNt.exists() == false || eNEMpFYZ == null || eNEMpFYZ.trim().length() < 1 || eDbVByDS == null)
			return null;
		boolean m9i2Pnc5 = (eNEMpFYZ.lastIndexOf("/") == eNEMpFYZ.length() - 1);
		try {
			Map X52CoQtN = (Map) jarContents.get(pObkHyNt.getPath());
			if (X52CoQtN == null) {
				X52CoQtN = new HashMap();
				jarContents.put(pObkHyNt.getPath(), X52CoQtN);
				ZipInputStream twOleG7z = new ZipInputStream(new FileInputStream(pObkHyNt));
				ZipEntry J5Z604MF = null;
				while ((J5Z604MF = twOleG7z.getNextEntry()) != null) {
					if (J5Z604MF.isDirectory())
						continue;
					X52CoQtN.put(J5Z604MF.getName(), J5Z604MF);
				}
				twOleG7z.close();
			}
			if (m9i2Pnc5) {
				Iterator Jwts20ja = X52CoQtN.keySet().iterator();
				while (Jwts20ja.hasNext()) {
					String caYzu5ZV = (String) Jwts20ja.next();
					if (caYzu5ZV.startsWith(eNEMpFYZ)) {
						ZipEntry N3AYh4rm = (ZipEntry) X52CoQtN.get(caYzu5ZV);
						int OT3qZBaP = eNEMpFYZ.length();
						File fFjlRcFH = new File(eDbVByDS, N3AYh4rm.getName().substring(OT3qZBaP));
						extract(pObkHyNt, caYzu5ZV, fFjlRcFH);
					}
				}
				return eDbVByDS;
			}
			ZipEntry c4wsmIlt = (ZipEntry) X52CoQtN.get(eNEMpFYZ);
			ZipFile kAR7n5bk = new ZipFile(pObkHyNt);
			InputStream L7EO5fXe = kAR7n5bk.getInputStream(c4wsmIlt);
			eDbVByDS.getParentFile().mkdirs();
			int mZEd7Ix3;
			byte[] DW2jEl5t = new byte[1024];
			FileOutputStream dADGq0H5 = new FileOutputStream(eDbVByDS);
			while ((mZEd7Ix3 = L7EO5fXe.read(DW2jEl5t)) != -1)
				dADGq0H5.write(DW2jEl5t, 0, mZEd7Ix3);
			dADGq0H5.close();
			kAR7n5bk.close();
			return eDbVByDS;
		} catch (Exception llGBoe7h) {
			llGBoe7h.printStackTrace();
		}
		return null;
	}

}