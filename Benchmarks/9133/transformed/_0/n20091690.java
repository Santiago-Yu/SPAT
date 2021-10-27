class n20091690 {
	public void performNObAction(NObActionEvent KXEQbetq) {
		System.out.println("Entering performNObAction");
		NObNode VDc3NxYc = KXEQbetq.getNObToChange();
		NObNode oDxahEgG;
		Vector SItC473b = new Vector();
		if (VDc3NxYc instanceof NObListNode) {
			Enumeration q9AtSjao = VDc3NxYc.children();
			while (q9AtSjao.hasMoreElements()) {
				SItC473b.add(q9AtSjao.nextElement());
			}
		} else {
			SItC473b.add(VDc3NxYc);
		}
		int pD3AiquC = SItC473b.size();
		int RPScxkTp = 0;
		for (int c796M4bo = 0; c796M4bo < pD3AiquC; c796M4bo++) {
			oDxahEgG = (NObNode) SItC473b.elementAt(c796M4bo);
			RPScxkTp = SItC473b.indexOf(oDxahEgG);
			Enumeration a959WMgE = oDxahEgG.keys();
			String deq9KThj = "";
			while (a959WMgE.hasMoreElements()) {
				deq9KThj = (String) a959WMgE.nextElement();
			}
			try {
				String gIVgdQsm = (String) oDxahEgG.get("label");
				NoteAddition hCmnCSvo;
				Object KHmraXVC = oDxahEgG.get("data");
				Object Dx7aSPUp = oDxahEgG.get("dataref");
				if ((mEditMode) && (currentAddition != null)) {
					hCmnCSvo = currentAddition;
				} else {
					hCmnCSvo = new NoteAddition(gIVgdQsm);
					hCmnCSvo.setProp("id", new Long(new java.util.Date().getTime()));
				}
				if (KHmraXVC != null) {
					if (KHmraXVC.getClass().getName().equals("java.lang.String")) {
						KHmraXVC = ((String) KHmraXVC).getBytes();
					}
					hCmnCSvo.setProp("data", KHmraXVC);
				} else if (Dx7aSPUp != null) {
					hCmnCSvo.setProp("dataref", (String) Dx7aSPUp);
					File H5y4hzSG = new File((String) Dx7aSPUp);
					InputStream YFtEk9Sd = (InputStream) new FileInputStream(H5y4hzSG);
					KHmraXVC = new byte[YFtEk9Sd.available()];
					int k0kP5OlI = YFtEk9Sd.read((byte[]) KHmraXVC);
					hCmnCSvo.setProp("data", KHmraXVC);
					KHmraXVC = null;
				}
				try {
					hCmnCSvo.setProp("datatype", (String) oDxahEgG.get("datatype"));
				} catch (Exception kYO9oh7S) {
					System.out.println("Exception occured setting datatype: " + kYO9oh7S);
				}
				try {
					hCmnCSvo.setProp("editor", (String) oDxahEgG.get("editor"));
				} catch (Exception WnXDtuJW) {
					System.out.println("Exception occured setting editor: " + WnXDtuJW);
				}
				try {
					hCmnCSvo.setProp("datalength", new Long(oDxahEgG.getDataLength()).toString());
				} catch (Exception SbIU9kqS) {
					System.out.println("Exception occured setting datalength: " + SbIU9kqS);
				}
				java.net.URL uGwe1prf = new java.net.URL(mServerUrl + "/echo");
				java.net.URLConnection yt7laG84 = uGwe1prf.openConnection();
				yt7laG84.setDoInput(true);
				yt7laG84.setDoOutput(true);
				yt7laG84.setUseCaches(false);
				yt7laG84.setRequestProperty("Content-Type", "application/x-java-serialized-object");
				if (browserCookie != null)
					yt7laG84.setRequestProperty("Cookie", getParameter("browserCookie"));
				java.io.OutputStream glZyO3FB = yt7laG84.getOutputStream();
				java.io.ObjectOutputStream VsxuvYnm = new java.io.ObjectOutputStream(glZyO3FB);
				VsxuvYnm.writeObject(hCmnCSvo);
				VsxuvYnm.flush();
				VsxuvYnm.close();
				java.io.InputStream asBDyZBV = yt7laG84.getInputStream();
				java.io.ObjectInputStream bklEQFUi = new java.io.ObjectInputStream(asBDyZBV);
				try {
					Object l4ea519X = bklEQFUi.readObject();
					System.out.println("Response:" + l4ea519X);
				} catch (Exception YonXgGoC) {
					System.out.println(YonXgGoC);
				}
				bklEQFUi.close();
				asBDyZBV.close();
				mEditMode = false;
			} catch (java.net.MalformedURLException IV5qzAx9) {
				System.out.println("ex" + IV5qzAx9);
			} catch (java.io.IOException dHdqEbUz) {
				System.out.println("ex2" + dHdqEbUz);
			}
			mEditorPanel.setEnabled(true);
			mEditMode = false;
		}
		System.out.println("Exiting performNObAction");
	}

}