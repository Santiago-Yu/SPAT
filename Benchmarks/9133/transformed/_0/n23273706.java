class n23273706 {
	public String[][] getProjectTreeData() {
		String[][] ulqeXPCU = null;
		String f7XATKeW = dms_home + FS + "temp" + FS + username + "adminprojects.xml";
		String DUKBzr3P = dms_url + "/servlet/com.ufnasoft.dms.server.ServerGetAdminProjects";
		try {
			String YOQZUlDr = DUKBzr3P + "?username=" + URLEncoder.encode(username, "UTF-8") + "&key="
					+ URLEncoder.encode(key, "UTF-8") + "&filename=" + URLEncoder.encode(username, "UTF-8")
					+ "adminprojects.xml";
			DocumentBuilderFactory Iy8HzVdm = DocumentBuilderFactory.newInstance();
			Iy8HzVdm.setValidating(false);
			DocumentBuilder Y1oa903C = Iy8HzVdm.newDocumentBuilder();
			URL kQaOLLNr = new URL(YOQZUlDr);
			DataInputStream P6LvWCvB = new DataInputStream(kQaOLLNr.openStream());
			FileOutputStream kUQjc5MP = new FileOutputStream(f7XATKeW);
			int HMYDJW4n = P6LvWCvB.available();
			byte duqBd7KF[] = new byte[20000 * 1024];
			int vmkGBv0W;
			while ((vmkGBv0W = P6LvWCvB.read(duqBd7KF, 0, HMYDJW4n)) > 0)
				kUQjc5MP.write(duqBd7KF, 0, vmkGBv0W);
			kUQjc5MP.close();
			P6LvWCvB.close();
			File azkR8Svd = new File(f7XATKeW);
			InputStream GrB7VltS = new FileInputStream(azkR8Svd);
			Document dJPlC6kO = Y1oa903C.parse(GrB7VltS);
			NodeList Vutpj5kr = dJPlC6kO.getElementsByTagName("proj");
			int aeEwWmrL = Vutpj5kr.getLength();
			ulqeXPCU = new String[aeEwWmrL][3];
			for (int wnnGdrzT = 0; wnnGdrzT < aeEwWmrL; wnnGdrzT++) {
				ulqeXPCU[wnnGdrzT][0] = new String(
						DOMUtil.getSimpleElementText((Element) Vutpj5kr.item(wnnGdrzT), "pid"));
				ulqeXPCU[wnnGdrzT][1] = new String(
						DOMUtil.getSimpleElementText((Element) Vutpj5kr.item(wnnGdrzT), "ppid"));
				ulqeXPCU[wnnGdrzT][2] = new String(
						DOMUtil.getSimpleElementText((Element) Vutpj5kr.item(wnnGdrzT), "p"));
			}
		} catch (MalformedURLException jaLEZByI) {
			System.out.println(jaLEZByI);
		} catch (ParserConfigurationException R0yxEI3i) {
			System.out.println(R0yxEI3i);
		} catch (NullPointerException sci8sdSZ) {
		} catch (Exception GnhRxLyT) {
			System.out.println(GnhRxLyT);
		}
		return ulqeXPCU;
	}

}