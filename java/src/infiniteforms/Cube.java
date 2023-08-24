package infiniteforms;

import ie.tudublin.AudioGarden;
import ie.tudublin.Poly;
import processing.core.PVector;

public class Cube extends Poly 
{
    
    PVector position;
  
    float smoothedBoxSize = 0;
    float angle = 0;
    float weight = 5;
    float size = 50;
  
    boolean useAmplitude = true;

    int colorOffset = 0;

    public void enter()
    {
        colorOffset = (int) v.random(0, 256);
    }

    public Cube(AudioGarden v)
    {
        super(v);

        position = new PVector(0, 0, 0);
    }    

    public void render()
    {

        v.camera(0, 0, -500, 0, 0, 0f, 0f, 0.001f, 0f);
        v.pushMatrix();
        //v.rotateZ(v.PI + v.yaw);
        //v.translate(v.width / 2, v.height / 2, 0); 
        v.strokeWeight(2);
        float c = v.hueShift((v.map(v.getSmoothedAmplitude(), 0, 1, 0, 255) + colorOffset) % 255);        
        v.stroke(c, 255, 255, v.alp);
        v.noFill();

        //v.translate(position.x, position.y, position.z);       
        v.rotateY(angle);
        v.rotateX(angle);
        v.strokeWeight(weight);

        float boxSize = size + (v.getAmplitude() * 300); 
        smoothedBoxSize = v.lerp(smoothedBoxSize, boxSize, 0.1f);                 
        v.box(smoothedBoxSize);
        
        
        angle+=0.01f * v.spe;
        v.popMatrix();
        
        
    }
}