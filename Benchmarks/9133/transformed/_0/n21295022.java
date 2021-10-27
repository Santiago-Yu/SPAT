class n21295022 {
	public static Vector webService(String rFaoeZnq, String OwOu0qlA, String Mtjc19jv, String QWImGa8O, String z8q6Ea2l,
			String rPScjk0q, String cdhKRKG7, String mOUhtnxw, String fdz7312p) throws Exception {
		Service fGxHlOl2 = new Service();
		Call XzyXxPvp = (Call) fGxHlOl2.createCall();
		if (OwOu0qlA != null) {
			XzyXxPvp.setUsername(OwOu0qlA);
			if (Mtjc19jv != null) {
				XzyXxPvp.setPassword(Mtjc19jv);
			}
			System.err.println("Info: authentication user=" + OwOu0qlA + " passwd=" + Mtjc19jv + " at " + rFaoeZnq);
		}
		XzyXxPvp.setTargetEndpointAddress(new URL(rFaoeZnq));
		XzyXxPvp.setOperationName("syncData");
		Vector MXM4Bj5F = (Vector) XzyXxPvp.invoke(new Object[] { QWImGa8O, z8q6Ea2l, rPScjk0q, cdhKRKG7, mOUhtnxw });
		if (MXM4Bj5F != null) {
			for (int rTZvxBvL = 0; rTZvxBvL < MXM4Bj5F.size(); rTZvxBvL++) {
				HashMap LkQp8Llf = (HashMap) MXM4Bj5F.get(rTZvxBvL);
				String osT9Nmpo = (String) LkQp8Llf.get("fileName");
				log.debug("result URL is " + osT9Nmpo);
				String UbHmoilt = null;
				URL TASUbDYY = new URL(osT9Nmpo);
				String W9Xsattp = TASUbDYY.getFile();
				if (W9Xsattp == null) {
					throw new Exception("Error: file part in the data URL is null");
				} else {
					UbHmoilt = W9Xsattp.substring(W9Xsattp.lastIndexOf("/") < 0 ? 0 : W9Xsattp.lastIndexOf("/") + 1);
					if (fdz7312p != null) {
						UbHmoilt = fdz7312p + UbHmoilt;
					}
					log.debug("local file name is " + UbHmoilt);
				}
				FileOutputStream JEd85Puo = new FileOutputStream(UbHmoilt);
				if (JEd85Puo == null) {
					throw new Exception("Error: file output stream is null");
				}
				InputStream U1jY41zT = TASUbDYY.openStream();
				if (U1jY41zT == null) {
					throw new Exception("Error: data input stream is null");
				} else {
					int msshOQbZ;
					while ((msshOQbZ = U1jY41zT.read()) != -1) {
						JEd85Puo.write(msshOQbZ);
					}
				}
				U1jY41zT.close();
				JEd85Puo.close();
				File ehKgu2LD = new File(UbHmoilt);
				LkQp8Llf.put("fileName", ehKgu2LD.getCanonicalPath());
			}
		}
		return MXM4Bj5F;
	}

}