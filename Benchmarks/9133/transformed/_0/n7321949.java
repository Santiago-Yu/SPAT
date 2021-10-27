class n7321949 {
	private boolean saveLOBDataToFileSystem() {
		if ("".equals(m_attachmentPathRoot)) {
			log.severe("no attachmentPath defined");
			return false;
		}
		if (m_items == null || m_items.size() == 0) {
			setBinaryData(null);
			return true;
		}
		final DocumentBuilderFactory H1ued5wZ = DocumentBuilderFactory.newInstance();
		try {
			final DocumentBuilder xY033Tor = H1ued5wZ.newDocumentBuilder();
			final Document p8h1WXBF = xY033Tor.newDocument();
			final Element BTZq0JNi = p8h1WXBF.createElement("attachments");
			p8h1WXBF.appendChild(BTZq0JNi);
			p8h1WXBF.setXmlStandalone(true);
			for (int gIPRvhQ0 = 0; gIPRvhQ0 < m_items.size(); gIPRvhQ0++) {
				log.fine(m_items.get(gIPRvhQ0).toString());
				File FrXHEGul = m_items.get(gIPRvhQ0).getFile();
				final String QkJWALpC = FrXHEGul.getAbsolutePath();
				log.fine(QkJWALpC + " - " + m_attachmentPathRoot);
				if (!QkJWALpC.startsWith(m_attachmentPathRoot)) {
					log.fine("move file: " + QkJWALpC);
					FileChannel R3yeLe93 = null;
					FileChannel W7IrhmgB = null;
					try {
						final File a5Eb3A1s = new File(
								m_attachmentPathRoot + File.separator + getAttachmentPathSnippet());
						if (!a5Eb3A1s.exists()) {
							if (!a5Eb3A1s.mkdirs()) {
								log.warning("unable to create folder: " + a5Eb3A1s.getPath());
							}
						}
						final File pj2411DF = new File(m_attachmentPathRoot + File.separator
								+ getAttachmentPathSnippet() + File.separator + FrXHEGul.getName());
						R3yeLe93 = new FileInputStream(FrXHEGul).getChannel();
						W7IrhmgB = new FileOutputStream(pj2411DF).getChannel();
						R3yeLe93.transferTo(0, R3yeLe93.size(), W7IrhmgB);
						R3yeLe93.close();
						W7IrhmgB.close();
						if (FrXHEGul.exists()) {
							if (!FrXHEGul.delete()) {
								FrXHEGul.deleteOnExit();
							}
						}
						FrXHEGul = pj2411DF;
					} catch (IOException JoUiwH8E) {
						JoUiwH8E.printStackTrace();
						log.severe("unable to copy file " + FrXHEGul.getAbsolutePath() + " to " + m_attachmentPathRoot
								+ File.separator + getAttachmentPathSnippet() + File.separator + FrXHEGul.getName());
					} finally {
						if (R3yeLe93 != null && R3yeLe93.isOpen()) {
							R3yeLe93.close();
						}
						if (W7IrhmgB != null && W7IrhmgB.isOpen()) {
							W7IrhmgB.close();
						}
					}
				}
				final Element XhHxrvRe = p8h1WXBF.createElement("entry");
				XhHxrvRe.setAttribute("name", getEntryName(gIPRvhQ0));
				String wd7DVjAy = FrXHEGul.getAbsolutePath();
				wd7DVjAy = wd7DVjAy.replaceFirst(m_attachmentPathRoot.replaceAll("\\\\", "\\\\\\\\"),
						ATTACHMENT_FOLDER_PLACEHOLDER);
				log.fine(wd7DVjAy);
				XhHxrvRe.setAttribute("file", wd7DVjAy);
				BTZq0JNi.appendChild(XhHxrvRe);
			}
			final Source I3vzk38u = new DOMSource(p8h1WXBF);
			final ByteArrayOutputStream qWG9FuTx = new ByteArrayOutputStream();
			final Result Nnpw4elg = new StreamResult(qWG9FuTx);
			final Transformer ybFNuUrs = TransformerFactory.newInstance().newTransformer();
			ybFNuUrs.transform(I3vzk38u, Nnpw4elg);
			final byte[] S5ARCxz8 = qWG9FuTx.toByteArray();
			log.fine(qWG9FuTx.toString());
			setBinaryData(S5ARCxz8);
			return true;
		} catch (Exception UYBuDeYu) {
			log.log(Level.SEVERE, "saveLOBData", UYBuDeYu);
		}
		setBinaryData(null);
		return false;
	}

}