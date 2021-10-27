class n18793482 {
	public void modifyApplicationMessage(String JYk8fmfd, String XnzEfUYQ, String Zekpu1xx) {
		Properties EGgsxG3A = new Properties();
		try {
			String ftmmCRqF = ServerUtil.removelastResourceURL(ConfigurationServiceImpl.class
					.getResource("/es/ua/tranube/prototype/main/client/TranubeConstants_en.properties").getPath())
					.toString();
			File mAg7mdw1 = new File(ftmmCRqF + "TranubeConstants_en.properties");
			if (!mAg7mdw1.exists())
				throw new Exception("English file not found");
			String F8c7uKIs = ftmmCRqF + "TranubeConstants_" + JYk8fmfd + ".properties";
			File JaMfecW3 = new File(F8c7uKIs);
			if (!JaMfecW3.exists()) {
				FileReader guMojTSN = new FileReader(mAg7mdw1);
				FileWriter Voc4qglF = new FileWriter(JaMfecW3);
				int HeJp7V7H;
				while ((HeJp7V7H = guMojTSN.read()) != -1)
					Voc4qglF.write(HeJp7V7H);
				guMojTSN.close();
				Voc4qglF.close();
			}
			InputStream EwHQMH1T = ConfigurationServiceImpl.class.getResourceAsStream(
					"/es/ua/tranube/prototype/main/client/TranubeConstants_" + JYk8fmfd + ".properties");
			BufferedReader xCR5ggJF = new BufferedReader(new InputStreamReader(EwHQMH1T));
			String e9fGnCq1 = null;
			StringBuilder gKyuYH5O = new StringBuilder();
			boolean Uaa63y0e = false;
			while ((e9fGnCq1 = xCR5ggJF.readLine()) != null) {
				if (e9fGnCq1.startsWith("#"))
					gKyuYH5O.append(e9fGnCq1).append("\n");
				else {
					String[] WMWnuEkX = e9fGnCq1.split("=");
					if (WMWnuEkX.length == 2) {
						if (WMWnuEkX[0].trim().equals(XnzEfUYQ)) {
							gKyuYH5O.append(WMWnuEkX[0].trim() + " = " + Zekpu1xx + "\n");
							Uaa63y0e = true;
						} else
							gKyuYH5O.append(e9fGnCq1).append("\n");
					} else
						gKyuYH5O.append(e9fGnCq1).append("\n");
				}
			}
			if (!Uaa63y0e)
				gKyuYH5O.append(XnzEfUYQ).append(" = ").append(Zekpu1xx).append("\n");
			xCR5ggJF.close();
			EwHQMH1T.close();
			FileWriter vDw5RNx2 = new FileWriter(JaMfecW3);
			vDw5RNx2.write(gKyuYH5O.toString());
			vDw5RNx2.close();
		} catch (Exception ZPtZM4i6) {
			ZPtZM4i6.printStackTrace();
		}
	}

}