package coderodde.lib3d;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

import static org.testng.Assert.*;

/**
 * Created by snyder on 2015-05-20.
 */
public class SceneObjectTest {
    //x' = x * cos(1); (+-10 * 0.54030230586813971740093660744298) = +-5.4030230586813971740093660744298
    //y' = y * sin(1); (+-10 * 0.8414709848078965066525023216303) = +-8.414709848078965066525023216303

    final Vertex CENTER = new Vertex(0, 0, 0);
    SceneObject object;
    private Vertex vertex0;
    private Vertex vertex1;

    @BeforeMethod
    public void SetupBeforeTest() {
        object = new SceneObject(0, 0, 0);
        vertex0 = new Vertex(-10, 0, 0);
        vertex1 = new Vertex(10, 0, 0);

        object.add(vertex0);
        object.add(vertex1);
    }

    @Test
    public void testRotateOnXAxis() throws Exception {
        object.rotate(CENTER, 1, 0, 0);//rotate 1 radian on x

        assertXYZ(vertex0, -10, 0, 0);//0
        assertXYZ(vertex1, 10, 0, 0);//0
    }

    @Test
    public void testRotateOnYAxis() throws Exception {
        object.rotate(CENTER, 0, 1, 0);//rotate 1 radian on y

        assertXYZ(vertex0, -5.4030230586813971740093660744298, 0, -8.414709848078965066525023216303);
        assertXYZ(vertex1, 5.4030230586813971740093660744298, 0, 8.414709848078965066525023216303);
    }

    @Test
    public void testRotateOnZAxis() throws Exception {
        object.rotate(CENTER, 0, 0, 1);//rotate 1 radian on z

        assertXYZ(vertex0, -5.4030230586813971740093660744298, 8.414709848078965066525023216303, 0);
        assertXYZ(vertex1, 5.4030230586813971740093660744298, -8.414709848078965066525023216303, 0);
    }

    private void assertXYZ(Vertex vertex, double x, double y, double z) {
        assertEquals(vertex.x, x, 0.00001, String.format("expected Vertex to have x coordinate of %f but found %f\r\nActual:%s", x, vertex.x, vertex));
        assertEquals(vertex.y, y, 0.00001, String.format("expected Vertex to have y coordinate of %f but found %f\r\nActual:%s", y, vertex.y, vertex));
        assertEquals(vertex.z, z, 0.00001, String.format("expected Vertex to have z coordinate of %f but found %f\r\nActual:%s", z, vertex.z, vertex));
    }
}