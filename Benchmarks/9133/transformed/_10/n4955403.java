class n4955403 {
	public FetchTextFromWebPage(String path) {
        HTMLFile = new File(path);
        HTMLEditorKit.Parser parser;
        byte[] html = new byte[new Long(HTMLFile.length()).intValue()];
        parser = new ParserDelegator();
        try {
			FileInputStream fis = new FileInputStream(HTMLFile);
			try {
				fis.read(html);
			} catch (IOException e) {
				e.printStackTrace();
			}
			ByteArrayInputStream ba_read = new ByteArrayInputStream(html);
			r = new InputStreamReader(ba_read);
		} catch (FileNotFoundException e) {
			URL url = null;
			try {
				url = new URL(path);
				URLConnection connection = null;
				try {
					connection = url.openConnection();
					connection.setDoInput(true);
					InputStream inStream = null;
					try {
						inStream = connection.getInputStream();
						BufferedReader input = new BufferedReader(new InputStreamReader(inStream));
						StringBuffer sbr = new StringBuffer();
						String line = null;
						try {
							while ((line = input.readLine()) != null) {
								System.out.println(line);
								sbr.append(line + "\n");
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						File temp = new File("//home//wiki14//temp.txt");
						if (!temp.exists()) {
							if (!temp.createNewFile())
								System.out.println("File caanot be created");
						} else {
							temp.delete();
							if (!temp.createNewFile())
								System.out.println("File caanot be created");
						}
						java.io.FileWriter fw = new java.io.FileWriter(temp);
						fw.write(sbr.toString());
						fw.close();
						byte[] newbyte = new byte[new Long(sbr.length()).intValue()];
						ByteArrayInputStream ba_read = new ByteArrayInputStream(newbyte);
						r = new InputStreamReader(ba_read);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}
        htmltextparser = new HtmlTextParser();
        htmltextparser.initData();
        try {
            parser.parse(r, htmltextparser, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            r.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}