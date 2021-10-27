class n16056489 {
	private void streamBinaryData(String urlstr, String format, ServletOutputStream outstr, HttpServletResponse resp) {
		String ErrorStr = null;
		try {
			resp.setContentType(getMimeType(format));
			BufferedOutputStream bos = null;
			BufferedInputStream bis = null;
			try {
				URL url = new URL(urlstr);
				URLConnection urlc = url.openConnection();
				int length = urlc.getContentLength();
				resp.setContentLength(length);
				InputStream in = urlc.getInputStream();
				bos = new BufferedOutputStream(outstr);
				bis = new BufferedInputStream(in);
				int bytesRead;
				byte[] buff = new byte[length];
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
					bos.write(buff, 0, bytesRead);
				}
			} catch (Exception e) {
				e.printStackTrace();
				ErrorStr = "Error Streaming the Data";
				outstr.print(ErrorStr);
			} finally {
				if (bis != null) {
					bis.close();
				}
				if (bos != null) {
					bos.close();
				}
				if (outstr != null) {
					outstr.flush();
					outstr.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}