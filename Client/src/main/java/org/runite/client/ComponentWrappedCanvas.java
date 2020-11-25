package org.runite.client;

import java.awt.*;

final class ComponentWrappedCanvas extends Canvas {

    private final Component component;

    public ComponentWrappedCanvas(Component component) {
        this.component = component;
    }

    public final void update(Graphics g) {
        this.component.update(g);
    }

    public final void paint(Graphics g) {
        this.component.paint(g);
    }

}
