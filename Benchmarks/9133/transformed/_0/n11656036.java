class n11656036 {
	@SuppressWarnings("unchecked")
	public static void createInstance(ExternProtoDeclare IvnaSV2Z) {
		ExternProtoDeclareImport pVqas00C = new ExternProtoDeclareImport();
		HashMap<String, ProtoDeclareImport> IgPJKvW4 = X3DImport.getTheImport().getCurrentParser().getProtoMap();
		boolean hZvg9tSV = false;
		File EOIIuM4w = null;
		URL KWQKZLtw = null;
		List<String> bjVk3v3a = IvnaSV2Z.getUrl();
		String TCoZR7gO = bjVk3v3a.toString();
		bjVk3v3a = Util.splitStringToListOfStrings(TCoZR7gO);
		String QrTiWsge = null;
		int Cx4p5NUF = bjVk3v3a.size();
		for (int a13XbLVh = 0; a13XbLVh < Cx4p5NUF; a13XbLVh++) {
			try {
				String hjfwXClz = bjVk3v3a.get(a13XbLVh);
				if (hjfwXClz.startsWith("\"") && hjfwXClz.endsWith("\""))
					hjfwXClz = hjfwXClz.substring(1, hjfwXClz.length() - 1);
				int aqeykKZt = hjfwXClz.indexOf("#");
				int vkMOlcNX = hjfwXClz.length();
				if (aqeykKZt == -1)
					hjfwXClz = hjfwXClz.substring(0, vkMOlcNX);
				else {
					QrTiWsge = hjfwXClz.substring(aqeykKZt + 1, vkMOlcNX);
					hjfwXClz = hjfwXClz.substring(0, aqeykKZt);
				}
				if (hjfwXClz.toLowerCase().startsWith("http://")) {
					String BAyLrCQr = hjfwXClz.substring(hjfwXClz.lastIndexOf("/") + 1, hjfwXClz.lastIndexOf("."));
					String tvT0Vs8N = hjfwXClz.substring(hjfwXClz.lastIndexOf("."), hjfwXClz.length());
					EOIIuM4w = File.createTempFile(BAyLrCQr, tvT0Vs8N);
					KWQKZLtw = new URL(hjfwXClz);
					InputStream REjEwWns = KWQKZLtw.openStream();
					FileOutputStream gmTwYW0m = new FileOutputStream(EOIIuM4w);
					byte[] aaRRs4Xp = new byte[0xFFFF];
					for (int OMxymsqB; (OMxymsqB = REjEwWns.read(aaRRs4Xp)) != -1;)
						gmTwYW0m.write(aaRRs4Xp, 0, OMxymsqB);
					REjEwWns.close();
					gmTwYW0m.close();
					KWQKZLtw = EOIIuM4w.toURI().toURL();
					hZvg9tSV = true;
				} else {
					if (hjfwXClz.startsWith("/") || (hjfwXClz.charAt(1) == ':')) {
					} else {
						File VCEzXQS5 = X3DImport.getTheImport().getCurrentParser().getFile();
						hjfwXClz = Util.getRealPath(VCEzXQS5) + hjfwXClz;
					}
					EOIIuM4w = new File(hjfwXClz);
					KWQKZLtw = EOIIuM4w.toURI().toURL();
					Object AalO3TMG = KWQKZLtw.getContent();
					if (AalO3TMG == null)
						continue;
					hZvg9tSV = false;
				}
				X3DDocument myX2twiH = null;
				try {
					myX2twiH = X3DDocument.Factory.parse(EOIIuM4w);
				} catch (XmlException rgaldITN) {
					rgaldITN.printStackTrace();
					return;
				} catch (IOException q0RGZKC3) {
					q0RGZKC3.printStackTrace();
					return;
				}
				Scene z6E8C1Tn = myX2twiH.getX3D().getScene();
				ProtoDeclare[] OPNZuJkf = z6E8C1Tn.getProtoDeclareArray();
				ProtoDeclare o6rgIDAn = null;
				if (QrTiWsge == null) {
					o6rgIDAn = OPNZuJkf[0];
				} else {
					for (ProtoDeclare t5YOvOLn : OPNZuJkf) {
						if (t5YOvOLn.getName().equals(QrTiWsge)) {
							o6rgIDAn = t5YOvOLn;
							break;
						}
					}
				}
				if (o6rgIDAn == null)
					continue;
				ProtoBody vJEGssv6 = o6rgIDAn.getProtoBody();
				pVqas00C.protoBody = vJEGssv6;
				IgPJKvW4.put(IvnaSV2Z.getName(), pVqas00C);
				break;
			} catch (MalformedURLException ZVc8TzpJ) {
			} catch (IOException KgAx3rIc) {
			} finally {
				if (hZvg9tSV && EOIIuM4w != null) {
					EOIIuM4w.delete();
				}
			}
		}
	}

}