package entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PlayerImages {
    public BufferedImage up, up1, up2, up3, up4, up5, up6, up7;
    public BufferedImage down1, down2;
    public BufferedImage right, right1, right2, right3, right4, right5;
    public BufferedImage rightRun, rightRun1, rightRun2, rightRun3, rightRun4, rightRun5;
    public BufferedImage stop, stop1, stop2, stop3;
    public BufferedImage left, left1, left2, left3, left4, left5;
    public BufferedImage leftStop, leftStop1, leftStop2, leftStop3;
    public BufferedImage leftJump1, leftJump2, leftJump3, leftJump4, leftJump5, leftJump6, leftJump7;
    public BufferedImage leftRun, leftRun1, leftRun2, leftRun3, leftRun4, leftRun5;
    public BufferedImage DJump1, DJump2, DJump3, DJump4, DJump5, DJump6;
    public BufferedImage interact1, interact2, interact3, interact4;
    public BufferedImage interactLeft1, interactLeft2, interactLeft3, interactLeft4;
    public BufferedImage attack1, attack2, attack3, attack4;
    public BufferedImage attackLeft1, attackLeft2, attackLeft3, attackLeft4;
    public PlayerImages() {
        loadImages();
    }

    private void loadImages() {
        try {
            up = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Jump1.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Jump2.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Jump3.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Jump4.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Jump5.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Jump6.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Jump7.png"));
            up7 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Jump8.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Monster.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Monster.png"));

            right = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Right.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Right3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Right4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Right5.png"));

            rightRun = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Run.png"));
            rightRun1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Run1.png"));
            rightRun2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Run2.png"));
            rightRun3 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Run3.png"));
            rightRun4 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Run4.png"));
            rightRun5 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Run5.png"));

            stop = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Stop.png"));
            stop1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Stop1.png"));
            stop2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Stop2.png"));
            stop3 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Stop3.png"));

            left = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Left.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Left3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Left4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Left5.png"));

            leftStop = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftStop.png"));
            leftStop1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftStop1.png"));
            leftStop2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftStop2.png"));
            leftStop3 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftStop3.png"));

            leftJump1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftJump1.png"));
            leftJump2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftJump2.png"));
            leftJump3 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftJump3.png"));
            leftJump4 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftJump4.png"));
            leftJump5 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftJump5.png"));
            leftJump6 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftJump6.png"));
            leftJump7 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftJump7.png"));

            leftRun = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftRun.png"));
            leftRun1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftRun1.png"));
            leftRun2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftRun2.png"));
            leftRun3 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftRun3.png"));
            leftRun4 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftRun4.png"));
            leftRun5 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftRun5.png"));

            DJump1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Double_Jump.png"));
            DJump2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Double_Jump1.png"));
            DJump3 = ImageIO.read(getClass().getResourceAsStream("/res/player/Double_Jump2.png"));
            DJump4 = ImageIO.read(getClass().getResourceAsStream("/res/player/Double_Jump3.png"));
            DJump5 = ImageIO.read(getClass().getResourceAsStream("/res/player/Double_Jump4.png"));
            DJump6 = ImageIO.read(getClass().getResourceAsStream("/res/player/Double_Jump5.png"));

            interact1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Attack1.png"));
            interact2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Attack2.png"));
            interact3 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Attack3.png"));
            interact4 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_Attack4.png"));
            attack1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_SecondAttack1.png"));
            attack2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_SecondAttack2.png"));
            attack3 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_SecondAttack3.png"));
            attack4 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_SecondAttack4.png"));



            interactLeft1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftAttack1.png"));
            interactLeft2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftAttack2.png"));
            interactLeft3 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftAttack3.png"));
            interactLeft4 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_LeftAttack4.png"));
            attackLeft1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_SecondLeftAttack1.png"));
            attackLeft2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_SecondLeftAttack2.png"));
            attackLeft3 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_SecondLeftAttack3.png"));
            attackLeft4 = ImageIO.read(getClass().getResourceAsStream("/res/player/Pink_SecondLeftAttack4.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}