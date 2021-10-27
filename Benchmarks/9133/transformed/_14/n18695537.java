class n18695537 {
	public InputSource resolveEntity(String pPublicId, String pSystemId) throws SAXException, IOException {
		try {
			URL url = new URL(pSystemId);
			String fileName = (String) urlMap.get(url);
			if (fileName != null) {
				FileInputStream istream = new FileInputStream(new File(schemaDir, fileName));
				InputSource isource = new InputSource(istream);
				isource.setSystemId(url.toString());
				return isource;
			}
			String file = url.getFile();
			if (null == file) {
				file = "";
			} else {
				int offset = file.lastIndexOf('/');
				if (offset >= 0) {
					file = file.substring(offset + 1);
				}
			}
			if ("".equals(file)) {
				file = "schema.xsd";
			}
			int offset = file.lastIndexOf('.');
			String prefix;
			String suffix;
			String numAsStr = "";
			if (offset > 0 && offset < file.length()) {
				prefix = file.substring(0, offset);
				suffix = file.substring(offset);
			} else {
				prefix = file;
				suffix = ".xsd";
			}
			File f;
			for (int num = 1;; ++num) {
				f = new File(schemaDir, prefix + numAsStr + suffix);
				if (f.exists()) {
					numAsStr = "_" + num;
				} else {
					break;
				}
			}
			InputStream istream = url.openStream();
			schemaDir.mkdirs();
			FileOutputStream fos = new FileOutputStream(f);
			try {
				byte[] buffer = new byte[1024];
				for (;;) {
					int res = istream.read(buffer);
					if (-1 == res) {
						break;
					} else if (res > 0) {
						fos.write(buffer, 0, res);
					}
				}
				istream.close();
				fos.close();
				fos = null;
			} finally {
				if (fos != null) {
					try {
						f.delete();
					} catch (Throwable ignore) {
					}
				}
			}
			urlMap.put(url, f.getName());
			InputSource isource = new InputSource(new FileInputStream(f));
			isource.setSystemId(url.toString());
			return isource;
		} catch (Exception e) {
			JaxMeServlet.this.log("Failed to resolve URL " + pSystemId, e);
		}
		return null;
	}

}