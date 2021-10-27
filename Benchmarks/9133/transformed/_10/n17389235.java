class n17389235 {
	public boolean PrintPage(String page, String url_addr, String charset) {
		File parent_path = new File(new File(page).getParent());
		String r_line = null;
		if (!parent_path.exists()) {
			parent_path.mkdirs();
		}
		FileOutputStream out = null;
		BufferedReader bReader = null;
		PrintWriter fileOut = null;
		OutputStreamWriter writer = null;
		File file = null;
		try {
			file = new File(page);
			InputStream ins = new URL(url_addr).openStream();
			bReader = new BufferedReader(new InputStreamReader(ins, charset));
			if (!file.exists()) {
				file.createNewFile();
			}
			out = new FileOutputStream(page);
			writer = new OutputStreamWriter(out, charset);
			fileOut = new PrintWriter(writer);
			while ((r_line = bReader.readLine()) != null) {
				r_line = r_line.trim();
				int str_len = r_line.length();
				if (str_len > 0) {
					fileOut.println(r_line);
					fileOut.flush();
				}
			}
			ins.close();
			ins = null;
			fileOut.close();
			writer.close();
			out.close();
			bReader.close();
			writer = null;
			fileOut = null;
			bReader = null;
			out = null;
			file = null;
			parent_path = null;
			r_line = null;
			return true;
		} catch (IOException ioe) {
			log.error(ioe.getMessage());
			ioe.printStackTrace();
			return false;
		} catch (Exception es) {
			es.printStackTrace();
			log.error("static----------" + es.getMessage());
			return false;
		} finally {
			try {
				if (fileOut != null) {
					fileOut.close();
					fileOut = null;
				}
				if (writer != null) {
					writer.close();
					writer = null;
				}
				if (out != null) {
					out.close();
					out = null;
				}
				if (bReader != null) {
					bReader.close();
					bReader = null;
				}
			} catch (IOException ioe) {
				log.error(ioe.getMessage());
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}

}