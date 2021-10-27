class n16094377{
    protected void xInitGUI() {
        this.jlHead.setText(formater.getText("select_marc21_title"));
        this.jlResId.setText(formater.getText("select_marc21_label_text"));
        this.jlResId.setToolTipText(formater.getText("select_marc21_label_description"));
        ElvisListModel model = new ElvisListModel();
        this.jlResourceList.setModel(model);
        try {
            URL urlListResources = new URL(ElvisRegistry.getInstance().getProperty("elvis.server") + "/servlet/listResources?xpath=document()//Book");
            InputStream streamResources = urlListResources.openStream();
            XmlPullParser xpp = XmlPullParserFactory.newInstance().newPullParser();
            xpp.setInput(new InputStreamReader(streamResources));
            int type = xpp.getEventType();
            while (type != XmlPullParser.END_DOCUMENT) {
                if (type == XmlPullParser.START_TAG && "Resource".equals(xpp.getName())) {
                    model.add(xpp.getAttributeValue("", "resId"), xpp.getAttributeValue("", "author"), xpp.getAttributeValue("", "title"));
                }
                type = xpp.next();
            }
            streamResources.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (XmlPullParserException xppe) {
            xppe.printStackTrace();
        }
        ListSelectionModel selectionModel = this.jlResourceList.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {

            /**
				 * @param  e  Description of the Parameter
				 * @see       javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent)
				 */
            public void valueChanged(ListSelectionEvent e) {
                int index = e.getFirstIndex();
                boolean isAdjusting = e.getValueIsAdjusting();
                if (!isAdjusting) {
                    ElvisListModel _model = (ElvisListModel) jlResourceList.getModel();
                    jtfResId.setText(_model.get(index).getId());
                }
            }
        });
    }

}