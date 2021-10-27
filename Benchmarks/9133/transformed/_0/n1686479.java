class n1686479 {
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/upload/upload.html", method = RequestMethod.POST)
	protected void save(HttpServletRequest lP2hxeoQ, HttpServletResponse chHdFQU6) throws ServletException {
		UPLOAD_DIRECTORY = uploadDiretory();
		File SOl3eI6C = new File(UPLOAD_DIRECTORY);
		boolean YldFfcfn = false;
		if (!SOl3eI6C.exists()) {
			YldFfcfn = SOl3eI6C.mkdir();
			if (!YldFfcfn)
				throw new RuntimeException("N?o foi poss¨ªvel criar o diret¨®rio do usu¨¢rio");
		}
		PrintWriter vSwK89xh = null;
		InputStream FXgoSGey = null;
		FileOutputStream uBjfR8Ee = null;
		try {
			vSwK89xh = chHdFQU6.getWriter();
		} catch (IOException MfF0KFvc) {
			System.err.println(
					FileUploadController.class.getName() + "has thrown an exception: " + MfF0KFvc.getMessage());
		}
		String Zp2pCDQi = lP2hxeoQ.getHeader("X-File-Name");
		try {
			FXgoSGey = lP2hxeoQ.getInputStream();
			uBjfR8Ee = new FileOutputStream(new File(UPLOAD_DIRECTORY + Zp2pCDQi));
			IOUtils.copy(FXgoSGey, uBjfR8Ee);
			chHdFQU6.setStatus(chHdFQU6.SC_OK);
			vSwK89xh.print("{success: true}");
		} catch (FileNotFoundException nmdbSHn8) {
			chHdFQU6.setStatus(chHdFQU6.SC_INTERNAL_SERVER_ERROR);
			vSwK89xh.print("{success: false}");
			System.err.println(
					FileUploadController.class.getName() + "has thrown an exception: " + nmdbSHn8.getMessage());
		} catch (IOException Vu8EJYf9) {
			chHdFQU6.setStatus(chHdFQU6.SC_INTERNAL_SERVER_ERROR);
			vSwK89xh.print("{success: false}");
			System.err.println(
					FileUploadController.class.getName() + "has thrown an exception: " + Vu8EJYf9.getMessage());
		} finally {
			try {
				uBjfR8Ee.close();
				FXgoSGey.close();
			} catch (IOException gqJF389S) {
			}
		}
		vSwK89xh.flush();
		vSwK89xh.close();
	}

}