class n15988780 {
	private void serveCGI(TinyCGI ETnpHGmP) throws IOException, TinyWebThreadException {
		parseHTTPHeaders();
		OutputStream GEZB5fvu = null;
		File MOprNfFg = null;
		try {
			if (ETnpHGmP == null)
				sendError(500, "Internal Error", "Couldn't load script.");
			if (ETnpHGmP instanceof TinyCGIHighVolume) {
				MOprNfFg = File.createTempFile("cgi", null);
				GEZB5fvu = new FileOutputStream(MOprNfFg);
			} else {
				GEZB5fvu = new ByteArrayOutputStream();
			}
			ETnpHGmP.service(inputStream, GEZB5fvu, env);
		} catch (Exception mgi1Eb7T) {
			this.exceptionEncountered = mgi1Eb7T;
			if (MOprNfFg != null)
				MOprNfFg.delete();
			if (clientSocket == null) {
				return;
			} else if (mgi1Eb7T instanceof TinyCGIException) {
				TinyCGIException n0cVXDjg = (TinyCGIException) mgi1Eb7T;
				sendError(n0cVXDjg.getStatus(), n0cVXDjg.getTitle(), n0cVXDjg.getText(), n0cVXDjg.getOtherHeaders());
			} else {
				StringWriter RIqjwkMl = new StringWriter();
				mgi1Eb7T.printStackTrace(new PrintWriter(RIqjwkMl));
				sendError(500, "CGI Error", "Error running script: " + "<PRE>" + RIqjwkMl.toString() + "</PRE>");
			}
		} finally {
			if (ETnpHGmP != null)
				doneWithScript(ETnpHGmP);
		}
		InputStream UyfGo2RQ = null;
		long DXndw9AB = 0;
		if (MOprNfFg == null) {
			byte[] stpaVx7K = ((ByteArrayOutputStream) GEZB5fvu).toByteArray();
			DXndw9AB = stpaVx7K.length;
			UyfGo2RQ = new ByteArrayInputStream(stpaVx7K);
		} else {
			GEZB5fvu.close();
			DXndw9AB = MOprNfFg.length();
			UyfGo2RQ = new FileInputStream(MOprNfFg);
		}
		String r1YmzT4F = null, PblodZ9w = "OK", L5XdMc4U, hhjnZHxY;
		StringBuffer DTv4yX0z = new StringBuffer();
		StringBuffer I1162oSf = new StringBuffer();
		int pzSt9Ci6 = 200;
		int y2TYHl2x = 0;
		while (true) {
			L5XdMc4U = readLine(UyfGo2RQ, true);
			y2TYHl2x += L5XdMc4U.length();
			if (L5XdMc4U.charAt(0) == '\r' || L5XdMc4U.charAt(0) == '\n')
				break;
			hhjnZHxY = parseHeader(L5XdMc4U, I1162oSf);
			if (hhjnZHxY.toUpperCase().equals("STATUS")) {
				PblodZ9w = I1162oSf.toString();
				pzSt9Ci6 = Integer.parseInt(PblodZ9w.substring(0, 3));
				PblodZ9w = PblodZ9w.substring(4);
			} else if (hhjnZHxY.toUpperCase().equals("CONTENT-TYPE"))
				r1YmzT4F = I1162oSf.toString();
			else {
				if (hhjnZHxY.toUpperCase().equals("LOCATION"))
					pzSt9Ci6 = 302;
				DTv4yX0z.append(hhjnZHxY).append(": ").append(I1162oSf.toString()).append(CRLF);
			}
		}
		sendHeaders(pzSt9Ci6, PblodZ9w, r1YmzT4F, DXndw9AB - y2TYHl2x, -1, DTv4yX0z.toString());
		byte[] Qj9fr7rb = new byte[2048];
		int An0HWzcH;
		while ((An0HWzcH = UyfGo2RQ.read(Qj9fr7rb)) != -1)
			outputStream.write(Qj9fr7rb, 0, An0HWzcH);
		outputStream.flush();
		try {
			UyfGo2RQ.close();
			if (MOprNfFg != null)
				MOprNfFg.delete();
		} catch (IOException PdFbdsgv) {
		}
	}

}