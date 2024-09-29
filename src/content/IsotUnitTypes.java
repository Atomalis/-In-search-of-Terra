package content;

import mindustry.ai.types.BuilderAI;
import mindustry.entities.abilities.RepairFieldAbility;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;

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

    }};

}
}