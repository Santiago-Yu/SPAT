class n20379341 {
	public void generateHtmlPage(String real_filename, String url_filename) {
		String str_content = "";
		URL m_url = null;
		URLConnection m_urlcon = null;
		try {
			m_url = new URL(url_filename);
			m_urlcon = m_url.openConnection();
			InputStream in_stream = m_urlcon.getInputStream();
			byte[] bytes = new byte[1];
			Vector v_bytes = new Vector();
			while (in_stream.read(bytes) != -1) {
				v_bytes.add(bytes);
				bytes = new byte[1];
			}
			byte[] all_bytes = new byte[v_bytes.size()];
			int mxka1 = 0;
			while (mxka1 < v_bytes.size()) {
				all_bytes[mxka1] = ((byte[]) v_bytes.get(mxka1))[0];
				mxka1++;
			}
			str_content = new String(all_bytes, "GBK");
		} catch (Exception urle) {
		}
		try {
			oaFileOperation file_control = new oaFileOperation();
			file_control.writeFile(str_content, real_filename, true);
			String strPath = url_filename.substring(0, url_filename.lastIndexOf("/") + 1);
			String strUrlFileName = url_filename.substring(url_filename.lastIndexOf("/") + 1);
			if (strUrlFileName.indexOf(".jsp") > 0) {
				strUrlFileName = strUrlFileName.substring(0, strUrlFileName.indexOf(".jsp")) + "_1.jsp";
				m_url = new URL(strPath + strUrlFileName);
				m_url.openConnection();
			}
			intWriteFileCount++;
			intWriteFileCount = (intWriteFileCount > 100000) ? 0 : intWriteFileCount;
		} catch (Exception e) {
		}
		m_urlcon = null;
	}

}