class n20091690 {
	public void performNObAction(NObActionEvent evt) {
		System.out.println("Entering performNObAction");
		NObNode newNob = evt.getNObToChange();
		NObNode curNob;
		Vector nobs = new Vector();
		if (newNob instanceof NObListNode) {
			Enumeration children = newNob.children();
			while (children.hasMoreElements()) {
				nobs.add(children.nextElement());
			}
		} else {
			nobs.add(newNob);
		}
		int numNobs = nobs.size();
		int index = 0;
		for (int i = 0; i < numNobs; i++) {
			curNob = (NObNode) nobs.elementAt(i);
			index = nobs.indexOf(curNob);
			Enumeration keys = curNob.keys();
			String key = "";
			while (keys.hasMoreElements()) {
				key = (String) keys.nextElement();
			}
			try {
				String label = (String) curNob.get("label");
				NoteAddition input;
				Object newData = curNob.get("data");
				Object dataRef = curNob.get("dataref");
				if ((mEditMode) && (currentAddition != null)) {
					input = currentAddition;
				} else {
					input = new NoteAddition(label);
					input.setProp("id", new Long(new java.util.Date().getTime()));
				}
				if (newData != null) {
					newData = (newData.getClass().getName().equals("java.lang.String")) ? ((String) newData).getBytes()
							: newData;
					input.setProp("data", newData);
				} else if (dataRef != null) {
					input.setProp("dataref", (String) dataRef);
					File dataFile = new File((String) dataRef);
					InputStream dataStream = (InputStream) new FileInputStream(dataFile);
					newData = new byte[dataStream.available()];
					int len = dataStream.read((byte[]) newData);
					input.setProp("data", newData);
					newData = null;
				}
				try {
					input.setProp("datatype", (String) curNob.get("datatype"));
				} catch (Exception dt) {
					System.out.println("Exception occured setting datatype: " + dt);
				}
				try {
					input.setProp("editor", (String) curNob.get("editor"));
				} catch (Exception ed) {
					System.out.println("Exception occured setting editor: " + ed);
				}
				try {
					input.setProp("datalength", new Long(curNob.getDataLength()).toString());
				} catch (Exception dl) {
					System.out.println("Exception occured setting datalength: " + dl);
				}
				java.net.URL urlServlet = new java.net.URL(mServerUrl + "/echo");
				java.net.URLConnection con = urlServlet.openConnection();
				con.setDoInput(true);
				con.setDoOutput(true);
				con.setUseCaches(false);
				con.setRequestProperty("Content-Type", "application/x-java-serialized-object");
				if (browserCookie != null)
					con.setRequestProperty("Cookie", getParameter("browserCookie"));
				java.io.OutputStream outstream = con.getOutputStream();
				java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(outstream);
				oos.writeObject(input);
				oos.flush();
				oos.close();
				java.io.InputStream in = con.getInputStream();
				java.io.ObjectInputStream inputFromServlet = new java.io.ObjectInputStream(in);
				try {
					Object echo = inputFromServlet.readObject();
					System.out.println("Response:" + echo);
				} catch (Exception e) {
					System.out.println(e);
				}
				inputFromServlet.close();
				in.close();
				mEditMode = false;
			} catch (java.net.MalformedURLException e) {
				System.out.println("ex" + e);
			} catch (java.io.IOException e2) {
				System.out.println("ex2" + e2);
			}
			mEditorPanel.setEnabled(true);
			mEditMode = false;
		}
		System.out.println("Exiting performNObAction");
	}

}