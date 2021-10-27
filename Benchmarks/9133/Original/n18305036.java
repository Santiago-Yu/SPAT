class n18305036{
            @Override
            protected Drawing construct() throws IOException {
                Drawing result;
                System.out.println("getParameter.datafile:" + getParameter("datafile"));
                if (getParameter("data") != null) {
                    NanoXMLDOMInput domi = new NanoXMLDOMInput(new NetFactory(), new StringReader(getParameter("data")));
                    result = (Drawing) domi.readObject(0);
                } else if (getParameter("datafile") != null) {
                    URL url = new URL(getDocumentBase(), getParameter("datafile"));
                    InputStream in = url.openConnection().getInputStream();
                    try {
                        NanoXMLDOMInput domi = new NanoXMLDOMInput(new NetFactory(), in);
                        result = (Drawing) domi.readObject(0);
                    } finally {
                        in.close();
                    }
                } else {
                    result = null;
                }
                return result;
            }

}