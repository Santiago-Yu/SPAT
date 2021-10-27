class n9077865 {
	@Override
	public void exec() {
		if (fileURI == null)
			return;
		InputStream is = null;
		try {
			if (fileURI.toLowerCase().startsWith("dbgp://")) {
				String uri = fileURI.substring(7);
				if (uri.toLowerCase().startsWith("file/")) {
					uri = fileURI.substring(5);
					is = new FileInputStream(new File(uri));
				} else {
					XmldbURI pathUri = XmldbURI.create(URLDecoder.decode(fileURI.substring(15), "UTF-8"));
					Database db = getJoint().getContext().getDatabase();
					DBBroker broker = null;
					try {
						broker = db.getBroker();
						DocumentImpl resource = broker.getXMLResource(pathUri, Lock.READ_LOCK);
						if (resource.getResourceType() == DocumentImpl.BINARY_FILE) {
							is = broker.getBinaryResource((BinaryDocument) resource);
						} else {
							return;
						}
					} catch (EXistException e) {
						exception = e;
					} finally {
						db.release(broker);
					}
				}
			} else {
				URL url = new URL(fileURI);
				URLConnection conn = url.openConnection();
				is = conn.getInputStream();
			}
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buf = new byte[256];
			int c;
			while ((c = is.read(buf)) > -1) {
				baos.write(buf, 0, c);
			}
			source = baos.toByteArray();
			success = true;
		} catch (MalformedURLException e) {
			exception = e;
		} catch (IOException e) {
			exception = e;
		} catch (PermissionDeniedException e) {
			exception = e;
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
					exception = (exception == null) ? e : exception;
				}
		}
	}

}