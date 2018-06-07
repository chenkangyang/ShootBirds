package com.mygdx.game.ActorGroup;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.mygdx.game.actor.BaseActor;

//用于生成子弹和运动 和 碰撞检测
public class BulletsFactory {

    // 生成子弹
    public static BaseActor createBullet(BaseActor pao, Vector3 target) {
        Texture image = new Texture("子弹.png");
        BaseActor bulletActor = new BaseActor(new TextureRegion(image));

        bulletActor.setX(pao.getX() + pao.getWidth() / 2);
        bulletActor.setY(pao.getY());
        bulletActor.setOrigin(bulletActor.getWidth() / 2, bulletActor.getHeight() / 2);
        bulletActor.addAction(Actions.moveTo(target.x, target.y, 2f)); // 设置飞镖的移动
        return bulletActor;
    }

    public static Boolean checkAlive(BaseActor bullet) {
        if (bullet.getActions().size == 0) {
            return false;
        }
        return true;
    }

    public static Boolean attackAlive(BaseActor target, BaseActor bullet) {
        Rectangle rectangle = new Rectangle(target.getX(), target.getY(),
                target.getWidth(), target.getHeight()); // 创建一个矩形
        return rectangle.contains(
                bullet.getX() + bullet.getWidth() / 2,
                bullet.getY() + bullet.getHeight() / 2); //判断是否在矩阵中，即是否击中
    }

}
