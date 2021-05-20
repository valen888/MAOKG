import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.*;
import javax.vecmath.Vector3f;
import java.awt.event.*;

public class BeeAnimation extends KeyAdapter implements ActionListener {
    private static final float DELTA_DISTANCE = 0.02f;
    private static final float DELTA_ANGLE = 0.05f;

    private TransformGroup bTransformGroup;
    private Transform3D transform3D = new Transform3D();

    private float LocationX = 0;
    private float LocationY = 0;

    private boolean pressedZ = false;
    private boolean pressedX = false;
    private boolean pressedW = false;
    private boolean pressedS = false;
    private boolean pressedA = false;
    private boolean pressedD = false;

    private boolean pressedVKRight = false;
    private boolean pressedVKLeft = false;
    private boolean pressedVKUp = false;
    private boolean pressedVKDown = false;

    BeeAnimation(Bee bee) {
        this.bTransformGroup = bee.getBeeTransformGroup();
        this.bTransformGroup.getTransform(this.transform3D);

        Timer timer = new Timer(20, this);
        timer.start();
    }

    private void Move() {
        if (pressedW)
            LocationY += DELTA_DISTANCE;

        if (pressedS)
            LocationY -= DELTA_DISTANCE;

        if (pressedA)
            LocationX -= DELTA_DISTANCE;

        if (pressedD)
            LocationX += DELTA_DISTANCE;

        transform3D.setTranslation(new Vector3f(LocationX, LocationY, 0));

        if (pressedVKRight) {
            Transform3D rotation = new Transform3D();
            rotation.rotZ(DELTA_ANGLE);
            transform3D.mul(rotation);
        }

        if (pressedVKLeft) {
            Transform3D rotation = new Transform3D();
            rotation.rotZ(-DELTA_ANGLE);
            transform3D.mul(rotation);
        }

        if (pressedVKUp) {
            Transform3D rotation = new Transform3D();
            rotation.rotX(-DELTA_ANGLE);
            transform3D.mul(rotation);
        }

        if (pressedVKDown) {
            Transform3D rotation = new Transform3D();
            rotation.rotX(DELTA_ANGLE);
            transform3D.mul(rotation);
        }

        if (pressedZ) {
            Transform3D rotation = new Transform3D();
            rotation.rotY(-DELTA_ANGLE);
            transform3D.mul(rotation);

            pressedZ = false;
        }

        if (pressedX) {
            Transform3D rotation = new Transform3D();
            rotation.rotY(DELTA_ANGLE);
            transform3D.mul(rotation);

            pressedX = false;
        }

        bTransformGroup.setTransform(transform3D);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Move();
    }

    @Override
    public void keyPressed(KeyEvent ev) {
        switch (ev.getKeyCode()) {
            case 87: // W
                pressedW = true;
                break;
            case 83: // S
                pressedS = true;
                break;
            case 65: // A
                pressedA = true;
                break;
            case 68: // D
                pressedD = true;
                break;
            case KeyEvent.VK_LEFT:
                pressedVKLeft = true;
                break;
            case KeyEvent.VK_RIGHT:
                pressedVKRight = true;
                break;
            case KeyEvent.VK_UP:
                pressedVKUp = true;
                break;
            case KeyEvent.VK_DOWN:
                pressedVKDown = true;
                break;
            case 90:
                pressedZ = true;
                break;
            case 88:
                pressedX = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ev) {
        switch (ev.getKeyCode()) {
            case 87: // W
                pressedW = false;
                break;
            case 83: // S
                pressedS = false;
                break;
            case 65: // A
                pressedA = false;
                break;
            case 68: // D
                pressedD = false;
                break;
            case KeyEvent.VK_RIGHT:
                pressedVKRight = false;
                break;
            case KeyEvent.VK_LEFT:
                pressedVKLeft = false;
                break;
            case KeyEvent.VK_UP:
                pressedVKUp = false;
                break;
            case KeyEvent.VK_DOWN:
                pressedVKDown = false;
                break;
            case 90:
                pressedZ = false;
                break;
            case 88:
                pressedX = false;
                break;

        }
    }

    private float degree(float degrees) {
        return (float) (degrees * Math.PI / 180);
    }
}