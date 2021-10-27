class n16056489 {
	private void streamBinaryData(String Rsap6szn, String xRdfwHLg, ServletOutputStream KXQZ7tuz,
			HttpServletResponse Uyk1K1dq) {
		String vAvhv1EB = null;
		try {
			Uyk1K1dq.setContentType(getMimeType(xRdfwHLg));
			BufferedInputStream yLhjl51I = null;
			BufferedOutputStream kHuGk43u = null;
			try {
				URL TK462VDD = new URL(Rsap6szn);
				URLConnection R2FCHNwy = TK462VDD.openConnection();
				int QYSwcEsW = R2FCHNwy.getContentLength();
				Uyk1K1dq.setContentLength(QYSwcEsW);
				InputStream GgCmE7lU = R2FCHNwy.getInputStream();
				yLhjl51I = new BufferedInputStream(GgCmE7lU);
				kHuGk43u = new BufferedOutputStream(KXQZ7tuz);
				byte[] gomnVt6a = new byte[QYSwcEsW];
				int dSwP63Fj;
				while (-1 != (dSwP63Fj = yLhjl51I.read(gomnVt6a, 0, gomnVt6a.length))) {
					kHuGk43u.write(gomnVt6a, 0, dSwP63Fj);
				}
			} catch (Exception Yeke0YFq) {
				Yeke0YFq.printStackTrace();
				vAvhv1EB = "Error Streaming the Data";
				KXQZ7tuz.print(vAvhv1EB);
			} finally {
				if (yLhjl51I != null) {
					yLhjl51I.close();
				}
				if (kHuGk43u != null) {
					kHuGk43u.close();
				}
				if (KXQZ7tuz != null) {
					KXQZ7tuz.flush();
					KXQZ7tuz.close();
				}
			}
		} catch (Exception W3wKow7c) {
			W3wKow7c.printStackTrace();
		}
	}

}