/*******************************************************************************
 * Copyright (c) 2012-2014 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package com.codenvy.ide.ext.python.client.wizard;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

/** @author Vladyslav Zhukovskii */
public class PythonPageViewImpl implements PythonPageView {
    private static PythonPageViewImplUiBinder ourUiBinder = GWT.create(PythonPageViewImplUiBinder.class);
    private final DockLayoutPanel rootElement;
    private       ActionDelegate  delegate;

    @UiField
    ListBox projectTypeField;

    interface PythonPageViewImplUiBinder extends UiBinder<DockLayoutPanel, PythonPageViewImpl> {
    }

    public PythonPageViewImpl() {
        rootElement = ourUiBinder.createAndBindUi(this);
    }

    @Override
    public void setDelegate(ActionDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Widget asWidget() {
        return rootElement;
    }

    @Override
    public String getProjectType() {
        return projectTypeField.getValue(projectTypeField.getSelectedIndex());
    }

    @Override
    public void reset() {
        projectTypeField.setSelectedIndex(0);
    }

    @UiHandler("projectTypeField")
    void onProjectTypeChanged(ChangeEvent event) {
        delegate.setProjectType(getProjectType());
    }
}
