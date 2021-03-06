/*
 * Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package com.intellij.designer.inspector.impl.actions;

import com.intellij.designer.inspector.NodeProperty;
import com.intellij.designer.inspector.Property;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * @author spleaner
 */
public class RemovePropertyAction extends AddPropertyAction {

  public RemovePropertyAction() {
    super("Remove Property");
  }

  @Override
  public void doUpdate(@NotNull AnActionEvent e) {
    final Property property = getSelectedProperty(e);
    final NodeProperty nodeProperty = getNodeProperty(property);
    e.getPresentation().setEnabled(nodeProperty != null && nodeProperty.isRemovable(property));
  }

  @Override
  public void actionPerformed(@NotNull AnActionEvent e) {
    final Property property = getSelectedProperty(e);
    assert property != null;

    final NodeProperty nodeProperty = getNodeProperty(property);
    assert nodeProperty != null;

    nodeProperty.removeProperty(property, e);
  }

}
