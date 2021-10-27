class n4617220 {
	public String postFileRequest(String bzJ77fua, String do1vaTBC) throws Exception {
		status = STATUS_INIT;
		String JMZjSAem = null;
		String AFh4bV46 = new String("");
		if (isThreadStopped) {
			return "";
		}
		status = STATUS_UPLOADING;
		if (isThreadStopped) {
			return "";
		}
		String u79Nrty2 = new String("");
		int qeLjunuX = 0, xkYsfm4m = 0, ASwYckrU = 0;
		try {
			for (java.util.Iterator vt40luoK = parameters.entrySet().iterator(); vt40luoK.hasNext();) {
				java.util.Map.Entry bCTaIYSN = (java.util.Map.Entry) vt40luoK.next();
				u79Nrty2 = u79Nrty2 + "-----------------------------7d338a374003ea\n"
						+ "Content-Disposition: form-data; name=\"" + (String) bCTaIYSN.getKey() + "\"\n\n"
						+ (String) bCTaIYSN.getValue() + "\n\n";
			}
			URL ORP0C5FE = new URL(urlString);
			URLConnection Nm77qojp = ORP0C5FE.openConnection();
			HttpURLConnection c77ud6KQ = (HttpURLConnection) Nm77qojp;
			u79Nrty2 = u79Nrty2 + "-----------------------------7d338a374003ea\n"
					+ "Content-Disposition: form-data; name=\"" + do1vaTBC + "\"; filename=\"" + bzJ77fua + "\"\n"
					+ "Content-Type: text/plain\n\n";
			AFh4bV46 = AFh4bV46 + "\n\n" + "-----------------------------7d338a374003ea\n" + "\n";
			FileInputStream lMxc3oCw = null;
			String G8v7SA0n = null;
			try {
				lMxc3oCw = new FileInputStream(bzJ77fua);
				int oc7obJkV = lMxc3oCw.available();
				qeLjunuX = u79Nrty2.length() + AFh4bV46.length() + oc7obJkV;
				c77ud6KQ.setRequestProperty("Content-Length", String.valueOf(qeLjunuX));
				c77ud6KQ.setRequestProperty("Content-Type",
						"multipart/form-data; boundary=---------------------------7d338a374003ea");
				c77ud6KQ.setRequestMethod("POST");
				c77ud6KQ.setDoOutput(true);
				c77ud6KQ.setDoInput(true);
				try {
					Nm77qojp.connect();
				} catch (ConnectException Qp1WIpuw) {
					error = true;
					finished = true;
					errorStr = "Cannot connect to: " + urlString;
					System.out.println("Cannot connect to:" + urlString);
				} catch (java.io.InterruptedIOException yimMLp66) {
					error = true;
					finished = true;
					errorStr = "Connection to Portal lost: communication is timeouted.";
					parentWorkflow.getMenuButtonEventHandler().stopAutomaticRefresh();
				} catch (IllegalStateException aJZgkbMT) {
					error = true;
					finished = true;
					errorStr = "IllegalStateException: " + aJZgkbMT.getMessage();
				}
				OutputStream JIJDiEM7 = c77ud6KQ.getOutputStream();
				byte[] hL4sD3Ex = u79Nrty2.getBytes("UTF-8");
				for (int Xyn83iTs = 0; Xyn83iTs < hL4sD3Ex.length; Xyn83iTs++) {
					JIJDiEM7.write(hL4sD3Ex[Xyn83iTs]);
				}
				int JCs8OkKK;
				int XLEfBf1q = 8 * 1024;
				setUploadProgress(oc7obJkV, ASwYckrU);
				byte LAkCDDDR[] = new byte[XLEfBf1q];
				GZIPOutputStream RphTEqzb = new GZIPOutputStream(JIJDiEM7);
				while ((JCs8OkKK = lMxc3oCw.read(LAkCDDDR, 0, XLEfBf1q)) != -1) {
					if (isThreadStopped) {
						return "";
					}
					RphTEqzb.write(LAkCDDDR, 0, JCs8OkKK);
					setUploadProgress(oc7obJkV, ASwYckrU);
					ASwYckrU += JCs8OkKK;
				}
				RphTEqzb.flush();
				RphTEqzb.finish();
				setUploadProgress(oc7obJkV, ASwYckrU);
				hL4sD3Ex = AFh4bV46.getBytes("UTF-8");
				for (int EPtQKGHc = 0; EPtQKGHc < hL4sD3Ex.length; EPtQKGHc++) {
					JIJDiEM7.write(hL4sD3Ex[EPtQKGHc]);
				}
				JIJDiEM7.close();
			} catch (IOException m7djqUqk) {
				finished = true;
				error = true;
				errorStr = "Error in Uploading file: " + bzJ77fua;
			} finally {
				try {
					lMxc3oCw.close();
				} catch (IOException ASSTBXur) {
				}
			}
			InputStreamReader n2UnLCiT = new InputStreamReader(c77ud6KQ.getInputStream());
			BufferedReader zhcyOclV = new BufferedReader(n2UnLCiT);
			String s5uNuHhp;
			String vbk1eOsO = "";
			while ((s5uNuHhp = zhcyOclV.readLine()) != null) {
				if (isThreadStopped) {
					return "";
				}
				vbk1eOsO = vbk1eOsO + s5uNuHhp + "\n";
				setDecompressStatusAtUpload(s5uNuHhp);
			}
			JMZjSAem = vbk1eOsO;
			n2UnLCiT.close();
		} catch (ConnectException viZMB325) {
			error = true;
			finished = true;
			errorStr = "Cannot connect to: " + urlString + "\nServer is not responding.";
		} catch (java.io.InterruptedIOException CHCpFwf3) {
			error = true;
			finished = true;
			errorStr = "Connection to Portal lost: communication is timeouted.";
			parentWorkflow.getMenuButtonEventHandler().stopAutomaticRefresh();
		} catch (IOException vNidotUt) {
			finished = true;
			error = true;
			errorStr = "IOError in postFileRequest: " + vNidotUt.getMessage();
		} catch (Exception zE63LR6s) {
			finished = true;
			error = true;
			errorStr = "Error while trying to communicate the server: " + zE63LR6s.getMessage();
		}
		return JMZjSAem;
	}

}