package bupt.zhang;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.JFrame;
public class CircleButton extends JButton {
Shape shape;
Color bgColor = SystemColor.control;
public CircleButton() {
    this("", null);
}
public CircleButton(String label) {
    this(label, null);
}

public void setBackground(Color bgColor) {
	this.bgColor = bgColor;
}

public CircleButton(String label, Color bgColor) {
    super(label); // ���ø��๹�췽��
    if (bgColor != null) {
      this.bgColor = bgColor;
    }
    Dimension size = this.getPreferredSize();
    size.width = size.height = Math.max(size.width, size.height);
    this.setPreferredSize(size); // ���ÿ�ߵȾ�
    this.setContentAreaFilled(false); // ��������������
    this.setBorderPainted(false); // �����Ʊ߿�
    this.setFocusPainted(false); // �����ƽ���״̬
}
protected void paintComponent(Graphics g) {
    // �����갴�£�isArmed()��������true
    if (this.getModel().isArmed()) {
      g.setColor(java.awt.SystemColor.controlHighlight);
    } else {
      g.setColor(java.awt.SystemColor.controlShadow);
      g.setColor(this.bgColor); // ���ñ�����ɫ
    }
    g.fillOval(0, 0, this.getSize().width - 1, this.getSize().height - 1); // ����Բ�α�������
    g.setColor(java.awt.SystemColor.controlShadow); // ���ñ߿���ɫ
    g.drawOval(0, 0, this.getSize().width - 1, this.getSize().height - 1); // ���Ʊ߿���
    super.paintComponent(g);
}
public boolean contains(int x, int y) {
    if ((shape == null) || (!shape.getBounds().equals(this.getBounds()))) {
      this.shape = new Ellipse2D.Float(0, 0, this.getWidth(), this
          .getHeight());
    }
    return shape.contains(x, y);
}
}
