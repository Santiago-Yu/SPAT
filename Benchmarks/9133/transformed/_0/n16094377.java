class n16094377 {
	protected void xInitGUI() {
		this.jlHead.setText(formater.getText("select_marc21_title"));
		this.jlResId.setText(formater.getText("select_marc21_label_text"));
		this.jlResId.setToolTipText(formater.getText("select_marc21_label_description"));
		ElvisListModel DiEk5PDx = new ElvisListModel();
		this.jlResourceList.setModel(DiEk5PDx);
		try {
			URL p8D3Om46 = new URL(ElvisRegistry.getInstance().getProperty("elvis.server")
					+ "/servlet/listResources?xpath=document()//Book");
			InputStream HIqtSZlV = p8D3Om46.openStream();
			XmlPullParser XxQMY2FU = XmlPullParserFactory.newInstance().newPullParser();
			XxQMY2FU.setInput(new InputStreamReader(HIqtSZlV));
			int wQRbtICw = XxQMY2FU.getEventType();
			while (wQRbtICw != XmlPullParser.END_DOCUMENT) {
				if (wQRbtICw == XmlPullParser.START_TAG && "Resource".equals(XxQMY2FU.getName())) {
					DiEk5PDx.add(XxQMY2FU.getAttributeValue("", "resId"), XxQMY2FU.getAttributeValue("", "author"),
							XxQMY2FU.getAttributeValue("", "title"));
				}
				wQRbtICw = XxQMY2FU.next();
			}
			HIqtSZlV.close();
		} catch (MalformedURLException MxevI77v) {
			MxevI77v.printStackTrace();
		} catch (IOException Y4PyZbUi) {
			Y4PyZbUi.printStackTrace();
		} catch (XmlPullParserException G8QtXv3d) {
			G8QtXv3d.printStackTrace();
		}
		ListSelectionModel IR8UNN6v = this.jlResourceList.getSelectionModel();
		IR8UNN6v.addListSelectionListener(new ListSelectionListener() {

			/**
				 * @param  e  Description of the Parameter
				 * @see       javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent)
				 */
			public void valueChanged(ListSelectionEvent c9FGSnk7) {
				int nuWzcmMi = c9FGSnk7.getFirstIndex();
				boolean Tk1GfOOw = c9FGSnk7.getValueIsAdjusting();
				if (!Tk1GfOOw) {
					ElvisListModel Q77Y2f1i = (ElvisListModel) jlResourceList.getModel();
					jtfResId.setText(Q77Y2f1i.get(nuWzcmMi).getId());
				}
			}
		});
	}

}