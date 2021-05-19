import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Transform3D;
import javax.swing.*;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame implements ActionListener, KeyListener {
    Castle Castle;
    boolean rotate = false;

    public Main() {
        // Frame title
        super("Lab4 - Castle");

        Castle = new Castle();

        Canvas3D canvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());

        add(canvas3D);
        canvas3D.addKeyListener(this);

        Timer timer = new Timer(50, this);
        timer.start();
        BranchGroup scene = Castle.createSceneGraph();
        SimpleUniverse u = new SimpleUniverse(canvas3D);
        Transform3D move = lookTowardsOriginFrom(new Point3d(0, 0, -3));
        u.getViewingPlatform().getViewPlatformTransform().setTransform(move);
       // u.getViewingPlatform().setNominalViewingTransform();

        u.addBranchGraph(scene);

        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }


    public Transform3D lookTowardsOriginFrom(Point3d point)
    {
        Transform3D move = new Transform3D();
        Vector3d up = new Vector3d(point.x, point.y + 1, point.z);
        move.lookAt(point, new Point3d(0.0d, 0.0d, 0.0d), up);

        return move;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(rotate) {
            Castle.rotate();
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            rotate = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
            rotate = false;
        }
    }

}