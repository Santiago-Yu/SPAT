class n4588203 {
	public String copyImages(Document doc, String sXML, String newPath, String tagName, String itemName) {
		Node n = null;
		NodeList nl = null;
		Node nsrc = null;
		NamedNodeMap nnp = null;
		String sFilename = "";
		URL url = null;
		int index;
		String sNewPath = "";
		String sOldPath = "";
		try {
			nl = doc.getElementsByTagName(tagName);
			for (int i = 0; i < nl.getLength(); i++) {
				n = nl.item(i);
				nnp = n.getAttributes();
				nsrc = nnp.getNamedItem(itemName);
				String sTemp = nsrc.getTextContent();
				url = new URL("file", "localhost", sTemp);
				sOldPath = url.getPath();
				sOldPath = sOldPath.replace('/', File.separatorChar);
				String sSourcePath;
				int indexFirstSlash = sOldPath.indexOf(File.separatorChar);
				if (itemName.equals("data"))
					sSourcePath = sOldPath;
				else
					sSourcePath = sOldPath.substring(indexFirstSlash + 1);
				index = sOldPath.lastIndexOf(File.separatorChar);
				sFilename = sOldPath.substring(index + 1);
				FileChannel in = null;
				sNewPath = newPath + sFilename;
				FileChannel out = null;
				try {
					in = new FileInputStream(sSourcePath).getChannel();
					out = new FileOutputStream(sNewPath).getChannel();
					long size = in.size();
					MappedByteBuffer buf = in.map(FileChannel.MapMode.READ_ONLY, 0, size);
					out.write(buf);
				} finally {
					if (in != null)
						in.close();
					if (out != null)
						out.close();
				}
				sXML = sXML.replace(nsrc.getTextContent(), sFilename);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sXML;
	}

}