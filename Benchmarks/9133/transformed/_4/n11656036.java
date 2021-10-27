class n11656036 {
	@SuppressWarnings("unchecked")
	public static void createInstance(ExternProtoDeclare externProtoDeclare) {
		ExternProtoDeclareImport epdi = new ExternProtoDeclareImport();
		HashMap<String, ProtoDeclareImport> protoMap = X3DImport.getTheImport().getCurrentParser().getProtoMap();
		boolean loadedFromWeb = false;
		File f = null;
		URL url = null;
		List<String> urls = externProtoDeclare.getUrl();
		String tmpUrls = urls.toString();
		urls = Util.splitStringToListOfStrings(tmpUrls);
		String protoName = null;
		int urlCount = urls.size();
		for (int urlIndex = 0; urlIndex < urlCount; urlIndex++) {
			try {
				String path = urls.get(urlIndex);
				path = (path.startsWith("\"") && path.endsWith("\"")) ? path.substring(1, path.length() - 1) : path;
				int hashMarkPos = path.indexOf("#");
				int urlLength = path.length();
				if (hashMarkPos == -1)
					path = path.substring(0, urlLength);
				else {
					protoName = path.substring(hashMarkPos + 1, urlLength);
					path = path.substring(0, hashMarkPos);
				}
				if (path.toLowerCase().startsWith("http://")) {
					String filename = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
					String fileext = path.substring(path.lastIndexOf("."), path.length());
					f = File.createTempFile(filename, fileext);
					url = new URL(path);
					InputStream is = url.openStream();
					FileOutputStream os = new FileOutputStream(f);
					byte[] buffer = new byte[0xFFFF];
					for (int len; (len = is.read(buffer)) != -1;)
						os.write(buffer, 0, len);
					is.close();
					os.close();
					url = f.toURI().toURL();
					loadedFromWeb = true;
				} else {
					if (path.startsWith("/") || (path.charAt(1) == ':')) {
					} else {
						File x3dfile = X3DImport.getTheImport().getCurrentParser().getFile();
						path = Util.getRealPath(x3dfile) + path;
					}
					f = new File(path);
					url = f.toURI().toURL();
					Object testContent = url.getContent();
					if (testContent == null)
						continue;
					loadedFromWeb = false;
				}
				X3DDocument x3dDocument = null;
				try {
					x3dDocument = X3DDocument.Factory.parse(f);
				} catch (XmlException e) {
					e.printStackTrace();
					return;
				} catch (IOException e) {
					e.printStackTrace();
					return;
				}
				Scene scene = x3dDocument.getX3D().getScene();
				ProtoDeclare[] protos = scene.getProtoDeclareArray();
				ProtoDeclare protoDeclare = null;
				if (protoName == null) {
					protoDeclare = protos[0];
				} else {
					for (ProtoDeclare proto : protos) {
						if (proto.getName().equals(protoName)) {
							protoDeclare = proto;
							break;
						}
					}
				}
				if (protoDeclare == null)
					continue;
				ProtoBody protoBody = protoDeclare.getProtoBody();
				epdi.protoBody = protoBody;
				protoMap.put(externProtoDeclare.getName(), epdi);
				break;
			} catch (MalformedURLException e) {
			} catch (IOException e) {
			} finally {
				if (loadedFromWeb && f != null) {
					f.delete();
				}
			}
		}
	}

}