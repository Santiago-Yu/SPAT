class n14563781 {
	public static void parseString(String cLFLfFwz, String K2sCH1Zf) {
		BufferedReader qludNjdZ;
		String HTf1Cf3N = null;
		boolean QUg7d7oF = true;
		int XeUKuLYS;
		float rlVk6Jg0;
		int FwE15T0o = 0;
		int I6Bc3J8Q = 0;
		HashMap<Integer, Float> DWrUZggD = new HashMap<Integer, Float>();
		String[] WPcTPYDt;
		try {
			File SoMR55K1 = File.createTempFile("tempFile", null);
			URL ckdSSDGN = new URL(cLFLfFwz);
			InputStream yWQS3PxT = ckdSSDGN.openStream();
			FileOutputStream c4XeLJNY = new FileOutputStream(SoMR55K1);
			byte[] IBM2QmxU = new byte[0xFFFF];
			for (int jAXE1mB2; (jAXE1mB2 = yWQS3PxT.read(IBM2QmxU)) != -1;)
				c4XeLJNY.write(IBM2QmxU, 0, jAXE1mB2);
			yWQS3PxT.close();
			c4XeLJNY.close();
			qludNjdZ = new BufferedReader(new FileReader(SoMR55K1));
			HTf1Cf3N = qludNjdZ.readLine();
			XeUKuLYS = 0;
			while (HTf1Cf3N != null) {
				if (!(HTf1Cf3N.length() > 0 && HTf1Cf3N.charAt(0) == '#')) {
					HTf1Cf3N = qludNjdZ.readLine();
					break;
				}
				HTf1Cf3N = qludNjdZ.readLine();
			}
			while (HTf1Cf3N != null) {
				if (HTf1Cf3N.length() > 0) {
					WPcTPYDt = HTf1Cf3N.split(" ");
					XeUKuLYS = Integer.parseInt(WPcTPYDt[0]);
					rlVk6Jg0 = Float.parseFloat(WPcTPYDt[1]);
					if (QUg7d7oF) {
						QUg7d7oF = false;
						FwE15T0o = XeUKuLYS;
					}
					DWrUZggD.put(XeUKuLYS, rlVk6Jg0);
				}
				HTf1Cf3N = qludNjdZ.readLine();
			}
			I6Bc3J8Q = XeUKuLYS;
		} catch (IOException DQNxmPiL) {
			System.err.println("Error2 :" + DQNxmPiL);
		}
		try {
			String VX1tJs9L;
			File MEBut1fg = new File("C:/spectralColors/" + K2sCH1Zf + ".sd");
			FileWriter qf7vJDxJ = new FileWriter(MEBut1fg);
			BufferedWriter mI7XJ50A = new BufferedWriter(qf7vJDxJ);
			mI7XJ50A.write(
					"# COLOR: " + K2sCH1Zf + " Auto generated File: 02/09/2009; From " + FwE15T0o + " to " + I6Bc3J8Q);
			mI7XJ50A.newLine();
			mI7XJ50A.write(FwE15T0o + "");
			mI7XJ50A.newLine();
			for (int zR8BLpeJ = FwE15T0o; zR8BLpeJ <= I6Bc3J8Q; zR8BLpeJ++) {
				if (DWrUZggD.containsKey(zR8BLpeJ)) {
					VX1tJs9L = zR8BLpeJ + " " + DWrUZggD.get(zR8BLpeJ);
					mI7XJ50A.write(VX1tJs9L);
					mI7XJ50A.newLine();
				}
			}
			mI7XJ50A.close();
		} catch (IOException q6jaykMo) {
			q6jaykMo.printStackTrace();
		}
	}

}