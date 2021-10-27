class n18099260 {
	public String[][] getProjectTreeData() {
		String[][] aX6pKoEs = null;
		String bVZTp39B = dms_home + FS + "temp" + FS + username + "projects.xml";
		String L6ex9c7h = dms_url + "/servlet/com.ufnasoft.dms.server.ServerGetProjects";
		try {
			String OwmavlFl = L6ex9c7h + "?username=" + URLEncoder.encode(username, "UTF-8") + "&key="
					+ URLEncoder.encode(key, "UTF-8") + "&filename=" + URLEncoder.encode(username, "UTF-8")
					+ "projects.xml";
			System.out.println(OwmavlFl);
			DocumentBuilderFactory BpOil8ui = DocumentBuilderFactory.newInstance();
			BpOil8ui.setValidating(false);
			DocumentBuilder pzFy7Xh6 = BpOil8ui.newDocumentBuilder();
			URL zBssSnqZ = new URL(OwmavlFl);
			DataInputStream k4YTKopt = new DataInputStream(zBssSnqZ.openStream());
			FileOutputStream SmTRxIxJ = new FileOutputStream(bVZTp39B);
			int UzkCJjrz = k4YTKopt.available();
			byte DPcPqUhp[] = new byte[20000 * 1024];
			int P5CT1Z7M;
			while ((P5CT1Z7M = k4YTKopt.read(DPcPqUhp, 0, UzkCJjrz)) > 0)
				SmTRxIxJ.write(DPcPqUhp, 0, P5CT1Z7M);
			SmTRxIxJ.close();
			k4YTKopt.close();
			File gM5Kyzwh = new File(bVZTp39B);
			InputStream i8VFQOB0 = new FileInputStream(gM5Kyzwh);
			Document YoeEY5b1 = pzFy7Xh6.parse(i8VFQOB0);
			NodeList W1msRzKQ = YoeEY5b1.getElementsByTagName("j");
			int CN96tVgY = W1msRzKQ.getLength();
			aX6pKoEs = new String[CN96tVgY][5];
			for (int EpOioLNg = 0; EpOioLNg < CN96tVgY; EpOioLNg++) {
				aX6pKoEs[EpOioLNg][0] = new String(
						DOMUtil.getSimpleElementText((Element) W1msRzKQ.item(EpOioLNg), "i"));
				aX6pKoEs[EpOioLNg][1] = new String(
						DOMUtil.getSimpleElementText((Element) W1msRzKQ.item(EpOioLNg), "pi"));
				aX6pKoEs[EpOioLNg][2] = new String(
						DOMUtil.getSimpleElementText((Element) W1msRzKQ.item(EpOioLNg), "p"));
				aX6pKoEs[EpOioLNg][3] = "";
				aX6pKoEs[EpOioLNg][4] = new String(
						DOMUtil.getSimpleElementText((Element) W1msRzKQ.item(EpOioLNg), "f"));
			}
		} catch (MalformedURLException LZZzr5sH) {
			System.out.println(LZZzr5sH);
		} catch (ParserConfigurationException Gq8zvxTj) {
			System.out.println(Gq8zvxTj);
		} catch (NullPointerException esFCbT2q) {
		} catch (Exception IadEJZyX) {
			System.out.println(IadEJZyX);
		}
		return aX6pKoEs;
	}

}