class n17389235 {
	public boolean PrintPage(String kWo4nyip, String uCE8t2mI, String RIKbT19J) {
		File RgDMi9Fd = new File(new File(kWo4nyip).getParent());
		if (!RgDMi9Fd.exists()) {
			RgDMi9Fd.mkdirs();
		}
		String G9pBwi9U = null;
		BufferedReader yUXk86wO = null;
		FileOutputStream BF5dCFpA = null;
		OutputStreamWriter DVTRuicc = null;
		PrintWriter ARpu3rCz = null;
		File MvjkRmVa = null;
		try {
			InputStream ttMzSz5t = new URL(uCE8t2mI).openStream();
			MvjkRmVa = new File(kWo4nyip);
			if (!MvjkRmVa.exists()) {
				MvjkRmVa.createNewFile();
			}
			yUXk86wO = new BufferedReader(new InputStreamReader(ttMzSz5t, RIKbT19J));
			BF5dCFpA = new FileOutputStream(kWo4nyip);
			DVTRuicc = new OutputStreamWriter(BF5dCFpA, RIKbT19J);
			ARpu3rCz = new PrintWriter(DVTRuicc);
			while ((G9pBwi9U = yUXk86wO.readLine()) != null) {
				G9pBwi9U = G9pBwi9U.trim();
				int xxUaYgs3 = G9pBwi9U.length();
				if (xxUaYgs3 > 0) {
					ARpu3rCz.println(G9pBwi9U);
					ARpu3rCz.flush();
				}
			}
			ttMzSz5t.close();
			ttMzSz5t = null;
			ARpu3rCz.close();
			DVTRuicc.close();
			BF5dCFpA.close();
			yUXk86wO.close();
			ARpu3rCz = null;
			DVTRuicc = null;
			BF5dCFpA = null;
			yUXk86wO = null;
			RgDMi9Fd = null;
			MvjkRmVa = null;
			G9pBwi9U = null;
			return true;
		} catch (IOException zy1nCAkL) {
			log.error(zy1nCAkL.getMessage());
			zy1nCAkL.printStackTrace();
			return false;
		} catch (Exception uiTn02gk) {
			uiTn02gk.printStackTrace();
			log.error("static----------" + uiTn02gk.getMessage());
			return false;
		} finally {
			try {
				if (ARpu3rCz != null) {
					ARpu3rCz.close();
					ARpu3rCz = null;
				}
				if (DVTRuicc != null) {
					DVTRuicc.close();
					DVTRuicc = null;
				}
				if (BF5dCFpA != null) {
					BF5dCFpA.close();
					BF5dCFpA = null;
				}
				if (yUXk86wO != null) {
					yUXk86wO.close();
					yUXk86wO = null;
				}
			} catch (IOException B397o1Yb) {
				log.error(B397o1Yb.getMessage());
			} catch (Exception l6n3us2Y) {
				log.error(l6n3us2Y.getMessage());
			}
		}
	}

}