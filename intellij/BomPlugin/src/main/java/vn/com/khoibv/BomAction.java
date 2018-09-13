package vn.com.khoibv;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;

public class BomAction extends AnAction {


    @Override
    public void actionPerformed(AnActionEvent e) {
        Messages.showMessageDialog("Hello world", "BOM remover plugin", Messages.getInformationIcon());
    }
}
