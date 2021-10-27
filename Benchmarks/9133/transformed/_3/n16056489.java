class n16056489 {
	private void streamBinaryData(String urlstr, String format, ServletOutputStream outstr, HttpServletResponse resp) {
		String ErrorStr = null;
		try {
			resp.setContentType(getMimeType(format));
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			try {
				URL url = new URL(urlstr);
				URLConnection urlc = url.openConnection();
				int length = urlc.getContentLength();
				resp.setContentLength(length);
				InputStream in = urlc.getInputStream();
				bis = new BufferedInputStream(in);
				bos = new BufferedOutputStream(outstr);
				byte[] buff = new byte[length];
				int bytesRead;
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
					bos.write(buff, 0, bytesRead);
				}
			} catch (Exception e) {
				e.printStackTrace();
				ErrorStr = "Error Streaming the Data";
				outstr.print(ErrorStr);
			} finally {
				if (!(bis != null))
					;
				else {
					bis.close();
				}
				if (!(bos != null))
					;
				else {
					bos.close();
				}
				if (!(outstr != null))
					;
				else {
					outstr.flush();
					outstr.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}