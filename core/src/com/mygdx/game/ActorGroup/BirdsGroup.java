package com.mygdx.game.ActorGroup;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.mygdx.game.actor.BaseActor;

public class BirdsGroup extends Group {

    BaseActor bird;
    static float worldWidth;
    static float worldHeight;

    public BirdsGroup(String[] birdsArray, int num, float width, float height)
    {
        worldWidth = width;
        worldHeight = height;
        for (int i = 0; i < num; i++) {
            // 生成一只鸟
            String birdName = birdsArray[(int) (Math.random() * birdsArray.length)];
            Texture img = new Texture(birdName);

            bird = new BaseActor(new TextureRegion(img));
            double flyHeight = MathUtils.random(worldHeight/2, worldHeight-bird.getHeight());
            bird.setPosition(-bird.getWidth(), (float) flyHeight);
            bird.setOrigin(bird.getWidth() / 2, bird.getHeight() / 2);

            // 添加飞行效果
            float speed = MathUtils.random(2, 7);
            bird.setFlySpeed(speed);
            fly(bird, bird.flySpeed);

            // 添加到组中
            this.addActor(bird);
        }

    }

    public static void fly(BaseActor bird, float speed) {

        float xOffSet = worldWidth + bird.getWidth();

        // 移动屏幕距离
        MoveByAction flyOff;
        MoveByAction flyBack;
        flyOff = Actions.moveBy(xOffSet, 0, speed);
        flyBack = Actions.moveBy(-xOffSet, 0, 0);

        SequenceAction sequence = Actions.sequence(flyOff, flyBack);

        RepeatAction repeatAction = Actions.forever(sequence);
        // 将动作附近在演员身上, 执行动作
        bird.addAction(repeatAction);
    }

    public void addOneBird(String[] birdsArray) {
        // 生成一只鸟
        String birdName = birdsArray[(int) (Math.random() * birdsArray.length)];
        Texture img = new Texture(birdName);

        bird = new BaseActor(new TextureRegion(img));
        double flyHeight = MathUtils.random(worldHeight/2, worldHeight-bird.getHeight());
        bird.setPosition(-bird.getWidth(), (float) flyHeight);
        bird.setOrigin(bird.getWidth() / 2, bird.getHeight() / 2);
        float speed = MathUtils.random(2, 7);
        bird.setFlySpeed(speed);
        // 添加飞行效果
        fly(bird, bird.flySpeed);
        this.addActor(bird); //添加到组中
    }
}
