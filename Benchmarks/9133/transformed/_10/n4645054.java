class n4645054 {
	public ActualTask(TEditor editor, TIGDataBase dataBase, String directoryPath, Vector images) {
            lengthOfTask = images.size();
            int i;
            Element dataBaseXML = new Element("dataBase");
            for (i = 0; ((i < images.size()) && !stop && !cancel); i++) {
                Vector imagen = new Vector(2);
                imagen = (Vector) images.elementAt(i);
                String element = (String) imagen.elementAt(0);
                current = i;
                String pathSrc = System.getProperty("user.dir") + File.separator + "images" + File.separator + element.substring(0, 1).toUpperCase() + File.separator + element;
                String name = pathSrc.substring(pathSrc.lastIndexOf(File.separator) + 1, pathSrc.length());
                String pathDst = directoryPath + name;
                Vector<String> keyWords=new Vector<String>();
                try {
					FileChannel srcChannel = new FileInputStream(pathSrc).getChannel();
					FileChannel dstChannel = new FileOutputStream(pathDst).getChannel();
					dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
					srcChannel.close();
					dstChannel.close();
				} catch (IOException exc) {
					System.out.println(exc.getMessage());
					System.out.println(exc.toString());
				}
                Element image = new Element("image");
                keyWords = TIGDataBase.asociatedConceptSearch(element);
                image.setAttribute("name", name);
                if (keyWords.size() != 0) {
                    for (int k = 0; k < keyWords.size(); k++) {
                        Element category = new Element("category");
                        category.setText(keyWords.get(k).trim());
                        image.addContent(category);
                    }
                }
                dataBaseXML.addContent(image);
            }
            Document doc = new Document(dataBaseXML);
            try {
                FileOutputStream f = new FileOutputStream(directoryPath + "images.xml");
                XMLOutputter out = new XMLOutputter();
                out.output(doc, f);
                f.flush();
                f.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            current = lengthOfTask;
        }

}