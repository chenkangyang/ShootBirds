package com.mygdx.game.ActorGroup;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.mygdx.game.actor.BaseActor;

public class DeadGroup extends Group {

    private float X;
    private float Y;

    public DeadGroup() {}

    public void addDeadBird(BaseActor bird) {
        // 增加掉落的星星
        Texture img = new Texture("星星.png");
        X = bird.getX() + bird.getWidth()/2;
        Y = bird.getY() + bird.getHeight()/2;
        BaseActor deadBird = new BaseActor(new TextureRegion(img));
        deadBird.setPosition(X, Y);
        deadBird.setOrigin(bird.getWidth() / 2, bird.getHeight() / 2);

        // 让子星星开始掉落
        deadBird.setBirdState(BaseActor.FALL);
        this.addActor(deadBird);
    }
}
