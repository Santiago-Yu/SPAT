class n9077865 {
	@Override
	public void exec() {
		if (fileURI == null)
			return;
		InputStream r8EFMS1F = null;
		try {
			if (fileURI.toLowerCase().startsWith("dbgp://")) {
				String bLUFQCZU = fileURI.substring(7);
				if (bLUFQCZU.toLowerCase().startsWith("file/")) {
					bLUFQCZU = fileURI.substring(5);
					r8EFMS1F = new FileInputStream(new File(bLUFQCZU));
				} else {
					XmldbURI Vhlo4arm = XmldbURI.create(URLDecoder.decode(fileURI.substring(15), "UTF-8"));
					Database a9W47ByD = getJoint().getContext().getDatabase();
					DBBroker B1q9hxGG = null;
					try {
						B1q9hxGG = a9W47ByD.getBroker();
						DocumentImpl thsgX4Ux = B1q9hxGG.getXMLResource(Vhlo4arm, Lock.READ_LOCK);
						if (thsgX4Ux.getResourceType() == DocumentImpl.BINARY_FILE) {
							r8EFMS1F = B1q9hxGG.getBinaryResource((BinaryDocument) thsgX4Ux);
						} else {
							return;
						}
					} catch (EXistException JkVmP596) {
						exception = JkVmP596;
					} finally {
						a9W47ByD.release(B1q9hxGG);
					}
				}
			} else {
				URL C9SX8KN5 = new URL(fileURI);
				URLConnection Sp32vTTD = C9SX8KN5.openConnection();
				r8EFMS1F = Sp32vTTD.getInputStream();
			}
			ByteArrayOutputStream LLxuO6xk = new ByteArrayOutputStream();
			byte[] RyxEIzxM = new byte[256];
			int YdgHNn4E;
			while ((YdgHNn4E = r8EFMS1F.read(RyxEIzxM)) > -1) {
				LLxuO6xk.write(RyxEIzxM, 0, YdgHNn4E);
			}
			source = LLxuO6xk.toByteArray();
			success = true;
		} catch (MalformedURLException gXzSzqW7) {
			exception = gXzSzqW7;
		} catch (IOException sHei3jY9) {
			exception = sHei3jY9;
		} catch (PermissionDeniedException AuQXr6oW) {
			exception = AuQXr6oW;
		} finally {
			if (r8EFMS1F != null)
				try {
					r8EFMS1F.close();
				} catch (IOException WsNVyO4T) {
					if (exception == null)
						exception = WsNVyO4T;
				}
		}
	}

}