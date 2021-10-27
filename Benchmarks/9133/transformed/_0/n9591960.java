class n9591960 {
	protected Object serveFile(MyServerSocket dzNDRq8N, String uixoTmVz, URL LuNOtbF8) {
		PrintStream wJNoKzbq = null;
		InputStream PqMFPvTl = null;
		long ftMtfxhT = 0;
		try {
			wJNoKzbq = new PrintStream(dzNDRq8N.getOutputStream());
			PqMFPvTl = LuNOtbF8.openStream();
			ftMtfxhT = PqMFPvTl.available();
		} catch (IOException RtcIpilB) {
			HttpHelper.httpWrap(HttpHelper.EXC, RtcIpilB.toString(), 0);
		}
		if (HttpHelper.isImage(uixoTmVz)) {
			wJNoKzbq.print(HttpHelper.httpWrapPic(uixoTmVz, ftMtfxhT));
		} else if (uixoTmVz.endsWith(".html")) {
			Comms.copyStreamSED(PqMFPvTl, wJNoKzbq, MPRES);
		} else if (HttpHelper.isOtherFile(uixoTmVz)) {
			wJNoKzbq.print(HttpHelper.httpWrapOtherFile(uixoTmVz, ftMtfxhT));
		} else {
			String UmOntBSO = MimeUtils.getMimeType(uixoTmVz);
			if (UmOntBSO.equals(MimeUtils.UNKNOWN_MIME_TYPE)) {
				wJNoKzbq.print(HttpHelper.httpWrapMimeType(UmOntBSO, ftMtfxhT));
			} else {
				wJNoKzbq.print(HttpHelper.httpWrapMimeType(UmOntBSO, ftMtfxhT));
			}
		}
		if (PqMFPvTl == null) {
			Log.logThis("THE INPUT STREAM IS NULL...url=" + LuNOtbF8);
		} else
			Files.copyStream(PqMFPvTl, wJNoKzbq);
		return null;
	}

}