class n4588203 {
	public String copyImages(Document ot5XB1Kr, String I6JQo5Oc, String KPuvcbAm, String mUmQwNdj, String IBqxwMPr) {
		NodeList ZSDkPEMt = null;
		Node C126PDyZ = null;
		NamedNodeMap wEtkIAnl = null;
		Node kz0CZEDN = null;
		URL arUToxqz = null;
		String meUxblIZ = "";
		String yQL73x01 = "";
		int hjPN2FZF;
		String AaZiY0WN = "";
		try {
			ZSDkPEMt = ot5XB1Kr.getElementsByTagName(mUmQwNdj);
			for (int SdcTFLt0 = 0; SdcTFLt0 < ZSDkPEMt.getLength(); SdcTFLt0++) {
				C126PDyZ = ZSDkPEMt.item(SdcTFLt0);
				wEtkIAnl = C126PDyZ.getAttributes();
				kz0CZEDN = wEtkIAnl.getNamedItem(IBqxwMPr);
				String xVJT3HzO = kz0CZEDN.getTextContent();
				arUToxqz = new URL("file", "localhost", xVJT3HzO);
				AaZiY0WN = arUToxqz.getPath();
				AaZiY0WN = AaZiY0WN.replace('/', File.separatorChar);
				int XujLUwfv = AaZiY0WN.indexOf(File.separatorChar);
				String dGDBmJZJ;
				if (IBqxwMPr.equals("data"))
					dGDBmJZJ = AaZiY0WN;
				else
					dGDBmJZJ = AaZiY0WN.substring(XujLUwfv + 1);
				hjPN2FZF = AaZiY0WN.lastIndexOf(File.separatorChar);
				meUxblIZ = AaZiY0WN.substring(hjPN2FZF + 1);
				yQL73x01 = KPuvcbAm + meUxblIZ;
				FileChannel lJEcYs4f = null;
				FileChannel iBHrjE9t = null;
				try {
					lJEcYs4f = new FileInputStream(dGDBmJZJ).getChannel();
					iBHrjE9t = new FileOutputStream(yQL73x01).getChannel();
					long b0JTM8QQ = lJEcYs4f.size();
					MappedByteBuffer buRKO1oR = lJEcYs4f.map(FileChannel.MapMode.READ_ONLY, 0, b0JTM8QQ);
					iBHrjE9t.write(buRKO1oR);
				} finally {
					if (lJEcYs4f != null)
						lJEcYs4f.close();
					if (iBHrjE9t != null)
						iBHrjE9t.close();
				}
				I6JQo5Oc = I6JQo5Oc.replace(kz0CZEDN.getTextContent(), meUxblIZ);
			}
		} catch (MalformedURLException Jn6Ks6Id) {
			Jn6Ks6Id.printStackTrace();
		} catch (IOException dsbTdccX) {
			dsbTdccX.printStackTrace();
		}
		return I6JQo5Oc;
	}

}