# ShootBirds
ShootBirds Game using libgdx


[libGdx官网](https://libgdx.badlogicgames.com/documentation/gettingstarted/Packaging.html)

### Packaging for desktop


### 只打包了桌面端的程序

```
LINUX:
./gradlew desktop:dist

WINDOWS:
gradlew.bat desktop:dist

```

Generates a fat jar in desktop/build/libs directory that you can run with


```
java -jar desktop-1.0.jar
```

### DEBUG
```
配置选择"Java Apllication"

desktop/src/com/mygdx/game/desktop/DesktopLauncher.java
作为主类(Main Class),

/Users/alex/Documents/2018/2018_Projecs/ShootBirds/core/assets
作为工作目录(Working directory) (改成自己的assets文件夹所在目录)
``` 

## 游戏玩法：
初始有**100颗**子弹，**50只**鸟。

屏幕上同时最多有**5只**鸟具有不同的速度和位置，同时屏幕上最多同时存在**5颗**子弹。

发射台会追随鼠标位置实时调整方向。

鼠标点击所在的位置为子弹射向的位置，到达鼠标点击位置后，子弹自动消失。

击中鸟得到10分，鸟会根据水平速度不同获得不同的下坠轨迹

鸟被击中会掉落星星，击中星星（星星按重力作用下坠）则获得100分，并且补充3颗子弹。

打完所有100颗子弹，或者50只鸟全部打完。**游戏结束！**

点击左上角*重新开始*图标，建立新的一局游戏。

游戏界面左下角实时显示剩余子弹，当前得分，已出现的鸟数量。

