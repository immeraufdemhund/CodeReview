package coderodde.lib3d;

import java.awt.*;

/**
 * Created by snyder on 2015-05-20.
 */
public class LineSegment {
    final private Vertex point0;
    final private Vertex point1;
    final private Color color;


    public LineSegment(Vertex point0, Vertex point1, Color color) {
        this.point0 = point0;
        this.point1 = point1;
        this.color = color;
    }
}
