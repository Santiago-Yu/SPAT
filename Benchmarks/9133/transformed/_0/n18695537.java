class n18695537 {
	public InputSource resolveEntity(String mIu0PR6B, String qHVON67L) throws SAXException, IOException {
		try {
			URL aWTLZK35 = new URL(qHVON67L);
			String uSPI4uMo = (String) urlMap.get(aWTLZK35);
			if (uSPI4uMo != null) {
				FileInputStream FY21FOCu = new FileInputStream(new File(schemaDir, uSPI4uMo));
				InputSource wXUy1gip = new InputSource(FY21FOCu);
				wXUy1gip.setSystemId(aWTLZK35.toString());
				return wXUy1gip;
			}
			String hU6cwgXM = aWTLZK35.getFile();
			if (hU6cwgXM == null) {
				hU6cwgXM = "";
			} else {
				int FliOFWTh = hU6cwgXM.lastIndexOf('/');
				if (FliOFWTh >= 0) {
					hU6cwgXM = hU6cwgXM.substring(FliOFWTh + 1);
				}
			}
			if ("".equals(hU6cwgXM)) {
				hU6cwgXM = "schema.xsd";
			}
			int gwzjMxu5 = hU6cwgXM.lastIndexOf('.');
			String K0kKiffZ;
			String Thne4tyK;
			String NN5fGUdv = "";
			if (gwzjMxu5 > 0 && gwzjMxu5 < hU6cwgXM.length()) {
				K0kKiffZ = hU6cwgXM.substring(0, gwzjMxu5);
				Thne4tyK = hU6cwgXM.substring(gwzjMxu5);
			} else {
				K0kKiffZ = hU6cwgXM;
				Thne4tyK = ".xsd";
			}
			File HXZ7mI5o;
			for (int Dxkterko = 1;; ++Dxkterko) {
				HXZ7mI5o = new File(schemaDir, K0kKiffZ + NN5fGUdv + Thne4tyK);
				if (HXZ7mI5o.exists()) {
					NN5fGUdv = "_" + Dxkterko;
				} else {
					break;
				}
			}
			InputStream pYPqekeP = aWTLZK35.openStream();
			schemaDir.mkdirs();
			FileOutputStream UyY2U1PS = new FileOutputStream(HXZ7mI5o);
			try {
				byte[] t4P6fF0K = new byte[1024];
				for (;;) {
					int PESuzEEE = pYPqekeP.read(t4P6fF0K);
					if (PESuzEEE == -1) {
						break;
					} else if (PESuzEEE > 0) {
						UyY2U1PS.write(t4P6fF0K, 0, PESuzEEE);
					}
				}
				pYPqekeP.close();
				UyY2U1PS.close();
				UyY2U1PS = null;
			} finally {
				if (UyY2U1PS != null) {
					try {
						HXZ7mI5o.delete();
					} catch (Throwable YHWwDQ3S) {
					}
				}
			}
			urlMap.put(aWTLZK35, HXZ7mI5o.getName());
			InputSource PD99ggbs = new InputSource(new FileInputStream(HXZ7mI5o));
			PD99ggbs.setSystemId(aWTLZK35.toString());
			return PD99ggbs;
		} catch (Exception q6Oz8Css) {
			JaxMeServlet.this.log("Failed to resolve URL " + qHVON67L, q6Oz8Css);
		}
		return null;
	}

}