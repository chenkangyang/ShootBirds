package com.mygdx.game.actor;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BaseActor extends Actor {

    // 用于展示该演员的纹理区域
    private TextureRegion region;

    public static final int FLY = 1;
    public static final int FALL = -1;
    public float flySpeed;

    private int BirdState;

    // 小鸟竖直方向上的重力加速度, 单位: px/(s*s)
    public static final float gravity = -480.0F;

    // 小鸟竖直方向上的速度
    private float velocityY;

    public BaseActor(TextureRegion region) {
        super();
        this.region = region;
        this.BirdState = FLY;
        // 将演员的宽高设置为纹理区域的宽高（必须设置, 否则宽高默认都为 0, 绘制后看不到）
        setSize(this.region.getRegionWidth(), this.region.getRegionHeight());
    }

    public TextureRegion getRegion() {
        return region;
    }

    public void setRegion(TextureRegion region) {
        this.region = region;
        // 重新设置纹理区域后, 需要重新设置宽高
        setSize(this.region.getRegionWidth(), this.region.getRegionHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        // 在击中状态时才应用物理效应
        if (BirdState == FALL) {
            /*
             * 应用物理效应（简单模拟物理效果, 帧率较低时物理效果的误差可能较大）
             * v = v0 + a * t
             * s = v0 * t + a * t^2
             */
            // 递增速度
            velocityY += gravity * delta;
            // 递增位移
            setY(getY() + velocityY * delta);
        }
    }

    // 纹理画布, 用于绘制演员封装的纹理。SpriteBatch 就是实现了 Batch 接口

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        // 如果 region 为 null 或者 演员不可见, 则直接不绘制
        if (region == null || !isVisible()) {
            return;
        }

        /*
         * 绘制纹理区域
         * 将演员中的 位置(position, 即 X, Y 坐标), 缩放和旋转支点(origin), 宽高尺寸, 缩放比, 旋转角度 应用到绘制中,
         * 最终 batch 会将综合结果绘制到屏幕上
         */

        batch.draw(
                region,
                getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation()
        );
    }

    public void setBirdState(int STATE) {
        this.BirdState = STATE;
    }

    public void setFlySpeed(float speed) {
        this.flySpeed = speed;
    }

    public float getFlySpeed() {
        return this.flySpeed;
    }
}