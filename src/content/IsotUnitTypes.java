package content;

import arc.graphics.Color;
import mindustry.ai.types.BuilderAI;
import mindustry.content.Fx;
import mindustry.entities.abilities.RepairFieldAbility;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.pattern.ShootHelix;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class IsotUnitTypes {
    public static UnitType
            colonist;

    public static void load() {
        colonist = new UnitType("colonist"){{
            constructor = UnitEntity::create;
            speed = 2f;
            hitSize = 7f;
            health = 10f;
            buildSpeed = 0.5f;
            alwaysUnlocked = true;
            mineTier = 1;
            mineSpeed = 2f;

            aiController = BuilderAI::new;
            isEnemy = false;

            lowAltitude = true;
            flying = true;
            drag = 0.05f;
            rotateSpeed = 15f;
            accel = 0.1f;
            fogRadius = 0f;
            itemCapacity = 10;
            engineOffset = 5f;

            abilities.add(new RepairFieldAbility(10f, 60f * 4, 60f));

            weapons.add(new Weapon("colonist-weapon"){{
                shootSound = Sounds.blaster;
                reload = 35f;
                x = 0f;
                y = 6.5f;
                shootY = 5f;
                recoil = 1f;
                top = false;
                layerOffset = -0.01f;
                rotate = false;
                mirror = false;
                shoot = new ShootHelix();

                bullet = new BasicBulletType(5f, 34){{
                    width = 7f;
                    height = 12f;
                    lifetime = 18f;
                    shootEffect = Fx.sparkShoot;
                    hitColor = backColor = trailColor = Pal.suppress;
                    frontColor = Color.white;
                    trailWidth = 1.5f;
                    trailLength = 5;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                }};
            }});

    }};

}
}